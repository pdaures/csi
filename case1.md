#Case 1: An unexpected error

Customer email:

Hello, I cannot access to my account page. I just have a big error when I access to my account page, I cannot use your service.


Evidence:

URL to test : http://localhost
UserId : fhollande

Logs :


```[24/02/16 10:09:55.166] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 10:09:55.166] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 10:09:55.166] INFO  [tp-8080-1] [Stats] - Country counter : USA: 4
[24/02/16 10:09:55.166] INFO  [tp-8080-1] [Stats] - Daily visitors :4
[24/02/16 10:10:00.165] INFO  [tp-8080-1] [AuthenticationFilter] - Security Token : token_hollande
[24/02/16 10:10:00.167] INFO  [tp-8080-1] [AccountOverviewController] - Display account overview of user fhollande
[24/02/16 10:10:00.167] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user fhollande
févr. 24, 2016 10:10:00 AM org.apache.catalina.core.StandardWrapperValve invoke
Grave: Servlet.service() for servlet DispatcherServlet threw exception
java.lang.NullPointerException
	at com.pdaures.csi.service.Stats.formatKey(Stats.java:51)
	at com.pdaures.csi.service.Stats.incrementCountryCounter(Stats.java:33)
	at com.pdaures.csi.service.AccountServiceImpl.findAccount(AccountServiceImpl.java:30)
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
	at java.lang.Thread.run(Thread.java:744)```


Find the problem and propose a solution.
