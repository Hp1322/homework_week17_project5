package com.localhost.categories;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTest extends TestBase {

    @Test
    public void getAllCategories(){
        Response response = given()
                .when()
                .get("/categories");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
