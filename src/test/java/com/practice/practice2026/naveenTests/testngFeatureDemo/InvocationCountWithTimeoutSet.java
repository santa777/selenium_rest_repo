package com.practice.practice2026.naveenTests.testngFeatureDemo;

import org.testng.annotations.Test;

public class InvocationCountWithTimeoutSet {
    int executionAttempt = 1;

    // invocationCount = 3 : Run test 3 times
    // Fail test if **execution exceeds milliseconds** (`@Test(timeOut=2000)`
    @Test(invocationCount = 3, timeOut=5000)
    public void invocationCountValidationTest() {
        System.out.println("Executing test on thread: " + Thread.currentThread().getId() + " Exec Attempt : " + executionAttempt++);
    }
}
