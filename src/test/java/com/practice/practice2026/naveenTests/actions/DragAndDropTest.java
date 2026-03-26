package com.practice.practice2026.naveenTests.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DragAndDropTest {

    WebDriver driver;
    SoftAssert softAssert;
    WebElement source, target, drageAndDropSuccessMessage;
    WebDriverWait wait;

    @BeforeMethod
    private void setup() {
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
    }

    @Test
    private void testValidateDragAndDrop() throws Exception {
        Actions actions = new Actions(driver);
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        source = driver.findElement(By.id("draggable"));
        target = driver.findElement(By.id("droppable"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Solution 1 : dragAndDrop
        actions.dragAndDrop(source, target).perform();
        drageAndDropSuccessMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        softAssert.assertTrue(drageAndDropSuccessMessage.isDisplayed(), "Dropped element is not displayed during Solution1");
        softAssert.assertAll();
    }

    @Test
    private void testDragDropHoldMoveAndRelease() {
        Actions actions = new Actions(driver);
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        source = driver.findElement(By.id("draggable"));
        target = driver.findElement(By.id("droppable"));
        Action action = actions.clickAndHold(source).moveToElement(target).release().build();
        action.perform();
        drageAndDropSuccessMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        softAssert.assertTrue(drageAndDropSuccessMessage.isDisplayed(), "Dropped element is not displayed during Solution1");
        softAssert.assertAll();
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }

}
