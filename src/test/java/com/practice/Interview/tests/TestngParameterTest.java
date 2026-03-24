package com.practice.Interview.tests;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.practice.Interview.constants.Urls;
import com.practice.Interview.helper.LoginHelper;
import com.practice.Interview.helper.TestBase;
import com.practice.Interview.pages.LinkedInLoginPage;

public class TestngParameterTest extends TestBase {
	
	@Parameters({"browser", "env"})
	@Test
	private void testLinkedInWithWrongPassword(String browser, String env)  {
		System.out.println("Browser = " + browser + "Environment = " + env);
		Assert.assertEquals("Chrome", browser);
		Assert.assertEquals("Production", env);
//		loginPage.loginButton.click();
//		Assert.assertTrue(linkedInLoginPage.userNameErrorMessage.isDisplayed());
//		System.out.println("Test executed successfully");
//		System.out.println("Closing browser in next 10 seconds");
//		Thread.sleep(10000);
	}

//	@Test
//	private void openForgotPasswordLinkInNewWindow() throws InterruptedException {
//		LinkedInLoginPage loginPage = new LinkedInLoginPage();
//		Actions actions = new Actions(driver);
//		driver.get(Urls.loginUrl);
//		Thread.sleep(10000);
//		actions.keyDown(Keys.CONTROL).perform();
//		loginPage.forgotPasswordLink.click();
//		String parentWindowHandle = driver.getWindowHandle();
//		Set<String> handles = driver.getWindowHandles();
//		Assert.assertEquals(handles.size(), 2);
//		loginPage.joinNowLink.click();
//		handles = driver.getWindowHandles();
//		Assert.assertEquals(handles.size(), 3);
//		actions.keyUp(Keys.CONTROL).perform();
////		Iterator<String> handleIterator = handles.iterator();
////		while (handleIterator.hasNext()) {
////			String handle = handleIterator.next();
////			driver.switchTo().window(handle);
////			// This if loop executes only for child windows
////			if(!handle.equals(parentWindowHandle))	{
////				System.out.println(driver.getTitle());
////			}
////			
////		}
//		for(String handle : handles) {
//			if(parentWindowHandle != handle)	{
//				System.out.println(driver.getTitle());
//			}
//		}
//		
//		driver.switchTo().window(parentWindowHandle);
//		loginPage.username.sendKeys("santalogicworked");
//	}

	@AfterMethod
	private void afterMethod() {
		driver.quit();
	}
}
