package com.pdaures.csi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pdaures.csi.model.Account;


@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


	public Account findAccount(String userId) {
		LOGGER.info("Loading account information for user "+userId);
		return new Account("Patrick", "Daures");
	}
	
}
