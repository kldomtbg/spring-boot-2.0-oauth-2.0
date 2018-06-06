package com.ywsoftware.oa.server.authserver.service;

import com.ywsoftware.oa.server.authserver.model.OauthClientDetails;
import com.ywsoftware.oa.server.authserver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public List<OauthClientDetails> getAll() {
        return clientRepository.findAll();
    }

    public OauthClientDetails findById(String id) {
        Optional<OauthClientDetails> role = clientRepository.findById(id);
        return role.orElse(null);
    }

    public OauthClientDetails save(OauthClientDetails oauthClientDetails) {
        return clientRepository.save(oauthClientDetails);
    }

    public void delete(String id) {
        clientRepository.deleteById(id);
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
