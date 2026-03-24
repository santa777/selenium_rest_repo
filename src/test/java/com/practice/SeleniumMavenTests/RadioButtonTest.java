package com.practice.SeleniumMavenTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {
	WebDriver driver;
	 
	@BeforeMethod
	private void beforeMethod()	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\geckodriver.exe");
	
	}

	@Test
	private void testRadioButton() throws InterruptedException	{
		driver.get("http://demo.guru99.com/test/radio.html");
		WebElement radio1, radio2, radio3;
		radio1 = driver.findElement(By.id("vfb-7-1"));
		radio2 = driver.findElement(By.id("vfb-7-2"));
		radio3 = driver.findElement(By.id("vfb-7-3"));
		radio1.click();
		Thread.sleep(1000);
		Assert.assertTrue(radio1.isSelected());
		Assert.assertFalse(radio2.isSelected());
		radio2.click();
		Thread.sleep(1000);
		Assert.assertTrue(radio2.isSelected());
		Assert.assertFalse(radio3.isSelected());
		radio3.click();
		Thread.sleep(1000);
		Assert.assertTrue(radio3.isSelected());
		Assert.assertFalse(radio1.isSelected());
		Assert.assertFalse(radio2.isSelected());
		driver.quit();
	}
	
	@Test
	private void testCheckBox() throws InterruptedException	{
		driver.get("http://demo.guru99.com/test/radio.html");
		WebElement  checkbox1, checkbox2, checkbox3;
		checkbox1 = driver.findElement(By.id("vfb-6-0"));
		checkbox2 = driver.findElement(By.id("vfb-6-1"));
		checkbox3 = driver.findElement(By.id("vfb-6-2"));
		checkbox1.click();
		Thread.sleep(1000);
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertFalse(checkbox2.isSelected());
		Assert.assertFalse(checkbox3.isSelected());
		checkbox2.click();
		Thread.sleep(1000);
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertTrue(checkbox2.isSelected());
		Assert.assertFalse(checkbox3.isSelected());
		checkbox3.click();
		Thread.sleep(1000);
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertTrue(checkbox2.isSelected());
		Assert.assertTrue(checkbox3.isSelected());
	}
	
	@AfterMethod
	private void afterMethod()	{
		driver.quit();
	}
}
