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
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('bobama','123456789freufre');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('amerkel','43584754548frebsrt');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('fhollande','249545fhrebfrea');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('drousseff','143frfr45fhrebfrea');");
		jdbcTemplate.update("INSERT INTO USER_TOKENS VALUES ('dcameron','free23433frfr45fhrebfrea');");
	}
	
	private void initTableUsers(JdbcTemplate jdbcTemplate) {
		jdbcTemplate
				.update("CREATE TABLE USERS (USER_ID CHAR(255) NOT NULL, FIRST_NAME CHAR(255) NOT NULL, LAST_NAME CHAR(255) NOT NULL, PRIMARY KEY (USER_ID));");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('bobama','barak', 'obama');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('amerkel','angela', 'merkel');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('fhollande','francois','hollande');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('drousseff','dima','rousseff');");
		jdbcTemplate.update("INSERT INTO USERS VALUES ('dcameron','david','cameron');");
	}

}
