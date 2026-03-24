package com.practice.Interview.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.Interview.helper.TestBase;

public class WebTableTest extends TestBase {

	@BeforeMethod
	private void beforeMethod() {
		driver = getDriver();
		driver.manage().window().maximize();
	}

	@Test
	private void testLinkedInWithWrongPassword() {
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.container-fluid")));
		List<WebElement> tableRows = driver.findElements((By.xpath("//table[@class='dataTable']//tr")));
		System.out.println("No of table rows " + tableRows.size());
		List<WebElement> tableColumns = driver.findElements((By.xpath("//table[@class='dataTable']//tbody/tr[1]//td")));
		System.out.println("No of table column " + tableColumns.size());

	}

	@AfterMethod
	private void afterMethod() {
		driver.quit();
	}
}
