package com.kaplan.pomframework;

import org.openqa.selenium.WebDriver;

import com.kaplan.pages.HomePage;
import com.kaplan.pages.Pagebase;
import com.kaplan.pages.Varification;

public class ApplicationController extends Pagebase{
	
	
	public HomePage HP;
	public Varification VP;
	
	
public ApplicationController(WebDriver driver)
{
        super(driver);
        HP= new HomePage(driver);
        VP= new Varification(driver);
}
	
public HomePage HP() 
{
	        return HP;
}
	 
public Varification VP()
{
		return VP;
 }
	
}
