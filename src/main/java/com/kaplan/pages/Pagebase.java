package com.kaplan.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;



public class Pagebase {

    
	protected WebDriver driver;


 public Pagebase(WebDriver driver)
    {
        this.driver = driver;
    }


    public void delayFor(int secInMili){
        try {
            Thread.sleep(secInMili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElement(final By locator)
    {
        return waitForElement(locator,20);
    }
    public WebElement waitForElement(final By locator, int timeToWaitInSec) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return foo;
    }


    public WebElement waitForElementDisplayed(final By locator) {
        return waitForElementDisplayed(locator,20);
    }

    public WebElement waitForElementDisplayed(final By locator,int timeToWaitInSec) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element != null && element.isDisplayed()) {
                    highlight(element);
                    return element;
                }
                return null;
            }
        });
        return foo;
    }

    public WebElement waitForElementEnabled(final By locator)
    {
        return waitForElementEnabled(locator,20);
    }
    public WebElement waitForElementEnabled(final By locator,int timeToWaitInSec) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element != null && element.isEnabled()) {
                    return element;
                }
                return null;
            }
        });
        return foo;
    }

    public void jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",  element);
    }

    public void highlight(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "border: 2px solid yellow;");
            delayFor(200);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            delayFor(200);
        }
    }

    public void jsSetAttribute(WebElement element, String attributeName, String attributeValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element, attributeName, attributeValue);
    }

    public void jsScrollElementIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  element);

    }


    public void hoverItem(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void hoverItemEx(WebElement element){
        Locatable hoverItem = (Locatable) element;
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(hoverItem.getCoordinates());
    }

    public String switchWindowByTitle(String titleToMatch) {
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String item : windows) {
            System.out.println(item);
            if (item.contentEquals(item)) {
                driver.switchTo().window(item);
                currentWindow = item;
                String title = driver.getTitle();
                if (title.contains(titleToMatch)) {
                    break;
                }
            }
        }
        return currentWindow;
    }
}
