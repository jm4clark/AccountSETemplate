package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.*;

import com.qa.business.service.AccountService;

@Path("/accounts")
public class AccountEndPoint {

	@Inject
	private AccountService service;

	@GET
	@Path("/getAllAccounts")
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@PUT
	@Path("/createAccount")
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return service.createAccount(account);
	}

}
