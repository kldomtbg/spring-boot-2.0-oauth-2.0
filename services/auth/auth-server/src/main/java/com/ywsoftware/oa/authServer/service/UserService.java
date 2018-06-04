package com.ywsoftware.oa.authServer.service;


import com.ywsoftware.oa.authServer.domain.User;
import com.ywsoftware.oa.authServer.domain.dto.UsuarioDTO;
import com.ywsoftware.oa.authServer.repository.UsuarioRepository;
import com.ywsoftware.oa.authServer.utils.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapperConverter modelMapperConverter;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", login));
        }
        return usuario;
    }

    public UsuarioDTO getUsuarioLogado() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User usuario = (User) authentication.getPrincipal();
        return modelMapperConverter.converterStrict(usuario, UsuarioDTO.class);
    }

}
