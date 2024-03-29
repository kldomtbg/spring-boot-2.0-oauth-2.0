package com.example.authresources.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {

    /**
     * 演示调用资源服务读取数据
     *
     * @param oauth2User
     * @return
     */
    @GetMapping(value = "/api/subject")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public SubjectResponse subject(OAuth2Authentication oauth2User) {
        SubjectResponse ret = new SubjectResponse();
        ret.setSubject(oauth2User.getName());
        ret.setScopes(new ArrayList<>());
        ret.getScopes().addAll(oauth2User.getOAuth2Request().getScope());
        return ret;
    }

    public class SubjectResponse {
        private String subject;
        private List<String> scopes;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public List<String> getScopes() {
            return scopes;
        }

        public void setScopes(List<String> scopes) {
            this.scopes = scopes;
        }
    }
}
