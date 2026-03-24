package com.practice.SeleniumMavenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchToIframe {
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

	// Not in working status wrote comments to understand selenium library api related to iframe
	@Test @Deprecated 
	private void testSwicthToWindow() throws InterruptedException {
		driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
		driver.switchTo().frame("name /id/index");
		// parentFrame() is generally used to switch the control back to 
		// the parent frame. When you deal with pop-up dialog windows within your webpage, then driver.
		driver.switchTo().parentFrame();
		//driver. switchTo(). defaultContent() is used to switch the control back to default content in the window.
		driver.switchTo().defaultContent();
		
	}	

}
