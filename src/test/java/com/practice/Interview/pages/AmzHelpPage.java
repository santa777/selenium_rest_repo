package com.practice.Interview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmzHelpPage {

    WebDriver driver;

    @FindBy(css = "input[id='twotabsearchtextbox']")
    public WebElement amzSearchBox;

    @FindBy(css = "input[type='search']")
    public WebElement amzHelpSearchBox;

    @FindBy(linkText = "Careers")
    public WebElement careersLink;

    @FindBy(linkText = "Help")
    public WebElement helpLink;

    @FindBy(linkText = "Amazon Bazaar")
    public WebElement amazonBazarLink;

    @FindBy(linkText = "How to cancel an order")
    public WebElement howToCancelOrderLink;

    @FindBy(linkText = "How to schedule a return")
    public WebElement howToScheduleReturnLink;

    @FindBy(linkText = "Shipping Speeds and Charges")
    public WebElement shippingSpeedAndChargesLink;

    public AmzHelpPage(WebDriver brosWebDriver) {
        this.driver = brosWebDriver;
        PageFactory.initElements(driver, this);
    }
}
