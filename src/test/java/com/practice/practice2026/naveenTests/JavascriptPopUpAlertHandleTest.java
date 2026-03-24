package com.practice.practice2026.naveenTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavascriptPopUpAlertHandleTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    private void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @Test
    private void testJavascriptPopUpAlertHandle() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // click on the button to trigger the alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        // It will also return the alert instance if it is present, so we can directly switch to it and perform actions
        wait.until(ExpectedConditions.alertIsPresent());

        // switch to the alert and accept it : Alert has text and ok button
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        softAssert.assertEquals(text, "I am a JS Alert", "Alert text does not match expected value");
        driver.switchTo().alert().accept();
        WebElement resultElement = driver.findElement(By.id("result"));

        softAssert.assertEquals(resultElement.getText(), "You successfully clicked an alert", "Result text does not match expected value");

        // Validate alert which has OK and cancel with text
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        text = alert.getText();
        softAssert.assertEquals(text, "I am a JS Confirm", "Alert text does not match expected value");
        alert.dismiss();

        softAssert.assertEquals(resultElement.getText(), "You clicked: Cancel", "Result text does not match expected value");

        // Validate alert which has texbox to enter value with ok button and cancel button
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        text = alert.getText();
        softAssert.assertEquals(text, "I am a JS prompt", "Alert text does not match expected value");
        String keyEntered = "Santa";
        alert.sendKeys("Santa");
        alert.accept();

        softAssert.assertEquals(resultElement.getText(), "You entered: " + keyEntered, "Result text does not match expected value");
        softAssert.assertAll();

    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }

}
