package com.localhost.servicesinfo;

import com.localhost.model.ServicesPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {

    @Test
    public void createService(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Rock");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post("/services");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
