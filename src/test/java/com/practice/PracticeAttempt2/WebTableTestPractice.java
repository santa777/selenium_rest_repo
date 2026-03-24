package com.practice.PracticeAttempt2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebTableTestPractice {
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
	public void testWebTableExcerciseCountRows() {
		driver.get("http://demo.guru99.com/test/web-table-element.php");	
		List<WebElement> tableRows = driver.findElements((By.xpath("//table[@class='dataTable']//tr")));
		System.out.println("No of table rows " + tableRows.size());
		List<WebElement> tableColumns = driver.findElements((By.xpath("//table[@class='dataTable']//tbody/tr[1]//td")));
		System.out.println("No of table column " + tableColumns.size());
		ArrayList arrList = new ArrayList();
	}
}
