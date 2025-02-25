package com.api.test;

import com.api.listener.TestListener;
import com.api.services.BookingService;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class BookingTest {

    private static Logger logger = LogManager.getLogger(BookingTest.class);
    @Test
    public void bookingTest(){
        BookingService bs = new BookingService();
        Response rs = bs.createBooking();
        logger.info(rs.prettyPrint());

    }
}
