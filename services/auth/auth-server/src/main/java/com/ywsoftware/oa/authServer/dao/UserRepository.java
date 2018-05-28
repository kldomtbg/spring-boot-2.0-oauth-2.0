package com.ywsoftware.oa.authServer.dao;

import com.ywsoftware.oa.authServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by userFly on 2018/5/25.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("from User u where u.name =?1")
    User findUser(String name);

    User findByName(String name);

    @Transactional
    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    int update(String name, String id);
}
