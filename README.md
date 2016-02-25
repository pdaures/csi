# csi
SPIA team member interview exercise

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
This webapps displays a simple page : accountOverview.html with 2 informtions inside :
- first name
- last name

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
