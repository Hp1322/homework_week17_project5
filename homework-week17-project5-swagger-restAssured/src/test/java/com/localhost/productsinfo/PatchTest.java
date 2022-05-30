package com.localhost.productsinfo;

import com.localhost.model.ProductsPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void upadteProduct(){

        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("raja");
        productsPojo.setType("alpha");
        productsPojo.setPrice(100);
        productsPojo.setShipping(200);
        productsPojo.setUpc("abc");
        productsPojo.setDescription("xyz");
        productsPojo.setManufacturer("pqr");
        productsPojo.setModel("Tesla");
        productsPojo.setUrl("www.google.com");
        productsPojo.setImage("123");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productsPojo)
                .pathParam("id",48530)
                .when()
                .patch("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
