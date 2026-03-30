package POSTAPITests;

import org.openqa.selenium.json.Json;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserApiRevision {

    String emailId;
    int userId;
    String bearerToken = "Bearer d0bf1714ac04c10dd2982e009d2dffe694a8e0b53af518cb7370e41e046a72f6";
    String endPoint = "/public/v2/users";
    Response response;
    SoftAssert softAssert;

    public String getEmailid() {
        return "newuser" + System.currentTimeMillis() + "@opencart.com";
    }

    @BeforeClass()
    private void setup() {
        RestAssured.baseURI = "https://gorest.co.in";
        softAssert = new SoftAssert();
    }

    @Test
    private void createUserTest() {
        emailId = getEmailid();
        String jsonBody = "{\n"
                + "    \"name\": \"Api Automation\",\n"
                + "    \"gender\": \"male\",\n"
                + "    \"email\": \"" + emailId + "\",\n"
                + "    \"status\": \"active\"    \n"
                + "}";
        userId = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", bearerToken)
                    .body(jsonBody)
                .when()
                    .post(endPoint)
                .then()
                    .log().all().assertThat().statusCode(201)
                .extract().path("id");
            System.out.println("newly created user id is " + userId);    

    }

    @Test(dependsOnMethods = "createUserTest")
    private void getApiResponseValidation() {

        response = RestAssured
                .given()
                    .header("Authorization", bearerToken)
                .when()
                    .get(endPoint + "/" + userId)
                .then()
                    .log().all()
                    .assertThat()
                .statusCode(200).extract().response();
        JsonPath jsonPath = response.getBody().jsonPath();
        softAssert.assertEquals(jsonPath.getInt("id"), userId, "User id mismatch");
        softAssert.assertEquals(jsonPath.getString("email"), emailId, "Email mismatch");
        softAssert.assertEquals(jsonPath.getString("name"), "Api Automation", "Name mismatch");
        softAssert.assertEquals(jsonPath.getString("gender"), "male", "Gender mismatch");
        softAssert.assertEquals(jsonPath.getString("status"), "active", "Status mismatch");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "getApiResponseValidation")
    private void deleteApiCall() {
        Response response = RestAssured
                .given()
                    .header("Authorization", bearerToken)
                .when()
                    .delete(endPoint + "/" + userId)
                .then()
                    .log().all().extract().response();

        softAssert.assertEquals(response.getStatusCode(), 204);
        // Make get call post delete 
        RestAssured
                .given()
                    .header("Authorization", bearerToken)
                .when()
                    .get(endPoint + "/" + userId)
                .then()
                    .log().all()
                    .assertThat()
                    .statusCode(404)
                    .body("message", equalTo("Resource not found"));
        softAssert.assertAll();

    }

}
