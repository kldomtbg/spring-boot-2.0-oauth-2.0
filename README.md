# spring-boot-2.0-oauth-2.0

## 软件平台
spring boot 2.0.2
mysql 8.0

## 项目构成

### auth-server
oauth2.0认证服务器 支持authorization_code模式

### auth-client 
登入客户端 会跳转到auth-server的登入页面

### auth-resources
资源服务器 提供一个了个简单的api 供auth-client调用


## 说明
大部分的代码源自github，我做了一次整合。因为我实在找不到完整一点的基于spring boot2.0的oauth例子。