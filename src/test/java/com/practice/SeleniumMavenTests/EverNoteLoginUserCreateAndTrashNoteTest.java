package com.practice.SeleniumMavenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EverNoteLoginUserCreateAndTrashNoteTest {
	WebDriver driver;
	 
	@BeforeMethod
	private void beforeMethod()	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@Test
	@Deprecated
	private void freeSignUp() throws InterruptedException	{
		driver.get("https://www.evernote.com/Login.action");
		driver.findElement(By.id("username")).sendKeys("tesusersantanayak13222@gmail.com");
		// Sometime allows direct signin, sometime page hitting only with email field with continue button without password field
		// added below conditional check to make it work in both the cases
		if(!driver.findElement(By.id("password")).isDisplayed())	{
				driver.findElement(By.id("loginButton")).click(); // Continue button click, to move towards password page
		}		
		driver.findElement(By.id("password")).sendKeys("Password@123!");
		driver.findElement(By.id("loginButton")).click(); 
		driver.findElement(By.id("qa-NAV_HOME")).click();
		// Hover on + symbol to create new note
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//*[@data-tooltipmark='createnotenavitem']"))).perform(); // Hover on + symbo
		actions.click(driver.findElement(By.partialLinkText("Blank Note"))).perform(); // Creating new blank document
		driver.findElement(By.xpath("//div[@data-testid='note-header']")).sendKeys("My new text");
		driver.findElement(By.id("en-note")).sendKeys("Evernote test experiment");
		driver.findElement(By.id("qa-NOTE_ACTIONS")).click();
		// Trashing out the created note
		driver.findElement(By.id("'qa-ACTION_DELETE")).click();
		//After trashing the page making sure page is not getting displayed
		Assert.assertFalse(driver.findElement(By.xpath("//div[@data-testid='note-header']")).isDisplayed());
	}	
	
	@AfterMethod
	private void afterMethod()	{
		driver.quit();
	}
}		