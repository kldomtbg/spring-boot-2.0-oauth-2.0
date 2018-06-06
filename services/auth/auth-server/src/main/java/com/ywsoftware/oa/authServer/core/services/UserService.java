package com.ywsoftware.oa.authServer.core.services;

import com.ywsoftware.oa.authServer.core.entity.User;
import com.ywsoftware.oa.authServer.core.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository _userRepository) {
        this.userRepository = _userRepository;
    }

    /**
     * 增加用户
     *
     * @param name
     * @param id
     * @param passWord
     * @param email
     * @return
     */
    @Transactional
    public User create(String id, String name, String passWord, String email) {
        return userRepository.create(new User(id, name, passWord, email));
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        userRepository.delete(id);
    }

    /**
     * 修改用户
     *
     * @param name
     * @param id
     * @return
     */
    @Transactional
    public void update(String name, String id) {
        userRepository.update(name, id);
    }

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    public User read(String id) {
        return userRepository.read(id);
    }


}
