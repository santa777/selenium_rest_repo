package com.practice.SeleniumMavenTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.SeleniumMavenTests.Pages.ChkBoxRadioButtonPage;


//@Test(singleThreaded = true)
public class CheckBoxOptionTest extends BaseTest	{
	WebDriver driver;
	public static ChkBoxRadioButtonPage chkBoxRadioButtonPage = new ChkBoxRadioButtonPage().getInstance();

	 
	@BeforeMethod
	private void beforeMethod()	{
		driver = getWebDriver();	
	}

	@Test()
	private void testRadioButton() throws InterruptedException	{
		driver.get("http://demo.guru99.com/test/radio.html");
		WebElement radio1, radio2, radio3;
		radio1 = driver.findElement(By.id(chkBoxRadioButtonPage.radioButton1_id));
		radio2 = driver.findElement(By.id(chkBoxRadioButtonPage.radioButton2_id));
		radio3 = driver.findElement(By.id(chkBoxRadioButtonPage.radioButton3_id));
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
	
//	@Test
//	private void testCheckBox() throws InterruptedException	{
//		driver.get("http://demo.guru99.com/test/radio.html");
//		WebElement  checkbox1, checkbox2, checkbox3;
//		checkbox1 = driver.findElement(By.id(chkBoxRadioButtonPage.checkbox1_id));
//		checkbox2 = chkBoxRadioButtonPage.checkbox2_id;
//		checkbox3 = driver.findElement(By.id(chkBoxRadioButtonPage.checkbox3_id));
//		checkbox1.click();
//		Thread.sleep(1000);
//		Assert.assertTrue(checkbox1.isSelected());
//		Assert.assertFalse(checkbox2.isSelected());
//		Assert.assertFalse(checkbox3.isSelected());
//		checkbox2.click();
//		Thread.sleep(1000);
//		Assert.assertTrue(checkbox1.isSelected());
//		Assert.assertTrue(checkbox2.isSelected());
//		Assert.assertFalse(checkbox3.isSelected());
//		checkbox3.click();
//		Thread.sleep(1000);
//		Assert.assertTrue(checkbox1.isSelected());
//		Assert.assertTrue(checkbox2.isSelected());
//		Assert.assertTrue(checkbox3.isSelected());
//		driver.quit();
//	}
//	
	@Test()
	private void testRadioButton1() throws InterruptedException	{
		driver.get("http://demo.guru99.com/test/radio.html");
	}
	
	@Test()
	private void testRadioButton2() throws InterruptedException	{
		driver.get("http://demo.guru99.com/test/radio.html");
	}
	@AfterMethod
	private  void afterMethod()	{
		driver.quit();
	}
}
