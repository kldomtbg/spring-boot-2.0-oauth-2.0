package com.ywsoftware.oa.example.authserver.controller;

import com.ywsoftware.oa.example.authserver.token.ClientProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    @Resource
    ClientProperties oAuth2ClientProperties;

    @RequestMapping("/user")
    public Principal user(Principal principal) {


        return principal;
    }

}
