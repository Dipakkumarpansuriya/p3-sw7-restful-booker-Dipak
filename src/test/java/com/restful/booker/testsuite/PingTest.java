package com.restful.booker.testsuite;
// **** Created By Harshit Patel ****

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PingTest extends TestBase {

    @Test
    public void getAllBookingData(){
        Response response=given()
                .when()
                .get("/ping");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
