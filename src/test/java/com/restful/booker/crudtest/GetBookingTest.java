package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBookingTest extends TestBase {

    @Test
    public void getAllBookingData(){
        Response response=given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getSingleBookingData(){
        Response response=given()
                .pathParam("id","11")
                .when()
                .get("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
