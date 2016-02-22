package com.pdaures.csi.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pdaures.csi.da.DataSourceProvider;

/**
 * Dao to access to table USERS_TOKENS
 * This table contains security tokens to authenticate users
 * @author patrick
 *
 */
@Service(value="userTokenDao")
public class UserTokenDao implements InitializingBean {
	
	@Autowired
	private DataSourceProvider dataSourceProvider;
	
	private JdbcTemplate jdbcTemplate;
    
    public String getUserFromToken(String token){
    	return this.jdbcTemplate.queryForObject("SELECT USER_ID FROM USER_TOKENS WHERE TOKEN ="+token, String.class);
    }

	public void afterPropertiesSet() throws Exception {
		this.jdbcTemplate = new JdbcTemplate(dataSourceProvider.getDataSource());
	}
}
