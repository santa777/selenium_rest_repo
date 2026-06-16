package com.practice.practice2026.apiTests.sampleTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class FirstSampleGetTest {
    public static final String ID = "data";
    public static final String TOKEN = "token";
    public static final String PAGE = "page";
    public static final String CREATED = "createdAt";
    public static final String UPDATED = "updatedAt";
  
    public static void main(String args[])  {
        
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Responses = " + response);
        System.out.println(response.jsonPath().toString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());

    }
    
}
