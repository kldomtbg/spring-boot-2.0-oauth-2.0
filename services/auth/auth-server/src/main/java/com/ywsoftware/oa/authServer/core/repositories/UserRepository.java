package com.ywsoftware.oa.authServer.core.repositories;

import com.ywsoftware.oa.authServer.core.entity.User;

public interface UserRepository {
    User read(String id);

    User create(User user);

    void update(User user);

    void delete(String id);
}

