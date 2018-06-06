package com.ywsoftware.oa.server.authserver.controller;


import com.ywsoftware.oa.server.authserver.model.security.User;
import com.ywsoftware.oa.server.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;


    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }


    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }


    @PostMapping("/saveOrUpdate")
    public User save(User user) {
        return userService.save(user);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
