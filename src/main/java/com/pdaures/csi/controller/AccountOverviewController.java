package com.pdaures.csi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pdaures.csi.model.Account;
import com.pdaures.csi.service.AccountService;

@Controller
public class AccountOverviewController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountOverviewController.class);
	
	@Autowired
	private AccountService service;

	@RequestMapping(value ="/accountOverview.htm")
	public void accountOverview (Model model, HttpServletRequest request) {
		String remoteUser = request.getRemoteUser();
		LOGGER.info("Display account overview of user "+remoteUser);
		
		Account account = service.findAccount(remoteUser);
		if(account == null){
			throw new IllegalStateException("Account for found for user "+remoteUser);
		}
		
		model.addAttribute("firstName", account.getFirstName());
		model.addAttribute("lastName", account.getLastName());

		return;
	}
	
}
