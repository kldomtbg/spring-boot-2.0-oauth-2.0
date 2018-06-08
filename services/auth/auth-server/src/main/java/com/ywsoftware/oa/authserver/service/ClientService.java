package com.ywsoftware.oa.authserver.service;

import com.ywsoftware.oa.authserver.model.OAuthClientDetails;
import com.ywsoftware.oa.authserver.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<OAuthClientDetails> getAll() {
        return clientRepository.findAll();
    }

    public OAuthClientDetails findById(String id) {
        Optional<OAuthClientDetails> role = clientRepository.findById(id);
        return role.orElse(null);
    }

    public OAuthClientDetails save(OAuthClientDetails oauthClientDetails) {
        return clientRepository.save(oauthClientDetails);
    }

    public void delete(String id) {
        clientRepository.deleteById(id);
    }
}
