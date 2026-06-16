package com.practice.practice2026.apiTests.san2026;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUpdatePatchDeleteApiWithPojo {

    RequestSpecification requestSpec;
    SoftAssert softAssert;
    private final String email = getRandomEmail();
    User user = new User("Tata", "male", email, "active");
    int userId;
    String bearerToken = "Bearer d0bf1714ac04c10dd2982e009d2dffe694a8e0b53af518cb7370e41e046a72f6";
    boolean isUserCreated = false;

    private String getRandomEmail() {
        return "api_" + System.currentTimeMillis() + "@opercart.com";

    }

    @BeforeClass
    private void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in")
                .setBasePath("/public/v2/users")
                .addHeader("Authorization", bearerToken)
                .setContentType(ContentType.JSON)
                .build();
        softAssert = new SoftAssert();
    }

    @Test
    private void testCreateUser() {
        Response response = RestAssured
                .given()
                    .spec(requestSpec)
                    .body(user)
                .when()
                    .post()
                .then()
                    .log().all()
                    .extract().response();
        userId = response.jsonPath().getInt("id");
        softAssert.assertEquals(response.statusCode(), 201);
        isUserCreated = true;


        // Duplicate entity should create 422
        response = RestAssured
                .given()
                    .spec(requestSpec)
                    .body(user)
                .when()
                    .post()
                .then()
                    .extract().response();
        softAssert.assertEquals(response.statusCode(), 422);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testCreateUser")
    private void testGetUser() {
        User actualUserViaGet = RestAssured
                .given()
                    .spec(requestSpec)
                .when()
                    .get("/" + userId)
                .then()
                    .statusCode(200)
                    .extract().as(User.class);

        softAssert.assertEquals(actualUserViaGet.getName(), user.getName());
        softAssert.assertEquals(actualUserViaGet.getEmail(), user.getEmail());
        softAssert.assertEquals(actualUserViaGet.getGender(), user.getGender());
        softAssert.assertEquals(actualUserViaGet.getStatus(), user.getStatus());
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testGetUser")
    private void testPutUser() {
        user = new User("Santa", "male", email, "active");

        Response response = RestAssured
                .given()
                    .spec(requestSpec)
                    .body(user)
                .when()
                    .put("/" + userId)
                .then()
                    .extract().response();
        softAssert.assertEquals(response.getStatusCode(), 200);

        User actualUserViaGet = RestAssured
                .given()
                    .spec(requestSpec)
                .when()
                    .get("/" + userId)
                .then()
                    .statusCode(200)
                    .extract().as(User.class);

        softAssert.assertEquals(actualUserViaGet.getName(), user.getName());
        softAssert.assertEquals(actualUserViaGet.getEmail(), user.getEmail());
        softAssert.assertEquals(actualUserViaGet.getGender(), user.getGender());
        softAssert.assertEquals(actualUserViaGet.getStatus(), user.getStatus());
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testPutUser")
    private void testPatchUser() {
        User payLoadUserForPatch = new User();
        payLoadUserForPatch.setName("SantaClaus");
        payLoadUserForPatch.setStatus("inactive");

        RestAssured
        .given()
            .spec(requestSpec)
            .body(payLoadUserForPatch)
        .when()
            .patch("/" + userId)
        .then()
            .log().all()
            .statusCode(200);

         User actualUserViaGet = RestAssured
                .given()
                    .spec(requestSpec)
                .when()
                    .get("/" + userId)
                .then()
                    .extract().as(User.class);

        softAssert.assertEquals(actualUserViaGet.getName(), payLoadUserForPatch.getName());
        // softAssert.assertEquals(actualUserViaGet.getEmail(), user.getEmail());
        // softAssert.assertEquals(actualUserViaGet.getGender(), user.getGender());
        softAssert.assertEquals(actualUserViaGet.getStatus(), payLoadUserForPatch.getStatus());
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testPatchUser")
    private void testDeleteUser() {
        Response response = RestAssured
                .given()
                    .spec(requestSpec)
                .when()
                    .delete("/" + userId)
                .then()
                    .extract().response();
        softAssert.assertEquals(response.getStatusCode(), 204);

        response = RestAssured
                .given()
                    .spec(requestSpec)
                .when()
                    .get("/" + userId)
                .then()
                    .extract().response();
        softAssert.assertEquals(response.statusCode(), 404);
        softAssert.assertEquals(response.getBody().jsonPath().getString("message"), "Resource not found");
        softAssert.assertAll();
    }

    @AfterClass
    private void tearDown() {
        if(isUserCreated) {
            RestAssured
                    .given()
                        .spec(requestSpec)
                    .when()
                        .delete("/" + userId);
        }
    }
}
    


