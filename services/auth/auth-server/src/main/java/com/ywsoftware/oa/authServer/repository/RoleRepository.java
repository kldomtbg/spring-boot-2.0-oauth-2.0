package com.ywsoftware.oa.authServer.repository;


import com.ywsoftware.oa.authServer.domain.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<OauthClientDetails, String> {

}
