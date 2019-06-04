package com.qa.persistence.repository;



import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	JSONUtil jsonutil = new JSONUtil();
	
	Map<Long, Account> accountMap = new HashMap<Long, Account>();
	
	//You must provide concrete implementation for each of these methods
	//do not change the method signature

	public String getAllAccounts() {
		return accountMap.toString();
	}

	public String createAccount(String account) {
		Account acc = jsonutil.getObjectForJSON(account, Account.class);
		accountMap.put(acc.getID(), acc);
		return "Created account";
	}

	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return "Deleted account";
	}

	public String updateAccount(Long id, String account) {
		Account newAcc = jsonutil.getObjectForJSON(account, Account.class);
		accountMap.put(newAcc.getID(), newAcc);
		return "Updated account";
	}

}
