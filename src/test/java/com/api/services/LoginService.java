package com.api.services;

import com.api.model.requests.LoginRequest;
import io.restassured.response.Response;


public class LoginService extends BaseService{
    private static final String BASE_PATH = "/auth";


    public Response login(){
        Response rs = postRequest(new LoginRequest("admin","password123"),BASE_PATH);
        return rs;
    }

}