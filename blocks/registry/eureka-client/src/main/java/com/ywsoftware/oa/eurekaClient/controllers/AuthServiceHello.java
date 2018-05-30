package com.ywsoftware.oa.eurekaClient.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("auth-server")
public interface AuthServiceHello {

    @GetMapping("/hi")
    String sayHi(@RequestParam("name") String name);
}
