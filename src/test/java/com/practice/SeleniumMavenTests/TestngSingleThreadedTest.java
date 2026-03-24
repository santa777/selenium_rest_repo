package com.practice.SeleniumMavenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Having this tag makes even paralle run set true
@Test(singleThreaded=true) // Though you set test execution parallel=true this will ensure each test run in isolation.
public class TestngSingleThreadedTest  extends BaseTest{
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod()	{
		driver = getWebDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	// Test not yet implemented
	@Test
	private void selectFromDropDown()	{
		driver.get("https://www.facebook.com");
	}
	
	
	@Test
	private void getGoogle()	{
		driver.get("https://www.google.co.in/");
	}
	
	@AfterMethod
	private void afterMethod()	{
		driver.quit();
	}
	

}
