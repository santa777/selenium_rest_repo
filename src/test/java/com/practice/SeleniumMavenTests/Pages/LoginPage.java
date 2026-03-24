package com.practice.SeleniumMavenTests.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement passwrod;

}
