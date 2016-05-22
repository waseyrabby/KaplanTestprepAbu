package com.kaplan.Test;

import org.testng.annotations.Test;

import com.kaplan.pomframework.Gmailscriptbase;

public class VerifyTest extends Gmailscriptbase{
	
	

	 @Test
	    public void Verifyemail() throws Exception{
		 gmail().HP().printMethod();
		 gmail().HP().navigateTo();
		 gmail().HP().inputemail();
		 gmail().HP().clicknext();
		 gmail().HP().inputpassword();
		 gmail().HP().signin(); 
	     gmail().VP().verifyemail(); 
	    }
}
