package com.ywsoftware.oa.authserver.controller;

import com.ywsoftware.oa.authserver.model.security.Authority;
import com.ywsoftware.oa.authserver.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authority")
public class AuthorityController {
    private AuthorityService authorityService;

    @GetMapping("/")
    public List<Authority> getAll() {
        return authorityService.getAll();
    }

    @GetMapping("/{id}")
    public Authority findById(@PathVariable String id) {
        return authorityService.findById(id);
    }

    @PostMapping()
    public Authority save(Authority Authority) {
        return authorityService.save(Authority);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        authorityService.delete(id);
    }

    @Autowired
    public void setAuthorityService(AuthorityService AuthorityService) {
        this.authorityService = AuthorityService;
    }
}
