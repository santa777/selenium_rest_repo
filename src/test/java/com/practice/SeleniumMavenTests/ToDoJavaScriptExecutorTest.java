package com.practice.SeleniumMavenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;	

public class ToDoJavaScriptExecutorTest {
	WebDriver driver;
	@BeforeMethod
	private void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	@Test
	private void executeJavaScript()	{
	    JavascriptExecutor js = (JavascriptExecutor)driver;	
   		
        //Launching the Site.		
        driver.get("http://demo.guru99.com/V4/");			
        		
        WebElement button =driver.findElement(By.name("btnLogin"));			
        		
        //Login to Guru99 		
        driver.findElement(By.name("uid")).sendKeys("mngr34926");					
        driver.findElement(By.name("password")).sendKeys("amUpenu");					
        		
        //Perform Click on LOGIN button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", button);
                                
        //To generate Alert window using JavascriptExecutor. Display the alert message 			
        js.executeScript("alert('Welcome to Guru99');"); 
        
//        executeAsyncScript
//        With Asynchronous script, your page renders more quickly.
//        Instead of forcing users to wait for a script to download before the page renders. 
//        This function will execute an asynchronous piece of JavaScript in the context of the currently 
//        selected frame or window in Selenium. The JS so executed is single-threaded with a various 
//        callback function which runs synchronously.
//
//        executeScript
//        This method executes JavaScript in the context of the currently selected frame or window in Selenium.
//        The script used in this method runs in the body of an anonymous function (a function without a name).
//        We can also pass complicated arguments to it.

	}
	


}
