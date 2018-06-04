package com.ywsoftware.oa.authServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
public class Oauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

    @Bean
    // @LoadBalanced
    // @LoadBalanced注解能让这个RestTemplate在请求时拥有客户端负载均衡的能力：
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
