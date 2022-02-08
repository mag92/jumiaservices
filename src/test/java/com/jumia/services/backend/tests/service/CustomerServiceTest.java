package com.jumia.services.backend.tests.service;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jumia.services.backend.entity.Customer;
import com.jumia.services.backend.repository.CustomerRepository;
import com.jumia.services.backend.service.CustomerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerServiceTest {
	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepository customerRepository;
    
    @Test
    @DisplayName("Customer List Test")
    public void testCustomerList() {
    	Customer c1 = new Customer();
    	c1.setId(0);
    	c1.setName("Walid");
    	c1.setPhone("(212) 6007989253");
    	
    	Customer c2 = new Customer();
    	c2.setId(1);
    	c2.setName("Younes");
    	c2.setPhone("(256) 7734127498");
    	//Mockito.when(customerRepository.findAll()).thenReturn(Arrays.asList(new Customer()));
    	List<Customer> customers = new ArrayList<>();
    	customers.add(c1);
    	customers.add(c2);
    	doReturn(customers).when(customerRepository).findAll();
    	
    	
    	List<Customer> allCustomers = customerService.getCustomers();
    	
    	assertEquals(2, allCustomers.size());
    }
}