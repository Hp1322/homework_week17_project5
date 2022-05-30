package com.localhost.categories;

import com.localhost.model.CategoriesPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {

    @Test
    public void createCategories(){

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Boss");
        categoriesPojo.setId("12125");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.prettyPrint();
        response.then().statusCode(201);

    }

}
