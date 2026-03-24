package com.practice.practice2026.naveenTests;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MultiWindowsTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    private void setUp() {
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
    }

    @Test
    private void testValidateMultiWindows() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/login");//parent window
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        softAssert.assertEquals(handles.size(), 1, "Handles count is not matching");
        softAssert.assertEquals(driver.getTitle(), "LinkedIn Login, Sign in | LinkedIn", "LinkedIn header title mismatch");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com/");
        handles = driver.getWindowHandles();
        softAssert.assertEquals(handles.size(), 2, "Handles count is not matching");
        softAssert.assertEquals(driver.getTitle(), "Facebook", "Facebook header title mismatch");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");
        handles = driver.getWindowHandles();
        softAssert.assertEquals(handles.size(), 3, "Handles count is not matching");
        softAssert.assertEquals(driver.getTitle(), "Google", "Google header title mismatch");
        softAssert.assertAll();

		driver.switchTo().window(parentWindowHandle);
		softAssert.assertEquals(driver.getTitle(), "LinkedIn Login, Sign in | LinkedIn", "LinkedIn header title mismatch");
		driver.quit();
    }

    @AfterMethod
    private void tearDown() {

        driver.quit();
    }
}
