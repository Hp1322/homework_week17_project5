package com.localhost.categories;

import com.localhost.model.CategoriesPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void createCategories(){

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Bosses");
        categoriesPojo.setId("1212");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .pathParam("id",1212)
                .when()
                .patch("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }

}
