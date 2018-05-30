package com.ywsoftware.oa.authServer.service;

import com.ywsoftware.oa.authServer.dao.UserRepository;
import com.ywsoftware.oa.authServer.entity.User;
import com.ywsoftware.oa.authServer.exception.NullDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by userFly on 2018/5/28.
 */
@Service(value = "userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

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
    public User saveUser(String id, String name, String passWord, String email) {
        int a = 1/0;
        return userRepository.save(new User(id, name, passWord, email));
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Transactional
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    /**
     * 修改用户
     *
     * @param name
     * @param id
     * @return
     */
    @Transactional
    public Integer update(String name, String id) {
        return userRepository.update(name, id);
    }

    /**
     * 查询用户
     *
     * @param name
     * @return
     */
    public User getUser(String name) {
        return userRepository.findByName(name);
    }

}
