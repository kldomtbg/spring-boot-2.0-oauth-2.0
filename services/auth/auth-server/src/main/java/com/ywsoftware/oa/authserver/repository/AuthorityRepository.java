package com.ywsoftware.oa.authserver.repository;


import com.ywsoftware.oa.authserver.model.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

}
