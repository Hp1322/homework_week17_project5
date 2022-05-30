package com.localhost.servicesinfo;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetIDTest extends TestBase {

    @Test
    public void getId(){
        Response response = given()
                .pathParam("id",6)
                .when()
                .get("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
