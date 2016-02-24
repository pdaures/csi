#Case 3 : Somebody else's account

#Victim interview:
From time to time, I see the account of somebody else. I access to localhost:8080/csi/accountOverview.htm?token=token_castro and see the account of Juha Sipila. I hope nobody see my own account !

#QA interview:
I can assure you we never had this problem, we always validate the system with 3 different users, one after the other, and we never arrived on the account of somebody else.

#Logs:
<pre>
[24/02/16 10:54:50.278] INFO  [p-8080-10] [AuthenticationFilter] - Security Token : token_jinping
[24/02/16 10:54:50.279] INFO  [p-8080-16] [AuthenticationFilter] - Security Token : token_correa
[24/02/16 10:54:50.279] INFO  [tp-8080-9] [AuthenticationFilter] - Security Token : token_castro
[24/02/16 10:54:50.279] INFO  [p-8080-10] [AccountOverviewController] - Display account overview of user xjinping
[24/02/16 10:54:50.279] INFO  [p-8080-10] [AccountServiceImpl] - Loading account information for user xjinping
[24/02/16 10:54:50.279] INFO  [tp-8080-9] [AccountOverviewController] - Display account overview of user jsipila
[24/02/16 10:54:50.279] INFO  [tp-8080-9] [AccountServiceImpl] - Loading account information for user jsipila
[24/02/16 10:54:50.279] INFO  [p-8080-16] [AccountOverviewController] - Display account overview of user rcastro
[24/02/16 10:54:50.300] INFO  [p-8080-16] [AccountServiceImpl] - Loading account information for user rcastro
</pre>
