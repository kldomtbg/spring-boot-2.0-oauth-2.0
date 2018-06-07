package com.example.authresources.config;

import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 查询 /check_token 端点以获取访问令牌的内容。
 * 如果端点返回400或401响应，则表示该令牌无效。
 * 如果端点返回属性“username”或“user_id”属性，则它们将被翻译为“user_name”。
 * 请注意，RFC7662需要“username”，但Spring Security会查找“user_name”...
 * 如果端点不返回“client_id”属性，则其值将从“aud”属性（如果存在）中提取。
 * 如果端点包含“aud”属性，它将被删除。
 * 如果未定义clientId / clientSecret，则对端点的请求将不会发送授权header。
 * 如果端点只返回一个error_description，表示调用失败。 
 *
 *其实就是RemoteTokenServices 做了翻译
 */
public class IntrospectionEndpointTokenService implements ResourceServerTokenServices {

    protected final Log logger = LogFactory.getLog(getClass());

    private RestOperations restTemplate;

    private String checkTokenEndpointUrl;

    private String clientId;

    private String clientSecret;

    private String tokenName = "token";

    private AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

    private ExpiringMap<String, Map<String, Object>> cache = ExpiringMap.builder().variableExpiration().build();

    public IntrospectionEndpointTokenService() {
        restTemplate = new RestTemplate();
        ((RestTemplate) restTemplate).setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            // Ignore 400 and 401 http errors
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400 && response.getRawStatusCode() != 401) {
                    super.handleError(response);
                }
            }
        });
    }

    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setCheckTokenEndpointUrl(String checkTokenEndpointUrl) {
        this.checkTokenEndpointUrl = checkTokenEndpointUrl;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setAccessTokenConverter(AccessTokenConverter accessTokenConverter) {
        this.tokenConverter = accessTokenConverter;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {

        Map<String, Object> map = this.cache.get(accessToken);
        if (map == null) {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
            formData.add(tokenName, accessToken);
            HttpHeaders headers = new HttpHeaders();
            if (!StringUtils.isEmpty(clientId) && !StringUtils.isEmpty(clientSecret))
                headers.set("Authorization", getAuthorizationHeader(clientId, clientSecret));
            map = postForMap(checkTokenEndpointUrl, formData, headers);

            if (map.containsKey("error") || map.containsKey("error_description")) {
                logger.debug("check_token returned error: " + map.get("error") + " / " + map.get("error_description"));
                throw new InvalidTokenException(accessToken);
            }

            // Get user_name from username
            if (!map.containsKey("user_name") && map.containsKey("username")) {        // "username" if defined in RFC7662, but Spring needs "user_name"
                map.put("user_name", map.get("username"));
                map.remove("username");
            }

            // Get user_name from user_id
            if (!map.containsKey("user_name") && map.containsKey("user_id")) {            // Google Cloud send "user_id" instead of" username"
                map.put("user_name", map.get("user_id"));
                map.remove("user_id");
            }

            // Get client_id from aud
            if (!map.containsKey("client_id") && map.containsKey("aud")) {
                map.put("client_id", map.get("aud"));
            }

            // Remove aud
            map.remove("aud");                // If aud is present, Spring Security will check if it is equal to a single configured value (oauth2-resource by default).

            Assert.state(map.containsKey("client_id"), "Client id must be present in response from auth server");

            long expiresIn;
            if (map.containsKey("exp")) {                        // As defined in RFC7662
                long exp = Long.parseLong(map.get("exp").toString());
                expiresIn = exp - (System.currentTimeMillis() / 1000L);
            } else if (map.containsKey("expires_in")) {            // Google Cloud sends a "expires_in" value
                expiresIn = (Long) map.get("expires_in");
            } else
                expiresIn = -1L;
            if (expiresIn > 0)
                this.cache.put(accessToken, map, ExpirationPolicy.CREATED, expiresIn, TimeUnit.SECONDS);
        }

        return tokenConverter.extractAuthentication(map);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }

    private String getAuthorizationHeader(String clientId, String clientSecret) {

        if (clientId == null || clientSecret == null) {
            logger.warn("Null Client ID or Client Secret detected. Endpoint that requires authentication will reject request with 401 error.");
        }

        String creds = String.format("%s:%s", clientId, clientSecret);
        try {
            return "Basic " + new String(Base64.getEncoder().encode(creds.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Could not convert String");
        }
    }

    private Map<String, Object> postForMap(String path, MultiValueMap<String, String> formData, HttpHeaders headers) {
        if (headers.getContentType() == null) {
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        }
        @SuppressWarnings("rawtypes")
        Map map = restTemplate.exchange(path, HttpMethod.POST,
                new HttpEntity<MultiValueMap<String, String>>(formData, headers), Map.class).getBody();
        @SuppressWarnings("unchecked")
        Map<String, Object> result = map;
        return result;
    }
}
