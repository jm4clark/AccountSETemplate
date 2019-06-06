package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;
import com.qa.util.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(TxType.SUPPORTS)
public class AccountDBRepo {

	private JSONUtil util = new JSONUtil();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public List<Account> getAllAccounts() {
		return manager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
	}

	@Transactional(TxType.REQUIRED)
	public Account findAccount(int id) {
		return manager.find(Account.class, id);
	}

	@Transactional(TxType.REQUIRED)
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		manager.persist(acc);
		return util.messageToJSON("Created account");
	}

	@Transactional(TxType.REQUIRED)
	public String deleteAccount(int id) {
		
		if (manager.find(Account.class, id) != null) {
			manager.remove(id);
			return util.messageToJSON("Deleted account");
		}
		return util.messageToJSON("No account to delete");
	}
}
