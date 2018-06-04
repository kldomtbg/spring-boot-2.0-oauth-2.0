package com.ywsoftware.oa.authServer.service;

import com.ywsoftware.oa.authServer.domain.OauthClientDetails;
import com.ywsoftware.oa.authServer.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private RoleRepository roleRepository;

    public List<OauthClientDetails> getAll() {
        return roleRepository.findAll();
    }

    public OauthClientDetails findById(String id) {
        Optional<OauthClientDetails> role = roleRepository.findById(id);
        return role.orElse(null);
    }

    public OauthClientDetails save(OauthClientDetails oauthClientDetails) {
        return roleRepository.save(oauthClientDetails);
    }

    @Autowired
    public void setRoleRepository(RoleRepository RoleRepository) {
        this.roleRepository = RoleRepository;
    }

    public void delete(String id) {
        roleRepository.deleteById(id);
    }
}
