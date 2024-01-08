package com.example.order.model;

import java.util.List;

import lombok.Data;

@Data
public class BranchVO {

	private String branchName;
	private List<String> customerId;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<String> getCustomerId() {
		return customerId;
	}

	public void setCustomerId(List<String> customerId) {
		this.customerId = customerId;
	}

}
