package com.ywsoftware.oa.server.authserver.service;

import com.ywsoftware.oa.server.authserver.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll(String search);

    Customer findById(Long customerId);

    void save(Customer customer);

    void deleteById(Long customerId);
}
