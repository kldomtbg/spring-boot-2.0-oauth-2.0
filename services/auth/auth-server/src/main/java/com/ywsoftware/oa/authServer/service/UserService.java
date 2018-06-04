package com.ywsoftware.oa.authServer.service;

import com.ywsoftware.oa.authServer.domain.User;
import com.ywsoftware.oa.authServer.domain.dto.UserDTO;
import com.ywsoftware.oa.authServer.repository.UserRepository;
import com.ywsoftware.oa.authServer.utils.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapperConverter modelMapperConverter;


    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(item -> userDTOS.add(modelMapperConverter.converterStrict(item, UserDTO.class)));
        return userDTOS;
    }

    public UserDTO findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(user1 -> modelMapperConverter.converterStrict(user1, UserDTO.class)).orElse(null);

    }

    public UserDTO save(User user) {
        return modelMapperConverter.converterStrict(userRepository.save(user), UserDTO.class);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setModelMapperConverter(ModelMapperConverter modelMapperConverter) {
        this.modelMapperConverter = modelMapperConverter;
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
