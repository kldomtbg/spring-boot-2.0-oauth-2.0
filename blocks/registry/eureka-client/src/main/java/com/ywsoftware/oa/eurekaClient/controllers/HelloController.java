package com.ywsoftware.oa.eurekaClient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final AuthServiceHello authServiceHello;

    @Autowired
    public HelloController(AuthServiceHello authServiceHello) {
        this.authServiceHello = authServiceHello;
    }

    @GetMapping("/hi")
    public String sayHi(String name) {
        return authServiceHello.sayHi(name);
    }
}
