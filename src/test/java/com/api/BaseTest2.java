package com.api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BaseTest2 {

    @Test
    public void test1(){

        Response rs =  given().baseUri("https://bookcart.azurewebsites.net").basePath("/api/Book").contentType(ContentType.ANY).get();
        System.out.println(rs.asPrettyString());
    }
}
