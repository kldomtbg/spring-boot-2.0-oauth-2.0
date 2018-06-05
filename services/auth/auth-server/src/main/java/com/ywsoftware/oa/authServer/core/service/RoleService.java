package com.ywsoftware.oa.authServer.core.service;

import com.ywsoftware.oa.authServer.core.entity.Role;
import com.ywsoftware.oa.authServer.core.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role findById(String id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null);

    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Autowired
    public void setRoleRepository(RoleRepository RoleRepository) {
        this.roleRepository = RoleRepository;
    }

    public void delete(String id) {
        roleRepository.deleteById(id);
    }
}
