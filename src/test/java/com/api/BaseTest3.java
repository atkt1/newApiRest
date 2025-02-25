package com.api;


import com.api.services.BaseService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseTest3  extends BaseService {
private static final String BASE_PATH = "/notes/api/health-check";

    @Test
    public void test1(){

        Response rs =  getRequest(BASE_PATH);
        System.out.println(rs.asPrettyString());
    }

    @Test
    public void postTest(){

    }
}
