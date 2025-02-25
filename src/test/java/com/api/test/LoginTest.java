package com.api.test;

import com.api.services.LoginService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginTest(){
        LoginService lgSer = new LoginService();
        Response rs = lgSer.login();
        System.out.println("TT" + rs.asPrettyString());
        System.out.println("TT" + rs.jsonPath().get("token"));
    }

}
