package com.api.model.requests;

import lombok.Data;

@Data
public class BookingRequest{
	private String firstname;
	private String additionalneeds;
	private Bookingdates bookingdates;
	private int totalprice;
	private boolean depositpaid;
	private String lastname;
}