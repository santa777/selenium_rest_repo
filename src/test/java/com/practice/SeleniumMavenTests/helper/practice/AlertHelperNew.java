package com.practice.SeleniumMavenTests.helper.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHelperNew {
	private boolean waitForAlert(WebDriver driver)	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		if(wait.until(ExpectedConditions.alertIsPresent()) == null)	{
			System.out.println("ALERT DID NOT FOUND");
			return false;
		}
		System.out.println("Alert found");
		return true;
	}
}
