package com.restfulbooker.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restfulbooker.actions.AssertActions;
import com.restfulbooker.endpoints.ApiConstant;
import com.restfulbooker.modules.PayloadManager;
import io.restassured.RestAssured;
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
    public JsonPath jsonPath;

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

    public String getToken() throws JsonProcessingException {
        requestSpecification = RestAssured.given().baseUri(ApiConstant.BASE_URL).basePath("/auth");
        String payload1 = payloadManager.setToken();
        response = requestSpecification.contentType(ContentType.JSON)
                   .body(payload1)
                   .when().post();
        jsonPath = new JsonPath(response.asString());
        return jsonPath.getString("token");




    }



}
