package com.localhost.productsinfo;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {

    @Test
    public void deleteProduct(){
        Response response = given()
                .pathParam("id",48530)
                .when()
                .delete("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
