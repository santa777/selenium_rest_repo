package com.practice.practice2026.naveenTests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CookieValidationTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @Test
    private void testValidateCookies() throws InterruptedException {
        driver.get("https://www.linkedin.com/login");
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Forgot password?")));
        // All cookies functions : getCookies(), getCookieNamed(String name), addCookie(Cookie cookie), deleteCookie(Cookie cookie), deleteCookieNamed(String name), deleteAllCookies()
        Cookie cookie = driver.manage().getCookieNamed("lang"); // getCookie
        softAssert.assertTrue(cookie.getValue().contains("ang=en-us"), "Lang cookie value does not contain expected value");
        Set<Cookie> cookiesSet = driver.manage().getCookies(); // getCookies
        driver.manage().deleteCookieNamed("lang");
        driver.manage().addCookie(cookie);
        driver.manage().deleteAllCookies();
        softAssert.assertAll();
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}
