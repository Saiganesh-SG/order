package com.example.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="branchdtl",catalog="bank")
public class BranchDtl {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	//It represents bidirectional 
	/*@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "BRANCH_ID",referencedColumnName="id")
	private Branch branch;*/
	
	@Column(name="PINCODE")
	private String pincode;
	
	

}
