package com.kaplan.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;

import com.kaplan.pomframework.DataProviders;
import com.kaplan.pomframework.Gmailscriptbase;

public class ParameterizeTest extends Gmailscriptbase {
	protected WebElement mail;
	protected WebElement pass;
	
	 @Test(description = "This is a data provider test",
	       dataProvider = "dataAsArray",
	       dataProviderClass = DataProviders.class)
	 
	  
	 public void testarray(String email,String password, String welcome)
	 {
		    gmail().HP().printMethod();
		    gmail().HP().navigateTo();
	        mail= driver.findElement(By.id("Email"));	
	        mail.sendKeys(email);
	        gmail().HP().clicknext();
	        driver.findElement(By.name("Passwd")).sendKeys(password);
	        gmail().HP().signin(); 
	        String welcomeMsg = driver.findElement(By.className("gb_P gb_R")).getText();
	        Assert.assertEquals(welcome,welcomeMsg);
	   }
	 
	 @Test(description = "This is a data provider test",
	            dataProvider = "dataAsExcel",
	            dataProviderClass = DataProviders.class)
	 
	    public void testexel(String email,String password,String Message) 
	 {
		    gmail().HP().printMethod();
	   	    gmail().HP().navigateTo(); 
	        mail= driver.findElement(By.id("Email"));	
	        mail.sendKeys(email);
	        gmail().HP().clicknext();
	        driver.findElement(By.name("Passwd")).sendKeys(password);
	        gmail().HP().signin(); 
	        String welcomeMsg = driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[1]")).getText();
	        Assert.assertEquals(Message,welcomeMsg);
	 }       
	    
}
