package com.practice.practice2026;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.Interview.pages.DemoAutoTestPage;
/* TO_DO : This is to just give the overview of different 
explicit wait methods available in Selenium. 
This is not a test case to be executed as it will fail due to the 
conditions not being met on the webpage. 
Please refer to the comments in the code for more details. */
public class ExplicitWaitDifferentMethodValidation {

    WebDriver driver;
    DemoAutoTestPage demoAutoTestPage;

    @BeforeMethod
    private void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Register.html");
        demoAutoTestPage = new DemoAutoTestPage(driver);
    }
    
    // Not running this test as this is created only get information about ExpectedConditions
    @Test (enabled=false) 
    private void testAutoFillRegisterForm() {
        driver.get("http://demo.automationtesting.in/Register.html");
        List<WebElement> listOfElements = new ArrayList<WebElement>();
        listOfElements.add(demoAutoTestPage.phoneNumberTxtBox);
        listOfElements.add(demoAutoTestPage.addressElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Visibility and invisibility of element or list of elements validation
        wait.until(ExpectedConditions.visibilityOf(demoAutoTestPage.firstNameElement));
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
        wait.until(ExpectedConditions.invisibilityOf(demoAutoTestPage.lastNameElement));
        wait.until(ExpectedConditions.invisibilityOfAllElements(listOfElements));

        // alert / number of windows / frame availaibility validation
        wait.until(ExpectedConditions.alertIsPresent());
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameNameOrId"));

        // element to be clickable validation
        wait.until(ExpectedConditions.elementToBeClickable(demoAutoTestPage.submitButton));
        // text to be present in element validation
        wait.until(ExpectedConditions.textToBePresentInElement(demoAutoTestPage.refreshButton, "Refresh"));

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
