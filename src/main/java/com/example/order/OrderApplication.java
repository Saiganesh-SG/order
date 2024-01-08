package com.example.order;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.example.order.entity.Account;
import com.example.order.entity.Book;
import com.example.order.entity.Branch;
import com.example.order.entity.Customer;
import com.example.order.repository.BookRepository;
import com.example.order.repository.CustomerRepository;
import com.example.order.service.AccountService;
import com.example.order.service.BranchService;
import com.example.order.service.CustomerService;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		// SpringApplication.run(OrderApplication.class, args);
		org.springframework.context.ApplicationContext appContext = SpringApplication.run(OrderApplication.class, args);
		// AccountService accService = appContext.getBean(AccountService.class);
		// System.out.println(accService.fetchAllAccounts().stream().map(x->x.getCusId()).collect(Collectors.toList()));
		// System.out.println(accService.fetchAccountsByCusId(1).stream().map(x->x.getCustomer()).collect(Collectors.toList()));
		// System.out.println(accService.fetchAllAccounts());

		// System.out.println(cusService.fetchCustomersDetailsByCusId("SB1234679"));
		// AddressService addressService = appContext.getBean(AddressService.class);
		// System.out.println(addressService.fetchAllAddress());
		// BranchService branchService = appContext.getBean(BranchService.class);

		/*
		 * List<Branch> branch = branchService.findallBranchIdDtls(); List<List<String>>
		 * listPinCode = branch.stream().map(x->{ return
		 * x.getBranchdtl().stream().map(y->y.getPincode()).collect(Collectors.toList())
		 * ; }).collect(Collectors.toList());
		 * System.out.println("listPinCode:"+listPinCode);
		 */
		BookRepository bookRepo = appContext.getBean(BookRepository.class);
		System.out.println(bookRepo.getClass().getName());
		Book b = new Book();
		
		b.setbookId(103);
		b.setbookName("DevOPs");
		b.setbookprice(5600.00);
		bookRepo.save(b);

		/*
		 * CustomerService cusService = appContext.getBean(CustomerService.class);
		 * List<Customer> customer = cusService.fetchAllCustomer();
		 * 
		 * List<String> cusnameList = customer.stream().filter(x ->
		 * x.getCusName().startsWith("R"))
		 * .map(Customer::getCusName).collect(Collectors.toList());
		 * 
		 * cusnameList.forEach(System.out::println);
		 * 
		 * List<String> cusidList = customer.stream() .filter(x ->
		 * x.getCusId().equals("SB0003") |
		 * x.getCusId().equals("SB0004")).map(Customer::getCusId)
		 * .collect(Collectors.toList());
		 * 
		 * cusidList.forEach(System.out::println);
		 */

		/*
		 * List<String> customerNameList = customer.stream().filter(x ->
		 * x.getCusName().startsWith("R")) .map(x ->
		 * x.getCusName()).collect(Collectors.toList()); customerNameList.forEach(x ->
		 * System.out.println("The name list are:" + x));
		 */
		/*
		 * List<List<Account>> accountlist = customer.stream().map(x ->
		 * x.getAccount()).collect(Collectors.toList()); List<Account> acclist =
		 * accountlist.stream().flatMap(List::stream).collect(Collectors.toList());
		 * List<String> accountidlist = acclist.stream().map(x ->
		 * x.getAccountId()).collect(Collectors.toList());
		 * accountidlist.forEach(System.out::println);
		 */
		// Customer customer = cusService.fetchCustomerDataByCustomerId("SB0002");
		// System.out.println("customer name:" + customer.getCusName());

		// branchService.getAllCustomerName();
		// branchService.insertBranchDetails();
	}
}
