package com.pdaures.csi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdaures.csi.model.Account;
import com.pdaures.csi.service.Stats;
import com.pdaures.csi.dao.AccountDao;
import com.pdaures.csi.model.Account;


@Service("accountService")
public class AccountServiceImpl implements AccountService {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountDao dao;

	@Autowired
	private Stats stats;

	public Account findAccount(String userId) {
		LOGGER.info("Loading account information for user "+userId);
		Account account = dao.getUserAccount(userId);
		
		//Increment the Country counters for marketing purpose
		stats.incrementCountryCounter(account.getCountry());

		stats.addDailyVisitor(userId);
		return account;
	}
	
}
