package com.jumia.services.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumia.services.backend.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findById(int id);
	public Customer findByPhone(String phone);
	
	
}
