package com.ywsoftware.oa.authserver.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class OAuthLogoutController {

    @Resource(name = "tokenServices")
    private ConsumerTokenServices tokenServices;

    @DeleteMapping(value = "/oauth/tokens/revoke")
    public void revokeToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && StringUtils.containsIgnoreCase(authorization, "Bearer")) {
            String tokenId = authorization.substring("Bearer".length() + 1);
            tokenServices.revokeToken(tokenId);
        }
    }
}