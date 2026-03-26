package com.practice.practice2026.naveenTests.testngFeatureDemo;

import org.testng.annotations.Test;

public class DepndsOnTest {

    @Test
    private void testMethod1() {
        System.out.println("Executing Test1");
    }

    @Test(dependsOnMethods="testMethod1")
    private void testMethod2() {
        System.out.println("Dependson testMethod1 : Executing Test2");
    }

    @Test(dependsOnMethods="testMethod2")
    private void testMethod3() {
        System.out.println("Dependson testMethod2 : Executing Test3");
    }

}
