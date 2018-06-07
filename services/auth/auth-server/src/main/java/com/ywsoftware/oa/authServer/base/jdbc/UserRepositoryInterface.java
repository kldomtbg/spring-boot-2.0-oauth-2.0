package com.ywsoftware.oa.authServer.base.jdbc;

import com.ywsoftware.oa.authServer.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User, String> {
   // @Query("FROM User u WHERE u.id = :id")
    User findUser(String id);

    @Modifying
    //@Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
    int update(String name, String id);

}
