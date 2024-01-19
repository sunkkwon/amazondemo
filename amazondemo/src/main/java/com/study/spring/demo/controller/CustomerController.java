package com.study.spring.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.demo.dao.CustomerRepository;
import com.study.spring.demo.entity.Customer;

@RestController
public class CustomerController {

	private CustomerRepository repository;

	public CustomerController(CustomerRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("/customer")
	public Customer getCustomer(int id) {
		return repository.findById(id).orElseThrow();
	}

	@GetMapping("/customer/name")
	public List<Customer> getCustomerName(String name) {
		return repository.findByName(name);
	}

	@GetMapping("/customer/search")
	public List<Customer> searchCustomerName(String name) {
		return repository.findByNameLike("%" + name + "%");
	}

	@GetMapping("/customer/list")
	public List<Customer> getCustomerList() {
		return (List<Customer>) repository.findAll();
	}

	@PutMapping("/customer")
	public Customer putCustomer(Customer customer) {
		return repository.save(customer);
	}

	@PostMapping("/customer")
	public Customer postcustomer(Customer customer) {
		// TODO: process POST request
		return repository.save(customer);
	}

	@DeleteMapping("/customer")
	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}

}
