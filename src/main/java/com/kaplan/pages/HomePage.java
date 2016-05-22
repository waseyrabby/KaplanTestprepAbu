package com.kaplan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends Pagebase {
protected static final String GMAILLINK = "http://gmail.com";
protected static final String MAIL= "kaplantestabu@gmail.com";
protected static final String PASS= "9083277874";
protected static String NEW;
protected WebElement email;
protected WebElement next;
protected WebElement password;
protected WebElement sign;
protected WebElement inbox;
	
public HomePage(WebDriver driver)
{
		super(driver);
}

public  void printMethod() 
{
		
	System.out.println("CURRENT CLASS AND MATHOD"+Thread.currentThread().getStackTrace()[2]);
	   
}

public void navigateTo()
 
{
      driver.navigate().to(GMAILLINK);
 } 
 

public void verifyPageTitle()
{
        String title = driver.getTitle();
        Assert.assertEquals(title,"Gmail");
    }


	public void inputemail() 
	{
		email=driver.findElement(By.id("Email"));
		 highlight(email);
		email.sendKeys(MAIL);
		
	}
	public void clicknext(){
		next=driver.findElement(By.id("next"));
		next.click();
		
	}
	
	
	public void inputpassword(){
		password=driver.findElement(By.id("Passwd"));
		 highlight(password);
		password.sendKeys(PASS);
		
	}
	public void signin()
	
	{
	sign=driver.findElement(By.id("signIn"));
	sign.click();
	}
	public void checkinbox() 
	
	{
		inbox=driver.findElement(By.cssSelector(".J-Ke.n0"));
		NEW= inbox.getText();
		
	  System.out.println("Number of imail in inbox is ="+NEW);
		
	}
   
}
