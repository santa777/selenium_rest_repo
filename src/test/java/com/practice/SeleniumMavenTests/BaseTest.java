package com.practice.SeleniumMavenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.practice.SeleniumMavenTests.Pages.ChkBoxRadioButtonPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public static ChkBoxRadioButtonPage chkBoxRadioButtonPage = new ChkBoxRadioButtonPage().getInstance();
	
	public void BaseTest()	{
		System.out.println("BaseTest1 : Base test is getting executed");
	
	}
	
	public WebDriver getWebDriver()	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}
	
	

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest is executed");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest is executed");
	}

	@BeforeSuite
	public void beforeSuite() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
	}

	@AfterSuite
	public void afterSuite() {
		// Kind of reporting code you can write here
		System.out.println("AfterSuite is executed");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Beforeclass  is executed");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass  is executed");
	}
	
	
}
