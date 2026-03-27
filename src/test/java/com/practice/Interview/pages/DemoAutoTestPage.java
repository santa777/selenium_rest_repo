package com.practice.Interview.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoAutoTestPage {

    WebDriver driver;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameElement;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameElement;

    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    public WebElement addressElement;

    @FindBy(css = "input[type='email']")
    public WebElement emailTxtBox;

    @FindBy(css = "input[type='tel']")
    public WebElement phoneNumberTxtBox;

    @FindBy(css = "input[value='Male']")
    public WebElement maleGenenderRadioButton;

    @FindBy(css = "input[value='Female']")
    public WebElement femaleGenenderRadioButton;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(css = "button[value='Refresh']")
    public WebElement refreshButton;

    @FindBy(id = "[id='select2-country-container']")
    public WebElement countryDropDown;

    @FindBy(id = "msdd")
    public WebElement languageDropDown;

    @FindBy(css = "span[class='ui-icon ui-icon-close']")
    public WebElement langCloseButton;

    @FindBy(xpath = "//div[@class='ui-autocomplete-multiselect-item']")
    public List<WebElement> selectedLanguages;

    @FindBy(id = "Skills")
    public WebElement skilsSelecElement;

    public DemoAutoTestPage(WebDriver brosWebDriver) {
        this.driver = brosWebDriver;
        PageFactory.initElements(driver, this);
    }
}
