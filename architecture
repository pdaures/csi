#Architecture

**Database Structure**
-USER_TOKENS
-- TOKEN CHAR(255) Primary Key : *security token from http request to identify a user*
-- USER_ID CHAR(255) NOT NULL *client userId*
-USERS
-- USER_ID CHAR(255) Primary Key *client's userId*
-- FIRST_NAME CHAR(255) NOT NULL *client's first name*
-- LAST_NAME CHAR(255) NOT NULL *client's last name*
-- COUNTRY CHAR(255) *client's country*

**Webfilters :** 
- AuthenticationFilter : checks the request attributes "token" and load associated user from the table USER_TOKENS.

**Controller :**
- AccountOverviewController : render the accountOverviewController.jsp

**Services:**
- AuthenticationServiceImpl : get a userId from a security token
- AccountServiceImpl : get the Account details from DB and update stats.
- Stats : holds the counts for unique client who accessed their accounts + keep counts by country

**DAO**
- AccountDao : Read only Dao to access USERS table by userId
- UserTokenDao : Read only Dao to access USER_TOKENS table by userId

**DB Config**
- CsiDataSourceProvider: Provides a DataSource and creates the tables at startup


#Request processing
