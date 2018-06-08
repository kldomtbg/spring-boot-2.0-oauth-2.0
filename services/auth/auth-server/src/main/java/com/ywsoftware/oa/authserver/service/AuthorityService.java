package com.ywsoftware.oa.authserver.service;


import com.ywsoftware.oa.authserver.model.security.Authority;
import com.ywsoftware.oa.authserver.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityService {

    private AuthorityRepository AuthorityRepository;

    public AuthorityService(com.ywsoftware.oa.authserver.repository.AuthorityRepository authorityRepository) {
        AuthorityRepository = authorityRepository;
    }

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


    public void delete(String id) {
        AuthorityRepository.deleteById(id);
    }
}
