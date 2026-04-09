package com.practice.practice2026.naveenTests.testngFeatureDemo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPassLoginParameterTest {

    int count = 1;

    @DataProvider(name = "loginTestValidationData")
    public String[][] loginData() {
        return new String[][]{
            {"invalidUserName", "invalidaPassword"},
            {"testemail@gmail.com", "wrongPassword"}
        };
    }

    @DataProvider(name = "cookiesData")
    public Object[][] getCookies() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("firstCookieName", "firstCookieValue");
        map.put("secondCookie", "secondCookieValue");
        return new Object[][]{
            {map}
        };
    }

    @Test(dataProvider = "loginTestValidationData")
    private void testLoginFeature(String username, String password) {
        System.out.println(String.format("\nValidating scenario number : %d ", count));

        System.out.println(String.format("Login Scenario %d username is \"%s\"", count, username));
        System.out.println(String.format("Login Scenario %d password is \"%s\"", count, password));

        System.out.println("Completed execution of Scenario " + count++);
    }

    @Test(dataProvider = "cookiesData")
    private void testCookieData(String cookieName, String cookieValue) {
        System.out.println(String.format("\nValidating scenario number : %d ", count));
        System.out.println(String.format("Cookie Scenario %d username is \"%s\"", count, cookieName));
        System.out.println(String.format("Cookie Scenario %d password is \"%s\"", count, cookieValue));
        System.out.println("Completed execution of Scenario " + count++);
    }

}
