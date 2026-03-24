package com.practice.SeleniumMavenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToDoResizeTest extends BaseTest {
	
	 @Test	
	    public void launchBrowserTest() throws InterruptedException {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
	        driver.navigate().to("http://www.softwaretestingmaterial.com");
	        System.out.println(driver.manage().window().getSize());
	        Thread.sleep(10000);
	        //Create object of Dimensions class
	        Dimension d = new Dimension(480,620);
	        //Resize the current window to the given dimension
	        driver.manage().window().setSize(d);
	     }	

}
