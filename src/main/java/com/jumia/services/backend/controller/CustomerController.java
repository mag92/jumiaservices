package com.jumia.services.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.services.backend.entity.Customer;
import com.jumia.services.backend.service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String info() {
		return "App is running.";
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{country}")
	@ResponseBody
	public List<Customer> getCustomersByState(@PathVariable String country) {
		return customerService.getCustomersByState(country);
	}
}
