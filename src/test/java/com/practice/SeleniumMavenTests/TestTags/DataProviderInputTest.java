package com.practice.SeleniumMavenTests.TestTags;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderInputTest {

	@DataProvider(name = "data1")
	public Object[][] getData() {
		return new Object[][] { 
			{ "Santa", "Banta" }, 
			{ "Uday", "Naya" }, 
			{ "Santa", "Pallu" } 
		};
	}

	@DataProvider(name = "data1")
	public Object[][] getData1() {
		return new Object[][] {
			{ "Santa", "Vami" },
			{ "Pallu", "Ash" },
			{ "Vrishti", "Dandu" }
		};
	}
	
	@DataProvider(name ="data2")
	public Object[][] getData2()	{
		Object[][] data2 = new Object[3][2];
		data2[0][0] ="Hegde";
		data2[0][1] ="Kumta";
		data2[1][0] ="Heggar";
		data2[1][1] ="Kumta";
		data2[2][0] ="Balkur";
		data2[2][1] ="Honnavar";
		
		return data2;
	}
	
	@DataProvider(name="gods")	
	private Object[][] getData3()	{
		return new Object[][]{
			{"Damodar", "Ramanath"},
			{"Shantikamba", "Marikamba"},
			{"Shanteri", "Kamakshi"}
		};
	}
	
	@Test(dataProvider="data1")	
	private void test1(String userName, String password)	{
		System.out.println("Username = " + userName + " password = " + password);
		
	}
	
	@Test(dataProvider="data2", enabled=false)	
	private void getDataProvider2(String village, String taluk){
		System.out.println("Village " + village + " Taluk : " + taluk);
	}
	
	@Test(dataProvider="gods", priority=0)
	private void testCheckGodNames(String god1, String god2) {
		System.out.println("God1 = " + god1);
		System.out.println("God2 = " + god2);
	}
	

}
