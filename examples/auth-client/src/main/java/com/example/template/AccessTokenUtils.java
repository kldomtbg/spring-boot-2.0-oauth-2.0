
package com.example.template;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;
import java.util.Optional;

import static org.springframework.security.oauth2.common.OAuth2AccessToken.ACCESS_TOKEN;


/**
 * AccessTokens 和 SecurityContext 的工具类
 *
 * @author jbellmann
 */
public class AccessTokenUtils {

    private AccessTokenUtils() {
        //
    }

    public static Optional<String> getAccessTokenFromSecurityContext() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication authentication = securityContext.getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            Object userDetails = ((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
            if (userDetails != null) {
                try {
                    final Map details = (Map) userDetails;
                    return Optional.ofNullable(((String) details.get(ACCESS_TOKEN)));
                } catch (ClassCastException e) {

                    return Optional.empty();
                }
            } else {

                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    public static Optional<String> getUserNameFromSecurityContext() {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication authentication = securityContext.getAuthentication();
        if (authentication instanceof OAuth2Authentication) {

            return Optional.ofNullable(authentication.getName());

        } else {

            return Optional.empty();
        }

    }
}
