package com.ywsoftware.oa.authServer.controller;

import com.ywsoftware.oa.authServer.controller.base.ExtendController;
import com.ywsoftware.oa.authServer.mybatis.pojo.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController extends ExtendController<Auth> {
}
