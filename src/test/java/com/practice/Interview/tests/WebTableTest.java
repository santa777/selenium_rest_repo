package com.practice.Interview.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.Interview.constants.Urls;
import com.practice.Interview.helper.LoginHelper;
import com.practice.Interview.helper.TestBase;
import com.practice.Interview.pages.LinkedInLoginPage;

public class WebTableTest extends TestBase {

	@BeforeMethod
	private void beforeMethod() {
		driver = getDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	private void testLinkedInWithWrongPassword() {
		driver.get("http://demo.guru99.com/test/web-table-element.php");
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
