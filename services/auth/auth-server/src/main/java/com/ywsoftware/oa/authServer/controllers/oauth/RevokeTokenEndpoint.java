package com.ywsoftware.oa.authServer.controllers.oauth;

import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@FrameworkEndpoint
public class RevokeTokenEndpoint {

    @Resource(name = "tokenServices")
    ConsumerTokenServices tokenServices;

    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
    @ResponseBody
    public void revokeToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")) {
            String tokenId = authorization.substring("Bearer".length() + 1);
            tokenServices.revokeToken(tokenId);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tokens/revokeRefreshToken/{tokenId:.*}")
    @ResponseBody
    public String revokeRefreshToken(@PathVariable String tokenId) {
        if (tokenServices instanceof JdbcTokenStore) {
            ((JdbcTokenStore) tokenServices).removeRefreshToken(tokenId);
        }
        return tokenId;
    }

}
