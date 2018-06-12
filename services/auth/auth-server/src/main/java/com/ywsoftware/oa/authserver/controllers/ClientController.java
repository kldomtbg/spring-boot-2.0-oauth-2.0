package com.ywsoftware.oa.authserver.controllers;

import com.ywsoftware.oa.authserver.model.OAuthClientDetails;
import com.ywsoftware.oa.authserver.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public List<OAuthClientDetails> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public OAuthClientDetails findById(@PathVariable String id) {
        return clientService.findById(id);
    }

    @PostMapping()
    public OAuthClientDetails save(OAuthClientDetails oauthClientDetails) {
        return clientService.save(oauthClientDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }
}
