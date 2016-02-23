# csi
Case for SPIA team member interview

#General goal
This webapp has several problems. Your goal is to find them using the evidence provided, and propose a set of fixes.

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
- http://localhost:8080/csi/accountOverview.htm?token=token_amerkel
- http://localhost:8080/csi/accountOverview.htm?token=token_dcameron

#What is the webapp supposed to do
This webapps displays a simple page : accountOverview.html with 2 informtions inside :
- first name
- last name

#Technology stack
- Java 7 + Servlet 2.5 + Spring MVC + Spring JdbcTemplate + H2 in memory DB
