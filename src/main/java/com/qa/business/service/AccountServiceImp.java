package com.qa.business.service;

import com.qa.persistence.repository.*;

import javax.inject.Inject;

public class AccountServiceImp implements AccountService{

	@Inject
	private AccountRepository repo;
	
	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		return repo.createAccount(account);
	}

	@Override
	public String deleteAccount(int accountNumber) {
		return repo.deleteAccount(accountNumber);
	}

	@Override
	public String updateAccount(int accountNumber, String account) {
		return repo.updateAccount(accountNumber, account);
	}

}
