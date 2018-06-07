package com.ywsoftware.oa.authserver.service;

import com.ywsoftware.oa.authserver.model.security.User;
import com.ywsoftware.oa.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElse(null);

    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
