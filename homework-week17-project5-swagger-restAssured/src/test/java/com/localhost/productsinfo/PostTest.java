package com.localhost.productsinfo;

import com.localhost.model.ProductsPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {
    @Test
    public void createProducts(){

        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("ram");
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
                .when()
                .post("/products");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
