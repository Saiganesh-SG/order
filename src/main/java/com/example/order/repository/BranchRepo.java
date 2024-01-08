package com.example.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.order.entity.Branch;

@Repository
public interface BranchRepo  extends JpaRepository<Branch,Integer> {
	
	List<Branch> findAll();

}
