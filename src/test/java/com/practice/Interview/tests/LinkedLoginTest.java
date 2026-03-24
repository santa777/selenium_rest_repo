package com.practice.Interview.tests;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.practice.Interview.constants.Urls;
import com.practice.Interview.helper.LoginHelper;
import com.practice.Interview.helper.TestBase;
import com.practice.Interview.pages.LinkedInLoginPage;

public class LinkedLoginTest extends TestBase {
	@Test
	private void testLinkedInWithWrongPassword() {
		LoginHelper loginHelper = new LoginHelper();
		loginHelper.loginWithUserNameAndPassword();
		driver.navigate().refresh();
		Assert.assertEquals(driver.getTitle(), "LinkedIn Login, Sign in | LinkedIn");
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
