package com.practice.SeleniumMavenTests.TestTags;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupingTagTest {
	
	@DataProvider(name = "indexedDataProvider")
	private Object[][] getData()	{
		Object[][] data = new Object[3][2];
		data[0][0] = "UserName1";
		data[0][1] = "Password1";
		data[1][0] = "UserName2";
		data[1][1] = "Password2";
		data[2][0] = "UserName3";
		data[2][1] = "Password3";
		return data;
	}
	
	@DataProvider(name="intializedDataProvider")
	private Object[][] getdata2()	{
		return new Object[][]	{
			{"Sant", "Naya"},
			{"Vaman", "Gai"},
			{"Prasanna", "Prabhu"}
		};
	}			
	
	
	
	@Test(dataProvider="intializedDataProvider", groups = {"HappyPath", "SmokeTest"})
	private void test1(String userName, String password)	{
		System.out.println("Username : " + userName + " Password : " + password);
	}
	
	@Test(dataProvider="indexedDataProvider", groups = {"HappyPath", "SanityTest"})
	private void test2(String firstName, String lastName)	{
		System.out.println("FirstName : " + firstName + " LastName : " + lastName);
	}
		
		
}
