package com.ywsoftware.oa.authServer.base.jdbc;

import com.ywsoftware.oa.authServer.core.entity.User;
import com.ywsoftware.oa.authServer.core.repositorys.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJdbc implements UserRepository {
    private UserRepositoryInterface userRepositoryInterface;

    public UserRepositoryJdbc(UserRepositoryInterface _userRepositoryInterface) {
        this.userRepositoryInterface = _userRepositoryInterface;
    }

    @Override
    public User read(String id) {
        return userRepositoryInterface.findUser(id);
    }

    @Override
    public User create(User user) {
        return userRepositoryInterface.save(user);
    }

    @Override
    public void update(String name, String id) {
        userRepositoryInterface.update(name, id);

    }

    @Override
    public void delete(String id) {
        userRepositoryInterface.deleteById(id);

    }
}
