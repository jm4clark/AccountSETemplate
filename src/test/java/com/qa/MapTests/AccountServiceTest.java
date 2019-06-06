package com.qa.MapTests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private JSONUtil util;
	private AccountMapRepository repo;

	Account acc1;
	Account acc2;
	Account acc3;
	Account acc1New;

	@Before
	public void setup() {
		util = new JSONUtil();
		repo = new AccountMapRepository();

		acc1 = new Account("Rad", "Dad");
		acc2 = new Account("Mad", "Lad");

		acc1New = new Account("Bad", "Dad");
		
		acc3 = new Account("Mad", "Sad");
	}

	@Test
	public void addAccountTest() {
		repo.createAccount(util.getJSONForObject(acc1));

		assertEquals(acc1.getFirstName(), repo.getAccount(acc1.getID()).getFirstName());
	}

	@Test
	public void add2AccountsTest() {

		repo.createAccount(util.getJSONForObject(acc1));
		repo.createAccount(util.getJSONForObject(acc2));
		
		System.out.println(acc1.getID() + repo.getAccount(acc1.getID()).getID());
		
		assertEquals(acc1.getFirstName(), repo.getAccount(acc1.getID()).getFirstName());
		assertEquals(acc2.getFirstName(), repo.getAccount(acc2.getID()).getFirstName());
	}

	@Test
	public void updateAccountTest() {
		repo.createAccount(util.getJSONForObject(acc1));

		repo.updateAccount(acc1.getID(), util.getJSONForObject(acc1New));

		assertEquals(acc1New.getFirstName(), repo.getAccount(acc1.getID()).getFirstName());
	}

	@Test
	public void removeAccountTest() {
		repo.createAccount(util.getJSONForObject(acc1));

		repo.deleteAccount(acc1.getID());
		assertEquals(null, repo.getAccount(acc1.getID()));
	}

	@Test
	public void remove2AccountsTest() {
		repo.createAccount(util.getJSONForObject(acc1));
		repo.createAccount(util.getJSONForObject(acc2));

		repo.deleteAccount(acc1.getID());
		repo.deleteAccount(acc2.getID());

		assertEquals(null, repo.getAccount(acc1.getID()));
		assertEquals(null, repo.getAccount(acc2.getID()));
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		repo.createAccount(util.getJSONForObject(acc1));
		repo.createAccount(util.getJSONForObject(acc2));

		repo.deleteAccount(acc1.getID());
		repo.deleteAccount(acc2.getID());
		repo.deleteAccount(3);

		assertEquals(null, repo.getAccount(acc1.getID()));
		assertEquals(null, repo.getAccount(acc2.getID()));
		assertEquals("No account to delete", repo.deleteAccount(3));
	}

	@Test
	@Ignore
	public void jsonStringToAccountConversionTest() {
		assertEquals(acc1,util.getObjectForJSON(util.getJSONForObject(acc1), Account.class));
	}

	@Test
	@Ignore
	public void accountConversionToJSONTest() {
		assertEquals(acc1,util.getObjectForJSON(util.getJSONForObject(acc1), Account.class));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		repo.createAccount(util.getJSONForObject(acc1));
		
		assertEquals(0, repo.getAccountsByName("Jim").size());
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		
		repo.createAccount(util.getJSONForObject(acc1));
		
		assertEquals(1, repo.getAccountsByName(acc1.getFirstName()).size());
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		repo.createAccount(util.getJSONForObject(acc2));
		repo.createAccount(util.getJSONForObject(acc3));
		
		
		
		assertEquals(2, repo.getAccountsByName("Mad").size());
	}

}
