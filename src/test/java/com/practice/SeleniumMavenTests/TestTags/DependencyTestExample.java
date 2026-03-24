package com.practice.SeleniumMavenTests.TestTags;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependencyTestExample {
	WebDriver driver;
	@BeforeTest
	private void beforeClass()	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
	}
	
	@BeforeMethod	
	private void beforeMethod()	{
		System.out.println("Executing before method");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(groups= {"FirstTest"})
	private void testOne()	{
		System.out.println("Executing test one");
	}
	
	@Test(groups = {"SmokeTest"}, dependsOnMethods = {"testOne"})
	private void testTwo()	{
		System.out.println("Executing test two");
	}
	
	@Test(groups = {"SanityTest"}, dependsOnMethods = {"testOne", "testTwo"})
	private void testThree()	{
		System.out.println("Executing test three");
	}
}
