package com.ywsoftware.oa.authserver.controller;

import com.ywsoftware.oa.authserver.model.OauthClientDetails;
import com.ywsoftware.oa.authserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;


    @GetMapping("/")
    public List<OauthClientDetails> getAll() {
        return clientService.getAll();
    }


    @GetMapping("/{id}")
    public OauthClientDetails findById(@PathVariable String id) {
        return clientService.findById(id);
    }


    @PostMapping("/saveOrUpdate")
    public OauthClientDetails save(OauthClientDetails oauthClientDetails) {
        return clientService.save(oauthClientDetails);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
