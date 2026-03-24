package com.practice.PracticeAttempt2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTestAttempt2ToDo {

	WebDriver driver;
	@BeforeMethod
	public void setUp()	{
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown()	{
		driver.quit();
	}
	
//	@Test
//	private void testSelectByDropDown() throws InterruptedException	{
//		driver.get("http://demo.automationtesting.in/Register.html");
//		WebElement skillsDropDown = driver.findElement(By.xpath("//select[@id='Skills']"));
//		Select selectSkills = new Select(ṭskillsDropDown);
//		selectSkills.selectByIndex(5);
//		Assert.assertEquals(selectSkills.getAllSelectedOptions().get(0).getText(), "APIs");
//		selectSkills.selectByVisibleText("Adobe InDesign");
//		Assert.assertEquals(selectSkills.getAllSelectedOptions().get(0).getText(), "Adobe InDesign");
//	}
	
	@Test
	private void testSelectMultipleItemsByDropDown() throws InterruptedException	{
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement skillsDropDown = driver.findElement(By.xpath("//select[@id='Skills']"));
		Select selectSkills = new Select(skillsDropDown);
		
//		if(selectSkills.isMultiple())	{
			selectSkills.selectByIndex(1);
			Assert.assertEquals(selectSkills.getFirstSelectedOption().getText(), "Adobe InDesign");
			selectSkills.selectByIndex(2);
			selectSkills.selectByIndex(3);
//		}
	}
}
