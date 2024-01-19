package com.study.spring.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.study.spring.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	List<Customer> findByName(String name);
	List<Customer> findByNameLike(String name);
}
