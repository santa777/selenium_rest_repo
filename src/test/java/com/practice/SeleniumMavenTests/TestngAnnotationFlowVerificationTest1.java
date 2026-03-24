package com.practice.SeleniumMavenTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotationFlowVerificationTest1 {
	@BeforeSuite
	public void beforeSuite() {
		// Kind of reporting code you can write here
		System.out.println("BeforeSuite is executed");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass  is executed");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod is executed");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest is executed");
	}

	@Test
	public void testPavanPai1() {
		System.out.println("******************TestPavanPai1 is getting executed*********************");
	}

	@Test
	public void testPurushottamPai1() {
		System.out.println("******************TestPavanPai1 is getting executed*********************");
	}

	@AfterSuite
	public void afterSuite() {
		// Kind of reporting code you can write here
		System.out.println("AfterSuite is executed");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass  is executed");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod is executed");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest is executed");
	}

}


/* ############################################## Console OutPut ##############################################
[RemoteTestNG] detected TestNG version 7.4.0
[Configuration] [WARN] Detected a static method [com.practice.SeleniumMavenTests.TestngAnnotationFlowVerificationTest1.beforeClass()]. Static configuration methods can cause  unexpected behavior.
[Configuration] [WARN] Detected a static method [com.practice.SeleniumMavenTests.TestngAnnotationFlowVerificationTest1.afterClass()]. Static configuration methods can cause  unexpected behavior.
BeforeSuite is executed
BeforeTest is executed
BeforeClass  is executed
BeforeMethod is executed
******************TestPavanPai1 is getting executed*********************
AfterMethod is executed
BeforeMethod is executed
******************TestPavanPai1 is getting executed*********************
AfterMethod is executed
AfterClass  is executed
AfterTest is executed
PASSED: testPavanPai1
PASSED: testPurushottamPai1

===============================================
    Default test
    Tests run: 2, Failures: 0, Skips: 0
===============================================

AfterSuite is executed

===============================================
Default suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
=============================================== */
