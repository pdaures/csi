#Case 2 : A DBA nightmare

#Victim interview:
Since this morning, no customer can access their accounts anymore. All clients have the same error.
It was working around 11:00, but the service has been down since 11:15

#Error on the client side:
- http://localhost:8080/csi/accountOverview.htm?token=token_obama
<pre>
description The server encountered an internal error () that prevented it from fulfilling this request.
exception
org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.springframework.jdbc.BadSqlGrammarException: StatementCallback; bad SQL grammar [SELECT FIRST_NAME, LAST_NAME, COUNTRY FROM USERS WHERE USER_ID='bobama';]; nested exception is org.h2.jdbc.JdbcSQLException: Table "USERS" not found; SQL statement:
SELECT FIRST_NAME, LAST_NAME, COUNTRY FROM USERS WHERE USER_ID='bobama'; [42102-191]
	org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:927)
	org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:811)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:617)
	org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:796)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:717)
	com.pdaures.csi.filter.AuthenticationFilter.doFilter(AuthenticationFilter.java:60)
</pre>



#Logs on the server:
<pre>
[24/02/16 11:11:49.872] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_obama
[24/02/16 11:11:49.902] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 11:11:49.902] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 11:11:49.903] INFO  [tp-8080-1] [Stats] - Country counter : USA: 1
[24/02/16 11:11:49.903] INFO  [tp-8080-1] [Stats] - Daily visitors :1
[24/02/16 11:11:52.502] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_merkel
[24/02/16 11:11:52.503] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user amerkel
[24/02/16 11:11:52.503] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user amerkel
[24/02/16 11:11:52.503] INFO  [tp-8080-1] [Stats] - Country counter : GERMANY: 1
[24/02/16 11:11:52.503] INFO  [tp-8080-1] [Stats] - Daily visitors :2
[24/02/16 11:12:06.224] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_biya
[24/02/16 11:12:06.226] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user pbiya
[24/02/16 11:12:06.226] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user pbiya
[24/02/16 11:12:06.227] INFO  [tp-8080-1] [Stats] - Country counter : BENIN: 1
[24/02/16 11:12:06.227] INFO  [tp-8080-1] [Stats] - Daily visitors :3
[24/02/16 11:12:10.438] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_obama
[24/02/16 11:12:10.439] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 11:12:10.439] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 11:12:10.440] INFO  [tp-8080-1] [Stats] - Country counter : USA: 2
[24/02/16 11:12:10.440] INFO  [tp-8080-1] [Stats] - Daily visitors :4
[24/02/16 11:12:13.585] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_jxiping
[24/02/16 11:12:13.586] INFO  [tp-8080-1] [AuthenticationFilter] - Unauthorized request for token token_jxiping
[24/02/16 11:12:16.116] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_jxinping
[24/02/16 11:12:16.117] INFO  [tp-8080-1] [AuthenticationFilter] - Unauthorized request for token token_jxinping
[24/02/16 11:14:16.098] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_obama
[24/02/16 11:14:16.100] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 11:14:16.100] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 11:14:16.100] INFO  [tp-8080-1] [Stats] - Country counter : USA: 3
[24/02/16 11:14:16.100] INFO  [tp-8080-1] [Stats] - Daily visitors :5
[24/02/16 11:14:26.633] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_obama
[24/02/16 11:14:26.634] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 11:14:26.634] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 11:14:26.635] INFO  [tp-8080-1] [Stats] - Country counter : USA: 4
[24/02/16 11:14:26.635] INFO  [tp-8080-1] [Stats] - Daily visitors :6
[24/02/16 11:14:33.094] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : ';drop table USERS;select * from USER_TOKENS WHERE USER_ID='
[24/02/16 11:14:33.100] INFO  [tp-8080-1] [AuthenticationFilter] - Unauthorized request for token ';drop table USERS;select * from USER_TOKENS WHERE USER_ID='
[24/02/16 11:14:36.574] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_merkel
[24/02/16 11:14:36.575] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user amerkel
[24/02/16 11:14:36.576] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user amerkel
[24/02/16 11:14:36.590] INFO  [tp-8080-1] [XmlBeanDefinitionReader] - Loading XML bean definitions from class path resource [org/springframework/jdbc/support/sql-error-codes.xml]
[24/02/16 11:14:36.632] INFO  [tp-8080-1] [SQLErrorCodesFactory] - SQLErrorCodes loaded: [DB2, Derby, H2, HSQL, Informix, MS-SQL, MySQL, Oracle, PostgreSQL, Sybase]
févr. 24, 2016 11:14:36 AM org.apache.catalina.core.StandardWrapperValve invoke
Grave: Servlet.service() for servlet DispatcherServlet threw exception
org.h2.jdbc.JdbcSQLException: Table "USERS" not found; SQL statement:
SELECT FIRST_NAME, LAST_NAME, COUNTRY FROM USERS WHERE USER_ID='amerkel'; [42102-191]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:345)
	at org.h2.message.DbException.get(DbException.java:179)
	at org.h2.message.DbException.get(DbException.java:155)
	at org.h2.command.Parser.readTableOrView(Parser.java:5349)
	at org.h2.command.Parser.readTableFilter(Parser.java:1245)
	at org.h2.command.Parser.parseSelectSimpleFromPart(Parser.java:1884)
	at org.h2.command.Parser.parseSelectSimple(Parser.java:2032)
	at org.h2.command.Parser.parseSelectSub(Parser.java:1878)
	at org.h2.command.Parser.parseSelectUnion(Parser.java:1699)
	at org.h2.command.Parser.parseSelect(Parser.java:1687)
	at org.h2.command.Parser.parsePrepared(Parser.java:443)
	at org.h2.command.Parser.parse(Parser.java:315)
	at org.h2.command.Parser.parse(Parser.java:287)
	at org.h2.command.Parser.prepareCommand(Parser.java:252)
	at org.h2.engine.Session.prepareLocal(Session.java:560)
	at org.h2.engine.Session.prepareCommand(Session.java:501)
	at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1188)
	at org.h2.jdbc.JdbcStatement.executeQuery(JdbcStatement.java:73)
	at org.springframework.jdbc.core.JdbcTemplate$1QueryStatementCallback.doInStatement(JdbcTemplate.java:441)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:396)
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:456)
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:464)
	at com.pdaures.csi.dao.AccountDao.getUserAccount(AccountDao.java:31)
	at com.pdaures.csi.service.AccountServiceImpl.findAccount(AccountServiceImpl.java:27)
	at com.pdaures.csi.controller.AccountOverviewController.accountOverview(AccountOverviewController.java:28)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:219)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:746)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:687)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:80)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:925)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:856)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:915)
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:811)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:617)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:796)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:717)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:290)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206)
	at com.pdaures.csi.filter.AuthenticationFilter.doFilter(AuthenticationFilter.java:60)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:235)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:233)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:191)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:127)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:102)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:109)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:298)
	at org.apache.coyote.http11.Http11Processor.process(Http11Processor.java:857)
	at org.apache.coyote.http11.Http11Protocol$Http11ConnectionHandler.process(Http11Protocol.java:588)
	at org.apache.tomcat.util.net.JIoEndpoint$Worker.run(JIoEndpoint.java:489)
	at java.lang.Thread.run(Thread.java:744)

