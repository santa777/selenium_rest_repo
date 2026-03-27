package com.practice.practice2026;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.Interview.pages.DemoAutoTestPage;

public class MultiSelectDropDownValidationTest {

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        //Selecting multiple languages from dropdown
        List<String> expected = new ArrayList<String>();
        expected.addAll(Arrays.asList("English", "Hindi", "Spanish"));
        wait.until(ExpectedConditions.visibilityOf(demoAutoTestPage.languageDropDown));
        demoAutoTestPage.languageDropDown.click();
        //Selecting multiple languages from dropdown
        for (String lang : expected) {
            String xpath = "//ul[contains(@class,'ui-menu')]//a[text()='" + lang + "']";
            WebElement option = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(xpath))
            );
            wait.until(ExpectedConditions.visibilityOf(option));
            option.click();
        }

        // List<String> actual = new ArrayList<>();
        // for (WebElement ele : demoAutoTestPage.selectedLanguages) {
        //     actual.add(ele.getText().trim());
        // }
        // for (String exp : expected) {
        //     softAssert.assertTrue(actual.contains(exp), "Missing: " + exp);
        // }

         List<String> actual =
         demoAutoTestPage.selectedLanguages.stream()
         .map(WebElement::getText).collect(Collectors.toList());
         System.out.println("Actual data = " + actual.toString());
        softAssert.assertTrue(expected.equals(actual), "Some expected languages are missing in actual " + actual);
        softAssert.assertAll();

    }

    @AfterMethod
    private void tearDown() {
        driver.close();
        driver.quit();
    }

}
