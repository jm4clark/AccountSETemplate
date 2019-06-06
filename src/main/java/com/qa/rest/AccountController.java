//package com.qa.rest;
//
//import javax.inject.Inject;
//import javax.ws.rs.*;
//
//import com.qa.business.service.AccountService;
//
//@Path("/accounts")
//public class AccountController {
//
//	@Inject
//	private AccountService accountService;
//	
//	
//	@GET
//	@Path("/getAllAccounts")
//	
//	public String getAllAccounts() {
//		return accountService.getAllAccounts();
//	}
//	
//	@POST
//	@Path("/createAccount")
//	@Produces({ "application/json" })
//	public String createAccount(String account) {
//		return accountService.createAccount(account);
//	}
//}
