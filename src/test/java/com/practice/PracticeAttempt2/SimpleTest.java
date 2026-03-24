package com.practice.PracticeAttempt2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class SimpleTest {
	WebDriver driver;
	@BeforeTest
	public void testSuiteSetup()	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
	}

	@BeforeMethod
	public void setUp()	{
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void sampleTest()	{
		driver.get("http://demo.guru99.com/test/radio.html");
		WebElement username = driver.findElement(By.id("username"));
		WebElement loginButton = driver.findElement(By.className("className"));
		WebElement elementByClassName = driver.findElement(By.className("className"));
		WebElement elementByName = driver.findElement(By.name("name"));
		

		
		
		
		driver.get("http://demo.guru99.com/test/radio.html");
		driver.navigate().to("http://demo.guru99.com/test/radio.html");
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
		// Switching between 2 tabs
		
		driver.manage().deleteCookieNamed("testCookie");
				
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().sendKeys("testmessage");
		
		Actions actions = new Actions(driver);
		actions.contextClick(elementByClassName).perform(); // Right click
		actions.moveToElement(username).contextClick().perform(); // Right click moving to element
		
		actions.dragAndDrop(elementByName, elementByClassName);
		actions.moveToElement(elementByName).clickAndHold().moveToElement(elementByClassName).release().perform();
		driver.close();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
		
}
