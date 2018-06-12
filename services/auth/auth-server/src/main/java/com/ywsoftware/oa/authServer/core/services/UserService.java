package com.ywsoftware.oa.authserver.core.services;

//import com.ywsoftware.oa.authserver.core.entity.User;
//import com.ywsoftware.oa.authserver.core.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class UserService {
//    private UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository _userRepository) {
//        this.userRepository = _userRepository;
//    }
//
//    /**
//     * 增加用户
//     *
//     * @param user
//     * @return
//     */
//    @Transactional
//    public User create(User user) {
//        return userRepository.create(user);
//    }
//
//    /**
//     * 删除用户
//     *
//     * @param id
//     */
//    @Transactional
//    public void delete(String id) {
//        userRepository.delete(id);
//    }
//
//    /**
//     * 修改用户
//     *
//     * @param user
//     * @return
//     */
//    @Transactional
//    public void update(User user) {
//        userRepository.update(user);
//    }
//
//    /**
//     * 查询用户
//     *
//     * @param id
//     * @return
//     */
//    public User read(String id) {
//        return userRepository.read(id);
//    }
//
//
//}
