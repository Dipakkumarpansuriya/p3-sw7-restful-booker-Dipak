package com.restful.booker.crudtest;

import com.restful.booker.model.PartialUpdatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchBookingTest extends TestBase {

    @Test
    public void partialUpdateBooking(){

        PartialUpdatePojo partialUpdatePojo=new PartialUpdatePojo();
        partialUpdatePojo.setFirstname("Ramesh");
        partialUpdatePojo.setLastname("Puri");

        Response response = given()
                .header("Cookie", "token=89e67cb52c90658")
                .header("Content-Type", "application/json")
                .pathParam("id", "441")
                .body(partialUpdatePojo)
                .when()
                .patch("/booking/{id}");
         response.then().statusCode(200);
        response.prettyPrint();

    }
}
