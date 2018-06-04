package com.ywsoftware.oa.authServer.controller.oauth;


import com.ywsoftware.oa.authServer.domain.dto.UserDTO;
import com.ywsoftware.oa.authServer.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserDetailsController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * 获取当前人员信息
     *
     * @param principal
     * @return
     */
    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping()
    public Principal getUserLogin(Principal principal) {
        UserDTO userDTO = userDetailsService.getUserLogin();
        //return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        return principal;
    }

}
