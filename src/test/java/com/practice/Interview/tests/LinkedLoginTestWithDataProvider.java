package com.practice.Interview.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.Interview.constants.Urls;
import com.practice.Interview.data.LoginDataProvider;
import com.practice.Interview.helper.TestBase;
import com.practice.Interview.pages.LinkedInLoginPage;


public class LinkedLoginTestWithDataProvider extends TestBase {
	WebDriver driver;

	@BeforeMethod
	private void beforeMethod() {
		driver = getDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/*
	 * If DataProvider exists locally "@Test(dataProvider="userNameAndPassword")
	 * should be good enough If it exists in different class dataProviderClass param
	 * has to be provided
	 */

	@Test(dataProvider = "userNameAndPassword", dataProviderClass = LoginDataProvider.class)
	public void testLinkedInWithWrongPassword(String username, String password) {
		LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage();
		driver.get(Urls.loginUrl);
		linkedInLoginPage.username.sendKeys(username);
		linkedInLoginPage.passwrod.sendKeys(password);

//		Thread.sleep(10000);
	}

//	@AfterMethod
//	private void afterMethod() {
//		driver.quit();
//	}
}
