package com.ywsoftware.oa.server.authserver.repository;

import com.ywsoftware.oa.server.authserver.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Vladimir Vashchuk on 30.05.2018
 */

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
}
