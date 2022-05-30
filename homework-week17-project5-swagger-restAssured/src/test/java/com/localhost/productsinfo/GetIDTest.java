package com.localhost.productsinfo;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetIDTest extends TestBase {

    @Test
    public void getProductID(){

        Response response = given()
                .pathParam("id",48530)
                .when()
                .get("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
