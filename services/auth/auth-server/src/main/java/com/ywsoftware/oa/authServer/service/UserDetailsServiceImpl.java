package com.ywsoftware.oa.authServer.service;


import com.ywsoftware.oa.authServer.domain.User;
import com.ywsoftware.oa.authServer.domain.dto.UserDTO;
import com.ywsoftware.oa.authServer.repository.UserRepository;
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
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapperConverter modelMapperConverter;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", login));
        }
        return user;
    }

    public UserDTO getUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        return modelMapperConverter.converterStrict(user, UserDTO.class);
    }


}
