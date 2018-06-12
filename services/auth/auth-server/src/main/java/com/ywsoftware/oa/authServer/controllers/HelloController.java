package com.ywsoftware.oa.authserver.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public ResponseEntity<String> hi(@RequestParam String name) {
        return ResponseEntity.ok("hello world " + name + ". port: " + port);
    }
}