[24/02/16 11:14:41.012] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_obama
[24/02/16 11:14:41.013] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 11:14:41.013] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user bobama
févr. 24, 2016 11:14:41 AM org.apache.catalina.core.StandardWrapperValve invoke
Grave: Servlet.service() for servlet DispatcherServlet threw exception
org.h2.jdbc.JdbcSQLException: Table "USERS" not found; SQL statement:
SELECT FIRST_NAME, LAST_NAME, COUNTRY FROM USERS WHERE USER_ID='bobama'; [42102-191]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:345)
	at org.h2.message.DbException.get(DbException.java:179)
	at org.h2.message.DbException.get(DbException.java:155)
	at org.h2.command.Parser.readTableOrView(Parser.java:5349)
	at org.h2.command.Parser.readTableFilter(Parser.java:1245)
	at org.h2.command.Parser.parseSelectSimpleFromPart(Parser.java:1884)
	at org.h2.command.Parser.parseSelectSimple(Parser.java:2032)
	at org.h2.command.Parser.parseSelectSub(Parser.java:1878)
	at org.h2.command.Parser.parseSelectUnion(Parser.java:1699)
	at org.h2.command.Parser.parseSelect(Parser.java:1687)
	at org.h2.command.Parser.parsePrepared(Parser.java:443)
	at org.h2.command.Parser.parse(Parser.java:315)
	at org.h2.command.Parser.parse(Parser.java:287)
	at org.h2.command.Parser.prepareCommand(Parser.java:252)
	at org.h2.engine.Session.prepareLocal(Session.java:560)
	at org.h2.engine.Session.prepareCommand(Session.java:501)
	at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1188)
	at org.h2.jdbc.JdbcStatement.executeQuery(JdbcStatement.java:73)
	at org.springframework.jdbc.core.JdbcTemplate$1QueryStatementCallback.doInStatement(JdbcTemplate.java:441)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:396)
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:456)
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:464)
	at com.pdaures.csi.dao.AccountDao.getUserAccount(AccountDao.java:31)
	at com.pdaures.csi.service.AccountServiceImpl.findAccount(AccountServiceImpl.java:27)
	at com.pdaures.csi.controller.AccountOverviewController.accountOverview(AccountOverviewController.java:28)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:219)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:746)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:687)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:80)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:925)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:856)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:915)
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:811)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:617)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:796)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:717)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:290)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206)
	at com.pdaures.csi.filter.AuthenticationFilter.doFilter(AuthenticationFilter.java:60)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:235)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:233)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:191)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:127)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:102)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:109)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:298)
	at org.apache.coyote.http11.Http11Processor.process(Http11Processor.java:857)
	at org.apache.coyote.http11.Http11Protocol$Http11ConnectionHandler.process(Http11Protocol.java:588)
	at org.apache.tomcat.util.net.JIoEndpoint$Worker.run(JIoEndpoint.java:489)
	at java.lang.Thread.run(Thread.java:744)

