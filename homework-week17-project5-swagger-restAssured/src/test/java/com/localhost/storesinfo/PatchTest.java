package com.localhost.storesinfo;

import com.localhost.model.StoresPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void updateStore(){
        HashMap<Object,Object> data = new HashMap<>();
        data.put("ram", "01");
        data.put("jay", "02");

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Den");
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
                .pathParam("id",6)
                .when()
                .patch("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
