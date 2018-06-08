package com.ywsoftware.oa.server.authserver.service;

import com.ywsoftware.oa.authserver.model.Customer;
import com.ywsoftware.oa.authserver.repository.CustomerRepository;
import com.ywsoftware.oa.authserver.repository.spec.CustomerSpecificationsBuilder;
import com.ywsoftware.oa.authserver.service.CustomerService;
import com.ywsoftware.oa.authserver.service.CustomerServiceImpl;
import com.ywsoftware.oa.authserver.util.CustomerTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {
    @Resource
    private CustomerService customerService;
    @MockBean
    private CustomerRepository customerRepository;
    @Before
    public void setUp() throws Exception {
        Customer testCustomer = CustomerTestUtil.buildCustomer(3L,
                "newCustomer",
                "mail@mail.com",
                "7777777777");

        Mockito.when(customerRepository.findById(testCustomer.getId()))
                .thenReturn(Optional.of(testCustomer));

        CustomerSpecificationsBuilder specificationsEmptyBuilder = new CustomerSpecificationsBuilder();
        Mockito.when(customerRepository.findAll(specificationsEmptyBuilder.build()))
                .thenReturn(CustomerTestUtil.buildCustomerList(3));
        Mockito.when(customerRepository.findAll(any(Specification.class)))
                .thenReturn(CustomerTestUtil.buildCustomerList(1));
        Mockito.when(customerRepository.save(any(Customer.class)))
                .thenReturn(CustomerTestUtil.buildDefaultCustomerWithId(1L));
    }

    @Test
    public void findAllWithSearchRequest() throws Exception {
        String searchReq = "mail:2";

        List<Customer> resultList = customerService.findAll(searchReq);
        assertThat(resultList.isEmpty()).isFalse();
        assertThat(resultList.size()).isEqualTo(1);
    }

    @Test
    public void findAllWithNoSearchRequest() throws Exception {
        List<Customer> resultList = customerService.findAll(null);
        assertThat(resultList.isEmpty()).isFalse();
        assertThat(resultList.size()).isEqualTo(3);
    }

    @Test
    public void findById() throws Exception {
        Long id = 3L;
        String expectedName = "newCustomer";

        Customer customer = customerService.findById(id);
        assertThat(customer.getName()).isEqualTo(expectedName);
    }

    @Test
    public void save() throws Exception {
        Customer customer = CustomerTestUtil.buildDefaultCustomer();
        customerService.save(CustomerTestUtil.buildDefaultCustomer());
        Mockito.verify(customerRepository, Mockito.times(1)).save(customer);
    }

    @Test
    public void deleteById() throws Exception {
        customerService.deleteById(1L);
        Mockito.verify(customerRepository, Mockito.times(1)).deleteById(1L);
    }

    @TestConfiguration
    static class CustomerServiceTestContextConfig {
        private CustomerServiceImpl customerService;
        @Bean
        public CustomerService customerService() {
            return customerService;
        }
    }
}