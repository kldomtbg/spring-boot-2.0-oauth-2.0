
package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Test client for use with social application (as an OAuth2 auth server). Remember to
 * access this app via its IP address (not "localhost"), otherwise the auth server will
 * steal your cookie.
 *
 * @author Dave Syer
 */
@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@RestController
public class ClientApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ClientApplication.class)
                .properties("spring.config.name=client").run(args);
    }

    @RequestMapping("/")
    public String home(Principal user) {
        return "Hello " + user.getName();
    }

}
