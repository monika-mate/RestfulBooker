package com.restfulbooker.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restfulbooker.base.BaseTest;
import com.restfulbooker.endpoints.ApiConstant;
import com.restfulbooker.payloads.BookingResponse;
import com.restfulbooker.payloads.Request.Booking;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TC_Integration extends BaseTest {
    String token;
    String bookingID;

    private static final Logger log = LogManager.getLogger(TC_Integration.class);

    @Test
    public void createBooking() throws JsonProcessingException {
        token = getToken();
        assertThat(token).isNotNull().isNotEmpty();
        requestSpecification.basePath(ApiConstant.Create_Booking);
        response = requestSpecification.when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

//        BookingResponse bookingResponse = payloadManager.JsonToObj(response.asString());
//        Assertions.assertThat(bookingResponse.getBookingid()).isNotNull();
//        System.out.println("Booking_ID = " + bookingResponse.getBookingid());
        jsonPath = JsonPath.from(response.asString());
        bookingID = jsonPath.getString("bookingid");
        log.info("this is my bookingid" + bookingID);
        assertThat(bookingID).isNotNull().isNotEmpty();

    }

    @Test(dependsOnMethods = {"createBooking"})
    public void createAndUpdateBooking() throws JsonProcessingException {

        requestSpecification.basePath(ApiConstant.Update_Booking + "/" + bookingID);
        response = RestAssured.given().spec(requestSpecification).cookie("token", token)
        .when().body(payloadManager.updatePayload()).put();
        validatableResponse = response.then().log().all();
//        validatableResponse.statusCode(200)
//                .body("firstname", Matchers.is("Nick"));

        Booking bookingResponse = payloadManager.JsonToObjPut(response.asString());
        assertThat(bookingResponse.getFirstname()).isEqualTo("Nick").isNotNull();
        assertThat(bookingResponse.getLastname()).isNotNull();




    }

    @Test(dependsOnMethods = {"createAndUpdateBooking"})
    public void createAndDeleteBooking() throws JsonProcessingException {

        requestSpecification.basePath(ApiConstant.Update_Booking + "/" + bookingID)
        .cookie("token", token);
        validatableResponse =  RestAssured.given().spec(requestSpecification).auth().basic("admin", "password123")
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);

    }

    @Test(dependsOnMethods = {"createAndDeleteBooking"})
    public void DeleteBookingByGet() throws JsonProcessingException {

        requestSpecification.basePath(ApiConstant.Update_Booking + "/" + bookingID);
        validatableResponse =  RestAssured.given().spec(requestSpecification).auth().basic("admin", "password123")
                .when().get().then().log().all();
        validatableResponse.statusCode(404);

    }


}
