package com.ywsoftware.oa.authServer.repository;


import com.ywsoftware.oa.authServer.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Role, String> {

}
