package com.ywsoftware.oa.server.authserver.service;


import com.ywsoftware.oa.server.authserver.model.security.Authority;
import com.ywsoftware.oa.server.authserver.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityService {

    private AuthorityRepository AuthorityRepository;

    public List<Authority> getAll() {
        return AuthorityRepository.findAll();
    }

    public Authority findById(String id) {
        Optional<Authority> Authority = AuthorityRepository.findById(id);
        return Authority.orElse(null);

    }

    public Authority save(Authority Authority) {
        return AuthorityRepository.save(Authority);
    }

    @Autowired
    public void setAuthorityRepository(AuthorityRepository AuthorityRepository) {
        this.AuthorityRepository = AuthorityRepository;
    }

    public void delete(String id) {
        AuthorityRepository.deleteById(id);
    }
}
