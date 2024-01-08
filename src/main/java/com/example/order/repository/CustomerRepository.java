package com.example.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

	List<Customer> findAllByCusNameInAndCusIdIn(List<String> cusName,List<String> cusId);


	Customer  findByCusId(String cusId);
	

	void deleteByCusId(String id);

    Customer findByCusNameAndCusId(String cusName,String cusId);
    
	Customer findByCusName(String cusName);


	List<Customer> findAllByCusIdIn(List<String> cusIdList);


	List<Customer> findAllByCusNameIn(List<String> cusName);


	void deleteByCusIdIn(List<String> cusIdList);

	//Customer findAllByCusId(List<Customer> customer);
	

}
