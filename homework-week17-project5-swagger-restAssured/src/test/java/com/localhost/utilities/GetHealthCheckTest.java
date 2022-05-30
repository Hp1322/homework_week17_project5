package com.localhost.utilities;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetHealthCheckTest extends TestBase {

    @Test
    public void getHealthCheck(){
        Response response = given()
                .when()
                .get("/healthcheck");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
