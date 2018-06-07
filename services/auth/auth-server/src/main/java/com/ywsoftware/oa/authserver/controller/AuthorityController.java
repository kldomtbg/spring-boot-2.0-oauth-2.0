package com.ywsoftware.oa.authserver.controller;

import com.ywsoftware.oa.authserver.model.security.Authority;
import com.ywsoftware.oa.authserver.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Authority")
public class AuthorityController {
    private AuthorityService AuthorityService;


    @GetMapping("/")
    public List<Authority> getAll() {
        return AuthorityService.getAll();
    }


    @GetMapping("/{id}")
    public Authority findById(@PathVariable String id) {
        return AuthorityService.findById(id);
    }


    @PostMapping("/saveOrUpdate")
    public Authority save(Authority Authority) {
        return AuthorityService.save(Authority);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        AuthorityService.delete(id);
    }

    @Autowired
    public void setAuthorityService(AuthorityService AuthorityService) {
        this.AuthorityService = AuthorityService;
    }
}
