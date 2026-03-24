package com.practice.SeleniumMavenTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngAnnotationFlowVerificationTest2 extends BaseTest	{

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod is executed");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod is executed");
	}
	

	@Test
	public void testDismissAlertPrintingText1() {
		WebDriver driver = new ChromeDriver();
		System.out.println("Annotation Validation 2 : Executing 3rd test");
		System.out.println(chkBoxRadioButtonPage.checkbox3_id);
		System.out.println(chkBoxRadioButtonPage);
		driver.quit();
	}
	
	
	@Test
	public void testDismissAlertPrintingText2() {
		WebDriver driver = new ChromeDriver();
		System.out.println("Annotation Validation 2 : Executing 4th test");
		driver.quit();
	}

}
