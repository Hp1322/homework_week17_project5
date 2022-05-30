package com.localhost.utilities;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetVersionTest extends TestBase {

    @Test
    public void getVersion(){
        Response response = given()
                .when()
                .get("/version");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
