package com.api.services;

import com.api.filters.ApiFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    static{
        RestAssured.filters(new ApiFilter());
    }


    private static final String BASE_URI ="https://restful-booker.herokuapp.com/";
    private RequestSpecification rqSp;

    public BaseService(){
        rqSp = RestAssured.given().baseUri(BASE_URI).contentType(ContentType.JSON);
    }

    protected Response getRequest(String endpoint){
        return rqSp.basePath(endpoint).get();
    }

    protected Response postRequest(Object payload, String endPoint){
        return rqSp.basePath(endPoint).body(payload).post();
    }
}
