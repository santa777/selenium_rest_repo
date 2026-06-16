package com.practice.practice2026.apiTests.san2026.reqresApiTests;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class FirstGetTest {
    RequestSpecification requestSpecification;

    @BeforeClass
    private void setUp()    {
        requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .addHeader("x-api-key", "pub_90788c02b35d922c91264eec13595a3d0985ac1976154ce3a9efe9bf9e4ac8db")
            .setContentType("application/json")
            .build();

    }

    @Test
    private void test_1()   {
        SoftAssert softAssert = new SoftAssert();
       RestAssured
        .given()
            .spec(requestSpecification)
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .log().all();

        // softAssert.assertEquals(response.getStatusCode(), 200);
        // softAssert.assertAll();
    }

}
