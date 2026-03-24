package com.practice.PracticeAttempt2;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest {
	WebDriver driver;
	@BeforeMethod
	private void beforeMethod()	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	private void testSelectDropDown()	{
		driver.get("http://demo.automationtesting.in/Register.html");
		
	}
	
	@AfterMethod
	private void tearDown() {
		driver.quit();
	}

}
  