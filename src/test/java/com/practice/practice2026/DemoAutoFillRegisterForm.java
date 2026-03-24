package com.practice.practice2026;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.Interview.pages.DemoAutoTestPage;

public class DemoAutoFillRegisterForm   {

    WebDriver driver;
    DemoAutoTestPage demoAutoTestPage;
    SoftAssert softAssert;

    @BeforeMethod
    private void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        demoAutoTestPage = new DemoAutoTestPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    private void testRadioButtonValidation() {
        driver.get("http://demo.automationtesting.in/Register.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(demoAutoTestPage.firstNameElement));
        // wait.until(ExpectedConditions.alertIsPresent()); // wait till alert
        demoAutoTestPage.firstNameElement.sendKeys("John");
        demoAutoTestPage.lastNameElement.sendKeys("Abrahim");
        demoAutoTestPage.addressElement.sendKeys("Sunnyvale, CA");
        demoAutoTestPage.maleGenenderRadioButton.click();

        softAssert.assertTrue(demoAutoTestPage.maleGenenderRadioButton.isDisplayed(), "Male radio button not displayed");   
        softAssert.assertTrue(demoAutoTestPage.maleGenenderRadioButton.isEnabled(), "Male radio button not displayed");   
        softAssert.assertTrue(demoAutoTestPage.maleGenenderRadioButton.isSelected(), "Male radio button not selected");
        
        softAssert.assertTrue(demoAutoTestPage.femaleGenenderRadioButton.isDisplayed(), "Female radio button not displayed");   
        softAssert.assertTrue(demoAutoTestPage.femaleGenenderRadioButton.isEnabled(), "Female radio button not displayed");   
        softAssert.assertFalse(demoAutoTestPage.femaleGenenderRadioButton.isSelected(), "Female radio button selected");
        softAssert.assertAll();
    }

    @AfterMethod
    private void afterMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
