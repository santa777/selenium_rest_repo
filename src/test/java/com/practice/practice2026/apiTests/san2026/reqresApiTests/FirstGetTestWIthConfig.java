package com.practice.practice2026.apiTests.san2026.reqresApiTests;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import com.practice.practice2026.apiTests.san2026.reqresApiTests.Lib.ApiConfig;
import com.practice.practice2026.apiTests.san2026.reqresApiTests.Lib.ApiConstant;

import io.restassured.RestAssured;

public class FirstGetTestWIthConfig {

    @Test
    public void testGetUser() {
        RestAssured
        .given()
            .header(ApiConstant.API_KEY_HEADER, ApiConfig.getInstance().getApiKey())
            .pathParam("id", 2)
        .when()
            .get(ApiConstant.BASE_URL + ApiConstant.USERS_ENDPOINT)
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2));
    }
    
}
