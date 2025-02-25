package com.api;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BasicTest {

@Test
    public void basicTest(){
        RestAssured.baseURI = "https://bookcart.azurewebsites.net";

        RequestSpecification x = RestAssured.given().basePath("/api/Book");
        RequestSpecification y = x.contentType(ContentType.JSON);
        Response rs = y.get();
        System.out.println(rs.asPrettyString());
    }

}
