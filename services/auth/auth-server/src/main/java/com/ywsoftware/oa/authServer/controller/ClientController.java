package com.ywsoftware.oa.authServer.controller;

import com.ywsoftware.oa.authServer.domain.OauthClientDetails;
import com.ywsoftware.oa.authServer.service.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;

    @ApiOperation(value = "获取所有client信息")
    @GetMapping("/")
    public List<OauthClientDetails> getAll() {
        return clientService.getAll();
    }

    @ApiOperation(value = "获取单条client信息")
    @GetMapping("/{id}")
    public OauthClientDetails findById(@PathVariable String id) {
        return clientService.findById(id);
    }

    @ApiOperation(value = "根据id,保存或者更新client信息")
    @PutMapping("/saveOrUpdate")
    public OauthClientDetails save(OauthClientDetails oauthClientDetails) {
        return clientService.save(oauthClientDetails);
    }

    @ApiOperation(value = "删除单条client信息")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
