package com.practice.practice2026.naveenTests.actions;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.Interview.pages.AmzHelpPage;


public class MouseScrollAndHoverWithMoveToElementTest {

    WebDriver driver;
    SoftAssert softAssert;
    AmzHelpPage amzHelpPage;
    Actions actions;
    Action action;
    WebDriverWait wait;

    @BeforeClass
    private void setUp() {
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        amzHelpPage = new AmzHelpPage(driver);
    }

    @Test
    private void testScrollAndMouseActions() {
        actions = new Actions(driver);
        driver.get("https://www.amazon.co.in");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(amzHelpPage.amzSearchBox));
        action = actions.scrollToElement(amzHelpPage.careersLink).click(amzHelpPage.helpLink).build();
        action.perform();
        wait.until(ExpectedConditions.visibilityOf(amzHelpPage.amzHelpSearchBox));
    }

    @Test (dependsOnMethods="testScrollAndMouseActions")    
    private void testMouseHoverAndFindElement() {
        actions.moveToElement(amzHelpPage.amazonBazarLink).perform();
        
        wait.until(ExpectedConditions.visibilityOf(amzHelpPage.howToCancelOrderLink));
        softAssert.assertTrue(amzHelpPage.howToCancelOrderLink.isDisplayed(), "howToCancelOrderLink link displayed before mouse hover");
        softAssert.assertTrue(amzHelpPage.howToScheduleReturnLink.isDisplayed(), "howToScheduleReturnLink link displayed before mouse hover");
        softAssert.assertTrue(amzHelpPage.shippingSpeedAndChargesLink.isDisplayed(), "shippingSpeedAndChargesLink link displayed before mouse hover");

        softAssert.assertTrue(amzHelpPage.howToCancelOrderLink.isEnabled(), "howToCancelOrderLink link enabled before mouse hover");
        softAssert.assertTrue(amzHelpPage.howToScheduleReturnLink.isEnabled(), "howToScheduleReturnLink link enabled before mouse hover");
        softAssert.assertTrue(amzHelpPage.shippingSpeedAndChargesLink.isEnabled(), "shippingSpeedAndChargesLink link enabled before mouse hover");
        softAssert.assertAll();
    }

    @AfterClass 
    private void tearDown() {
        driver.close();
        driver.quit();
    }

}
