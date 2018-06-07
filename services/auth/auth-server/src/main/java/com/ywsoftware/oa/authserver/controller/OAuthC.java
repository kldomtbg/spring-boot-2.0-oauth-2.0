package com.ywsoftware.oa.authserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OAuthC {
    @RequestMapping("/login/oauth2")
    public String LoginPage() {
        return "/login.html";
    }
}
