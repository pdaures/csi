#Crazy Friday

#Victim inteview
Every Friday, every week, Tomcat crashes. We have to kill Tomcat and restart it manually. It happens every Friday, it shouldn't happen. Something is wrong with your application.

#Evidence
Servers are usually restarted every sunday night, and should run for the week.
There is the same activity of customers every day of the week, so nothing special happens on Friday
The Garbage Collection activity seems to be higher every day (Friday > Thursday > Wednesday > Tuesday > Monday)

#Logs
<pre>
[24/02/16 14:39:53.132] INFO  [p-8080-19] [Stats] - Daily visitors :195331
Exception in thread "http-8080-9" Exception in thread "*** JFluid Monitor thread ***" [24/02/16 14:39:44.548] INFO  [p-8080-16] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:39:43.747] INFO  [p-8080-13] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:39:40.737] INFO  [tp-8080-8] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:39:40.737] INFO  [p-8080-15] [AccountOverviewController] - Display account overview of user bobama
java.lang.OutOfMemoryError: Java heap space
java.lang.OutOfMemoryError: Java heap space
[24/02/16 14:39:39.909] INFO  [p-8080-24] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:40:30.272] INFO  [p-8080-24] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 14:39:39.909] INFO  [p-8080-12] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:39:39.708] INFO  [p-8080-17] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:39:39.707] INFO  [p-8080-27] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:39:38.840] INFO  [tp-8080-1] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 14:39:37.288] INFO  [tp-8080-2] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:39:30.555] INFO  [p-8080-25] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 14:39:29.005] INFO  [p-8080-11] [AccountOverviewController] - Display account overview of user bobama
[24/02/16 14:40:54.592] INFO  [p-8080-11] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 14:39:23.355] INFO  [p-8080-21] [AccountServiceImpl] - Loading account information for user bobama
[24/02/16 14:39:14.335] INFO  [p-8080-10] [Stats] - Country counter : USA: 195084
[24/02/16 14:39:14.402] INFO  [p-8080-10] [Stats] - Daily visitors :195330
[24/02/16 14:39:00.461] INFO  [p-8080-22] [AccountServiceImpl] - Loading account information for user bobama
Exception in thread "http-8080-35" java.lang.NullPointerException
[24/02/16 14:38:59.977] INFO  [p-8080-29] [AuthenticationFilter] - Security Token : token_obama
Exception in thread "http-8080-9" Exception in thread "http-8080-35" Exception in thread "ContainerBackgroundProcessor[StandardEngine[localEngine]]" Exception in thread "http-8080-32" 
*** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message can't create byte arrau at ../../../src/share/instrument/JPLISAgent.c line: 813
[24/02/16 14:38:58.848] INFO  [p-8080-18] [Stats] - Country counter : USA: 195083
Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "http-8080-35"
[24/02/16 14:41:10.920] INFO  [p-8080-21] [Stats] - Country counter : USA: 195089
java.lang.OutOfMemoryError: Java heap space
java.lang.OutOfMemoryError: Java heap space
</pre>

#RAM content :
char[] : 16.1%
java.util.concurrent.ConcurrentHashMap$Segment[] : 9.3%
java.util.Hashtable$Entry[] : 8.4%
java.util.concurrent.ConcurrentHashMap$HashEntry : 6.7%
java.lang.String : 6.3%
java-util.concurrent.ConcurrentHashMap : 6.1%
com.pdaures.csi.service.Stats$Key : 4%

