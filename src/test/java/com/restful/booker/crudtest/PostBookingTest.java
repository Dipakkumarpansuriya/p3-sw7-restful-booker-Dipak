package com.restful.booker.crudtest;


import com.restful.booker.model.CreatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostBookingTest extends TestBase {


    @Test
    public void createBookingData(){
        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2023-10-28");
        bookingsDatesData.put("checkout", "2023-11-20");


        CreatePojo createPojo =new CreatePojo();
        createPojo.setFirstname("Pratik");
        createPojo.setLastname("Patel");
        createPojo.setTotalprice(2100);
        createPojo.setDepositpaid(true);
        createPojo.setBookingdates(bookingsDatesData);

        createPojo.setAdditionalneeds("Breakfast");

        Response response=given()
                .header("Cookie", "token=2e4c603786fcf0f")
                .header("Content-Type", "application/json")
                .body(createPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
