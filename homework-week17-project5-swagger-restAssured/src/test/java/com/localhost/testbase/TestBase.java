package com.localhost.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Harsh Patel
 */
public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
    }
}