[24/02/16 11:14:55.864] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_merkel
[24/02/16 11:14:55.865] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user amerkel
[24/02/16 11:14:55.865] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user amerkel
févr. 24, 2016 11:14:55 AM org.apache.catalina.core.StandardWrapperValve invoke
Grave: Servlet.service() for servlet DispatcherServlet threw exception
org.h2.jdbc.JdbcSQLException: Table "USERS" not found; SQL statement:
SELECT FIRST_NAME, LAST_NAME, COUNTRY FROM USERS WHERE USER_ID='amerkel'; [42102-191]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:345)
	at org.h2.message.DbException.get(DbException.java:179)
	at org.h2.message.DbException.get(DbException.java:155)
	at org.h2.command.Parser.readTableOrView(Parser.java:5349)
	at org.h2.command.Parser.readTableFilter(Parser.java:1245)
	at org.h2.command.Parser.parseSelectSimpleFromPart(Parser.java:1884)
	at org.h2.command.Parser.parseSelectSimple(Parser.java:2032)
	at org.h2.command.Parser.parseSelectSub(Parser.java:1878)
	at org.h2.command.Parser.parseSelectUnion(Parser.java:1699)
	at org.h2.command.Parser.parseSelect(Parser.java:1687)
	at org.h2.command.Parser.parsePrepared(Parser.java:443)
	at org.h2.command.Parser.parse(Parser.java:315)
	at org.h2.command.Parser.parse(Parser.java:287)
	at org.h2.command.Parser.prepareCommand(Parser.java:252)
	at org.h2.engine.Session.prepareLocal(Session.java:560)
	at org.h2.engine.Session.prepareCommand(Session.java:501)
	at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1188)
	at org.h2.jdbc.JdbcStatement.executeQuery(JdbcStatement.java:73)
	at org.springframework.jdbc.core.JdbcTemplate$1QueryStatementCallback.doInStatement(JdbcTemplate.java:441)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:396)
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:456)
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:464)
	at com.pdaures.csi.dao.AccountDao.getUserAccount(AccountDao.java:31)
	at com.pdaures.csi.service.AccountServiceImpl.findAccount(AccountServiceImpl.java:27)
	at com.pdaures.csi.controller.AccountOverviewController.accountOverview(AccountOverviewController.java:28)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:219)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:746)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:687)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:80)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:925)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:856)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:915)
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:811)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:617)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:796)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:717)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:290)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206)
	at com.pdaures.csi.filter.AuthenticationFilter.doFilter(AuthenticationFilter.java:60)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:235)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:233)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:191)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:127)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:102)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:109)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:298)
	at org.apache.coyote.http11.Http11Processor.process(Http11Processor.java:857)
	at org.apache.coyote.http11.Http11Protocol$Http11ConnectionHandler.process(Http11Protocol.java:588)
	at org.apache.tomcat.util.net.JIoEndpoint$Worker.run(JIoEndpoint.java:489)
	at java.lang.Thread.run(Thread.java:744)

