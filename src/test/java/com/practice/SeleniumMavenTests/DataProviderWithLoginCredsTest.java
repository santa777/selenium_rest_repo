package com.practice.SeleniumMavenTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithLoginCredsTest {
	WebDriver driver;

	@BeforeMethod
	private void beforeMethod() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\geckodriver.exe");
	}

	@DataProvider(name = "loginInputs")
	public Object[][] getDataFromObjectArray() {
		return new Object[][] { { "Guru997788@gmail.com", "India" }, { "+1123456", "USA@123!" }, { "Bhupesh", "USA" } };

	}

	@DataProvider(name="loginCredentials")
	public Object[][] getData() {

		Object[][] data = new Object[4][2];

		// 1st row
		data[0][0] = "testuser1";
		data[0][1] = "pass";

		// 2nd row
		data[1][0] = "testuser2";
		data[1][1] = "pass2121";

		// 3rd row
		data[2][0] = "testuser3";
		data[2][1] = "wswkdsj";

		// 4th row
		data[3][0] = "testuser4";
		data[3][1] = "skaalk";

		return data;
	}

	@Test(dataProvider = "loginInputs")
	private void testLoginInputs(String username, String password) {
//		driver = new FirefoxDriver();
		Assert.assertNotEquals(username, password);
	}
	
	@Test(dataProvider = "loginCredentials")
	private void testLoginCredentials(String username, String password) {
		Assert.assertNotEquals(username, password);
	}
}
