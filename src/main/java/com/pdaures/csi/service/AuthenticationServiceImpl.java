package com.pdaures.csi.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.pdaures.csi.dao.UserTokenDao;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private UserTokenDao dao;
	

	public String getUserFromToken(String token) {
		return dao.getUserFromToken(token);
	}

}
