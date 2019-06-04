package com.qa.MapTests;

import static org.junit.Assert.*;

import javax.rmi.CORBA.Util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	JSONUtil util = new JSONUtil();
	AccountMapRepository repo = new AccountMapRepository();

	@Before
	public void setup() {
	}

	@Test
	public void addAccountTest() {
		Account a = new Account("Dude", "Guy");
		repo.createAccount(util.getJSONForObject(a));

		assertTrue(repo.getAccount(a.getID()) != null);
	}

	@Test
	public void add2AccountsTest() {
		Account a = new Account("Rad", "Dad");
		Account b = new Account("Mad", "Lad");
		
		repo.createAccount(util.getJSONForObject(a));
		repo.createAccount(util.getJSONForObject(b));
		
		System.out.println(util.getJSONForObject(a) + util.getJSONForObject(b));
		
		assertTrue(repo.getAccount(a.getID()) != null && repo.getAccount(b.getID()) != null);
	}

	@Test
	public void removeAccountTest() {
		Account a = new Account("Mad", "Lad");
		repo.createAccount(util.getJSONForObject(a));
		System.out.println(util.getJSONForObject(a) + util.getJSONForObject(a));
		
		System.out.println(repo.getAccount(a.getID()));
		
		repo.deleteAccount(a.getID());
		assertEquals(null, repo.getAccount(a.getID()));
	}

	@Test
	public void remove2AccountsTest() {
		
		Account a = new Account("Rad", "Dad");
		Account b = new Account("Mad", "Lad");
		
		repo.createAccount(util.getJSONForObject(a));
		repo.createAccount(util.getJSONForObject(b));
		
		repo.deleteAccount(a.getID());
		repo.deleteAccount(b.getID()); 
		
		assertTrue(repo.getAccount(a.getID()) == null && repo.getAccount(b.getID()) == null);
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");
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
