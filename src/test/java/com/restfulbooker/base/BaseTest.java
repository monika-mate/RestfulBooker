package com.restfulbooker.base;

import com.restfulbooker.actions.AssertActions;
import com.restfulbooker.endpoints.ApiConstant;
import com.restfulbooker.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public PayloadManager payloadManager;
    public AssertActions actions;

    @BeforeTest
    public void setup(){
      payloadManager =new PayloadManager();
      actions = new AssertActions();
      requestSpecification = RestAssured.given()
              .baseUri(ApiConstant.BASE_URL)
              .contentType(ContentType.JSON);

//      requestSpecification = new RequestSpecBuilder().
//              setBaseUri(ApiConstant.BASE_URL)
//              .addHeader("Content-Type", "application/json")
//              .build().log().all();


    }

}
