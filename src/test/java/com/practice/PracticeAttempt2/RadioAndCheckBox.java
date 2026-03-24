package com.practice.PracticeAttempt2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioAndCheckBox {
	WebDriver driver;
	@BeforeMethod
	public void setUp()	{
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown()	{
		driver.quit();
	}
	
	@Test
	private void testRadioAndCheckBox() {
		driver.get("http://demo.guru99.com/test/radio.html");
		WebElement radio1, radio2, radio3, checkbox1, checkbox2, checkbox3;
		radio1 = driver.findElement(By.id("vfb-7-1"));
		radio2 = driver.findElement(By.id("vfb-7-2"));
		radio3 = driver.findElement(By.id("vfb-7-3"));
		checkbox1 = driver.findElement(By.id("vfb-6-0"));
		checkbox2 = driver.findElement(By.id("vfb-6-1"));
		checkbox3 = driver.findElement(By.id("vfb-6-2"));
		
		radio1.click();
		Assert.assertTrue(radio1.isSelected());
		Assert.assertFalse(radio2.isSelected());
		Assert.assertFalse(radio3.isSelected());
		checkbox1.click();
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertFalse(checkbox2.isSelected());
		Assert.assertFalse(checkbox3.isSelected());
		checkbox2.click();
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertTrue(checkbox2.isSelected());
		Assert.assertFalse(checkbox3.isSelected());

	}
	

}
