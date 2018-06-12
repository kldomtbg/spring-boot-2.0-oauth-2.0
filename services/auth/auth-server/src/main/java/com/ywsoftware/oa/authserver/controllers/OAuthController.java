package com.ywsoftware.oa.authserver.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@RestController
public class OAuthController {
    private ConsumerTokenServices tokenServices;

    public OAuthController(ConsumerTokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }

    @DeleteMapping(value = "/oauth/tokens/revoke")
    public void revokeToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && StringUtils.containsIgnoreCase(authorization, "Bearer")) {
            String tokenId = authorization.substring("Bearer".length() + 1);
            tokenServices.revokeToken(tokenId);
        }
    }

    @GetMapping("/secured/user")
    public Principal getPrincipal(Principal user) {
        return user;
    }


}
