package com.practice.practice2026.naveenTests.testngFeatureDemo;

import org.testng.annotations.Test;

public class InvocationCountWithThreadPoolTest {
    int executionAttempt = 1;

    // In TestNG, invocationCount is allows you to run sample test multiple times
    /*
    Repeating tests to check stability
    Simple load testing
    Re-running flaky tests without retry logic 
    */
    @Test(invocationCount = 3,  threadPoolSize = 2)
    public void invocationCountValidationTest() {
        System.out.println("Executing test on thread: " + Thread.currentThread().getId() + " Exec Attempt : " + executionAttempt++);
    }
}
