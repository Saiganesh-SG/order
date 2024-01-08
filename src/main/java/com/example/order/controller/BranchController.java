package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.exception.OrderException;
import com.example.order.model.BranchVO;
import com.example.order.service.BranchService;

@RestController
public class BranchController {

	private static final String SUCCESS = "success";
	private static final String FAILED = "failed";
	@Autowired
	BranchService branchService;

	@PostMapping(value = "/branch/addbranch/{branchName}")

	public ResponseEntity<String> addBranchDtls(@PathVariable String branchName, @RequestBody BranchVO branchVo) throws OrderException {
		String status = branchService.insertBranchDetails(branchVo);
		System.out.println("The value of path variable branchName:"+branchName);
		if (SUCCESS.equalsIgnoreCase(status)) {
			return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(FAILED, HttpStatus.BAD_REQUEST);
		}
	}
}
