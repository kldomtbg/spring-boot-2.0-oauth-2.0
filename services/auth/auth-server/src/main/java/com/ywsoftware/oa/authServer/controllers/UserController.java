package com.ywsoftware.oa.authServer.controllers;

import com.ywsoftware.oa.authServer.core.entity.User;
import com.ywsoftware.oa.authServer.core.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService _userService) {
        this.userService = _userService;
    }

    @PostMapping("/create")
    public void create(String id, String name, String password, String email){
        userService.create(id, name, password, email);
    }

    @PutMapping("/update")
    public void update(String name, String id) {
        userService.update(name, id);
    }

    @GetMapping("/read")
    public User read(String name) {
        return userService.read(name);
    }

    @DeleteMapping("/delete")
    public void delete(String id) {
        userService.delete(id);
    }

}
