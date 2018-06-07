package com.ywsoftware.oa.authserver.repository;


import com.ywsoftware.oa.authserver.model.OAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<OAuthClientDetails, String> {

}
