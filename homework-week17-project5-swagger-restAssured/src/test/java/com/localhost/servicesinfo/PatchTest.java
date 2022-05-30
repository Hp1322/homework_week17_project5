package com.localhost.servicesinfo;

import com.localhost.model.ServicesPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void updateService(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Ck");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .pathParam("id",6)
                .when()
                .patch("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
