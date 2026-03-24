package com.practice.SeleniumMavenTests;

import org.testng.annotations.Test;

public class TestNgDependsOnMethods {
	 @Test(dependsOnMethods = { "testTwo" })
	    public void testThree() {
	        System.out.println("Test method three depends on two");
	    }
	 

	    @Test(dependsOnMethods = { "testTwo" })
	    public void testOne() {
	        System.out.println("Test method one depends on two");
	    }
	 
	    @Test
	    public void testTwo() {
	        System.out.println("Test method two");
	    }
	

}
