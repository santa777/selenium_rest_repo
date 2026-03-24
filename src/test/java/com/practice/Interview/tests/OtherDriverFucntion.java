package com.practice.Interview.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.Interview.constants.Urls;
import com.practice.Interview.helper.TestBase;
import com.practice.Interview.pages.LinkedInLoginPage;

public class OtherDriverFucntion extends TestBase {
	WebDriver driver;
	
	@BeforeMethod
	private void beforeMethod() {
		driver = getDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testLinkedInWithWrongPassword()  {
		LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage();
		driver.get(Urls.loginUrl);
		driver.navigate().refresh ();
//		linkedInLoginPage.username.sendKeys("heggar@yahoo.com");
//		
//		manageTimeOutMethods();
//		manageCookieMethods();
//		// switchTo.windows / iframe / alert
//		switcthToMethods();
//		// Java Script executor
//		javaScriptExecute();
//		// Mouse Action
//		mouseAction(linkedInLoginPage.userNameErrorMessage, linkedInLoginPage.passwordErrorMessage);
//		// 	Open link in new window deal with child and partent write seperate test
//		//	LinkedLoginTest.openForgotPasswordLinkInNewWindow
//		
//		// Handling properties and user data for different environments
//		//https://www.youtube.com/watch?v=DW2NMjjVFro
//		//https://www.youtube.com/watch?v=lQCyVy-g1e8 (maven pom.xml environment variables)
//				
//		
//		/*************************** Pending ********************************************/
//		// Pending : Write a logic and test for below 4
//		// Framework :
//		// Reporting  Log4j, Extent Report, screenshot for failures
//		
//		
//		// Infrastructure :
//		// Version Control, Jenkin pipeline, How to setup server or grid to run the jobs
//		// Selenium Grid, Docker containers to run tests check it
//		
//		// Non Selenium :  Check SQL and No SQL DBs, Mongo DB and Dynamo DB(check about database related questions)
//		
//		// Selenium Utitls
//		// Write a code to type in attachment // Sendkeys should do it check it once
		// Write a code to deal with ajax popup
		// Wirte a code to deal with WebTable
		// Wite a code to read data from excel
		// 
		
		// Dropdown selection
		// Priority, Testng Execution
		
		//Key down is not working in firefox check what is Robot Framework and if it helps here.
		
	}
	
	// Implicit, Explicit and WebDriverWait
	private void manageTimeOutMethods()	{
		// TimeUnit can NANO, MICRO, MILLI SECCONDS to SECONDS, MINUTES, HOURS, DAYS 
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		LinkedInLoginPage loginPage = new LinkedInLoginPage();
		wait.until(ExpectedConditions.alertIsPresent());
		wait.until(ExpectedConditions.visibilityOf(loginPage.joinNowLink));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframe"));
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.forgotPasswordLink));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	// Driver manage cookies methods
	private void manageCookieMethods()	{
		Cookie cookie = new Cookie("lix", "new.experiment=enabled");
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookie(cookie);
		driver.manage().deleteCookieNamed("lix");
		driver.manage().addCookie(cookie);
		driver.manage().getCookieNamed("lix");
		driver.manage().getCookies();
	}
	
	private void switcthToMethods()	{
		String windoHandle = "handle", iframeNameOrId = "nameOrId";
		WebElement frameElement = driver.findElement(By.id("222"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// Switch to frame By element, id or Name as String, index and switching to parentFramew
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		driver.switchTo().frame(frameElement);
		driver.switchTo().frame(iframeNameOrId);
		driver.switchTo().frame(1);
		driver.switchTo().parentFrame(); 
		// When you have nested iframes webpagebody > { mainFrame { parentFrame{ childFrame}}}
		// If you are in child frame switcTo parentFame will set control to mainFrame.
		driver.switchTo().defaultContent(); // Get control back to the default content of the page
		
		// Switching to alert
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
		alert.dismiss();
		alert.sendKeys("hello");
		
		// Switchto window
		driver.switchTo().window("handle");
	}
	
	//***************************Action class begin here
	private void keyUpAndDown()	{
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).keyUp(Keys.CONTROL).perform();
		actions.moveByOffset(30, 30).perform();; // Check how will define cordinates
	}
	
	private void mouseAction(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		// Mouse Hover Action in Selenium
		actions.moveToElement(source).perform(); 

		// Dragging and dropping element from source to target
		actions.dragAndDrop(source, target).perform();
		actions.clickAndHold(source).moveToElement(target).release().perform();
		
		// All click actions
		actions.click(source); // click
		
		// Doouble click and Rightclick
		actions.doubleClick(source).perform();
		actions.moveToElement(source).doubleClick().perform();
		
		// Right click
		actions.contextClick(source).perform();
		actions.moveToElement(source).contextClick().perform();
	}
	
	private void javaScriptExecute()	{
		LinkedInLoginPage loginPage = new LinkedInLoginPage();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeAsyncScript("argument[0].click", loginPage.forgotPasswordLink);
//		js.executeScript("alert('Welcome to Guru99');"); 
//		// Above commented code will produce alert on some unsecured site dont try on LinkedIn
	}
	
}
