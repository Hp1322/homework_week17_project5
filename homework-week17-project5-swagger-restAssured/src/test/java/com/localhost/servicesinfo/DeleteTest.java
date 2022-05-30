package com.localhost.servicesinfo;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {

    @Test
    public void deleteServices() {
        Response response = given()
                .pathParam("id", 6)
                .when()
                .delete("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }
}
