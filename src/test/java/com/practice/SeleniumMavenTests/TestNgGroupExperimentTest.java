package com.practice.SeleniumMavenTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgGroupExperimentTest {
	
	@Test(groups = {"RegressionTest", "SmokeTest"})
	public void testRegressionTest1SmokeTest1() {
		System.out.println("Executing =>  Regression Test1, SmokeTes1");
		Assert.assertEquals(1, 1);
	}

	@Test(groups = {"SanityTest"}) // Default Priority is 0
	public void testSanityTest1() {
		System.out.println("Executing SanityTest1");
	}

	@Test(groups = {"RegressionTest"})
	private void testRegressionTest2() {
		System.out.println("Executing RegressionTest2");

	}

	@Test(groups = {"RegressionTest"})
	private void testRegressionTest3() {
		System.out.println("Executing RegressionTest3");
		new SoftAssert().assertAll();
	}

	@Test(groups = {"RegressionTest"})
	private void testRegressionTest4() {
		System.out.println("Executing RegressionTest4");
		new SoftAssert().assertAll();
	}

}
