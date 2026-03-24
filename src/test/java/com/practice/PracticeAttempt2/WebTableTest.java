package com.practice.PracticeAttempt2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import java.util.List;


public class WebTableTest {
	static WebDriver driver;

	@BeforeMethod
	public void beforeEachTestFunction() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterEachTest() {
		driver.quit();
	}

	@Test
	public void webTableExcerciseCountRows() {
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		List<WebElement> tableRows = driver.findElements((By.xpath("//table[@class='dataTable']//tr")));
		System.out.println("No of table rows " + tableRows.size());
		List<WebElement> tableColumns = driver.findElements((By.xpath("//table[@class='dataTable']//tbody/tr[1]//td")));
		System.out.println("No of table column " + tableColumns.size());
		ArrayList arrList = new ArrayList();
	}
}
