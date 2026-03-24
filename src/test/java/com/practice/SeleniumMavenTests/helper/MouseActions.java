package com.practice.SeleniumMavenTests.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public void mouseOver(WebDriver driver, WebElement webElelement)	{
		Actions action = new Actions(driver);
		action.moveToElement(webElelement);
	
	
	}
	
	public void dragAndDrop(WebDriver driver, String source, String target)	{
		
	}
}
