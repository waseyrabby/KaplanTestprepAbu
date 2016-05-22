package com.kaplan.pomframework;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Gmailscriptbase extends ScriptBase {
	protected ApplicationController gmail;

    @Override
    @BeforeMethod
    public void before() throws MalformedURLException
    {
       super.before();

    }


    public ApplicationController gmail() 
    {
        gmail = new ApplicationController(driver);
        return gmail;
    }

    @Override
    @AfterMethod
    public void afterMethods()
    {
        gmail = null;

        super.afterMethods();
    }
}
