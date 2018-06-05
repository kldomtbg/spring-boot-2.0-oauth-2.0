package com.ywsoftware.oa.server.authserver.service;

import com.ywsoftware.oa.server.authserver.model.Customer;

import java.util.List;

/**
 * Created by Vladimir Vashchuk on 31.05.2018
 */
public interface CustomerService {

    List<Customer> findAll(String search);

    Customer findById(Long customerId);

    void save(Customer customer);

    void deleteById(Long customerId);
}
