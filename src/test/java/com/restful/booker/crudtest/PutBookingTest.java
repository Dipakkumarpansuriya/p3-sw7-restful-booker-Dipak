package com.restful.booker.crudtest;


import com.restful.booker.model.UpdatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutBookingTest extends TestBase {

    @Test
    public void updateBookingData() {
        UpdatePojo updatePojo = new UpdatePojo();
        updatePojo.setFirstname("Naresh");
        updatePojo.setLastname("patel");
        updatePojo.setTotalprice(800);
        updatePojo.setDepositpaid(false);
        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2023-12-30");
        bookingsDatesData.put("checkout", "2024-01-05");
        updatePojo.setBookingdates(bookingsDatesData);
        updatePojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Cookie", "token=740dba78658cc41")
                .header("Content-Type", "application/json")
                .pathParam("id", "2650")
                .body(updatePojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
