package com.practice.SeleniumMavenTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ResizeWindowWIthDimensionTest extends BaseTest {
	WebDriver driver;
	 @Test	
	    public void launchBrowserTest() throws InterruptedException {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.navigate().to("http://www.softwaretestingmaterial.com");
	        System.out.println(driver.manage().window().getSize());
	        //Create object of Dimensions class
	        Dimension d = new Dimension(480,620);
	        //Resize the current window to the given dimension
	        driver.manage().window().setSize(d);
	        System.out.println(driver.manage().window().getSize());
	     }	
	 @AfterMethod
	 private void afterMethod()	{
		 driver.quit();
	 }
	 
}
