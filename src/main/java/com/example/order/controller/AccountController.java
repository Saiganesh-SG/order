package com.example.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.entity.Customer;
import com.example.order.model.CustomerVO;
import com.example.order.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	AccountService accService;

	@GetMapping(value = "/account/customername")

	public String getCustomerName(@RequestParam String accid) {
		String customerName=accService.getCustomerNameByAccountId(accid);
		return customerName;
	}
	
	@GetMapping(value = "/customer/customerid")

	public Customer getCustomerDetails(@RequestParam String id) {
		Customer customer=accService.getCustomerDetailsByCusId(id);
		return customer;
	}
	
	
	@GetMapping(value = "/account/customername/vrt")

	public Integer getSquareRoot(@RequestParam Integer i) {
		i=i*i;
		return  i;
	}
	
	@PostMapping(value = "/account/customername/rrt")

	public Integer getSquareRootp(@RequestParam Integer i) {
		i=i*i;
		return  i;
	}
	
	@PostMapping(value = "/account/customername/grt")

	public Integer getSquareRootBody(@RequestBody CustomerVO i) {
		Integer a=0;
		a=a.parseInt(i.getId());
		a=a*a;
		System.out.println("a:"+a);
		return  a;
	}
	
@PostMapping(value = "/customer/save")
	public String createCustomer(@RequestBody CustomerVO customer) {
		accService.saveCustomer(customer); 
		return "success";
	}
	
	
@PostMapping(value = "/customerlist/save")
public String createCustomerList(@RequestBody List<CustomerVO> customer) {
	accService.saveCustomerList(customer); 
	return "success";
}

@PutMapping(value = "/customer/update/put")
public String updateCustomerPut(@RequestParam String id,@RequestBody CustomerVO customer) {
	accService.updateCustomer(id,customer);
	return "success";
}

@PostMapping(value = "/customer/update/post")
public String updateCustomerPost(@RequestParam String id,@RequestBody CustomerVO customer) {
	accService.updateCustomer(id,customer);
	return "success";
}

@DeleteMapping(value = "/customer/delete")
public String updateCustomerDelete(@RequestParam String id) {
	accService.deleteCustomer(id);
	return "success";
}
}
