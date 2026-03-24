package com.practice.SeleniumMavenTests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.SeleniumMavenTests.helper.AlertHelper;

public class AlertValidationTest extends BaseTest {
	static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public void alertSampleTest() {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AlertHelper alertHelper = new AlertHelper();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		WebElement customerIdTextBox = driver.findElement(By.name("cusid"));
		WebElement submitButton = driver.findElement(By.name("submit"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		customerIdTextBox.sendKeys("53920");
		submitButton.click();		
		Assert.assertTrue(alertHelper.waitForAlert(driver));
		System.out.print("Alert Text" + driver.switchTo().alert().getText());	
		driver.switchTo().alert().dismiss();
		submitButton.click();
		driver.switchTo().alert().accept();
		alertHelper.dismissAlert(driver);
		driver.manage().window().maximize();
		String parentWindoHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while(it.hasNext()) {
			String childWindow = it.next();
			if(!parentWindoHandle.equals(childWindow))	{
				driver.switchTo().window(childWindow);
				driver.get("https://www.browserstack.com/guide/handle-multiple-windows-in-selenium");
				System.out.println("Child window title = " + driver.getTitle());
			}
		}
 	}
	
	@Test(enabled = false)
	private void testMethod()	{
		Assert.assertEquals(true, true);
	}

}
