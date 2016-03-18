# SPIA team member interview exercise

#General goal
This webapp has several problems. Your goal is to find them using the evidence provided, and propose a set of solutions.

#How to start
Required :
- git
- maven 3
- java 7+
- a valid internet connexion

Start the webapp :
`mvn tomcat:run`

Pages to visit:
- http://localhost:8080/csi/accountOverview.htm?token=token_obama
- http://localhost:8080/csi/accountOverview.htm?token=token_merkel
- http://localhost:8080/csi/accountOverview.htm?token=token_cameron

#What is the webapp supposed to do
A user can access his account and see 2 informations :
- first name
- last name
- Example for user Barack Obama : http://localhost:8080/csi/accountOverview.htm?token=token_obama
- Example for user Angela Merkel :http://localhost:8080/csi/accountOverview.htm?token=token_merkel
 

The application keeps some metrics about user activity:
- One counter of access by Country. Example : if Merkel accesses to her account, then there will be a counter with Germany : 1. If Obama accesses to his account, there will be USA :1, Germany :1
- One counter of unique visitor. Example : if Merkel accesses to her account once or 20 times, there will be "unique visitor count : 1".
- See class com.pdaures.csi.service.Stats

#Technology stack
- Java 7 + Servlet 2.5 + Spring MVC + Spring JdbcTemplate + H2 in memory DB

#Webapp architecture
- [Architecture](https://github.com/pdaures/csi/blob/master/architecture.md)

#Investigation cases
- [case 1](https://github.com/pdaures/csi/blob/master/case1.md)
- [case 2](https://github.com/pdaures/csi/blob/master/case2.md)
- [case 3](https://github.com/pdaures/csi/blob/master/case3.md) 
- [case 4](https://github.com/pdaures/csi/blob/master/case4.md)
- [case 5](https://github.com/pdaures/csi/blob/master/case5.md)
