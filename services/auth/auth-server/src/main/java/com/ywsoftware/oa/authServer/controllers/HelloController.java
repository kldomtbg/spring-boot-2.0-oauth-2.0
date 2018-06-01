package com.ywsoftware.oa.authServer.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public ResponseEntity<String> hi(@RequestParam String name) {
        return ResponseEntity.ok("hello world " + name + ". port: " + port);
    }

    @Value("${config.a}")
    String a;
    @Value("${config.b}")
    String b;
    @Value("${config.c}")
    String c;
    @Value("${config.d}")
    String d;
    @Value("${config.e}")
    String e;

    @GetMapping("/env")
    public ResponseEntity<List<String>> env() {
        List<String> config = new ArrayList<String>();
        config.add(a);
        config.add(b);
        config.add(c);
        config.add(d);
        config.add(e);
        return ResponseEntity.ok(config);
    }
}