[24/02/16 11:14:58.674] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_hollande
[24/02/16 11:14:58.676] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user fhollande
[24/02/16 11:14:58.676] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user fhollande
févr. 24, 2016 11:14:58 AM org.apache.catalina.core.StandardWrapperValve invoke
Grave: Servlet.service() for servlet DispatcherServlet threw exception
org.h2.jdbc.JdbcSQLException: Table "USERS" not found; SQL statement:
SELECT FIRST_NAME, LAST_NAME, COUNTRY FROM USERS WHERE USER_ID='fhollande'; [42102-191]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:345)
	at org.h2.message.DbException.get(DbException.java:179)
	at org.h2.message.DbException.get(DbException.java:155)
	at org.h2.command.Parser.readTableOrView(Parser.java:5349)
	at org.h2.command.Parser.readTableFilter(Parser.java:1245)
	at org.h2.command.Parser.parseSelectSimpleFromPart(Parser.java:1884)
	at org.h2.command.Parser.parseSelectSimple(Parser.java:2032)
	at org.h2.command.Parser.parseSelectSub(Parser.java:1878)
	at org.h2.command.Parser.parseSelectUnion(Parser.java:1699)
	at org.h2.command.Parser.parseSelect(Parser.java:1687)
	at org.h2.command.Parser.parsePrepared(Parser.java:443)
	at org.h2.command.Parser.parse(Parser.java:315)
	at org.h2.command.Parser.parse(Parser.java:287)
	at org.h2.command.Parser.prepareCommand(Parser.java:252)
	at org.h2.engine.Session.prepareLocal(Session.java:560)
	at org.h2.engine.Session.prepareCommand(Session.java:501)
	at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1188)
	at org.h2.jdbc.JdbcStatement.executeQuery(JdbcStatement.java:73)
	at org.springframework.jdbc.core.JdbcTemplate$1QueryStatementCallback.doInStatement(JdbcTemplate.java:441)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:396)
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:456)
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:464)
	at com.pdaures.csi.dao.AccountDao.getUserAccount(AccountDao.java:31)
	at com.pdaures.csi.service.AccountServiceImpl.findAccount(AccountServiceImpl.java:27)
	at com.pdaures.csi.controller.AccountOverviewController.accountOverview(AccountOverviewController.java:28)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:219)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:746)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:687)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:80)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:925)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:856)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:915)
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:811)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:617)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:796)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:717)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:290)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206)
	at com.pdaures.csi.filter.AuthenticationFilter.doFilter(AuthenticationFilter.java:60)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:235)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:233)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:191)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:127)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:102)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:109)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:298)
	at org.apache.coyote.http11.Http11Processor.process(Http11Processor.java:857)
	at org.apache.coyote.http11.Http11Protocol$Http11ConnectionHandler.process(Http11Protocol.java:588)
	at org.apache.tomcat.util.net.JIoEndpoint$Worker.run(JIoEndpoint.java:489)
	at java.lang.Thread.run(Thread.java:744)

</pre>
