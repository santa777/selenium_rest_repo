package com.practice.SeleniumMavenTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ToDOPirorityExperimentTest {
	
	@BeforeClass
	private void beforeClass()	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
	}
	
	@Test(priority=0)
	private void priority1Test()	{
		System.out.println("Zero'th priority test getting executed");

	}
	
	@Test(priority=-1)
	private void priority0Test()	{
		System.out.println("-1 priority test getting executed");
		new SoftAssert().assertAll();
	}
	
	@Test(priority=-2)
	private void priorityNegative2Test()	{
		System.out.println("-2 priority test getting executed");
		new SoftAssert().assertAll();
	}
}
