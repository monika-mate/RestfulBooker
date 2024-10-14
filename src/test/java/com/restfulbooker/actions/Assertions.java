package com.restfulbooker.actions;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;



public class Assertions {

    public void verifyStatusCode(Response response){
         assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"), true,
                "Value of status code" + response.statusCode());

    }

    public void verifyResponseBody(String actual, String expected, String discription){
         assertEquals(actual, expected, discription);
    }

    public void verifyResponseBody(float actual, float expected, String discription){
        assertEquals(actual, expected, discription);
    }

    public void verifyResponseBody(int actual, int expected, String discription){
        assertEquals(actual, expected, discription);
    }

    public void verifyResponseBody(double actual, double expected, String discription){
        assertEquals(actual, expected, discription);
    }



}
