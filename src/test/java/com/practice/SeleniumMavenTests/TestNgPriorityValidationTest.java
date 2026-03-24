package com.practice.SeleniumMavenTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgPriorityValidationTest {

	@Test(priority = 1)
	public void testDismissAlertPrintingText1() {
		System.out.println("Annotation Validation 1 : Executing 1st test");
		Assert.assertEquals(1, 1);
	}

	@Test // Default Priority is 0
	public void testDismissAlertPrintingText2() {
		System.out.println("Annotation Validation 1 : Executing 2nd test");
	}

	@Test(priority = 0)
	private void priority1Test() {
		System.out.println("Zero'th priority test getting executed");

	}

	@Test(priority = -1)
	private void priority0Test() {
		System.out.println("-1 priority test getting executed");
		new SoftAssert().assertAll();
	}

	@Test(priority = -2)
	private void priorityNegative2Test() {
		System.out.println("-2 priority test getting executed");
		new SoftAssert().assertAll();
	}
}
