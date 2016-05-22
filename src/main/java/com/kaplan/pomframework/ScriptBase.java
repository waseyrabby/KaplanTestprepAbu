package com.kaplan.pomframework;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public class ScriptBase {

	 protected WebDriver driver ;

	    @BeforeMethod

	    public void before() throws MalformedURLException 
	    {
	        driver = new FirefoxDriver();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.manage().window().maximize();

	    }
	   
	    
	    @AfterMethod
	    
	    public void afterMethods() 
	    {
	        driver.close();
	        driver.quit();
	        driver=null;
	    }
}
