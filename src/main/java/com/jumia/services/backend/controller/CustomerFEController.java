package com.jumia.services.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jumia.services.backend.entity.Customer;
import com.jumia.services.backend.service.CustomerService;

@Controller
public class CustomerFEController {
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String main(Model model) {
        model.addAttribute("message", welcomeMessage);
        return "welcome";
	}
	
	
	@GetMapping("/customers")
	public String getCustomers(Model model) {
		List<Customer> customers = new ArrayList<>();
		customers = customerService.getCustomers();
		model.addAttribute("filteredCustomers", customers);
		return "customers";
	}
	
	
	@GetMapping("/customers/filter")
    public String mainWithParam(
            @RequestParam(name = "country", required = false, defaultValue = "") 
			String country, Model model) {
		List<Customer> filteredCustomers = new ArrayList<>();
		
		filteredCustomers = customerService.getCustomersByState(country);
		
		model.addAttribute("filteredCustomers", filteredCustomers);
		return "customers";
	}
	
	
}


