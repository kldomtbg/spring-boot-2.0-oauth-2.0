package com.ywsoftware.oa.authServer.controllers;

import com.ywsoftware.oa.authServer.core.entity.User;
import com.ywsoftware.oa.authServer.core.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/User")
public class UserController {

    private UserService userService;

    public UserController(UserService _userService) {
        this.userService = _userService;
    }

    @PostMapping
    public void create(String id, String name, String password, String email) {
        userService.create(id, name, password, email);
    }

    @PutMapping
    public void update(String name, String id) {
        userService.update(name, id);
    }

    @GetMapping
    public User read(String name) {
        return userService.read(name);
    }

    @DeleteMapping
    public void delete(String id) {
        userService.delete(id);
    }

}
