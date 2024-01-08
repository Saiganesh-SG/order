package com.example.order.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="branch",catalog="bank")
public class Branch {

		// TODO Auto-generated method stub
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="BRANCH_NAME")
		private String branchName;
		
		//It represents bidirectional 
	/*	@OneToMany(mappedBy="branch",fetch=FetchType.EAGER)
		// @JoinColumn(name="id")*/
		
		//It represents unidirectional
		@OneToMany(fetch=FetchType.LAZY)
		@JoinColumn(name = "BRANCH_ID")
		private List<BranchDtl> branchdtl;
		
		@ManyToMany(fetch=FetchType.LAZY)
		@JoinTable(name = "branch_customer_mapping",catalog="bank",joinColumns=@JoinColumn(name="branch_id"),inverseJoinColumns=@JoinColumn(name="customer_id"))
		private List<Customer> customers;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getBranchName() {
			return branchName;
		}

		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}

		public List<BranchDtl> getBranchdtl() {
			return branchdtl;
		}

		public void setBranchdtl(List<BranchDtl> branchdtl) {
			this.branchdtl = branchdtl;
		}

		public List<Customer> getCustomers() {
			return customers;
		}

		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}
		
		/*public static String getBranchName() {
			return "Branch";
		}*/
		
		

}
