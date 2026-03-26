package com.practice.practice2026.naveenTests.testngFeatureDemo;

import org.testng.annotations.Test;

public class InvocationCountWithThreadPoolTest {
    int executionAttempt = 1;

    // Runs 3 times, optionally in parallel threads
    // | Attribute         | Purpose                                                              |
    // | ----------------- | -------------------------------------------------------------------- |
    // | `invocationCount` | Number of times this test should be executed (here **3 times**).     |
    // | `threadPoolSize`  | Number of threads to run this test in parallel (here **2 threads**). |

    @Test(invocationCount = 3,  threadPoolSize = 2)
    public void invocationCountValidationTest() {
        System.out.println("Executing test on thread: " + Thread.currentThread().getId() + " Exec Attempt : " + executionAttempt++);
    }
}
