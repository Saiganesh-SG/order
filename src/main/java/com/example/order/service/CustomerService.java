package com.example.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.order.entity.Customer;
import com.example.order.model.CustomerVO;

import com.example.order.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	CustomerRepository cusRepo;
	

	/*
	 * public Customer getCustomerDetailsByCustomerId(String cusId) { return
	 * cusRepo.findByCusId(cusId);
	 * 
	 * }
	 */
	public List<List<String>> fetchGroupAccountids() {
		List<Customer> customerList = cusRepo.findAll();
		return customerList.stream().map(x -> {
			return x.getAccount().stream().map(y -> y.getAccountId()).collect(Collectors.toList());
		}).collect(Collectors.toList());
	}

	public Customer fetchCustomersDetailsByCusId(String cusId) {
		return cusRepo.findByCusId(cusId);
	}

	public Customer getCustomerDetailsByCustomerName(String cusName) {
		// TODO Auto-generated method stub
		return cusRepo.findByCusName(cusName);
	}

	/*
	 * public Customer getCustomerDetailsByCustomerNameAndCustomerId(String
	 * cusName,String cusId) { return cusRepo.findByCusNameandCusId(cusName, cusId);
	 * }
	 */

	/*
	 * public List<Customer> getAllCustomerDetailsByCustomerId( List<CustomerVO>
	 * customervo ) { List<String> cusIdList = new ArrayList<>(); for(CustomerVO
	 * cus:customervo) { String cusId = new String(cus.getId());
	 * cusIdList.add(cusId); } return cusRepo.findAllByCusIdIn(cusIdList); }
	 */

	public List<Customer> getAllCustomerDetailsByCustomerId(List<CustomerVO> customervo) {
		List<String> cusIdList = new ArrayList<>();
		for (CustomerVO cus : customervo) {
			String cusId = new String(cus.getId());
			cusIdList.add(cusId);
		}
		return cusRepo.findAllByCusIdIn(cusIdList);
	}

	public void saveCustomer(CustomerVO customervo) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		// customer.setCusId(customervo.getId());
		customer.setCusName(customervo.getName());

		cusRepo.save(customer);

	}

	public void updateCustomerNameBycusId(CustomerVO customervo) {
		// TODO Auto-generated method s
		Customer cus = cusRepo.findByCusId(customervo.getId());
		cus.setCusName(customervo.getName());
		cusRepo.save(cus);

	}

	@Transactional
	public void DeleteCustomerDetailsByCusId(String cusId) {
		// TODO Auto-generated method stub
		cusRepo.deleteByCusId(cusId);
	}

	public List<Customer> fetchAllCustomerDetailsByCustomerName(List<CustomerVO> customervo) {
		// TODO Auto-generated method stub
		List<String> cusNameList = new ArrayList<>();
		for (CustomerVO cus : customervo) {
			String cusName = new String(cus.getName());
			cusNameList.add(cusName);
		}
		return cusRepo.findAllByCusNameIn(cusNameList);
	}

	public List<Customer> getAllCustomerDetailsByCustomerName(List<CustomerVO> customervo) {
		List<String> cusNameList = new ArrayList<>();
		for (CustomerVO cus : customervo) {
			String cusName = new String(cus.getName());
			cusNameList.add(cusName);
		}
		return cusRepo.findAllByCusNameIn(cusNameList);
	}

	@Transactional
	public void deleteallCustomerByCusId(List<CustomerVO> customervo) {
		// TODO Auto-generated method stub
		List<String> cusIdList = new ArrayList<>();
		for (CustomerVO cus : customervo) {
			String cusId = new String(cus.getId());
			cusIdList.add(cusId);
		}
		cusRepo.deleteByCusIdIn(cusIdList);

	}

	public void updateAllCustomerByCusId(List<CustomerVO> customervo) {
		// TODO Auto-generated method stub
		List<Customer> cusList = new ArrayList<>();
		for (CustomerVO cus : customervo) {
			// String cusId = new String(cus.getId());
			Customer customer = cusRepo.findByCusId(cus.getId());
			customer.setCusName(cus.getName());
			cusList.add(customer);
		}
		cusRepo.saveAll(cusList);
	}

	public List<Customer> getAllCustomerDetailsByCustomerNameAndCustomerId(List<CustomerVO> customervo) {
		List<String> cusNameList = new ArrayList<>();
		List<String> cusIdList = new ArrayList<>();
		for (CustomerVO cus : customervo) {
			String cusName = new String(cus.getName());
			String cusId = new String(cus.getId());
			cusNameList.add(cusName);
			cusIdList.add(cusId);
		}

		return cusRepo.findAllByCusNameInAndCusIdIn(cusNameList, cusIdList);
	}

	public Customer fetchCustomerDataByCustomerId(String cusId) {
		// TODO Auto-generated method stub
	     log.info("Find customer details");
	     log.error("error  customer details");
	     
		
		return cusRepo.findByCusId(cusId);
	}

	public List<Customer> fetchAllCustomerDetailsByCustomerId(List<CustomerVO> customervo) {
		List<String> cusIdList = new ArrayList<>();
		for (CustomerVO cus : customervo) {
			String cusId = new String(cus.getId());
			cusIdList.add(cusId);
		}
		return cusRepo.findAllByCusIdIn(cusIdList);
	}

	public List<Customer> fetchAllCustomer() {
		return cusRepo.findAll();
	}

}
