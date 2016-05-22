package com.kaplan.Test;

import org.testng.annotations.Test;



import com.kaplan.pomframework.Gmailscriptbase;


public class GmailLoginTest extends Gmailscriptbase{
	
	 @Test
	    public void Homepage(){
		 gmail().HP().printMethod();
		 gmail().HP().navigateTo();
		 gmail().HP().verifyPageTitle();
	       
	   }
	 @Test
	 public void Login(){
		 gmail().HP().printMethod();
		 gmail().HP().navigateTo();
		 gmail().HP().inputemail();
		 gmail().HP().clicknext();
		 gmail().HP().inputpassword();
	     gmail().HP().signin(); 
	     gmail().HP().checkinbox();;
	    }
}
