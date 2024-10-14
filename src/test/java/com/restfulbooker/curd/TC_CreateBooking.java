package com.restfulbooker.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restfulbooker.base.BaseTest;
import com.restfulbooker.endpoints.ApiConstant;
import com.restfulbooker.payloads.BookingResponse;
import com.restfulbooker.utils.YmalReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TC_CreateBooking extends BaseTest {

    @Test
    @Owner("Monika")
    @Description("Verify that create booking")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateBooking_Positive() throws JsonProcessingException {
        requestSpecification.basePath(ApiConstant.Create_Booking);
        response = requestSpecification.when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.JsonToObj(response.asString());
        //assertThat(bookingResponse.getBookingid()).isNotNull();
        System.out.println("Booking_ID = " + bookingResponse.getBookingid());
    }

    @Test
    @Owner("Monika")
    @Description("Verify that create booking")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateBooking_Negative() throws JsonProcessingException {
        requestSpecification.basePath(ApiConstant.Create_Booking);
        response = requestSpecification.when().body("").post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);
       // new YmalReader().readkey().get("username");
        // new PropertyReader().readkey().get("username");
        // new ExcelReader().readkey().get("username");
        // new JsonReader().readkey().get("username");
        // new TextReader().readkey().get("username");
        // new EnvReader().readkey().get("username");


    }
}