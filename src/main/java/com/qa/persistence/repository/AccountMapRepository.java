package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	@Inject
	JSONUtil jsonutil;
	
	Map<Integer, Account> accountMap = new HashMap<>();

	// You must provide concrete implementation for each of these methods
	// do not change the method signature
	// THINK - if the parameter is a String, or the return type is a String
	// How can I convert to a String from an Object?
	// What utility methods do I have available?

	// You must complete this section using TDD
	// You can use the suggested tests or build your own.

	public String getAllAccounts() {
		String result = "";
		for (Account a : accountMap.values()) {
			result += jsonutil.getJSONForObject(a) + " ";
		}
		return result;
	}

	public String getAccountJSON(int id) {
		return jsonutil.getJSONForObject(accountMap.get(id));
	}

	public Account getAccount(int id) {
		return accountMap.get(id);
	}
	
	public List<Account> getAccountsByName(String name){
		
		List<Account> listWithNames = new ArrayList<>();
		for(Account a: accountMap.values()) {
			if(a.getFirstName().equals(name)) {
				listWithNames.add(a);
			}
		}
				
		return listWithNames;
	}

	public String createAccount(String account) {
		Account acc = jsonutil.getObjectForJSON(account, Account.class);
		accountMap.put(acc.getID(), acc);
		return "Created account";
	}

	public String deleteAccount(int id) {
		if (accountMap.get(id) != null) {
			accountMap.remove(id);
			return "Deleted account";
		}
		return "No account to delete";
	}

	public String updateAccount(int id, String account) {
		Account newAcc = jsonutil.getObjectForJSON(account, Account.class);
		accountMap.replace(id, newAcc);
		return "Updated account";
	}

}
