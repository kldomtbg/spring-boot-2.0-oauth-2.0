package com.ywsoftware.oa.authserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuthLoginController {
    @GetMapping("/login/oauth2")
    public String LoginPage() {
        return "/login.html";
    }
}
