package com.localhost.storesinfo;

import com.localhost.model.StoresPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {

    @Test
    public void createStore(){
        HashMap<Object,Object> data = new HashMap<>();
        data.put("ram", "01");
        data.put("jay", "02");

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("jay");
        storesPojo.setType("Male");
        storesPojo.setAddress("Harrow");
        storesPojo.setAddress2("Cd12Op13");
        storesPojo.setCity("Rom");
        storesPojo.setState("Milan");
        storesPojo.setZip("100-200");
        storesPojo.setLat(10);
        storesPojo.setLng(11);
        storesPojo.setHours("four");
        storesPojo.setServices(data);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
