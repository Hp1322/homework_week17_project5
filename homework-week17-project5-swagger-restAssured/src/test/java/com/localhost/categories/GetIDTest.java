package com.localhost.categories;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetIDTest extends TestBase {

    @Test
    public void getIDCategories(){

        HashMap<Object, Object> qParams = new HashMap<>();
        qParams.put("id", "abcat0010000");
        qParams.put("limit", 1);

        Response response = given()
                .pathParam("id", 1212)
                .when()
                .get("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
