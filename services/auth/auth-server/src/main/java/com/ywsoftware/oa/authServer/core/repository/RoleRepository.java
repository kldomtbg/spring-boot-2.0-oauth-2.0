package com.ywsoftware.oa.authServer.core.repository;


import com.ywsoftware.oa.authServer.core.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
