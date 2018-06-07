package com.ywsoftware.oa.server.authserver.repository;


import com.ywsoftware.oa.server.authserver.model.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<OauthClientDetails, String> {

}
