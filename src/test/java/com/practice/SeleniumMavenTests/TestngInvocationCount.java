package com.practice.SeleniumMavenTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngInvocationCount extends BaseTest {
	WebDriver driver;
	
	@BeforeMethod
	private void beforeMethod()	{
		driver = getWebDriver();	
	}

	@Test(invocationCount=3)
	private void testRadioButton() throws InterruptedException	{
		driver.get("http://demo.guru99.com/test/radio.html");
	}	
	
	@AfterMethod
	private void afterMethod()	{
		driver.quit();
	}
}
