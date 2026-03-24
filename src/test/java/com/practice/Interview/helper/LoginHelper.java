package com.practice.Interview.helper;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.Interview.constants.Urls;
import com.practice.Interview.pages.LinkedInLoginPage;

public class LoginHelper extends TestBase {

	// TO_DO : Click is disabled for now
	public void  loginWithUserNameAndPassword() {
		LinkedInLoginPage loginPage = new LinkedInLoginPage();
		driver.get(Urls.loginUrl);
		loginPage.username.sendKeys("Heggar@gmail.com");
		loginPage.passwrod.sendKeys("Balkur");
//		loginPage.loginButton.click();
//		WebDriverWait webDriverWait = new WebDriverWait(driver, 4);
//		webDriverWait.until(ExpectedConditions.alertIsPresent());
//		webDriverWait.until(ExpectedConditions.invisibilityOf(loginPage.forgotPasswordLink));
//		webDriverWait.until(ExpectedConditions.titleContains("Welcome To Linkedin"));
	}

	
}
