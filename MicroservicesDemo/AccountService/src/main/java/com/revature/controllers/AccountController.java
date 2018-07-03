package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
public class AccountController {
	
	protected Logger logger = Logger.getLogger(AccountController.class.getName());

	private List<Account> accounts;
	
	public AccountController() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1,1,40.34));
		accounts.add(new Account(2,2,500.24));
		accounts.add(new Account(3,1,403.87));
		accounts.add(new Account(4,3,16.00));
		accounts.add(new Account(5,4,1200.45));
		accounts.add(new Account(6,2,120.97));
		accounts.add(new Account(7,1,640.24));
		accounts.add(new Account(8,4,480.38));
	}
	
	@GetMapping
	public List<Account> findAll(){
		logger.info("Account.findAll()");
		return accounts;
	}
	
	@GetMapping(value="{accountId}")
	public Account findByAccountId(@PathVariable("accountId") int accountId) {
		logger.info("finding account by id");
		for(Account a: accounts) {
			if(accountId == a.getAccountId()) {
				return a;
			}
		}
		return null;
	}
	
	@GetMapping(value="customer/{customerId}")
	public List<Account> findByCustomerId(@PathVariable("customerId") int customerId){
		logger.info("finding accounts by customer");
		return accounts.stream().filter(acct -> acct.getCustomerId()==customerId).collect(Collectors.toList());
	}
	
}
