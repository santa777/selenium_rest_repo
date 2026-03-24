package com.practice.SeleniumMavenTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectFromDropDown  {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod()	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	@Test
	private void selectFromDropDown() throws InterruptedException	{
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement skillsDropDown = driver.findElement(By.xpath("//select[@id='Skills']"));
		Select sel = new Select(skillsDropDown);
		sel.selectByIndex(5);
		Thread.sleep(500);
		Assert.assertEquals(sel.getAllSelectedOptions().get(0).getText(), "APIs");	
		sel.selectByValue("Analytics");
		Thread.sleep(500);
		Assert.assertEquals(sel.getAllSelectedOptions().get(0).getText(), "Analytics");	
		sel.selectByVisibleText("Content Managment");
		Thread.sleep(500);
		Assert.assertEquals(sel.getAllSelectedOptions().get(0).getText(), "Content Managment");	
	}
	
	@AfterMethod
	private void afterMethod()	{
		driver.quit();
	}
	
	
	

}
