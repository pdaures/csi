package com.pdaures.csi.service;

import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	public String getUserFromToken(String token) {
		return "pdaures";
	}

}
