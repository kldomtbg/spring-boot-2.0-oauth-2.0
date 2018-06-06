package com.ywsoftware.oa.authServer.core.repositorys;

import com.ywsoftware.oa.authServer.core.entity.User;

public interface UserRepository {
    User read(String id);

    User create(User user);

    void update(String name, String id);

    void delete(String id);
}

