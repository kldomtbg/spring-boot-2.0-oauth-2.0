package com.ywsoftware.oa.server.authserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/secured/user")
public class User2Controller {

    @RequestMapping(method = RequestMethod.GET)
    public Principal getPrincipal(Principal user) {
        return user;
    }
}
