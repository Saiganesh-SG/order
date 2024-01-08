package com.example.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.entity.Customer;
import com.example.order.model.CustomerVO;
import com.example.order.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired 
	CustomerService cusService;
	
	@GetMapping(value ="customer/cusid")
	public ResponseEntity<Customer> getCustomerDetailsByCustomerId(@RequestParam String cusId) {
		Customer customer =  cusService.fetchCustomerDataByCustomerId(cusId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	/*@GetMapping(value ="customer/cusiddtl")
	public Customer getCustomerDetailsCustomerId(@RequestParam String cusId) {
		return cusService.fetchCustomerDataByCustomerId(cusId);
	}*/
	
	@GetMapping(value = "customer/cusname")
	public Customer getCustomerDetailsByCustomerName(@RequestParam String cusName) {
		return cusService.getCustomerDetailsByCustomerName(cusName);
		
	}
	
	@GetMapping(value = "customer/cusnamedtlsnew")
	public List<Customer> FetchallCustomerDetailsByCustomerId(@RequestBody List<CustomerVO> customervo) {
		return cusService.fetchAllCustomerDetailsByCustomerId(customervo);
	}
	
/*	@GetMapping(value ="customer/fetchallcusdetailsbycusid")
	
	public List<Customer> getAllCustomerDetailsByCustomerId(@RequestBody List<CustomerVO> customervo) {
	
			return cusService.getAllCustomerDetailsByCustomerId(customervo);
			
	}*/
	
@GetMapping(value ="customer/getallcustomerdetails")

public List<Customer> getAllCustomerDetailsByCustomerId(@RequestBody List<CustomerVO> customervo) {
	return cusService.getAllCustomerDetailsByCustomerId(customervo);
}

	
/*@GetMapping(value="customer/fetchallcusdetailsbycusname")

public List<Customer> fetchAllCustomerDetailsByCustomerName(@RequestBody List<CustomerVO> customervo) {
	return cusService.fetchAllCustomerDetailsByCustomerName(customervo);
}*/

@GetMapping(value="customer/fetchallcusdetailsbycusname")
public List<Customer> getAllCustomerDetailsByCustomerName(@RequestBody List<CustomerVO> customervo) {
	return cusService.getAllCustomerDetailsByCustomerName(customervo);
}

@GetMapping(value="customer/getallcusdetailsbycusnameandcusid")
public List<Customer> getAllCustomerDetailsByCustomerNameAndCustomerId(@RequestBody List<CustomerVO> customervo) {
	return cusService.getAllCustomerDetailsByCustomerNameAndCustomerId(customervo);
}

	
@PostMapping(value="customerdetails/save") 

public String createCustomerDet(@RequestBody CustomerVO customervo) {
	cusService.saveCustomer(customervo);
	return "success";
}

@PutMapping(value="customer/customerupdatebyid")

public String updateCustomerNameBycusId(@RequestBody CustomerVO customervo) {

	cusService.updateCustomerNameBycusId(customervo);
	return "success";
	
}

@DeleteMapping(value ="customer/customerdeletebycusid")

public String DeleteCustomerDetailsByCusId(@RequestParam String cusId) {
   
cusService.DeleteCustomerDetailsByCusId(cusId);

return "Success";
}

@DeleteMapping(value ="customer/customerdeleteallbycusid")

public String deleteallCustomerByCusId(@RequestBody List<CustomerVO> customervo) {
	cusService.deleteallCustomerByCusId(customervo);
	return "success";
}

@PutMapping(value="customer/customerupdateallbycusid") 

public String updateAllCustomerByCusId(@RequestBody List<CustomerVO> customervo) {
	cusService.updateAllCustomerByCusId(customervo);
	return "Success";
}


	 }
