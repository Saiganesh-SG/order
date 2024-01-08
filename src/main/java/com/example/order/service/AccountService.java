package com.example.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.order.entity.Account;
import com.example.order.entity.Customer;
import com.example.order.model.CustomerVO;
import com.example.order.repository.AccountRepository;
import com.example.order.repository.CustomerRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accRepo;

	@Autowired
	CustomerRepository cusRepo;

	public List<Account> fetchAllAccounts() {
		return accRepo.findAll();
	}

	public List<Account> fetchAccountsByCusId(int i) {
		Optional<Customer> cusOpt = cusRepo.findById(i);
		Customer cus = cusOpt.orElse(null);
		//return accRepo.findByCustomer(cus);
		return null;
	}

	public List<Account> fetchAccountsByCusIdAndStatus() {
		Optional<Customer> cusOpt = cusRepo.findById(1);
		Customer cus = cusOpt.orElse(null);
		//return accRepo.findByCustomerAndStatus(cus, "open");
		return null;
	}

	public String getCustomerNameByAccountId(String accId) {
		//return accRepo.getCustomerNameByAccountId(accId);
        return null;
	}

	public void saveCustomer(CustomerVO customervo) {

		Customer cus1 = new Customer();
		//cus1.setCusId(customervo.getId());
		cus1.setCusName(customervo.getName());
		cusRepo.save(cus1);
	}

	public void saveCustomerList(List<CustomerVO> customervo) {
		List<Customer> customer = new ArrayList<>();
		for (CustomerVO cus : customervo) {
			Customer cus1 = new Customer();
			//cus1.setCusId(cus.getId());
			cus1.setCusName(cus.getName());
			customer.add(cus1);
		}
		cusRepo.saveAll(customer);
	}

	public void updateCustomer(String id, CustomerVO customer) {
		// TODO Auto-generated method stub
		Customer cus = cusRepo.findByCusId(id);
		System.out.println(cus);
		cus.setCusName(customer.getName());
		cusRepo.save(cus);
	}

	@Transactional
	public void deleteCustomer(String id) {
		cusRepo.deleteByCusId(id);

	}

	public Customer getCustomerDetailsByCusId(String cusid) {
		// TODO Auto-generated method stub
		return cusRepo.findByCusId(cusid);
	}
}
