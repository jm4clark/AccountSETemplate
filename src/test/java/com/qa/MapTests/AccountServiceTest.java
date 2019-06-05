package com.qa.MapTests;

import static org.junit.Assert.*;

import javax.rmi.CORBA.Util;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private JSONUtil util;
	private AccountMapRepository repo;

	Account acc1;
	Account acc2;
	Account acc1New;

	@Before
	public void setup() {
		util = new JSONUtil();
		repo = new AccountMapRepository();

		acc1 = new Account("Rad", "Dad");
		acc2 = new Account("Mad", "Lad");

		acc1New = new Account("Bad", "Dad");
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
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}

}
