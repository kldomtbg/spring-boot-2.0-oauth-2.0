package com.ywsoftware.oa.authServer.base.jdbc;

import com.ywsoftware.oa.authServer.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User, String> {
    @Query("from User u where u.id =?1")
    User findUser(String id);

    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    int update(String name, String id);

}
