package com.api.model.response;

import lombok.Data;

@Data
public class Booking{
	private String firstname;
	private String additionalneeds;
	private Bookingdates bookingdates;
	private int totalprice;
	private boolean depositpaid;
	private String lastname;
}