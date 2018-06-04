package com.ywsoftware.oa.authServer.controller;


import com.ywsoftware.oa.authServer.controller.base.ExtendController;
import com.ywsoftware.oa.authServer.domain.User;
import com.ywsoftware.oa.authServer.domain.dto.UsuarioDTO;
import com.ywsoftware.oa.authServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends ExtendController<User> {

    @Autowired
    private UserService usuarioService;

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping()
    public Principal getUsuarioLogado(Principal principal) {
        UsuarioDTO usuarioDTO = usuarioService.getUsuarioLogado();
        //return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        return principal;
    }

}
