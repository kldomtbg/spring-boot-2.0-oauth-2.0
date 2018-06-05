package com.ywsoftware.oa.authServer.core.repository;


import com.ywsoftware.oa.authServer.core.entity.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<OauthClientDetails, String> {

}
