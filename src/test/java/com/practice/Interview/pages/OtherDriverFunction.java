package com.practice.Interview.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.Interview.helper.TestBase;

public class OtherDriverFunction extends TestBase {
	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement passwrod;

	@FindBy(id = "join_now")
	public WebElement joinNowLink;

	@FindBy(xpath = "//*[contains(@class,'forgot-password')]")
	public WebElement forgotPasswordLink;

	@FindBy(id = "error-for-password")
	public WebElement passwordErrorMessage;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement loginButton;
	
	@FindBy(id = "error-for-username")
	public WebElement userNameErrorMessage;
	
	
	
	public OtherDriverFunction() {
		PageFactory.initElements(driver, this);
	}

}
