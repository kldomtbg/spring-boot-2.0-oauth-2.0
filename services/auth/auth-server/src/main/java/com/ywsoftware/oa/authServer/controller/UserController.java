package com.ywsoftware.oa.authServer.controller;

import com.ywsoftware.oa.authServer.entity.User;
import com.ywsoftware.oa.authServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by userFly on 2018/5/25.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create")
    public void create(String id, String name, String password, String email) throws Exception {
        userService.create(id, name, password, email);
    }

    @RequestMapping(value = "/update")
    public Integer update(String name, String id) {
        return userService.update(name, id);
    }

    @RequestMapping(value = "/read")
    public User read(String name) {
        return userService.read(name);
    }

    @RequestMapping(value="/delete")
    public void delete(String id) {
        userService.deleteUser(id);
    }
}
