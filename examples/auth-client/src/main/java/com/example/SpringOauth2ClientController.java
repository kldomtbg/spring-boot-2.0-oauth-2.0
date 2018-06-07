package com.example;

import com.example.template.Oauth2ClientRestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class SpringOauth2ClientController {

    private static final Logger logger = LoggerFactory.getLogger(SpringOauth2ClientController.class);
    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;
    // 配置，配置单配置文件中比较合适下面的
    @Value("${github.client.clientId}")
    private String client_id;
    @Value("${github.client.clientSecret}")
    private String client_secret;
    private String[] scopes = new String[]{"read"};
    @Value("${resource_server_uri}")
    private String resource_server_url;
    @Value("${github.client.accessTokenUri}")
    private String access_token_uri;
    @Value("${github.client.userAuthorizationUri}")
    private String user_authorization_uri;
    @Autowired
    private Oauth2ClientRestTemplate restTemplate;


    /**
     * 演示 grant_type=authorization_code 时，获取资源的方法
     *
     * @return
     */
    @RequestMapping("/authorization_code")
    @ResponseBody
    public JsonNode authorizationCode() {
        logger.info("grant_type=authorization_code  ... ");
        OAuth2RestOperations operations = restTemplate.authorizationCodeRestTemplate(client_id, client_secret, user_authorization_uri, access_token_uri, scopes);
        logger.info("access_token:" + operations.getAccessToken().getValue());
        return operations.getForObject(resource_server_url + "api/subject", JsonNode.class);  // getForObject 发送 get 方法，获取的数据类型由具体的数据类型确定，此处 JsonNode 表示返回值为 json 类型

    }

    /**
     * 演示 grant_type=implicit 时，获取资源的方法
     *
     * @return
     */
/*
    @RequestMapping("/implicit")
    @ResponseBody
    public JsonNode implicit() {
        logger.info("grant_type=implicit  ... ");
        OAuth2RestOperations operations = restTemplate.implicitResourceRestTemplate(client_id, client_secret, user_authorization_uri, access_token_uri, scopes);  // getForObject 发送 get 方法
        logger.info("AccessTokenRequest : " + operations.getResource().getAccessTokenUri());
        logger.info("access_token:" + operations.getOAuth2ClientContext().getAccessToken());
        return operations.getForObject(resource_server_url + "/foos/1", JsonNode.class);  // getForObject 发送 get 方法
    }

*/

    /*    *//**
     * 演示 grant_type=password 时，获取资源的方法
     *
     * @return
     *//*
    @RequestMapping("/password")
    @ResponseBody
    public JsonNode resourceOwnerPassword() {
        logger.info("grant_type=password  ... ");
        OAuth2RestOperations operations = restTemplate.resourceOwnerPasswordRestTemplate(client_id, client_secret, access_token_uri, username, password, scopes);  // getForObject 发送 get 方法
        logger.info("access_token:" + operations.getAccessToken().getValue());
        return operations.getForObject(resource_server_url +"/foos/1", JsonNode.class);  // getForObject 发送 get 方法

    }*/

    /*    *//**
     * 演示 grant_type=client_credentials 时，获取资源的方法
     *
     * @return
     *//*
    @RequestMapping("/client_credentials")
    @ResponseBody
    public JsonNode clientCredentials() {
        logger.info("grant_type=client_credentials  ... ");
        OAuth2RestOperations operations = restTemplate.clientCredentialsRestTemplate(client_id, client_secret, access_token_uri, scopes);  // getForObject 发送 get 方法
        logger.info("access_token:" + operations.getAccessToken().getValue());
        logger.info("refresh_token:" + operations.getAccessToken().getRefreshToken());
        return operations.getForObject(resource_server_url + "/foos/1", JsonNode.class);  // getForObject 发送 get 方法
    }*/
}