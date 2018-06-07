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
    public void create(User user) {
        userService.create(user);
    }

    @PutMapping
    public void update(User user) {
        userService.update(user);
    }

    @GetMapping("/{id}")
    public User read(String id) {
        return userService.read(id);
    }

    @DeleteMapping
    public void delete(String id) {
        userService.delete(id);
    }

}
