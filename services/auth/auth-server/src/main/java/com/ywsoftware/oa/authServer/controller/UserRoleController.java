package com.ywsoftware.oa.authServer.controller;


import com.ywsoftware.oa.authServer.controller.base.ExtendController;
import com.ywsoftware.oa.authServer.mybatis.pojo.UserRole;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_role")
public class UserRoleController extends ExtendController<UserRole> {
}
