package com.ywsoftware.oa.authserver.controllers;

import com.ywsoftware.oa.authserver.model.security.Authority;
import com.ywsoftware.oa.authserver.service.AuthorityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authority")
public class AuthorityController {
    private AuthorityService authorityService;

    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

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
}
