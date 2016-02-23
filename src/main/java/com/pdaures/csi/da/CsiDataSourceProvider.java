package com.pdaures.csi.da;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author patrick
 *
 */
@Service(value = "dataSourceProvider")
public class CsiDataSourceProvider implements DataSourceProvider, InitializingBean {

	private DataSource dataSource;

	public CsiDataSourceProvider() {
		this.dataSource = new DataSource();
		dataSource.setUrl("jdbc:h2:mem:dataSource");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		dataSource.setMaxActive(10);
		dataSource.setMinIdle(1);
		dataSource.setValidationQuery("SELECT 1 from DUAL;");
	}

	public javax.sql.DataSource getDataSource() {
		return dataSource;
	}

	public void afterPropertiesSet() throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		initTableUserTokens(jdbcTemplate);
		initTableUsers(jdbcTemplate);
	}

	private void initTableUserTokens(JdbcTemplate jdbcTemplate) {
		jdbcTemplate
				.update("CREATE TABLE USER_TOKENS (USER_ID CHAR(255) NOT NULL, TOKEN CHAR(255) NOT NULL, PRIMARY KEY (TOKEN));");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('bobama','token_obama');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('amerkel','token_merkel');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('fhollande','token_hollande');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('drousseff','token_rousseff');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('dcameron','token_cameron');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('aghani','token_ghani');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('bnishani','token_nishani');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('mmacri','token_macri');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('ahamid','token_hamid');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('lzinsou','token_zinsou');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('pbiya','token_biya');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('jtrudeau','token_trudeau');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('xjinping','token_jinping');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('rcastro','token_castro');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('rcorrea','token_correa');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('jsipila','token_sipila');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('atsipras','token_tsipras');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('ccorreia','token_correia');");


	}
	
	private void initTableUsers(JdbcTemplate jdbcTemplate) {
		jdbcTemplate
				.update("CREATE TABLE USERS (USER_ID CHAR(255) NOT NULL, FIRST_NAME CHAR(255) NOT NULL, LAST_NAME CHAR(255) NOT NULL, COUNTRY CHAR(255), PRIMARY KEY (USER_ID));");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('bobama','barak', 'obama', 'USA');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('amerkel','angela', 'merkel', 'Germany');");
		jdbcTemplate.update("INSERT INTO USERS (USER_ID, FIRST_NAME, LAST_NAME) VALUES ('fhollande','francois','hollande');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('drousseff','dima','rousseff', 'Brazil');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('dcameron','david','cameron', 'UK');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('aghani','Ashraf','Ghani', 'Afghanistan');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('bnishani','Bujar','Nishani', 'Albania');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('mmacri','Mauricio','Macri', 'Argentina');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('ahamid','Abdul','Hamid', 'Bangladesh');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('lzinsou','lionel','zinsou', 'Benin');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('pbiya','lionel','zinsou', 'Benin');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('jtrudeau','Justin','Trudeau', 'Canada');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('xjinping','Xi','Jinping', 'China');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('rcastro','Raul','Castro', 'Cuba');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('rcorrea','Raphael','Correa', 'Ecuador');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('jsipila','Juha','Sipila', 'Finland');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('atsipras','Alexis','Tsipras', 'Greece');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('ccorreia','Carlos','Correia', 'Guinea-Bissau');");

		



	}

}
