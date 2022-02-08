package com.jumia.services.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.services.backend.entity.Customer;
import com.jumia.services.backend.repository.CustomerRepository;
import com.jumia.services.backend.helper.*;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	public List<Customer> getCustomersByState(String country) {
		List<Customer> filteredCustomers = new ArrayList<>();
		// initialize helper regex
		RegexHelper regexHelper = new RegexHelper(country);
		
		Pattern pattern = regexHelper.getRegexPattern(country);
		
		// filter based on country regex
		filteredCustomers = getCustomers().stream()
				.filter(c -> pattern.asPredicate().test(c.getPhone()))
				.collect(Collectors.toList());
		return filteredCustomers;
	}
	
	
}
