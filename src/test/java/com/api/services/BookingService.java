package com.api.services;

import com.api.model.requests.BookingRequest;
import com.api.util.RandomPojoGenerator;
import io.restassured.response.Response;


public class BookingService extends BaseService{
    private static final String BASE_PATH ="/booking";


    public Response createBooking(){
        BookingRequest br = RandomPojoGenerator.generateRandomBookingRequest();
        Response rs = postRequest(br, BASE_PATH);
        return rs;
    }

}
