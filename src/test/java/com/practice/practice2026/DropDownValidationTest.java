package com.practice.practice2026;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.Interview.pages.DemoAutoTestPage;

public class DropDownValidationTest {

    WebDriver driver;
    DemoAutoTestPage demoAutoTestPage;
    SoftAssert softAssert;

    @BeforeMethod
    private void setUp() {
        driver = new ChromeDriver();
        demoAutoTestPage = new DemoAutoTestPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    private void testDropDownValidation() {
        driver.get("http://demo.automationtesting.in/Register.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(demoAutoTestPage.firstNameElement));
        Select skillDropDown = new Select(demoAutoTestPage.skilsSelecElement);
        skillDropDown.selectByValue("Android");
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }

}
