package com.practice.practice2026.naveenTests.actions;



import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;


public class W3CComplianceTest {

    // TO_DO : Not yet tested
    @Test(enabled=false)
    public static void testW3CComplianceTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.example.com");

        // ===== 1. Navigation Commands =====
        driver.navigate().to("https://www.google.com");  // W3C compliant
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // ===== 2. Element Commands =====
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium 4 W3C compliance");  // keyboard command compliant
        searchBox.submit();

        // ===== 3. Actions Class (Mouse + Keyboard) =====
        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox).click().sendKeys("Testing W3C").perform();

        // ===== 4. Advanced Pointer Actions (W3C) =====
        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "mouse");
        Sequence seq = new Sequence(mouse, 0);
        seq.addAction(mouse.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), 200, 200));
        seq.addAction(mouse.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(mouse.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // driver.perform(Arrays.asList(seq));

        // ===== 5. Window Handling (Tabs / Windows) =====
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.selenium.dev");
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());

        // ===== 6. Alerts / IFrames =====
        // Assuming an alert is present
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present");
        }

        // ===== 7. Element Screenshot (W3C compliant) =====
        WebElement logo = driver.findElement(By.cssSelector("img"));
        File src = logo.getScreenshotAs(OutputType.FILE);

        driver.quit();
    }
}