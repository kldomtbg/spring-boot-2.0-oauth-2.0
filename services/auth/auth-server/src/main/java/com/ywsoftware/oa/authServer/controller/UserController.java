package com.ywsoftware.oa.authServer.controller;

import com.ywsoftware.oa.authServer.domain.User;
import com.ywsoftware.oa.authServer.domain.dto.UserDTO;
import com.ywsoftware.oa.authServer.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @ApiOperation(value = "获取所有人员信息")
    @GetMapping("/")
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @ApiOperation(value = "获取个人信息")
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @ApiOperation(value = "根据id,保存或者更新用户信息")
    @PutMapping("/saveOrUpdate")
    public UserDTO save(User user) {
        return userService.save(user);
    }


    @ApiOperation(value = "删除个人信息")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
