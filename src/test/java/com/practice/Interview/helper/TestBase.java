package com.practice.Interview.helper;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.practice.Interview.util.ConfigUtil;

public class TestBase {
	public static String browser = "Firefox";
	public static WebDriver driver;
	public static String baseUrl;
	
	@Parameters({"browser", "env"})
	@BeforeMethod
	public void beforeTest(String browserNew, String env)	{
		System.out.println("Setup : BrowserName : " + browserNew + "Environment : " + env);
		ConfigUtil configUtil = new ConfigUtil();
		Properties properties = configUtil.setProperties(env);
		browser = properties.getProperty("browser");
		baseUrl = properties.getProperty("baseUrl");
		getDriver();
	}

	public WebDriver getDriver()	{
		switch(browser.toLowerCase()) {
		case "chrome" : 
			driver = new ChromeDriver();
			break;
		case "firefox" :
			driver = new FirefoxDriver();
			break;
		default :
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}	
	
	
}
