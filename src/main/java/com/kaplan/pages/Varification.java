package com.kaplan.pages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Varification extends Pagebase {
	
	
public Varification(WebDriver driver) 
    {
		super(driver);
		
	}

public void verifyemail() throws Exception {
	
	List<WebElement> email = driver.findElements(By.cssSelector("div.xT>div.y6>span>b"));
	
	for(WebElement emailsub : email)
           {
	    if(emailsub.getText().equals("gmail") == true)
	       {
	           emailsub.click();
	           break;
	        }
	    else
	    {
	    	System.out.println("No email Whith  Keyword:- gmail");
	   
	    }} }}


