package com.ywsoftware.oa.authserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/secured/user")
public class User2Controller {

    @GetMapping
    public Principal getPrincipal(Principal user) {
        return user;
    }
}
