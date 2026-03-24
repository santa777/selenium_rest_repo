package com.practice.SeleniumMavenTests.helper;

 import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHelper {
	private static final int ALERT_TIMEOUT_SECONDS = 3;

	public boolean waitForAlert(WebDriver driver)	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(ALERT_TIMEOUT_SECONDS));
		if(webDriverWait.until(ExpectedConditions.alertIsPresent()) == null)	{	
			System.out.print("Alert not found!!!");
			return false;
		}
		System.out.print("Alert found:)");
		return true;		
	}
	
	public Alert getAlert(WebDriver driver)	{
		waitForAlert(driver);
		return driver.switchTo().alert();
	}
	
	public void accepttJsAlert(WebDriver driver)	{
		getAlert(driver).accept();
	}
	
	public void dismissAlert(WebDriver driver)	{
		getAlert(driver).dismiss();
	}
	
	public String getAlertTest(WebDriver driver, String text)	{
		return getAlert(driver).getText();
	}
	
	public void webDriverWaitUntil(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ALERT_TIMEOUT_SECONDS));
		wait.until(ExpectedConditions.alertIsPresent());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("id"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("className"))));
	}
	
}
