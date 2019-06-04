package com.qa.persistence.repository;



import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	

	JSONUtil jsonutil = new JSONUtil();
	
	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
	
	//You must provide concrete implementation for each of these methods
	//do not change the method signature
	//THINK - if the parameter is a String, or the return type is a String
	//How can I convert to a String from an Object?
	//What utility methods do I have available?
	
	//You must complete this section using TDD
	//You can use the suggested tests or build your own.

	public String getAllAccounts() {
		return accountMap.toString();
	}
	
	public String getAccountJSON(int id) {
		return jsonutil.getJSONForObject(accountMap.get(id));
	}
	
	public Account getAccount(int id) {
		return accountMap.get(id);
	}

	public String createAccount(String account) {
		Account acc = jsonutil.getObjectForJSON(account, Account.class);
		accountMap.put(acc.getID(), acc);
		return "Created account";
	}

	public String deleteAccount(int id) {
		accountMap.remove(id);
		return "Deleted account";
	}

	public String updateAccount(int id, String account) {
		Account newAcc = jsonutil.getObjectForJSON(account, Account.class);
		accountMap.replace(id, newAcc);
		return "Updated account";
	}

}
