package com.restfulbooker.modules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfulbooker.payloads.BookingResponse;
import com.restfulbooker.payloads.Request.Auth;
import com.restfulbooker.payloads.Request.Booking;
import com.restfulbooker.payloads.Request.Bookingdates;
import com.restfulbooker.utils.FakerUtil;

public class PayloadManager {

ObjectMapper mapper;

 public String createPayload() throws JsonProcessingException {
     mapper = new ObjectMapper();

     Booking booking = new Booking();
     booking.setFirstname("Monika");
     booking.setLastname("Mate");
     booking.setTotalprice(23123);
     booking.setDepositpaid(true);
     booking.setAdditionalneeds("Dinner");

     Bookingdates bookingdate = new Bookingdates();
     bookingdate.setCheckin("2024-11-23");
     bookingdate.setCheckout("2024-12-01");

     booking.setBookingdates(bookingdate);

     String payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
     return payload;
}

  public BookingResponse JsonToObj(String jsonString) throws JsonProcessingException {
      mapper = new ObjectMapper();
        BookingResponse bookingResponse = mapper.readValue(jsonString, BookingResponse.class);

     return bookingResponse;
    }

    public String setToken() throws JsonProcessingException {
     mapper = new ObjectMapper();
     Auth auth = new Auth();
     auth.setUsername("admin");
     auth.setPassword("password123");
     return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(auth);

    }

    public String updatePayload() throws JsonProcessingException {
        mapper = new ObjectMapper();

        Booking booking = new Booking();
        booking.setFirstname("Nick");
        booking.setLastname("Mate");
        booking.setTotalprice(23123);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Dinner");

        Bookingdates bookingdate = new Bookingdates();
        bookingdate.setCheckin("2024-11-23");
        bookingdate.setCheckout("2024-12-01");

        booking.setBookingdates(bookingdate);

        String payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;
    }

    public Booking JsonToObjPut(String jsonString) throws JsonProcessingException {
        mapper = new ObjectMapper();
        Booking bookingResponse = mapper.readValue(jsonString, Booking.class);

        return bookingResponse;
    }

}
