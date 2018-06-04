package com.ywsoftware.oa.authServer.repository;


import com.ywsoftware.oa.authServer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    User findByLogin(@Param("userName") String userName);

}