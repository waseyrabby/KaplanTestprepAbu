# KaplanTestprepAbu
Created a Page Object model Framework Useing Java,Selenium,Testng and Mavan as build tool on Gmail email account.


TEST WEBSITE:- http://gmail.com
Test E-mail ID:- kaplantestabu@gmail.com
Test E-mail Password:- 9083277874 

1. Log into any email account and check if there is any email.

Created Testscript GmailLoginTest For this.I put two test in their .One to verify the page title(assertion).
And second test is to print out the number of new e-mail.

2. Verify that subject and body of the e-mail contains a pre-defined string.

Created Testscript VerifyTest for this.It check if their is any email contains Gmail in it ,If it does then its gonna
click on that e-mail if not it prints out "No email Whith  Keyword:- gmail".

3. Parameterize (data-drive) the script to handle multiple email accounts.

Created Testscript ParameterizeTest for this.I created two test on this .Used Array as dataprovider in firs test and 
Exel as dataprovider in second one.I used jexcel to read data from exel.Verified if its showing right name once login.


The test script is  compileing  and running  from the command line or within Eclipse.
 
