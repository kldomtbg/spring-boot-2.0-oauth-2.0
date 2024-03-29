package com.ywsoftware.oa.authserver.service;

import com.ywsoftware.oa.authserver.model.Customer;
import com.ywsoftware.oa.authserver.repository.CustomerRepository;
import com.ywsoftware.oa.authserver.repository.spec.CustomerSpecificationsBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public List<Customer> findAll(String search) {
        CustomerSpecificationsBuilder builder = new CustomerSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:)([a-zA-Z0-9\\-]*),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<Customer> spec = builder.build();

        return repository.findAll(spec);
    }

    @Override
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public Customer findById(Long customerId) {
        Optional<Customer> customer = repository.findById(customerId);

        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("id=" + customerId);
        }

        return customer.get();
    }

    @Override
    @PreAuthorize("hasAuthority('CUSTOMER_CREATE') and hasAuthority('CUSTOMER_UPDATE')")
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    @PreAuthorize("hasAuthority('CUSTOMER_DELETE')")
    public void deleteById(Long customerId) {
        repository.deleteById(customerId);
    }
}
