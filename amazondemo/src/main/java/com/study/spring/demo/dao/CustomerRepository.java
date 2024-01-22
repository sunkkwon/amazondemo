package com.study.spring.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.study.spring.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	List<Customer> findByName(String name);
	List<Customer> findByNameLike(String name);
	List<Customer> findByNameLikeOrderByAddressDesc(String name);
	List<Customer> findByNameLikeOrAddressLike(String name, String address);
	List<Customer> findByNameLikeAndAddressLike(String name, String address);
	List<Customer> findByNameOrAddress(String name, String address);
	
	@Query("from Customer where name=?1 or address=?2")
	List<Customer> findVipList(String value1, String value2);

	@Query(value="select * from Customer where name=?1 and address=?2", nativeQuery=true)
	List<Customer> findVipList2(String value1, String value2);

}
