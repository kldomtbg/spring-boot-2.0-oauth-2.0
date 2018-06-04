package com.ywsoftware.oa.example.authserver.token;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 维护token
 */
@Component
public class TokenManager {

    @Resource
    ClientProperties oAuth2ClientProperties;
    @Resource
    RestTemplate restTemplate;

    /**
     * 获取token
     */
    public void getToken(String userName, String password) {
        //restTemplate.postForEntity(oAuth2ClientProperties.getAccessTokenUri(),)
        //String url = oAuth2ClientProperties.getAccessTokenUri() + "?username=teste&password=123&grant_type=password&client_secret=123456&client_id=clientapp"
    }

    /**
     * 验证token
     */
    public void authToken(String token) {

    }

    /**
     * 刷新token
     */
    public void refreshToken(String refreshToken) {

    }

}
