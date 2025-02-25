package com.api.util;
import com.github.javafaker.Faker;
import com.api.model.requests.BookingRequest;
import com.api.model.requests.Bookingdates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class RandomPojoGenerator {

    private static final Faker faker = new Faker(new Locale("en-US"));
    private static final Random random = new Random();

    public static BookingRequest generateRandomBookingRequest() {
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setFirstname(faker.name().firstName());
        bookingRequest.setLastname(faker.name().lastName());
        bookingRequest.setTotalprice(random.nextInt(1000));
        bookingRequest.setDepositpaid(random.nextBoolean());
        bookingRequest.setAdditionalneeds(faker.lorem().sentence());

        Bookingdates bookingdates = new Bookingdates();
        LocalDate checkin = LocalDate.now().plusDays(random.nextInt(30));
        LocalDate checkout = checkin.plusDays(random.nextInt(10) + 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        bookingdates.setCheckin(checkin.format(formatter));
        bookingdates.setCheckout(checkout.format(formatter));

        bookingRequest.setBookingdates(bookingdates);

        return bookingRequest;
    }

    public static void main(String[] args) {
        BookingRequest randomRequest = generateRandomBookingRequest();
        System.out.println(randomRequest);
    }
}