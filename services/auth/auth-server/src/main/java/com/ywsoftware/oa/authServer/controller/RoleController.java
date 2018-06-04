package com.ywsoftware.oa.authServer.controller;

import com.ywsoftware.oa.authServer.domain.Role;
import com.ywsoftware.oa.authServer.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    @ApiOperation(value = "获取所有权限信息")
    @GetMapping("/")
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @ApiOperation(value = "获取单条权限信息")
    @GetMapping("/{id}")
    public Role findById(@PathVariable String id) {
        return roleService.findById(id);
    }

    @ApiOperation(value = "根据id,保存或者更新权限信息")
    @PostMapping("/saveOrUpdate")
    public Role save(Role role) {
        return roleService.save(role);
    }

    @ApiOperation(value = "删除单条权限信息")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        roleService.delete(id);
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
