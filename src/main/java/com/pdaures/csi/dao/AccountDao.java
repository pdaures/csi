package com.pdaures.csi.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import com.pdaures.csi.model.Account;
import java.lang.IllegalStateException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pdaures.csi.da.DataSourceProvider;

/**
 * Dao to access to table USERS_TOKENS
 * This table contains security tokens to authenticate users
 * @author patrick
 *
 */
@Service(value="accountDao")
public class AccountDao implements InitializingBean {
	
	@Autowired
	private DataSourceProvider dataSourceProvider;
	
	private JdbcTemplate jdbcTemplate;
    
    public Account getUserAccount(String userId){
    	List<Account> accounts = this.jdbcTemplate.query("SELECT FIRST_NAME, LAST_NAME, COUNTRY FROM USERS WHERE USER_ID='"+userId+"';", new AccountMapper());
    	if(accounts.size() > 1){
    		throw new IllegalStateException("Multiple account found for user "+userId);
    	}
    	return accounts.isEmpty() ? null : accounts.get(0);
    }

	public void afterPropertiesSet() throws Exception {
		this.jdbcTemplate = new JdbcTemplate(dataSourceProvider.getDataSource());
	}
	
	public class AccountMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Account(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("COUNTRY"));
		}
		
	}
}
