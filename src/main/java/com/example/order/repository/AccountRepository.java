package com.example.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.order.entity.Account;
import com.example.order.entity.Customer;

@Repository
public interface AccountRepository  extends JpaRepository<Account,Integer> {

	/*List<Account> findByCustomer(Customer i);

	List<Account> findByCustomerAndStatus(Customer i, String string);
	
	@Query(nativeQuery = true, value ="select CUS_NAME from bank.customer c INNER join bank.account a on a.CUS_ID =c.ID where "
			+ "a.ACCOUNT_ID =:ACC_ID")
			String getCustomerNameByAccountId(@Param ("ACC_ID") String accId);*/

}
