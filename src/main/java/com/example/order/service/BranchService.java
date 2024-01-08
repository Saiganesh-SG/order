package com.example.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.order.entity.Branch;
import com.example.order.entity.Customer;
import com.example.order.exception.OrderException;
import com.example.order.model.BranchVO;
import com.example.order.repository.BranchRepo;
import com.example.order.repository.CustomerRepository;

@Service
public class BranchService {

	@Autowired
	BranchRepo branchRepo;

	@Autowired
	CustomerRepository cusRepo;

	public List<Branch> findallBranchIdDtls() {
		return branchRepo.findAll();
	}

	@Transactional
	public List<List<String>> getAllCustomerName() {
		List<Branch> branch = branchRepo.findAll();
		List<Customer> listCustomer = branch.stream()
				.filter(branchName -> branchName.getBranchName().equalsIgnoreCase("Chennai")
						|| branchName.getBranchName().equalsIgnoreCase("Bangalore"))
				.map(x -> x.getCustomers()).flatMap(List::stream).collect(Collectors.toList());
		List<Object> listCustomer2 = branch.stream().map(Branch::getBranchName).collect(Collectors.toList());
		System.out.println(listCustomer2);
		List<String> listCustomerName = listCustomer.stream().map(Customer::getCusName).collect(Collectors.toList());
		System.out.println("listCustomerName:" + listCustomerName);
		return null;
	}

	@Transactional
	public String insertBranchDetails(BranchVO branchVo) throws OrderException {
		String status = "failed";
		try {
			Branch branch = new Branch();
			branchVo = null;
			if (branchVo == null) {
				status = "unauthorised";
				throw new OrderException("BranchVO is null");
			}
			branch.setBranchName(branchVo.getBranchName());
			List<Customer> customerlist = cusRepo.findAllByCusIdIn(branchVo.getCustomerId());
			branch.setCustomers(customerlist);
			branchRepo.save(branch);
			status = "success";
		} catch (OrderException oe) {
			System.out.println("Insert Branch failed- " + oe.getMessage());
			throw new OrderException(oe.getMessage());
		} catch (Exception e) {
			System.out.println("Insert Branch failed- " + e.getMessage());
			throw new OrderException(e.getMessage());
		} finally {
			System.out.println("finally block");
		}
		return status;
	}

}
