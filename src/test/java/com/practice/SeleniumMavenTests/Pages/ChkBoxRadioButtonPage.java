package com.practice.SeleniumMavenTests.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChkBoxRadioButtonPage {
	private static ChkBoxRadioButtonPage chkBoxRadioButtonPage = null;
	public static final String checkbox1_id = "vfb-6-0";
	public static final String checkbox2_id = "vfb-6-1";
	public static final String checkbox3_id = "vfb-6-2";
	public static final String radioButton1_id = "vfb-7-1";
	public static final String radioButton2_id = "vfb-7-2";
	public static final String radioButton3_id = "vfb-7-3";
	

	
	public  ChkBoxRadioButtonPage getInstance()	{
		 if (chkBoxRadioButtonPage == null)	{
			 System.out.println("Initialization done for ChkBoxRadioButtonPage Santappa");
			 chkBoxRadioButtonPage = new ChkBoxRadioButtonPage();
		 }
		 return chkBoxRadioButtonPage;
	}
	
	


}
