package com.localhost.storesinfo;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetTest extends TestBase {

    @Test
    public void getAllStores() {
        Response response = given()
                .when()
                .get("/stores");
      //  response.prettyPrint();
        response.then().statusCode(200);

        //1. Extract the limit
        int limit = response.then().extract().path("limit");
        System.out.println("1.Extract the limit                 : "+limit);

        //2. Extract the total
        int total = response.then().extract().path("total");
        System.out.println("2.Extract the total                 : "+total);

        //3. Extract the name of 5 store
        String name5 = response.then().extract().path("data[4].name");
        System.out.println("3.Name of 5th store                 : "+name5);

        //4. Extract the names of all the store
        List<?> allName = response.then().extract().path("data.name");
        System.out.println("4.All Name of store                 : "+allName);

        //5. Extract the storeId of all the store
        List<?> allId = response.then().extract().path("data.id");
        System.out.println("5.All id of store                   : "+allId);

        //6. Print the size of the data list
        List<?> sizeOfData = response.then().extract().path("data");
        System.out.println("6.Size of Data                      : "+sizeOfData.size());

        //7. Get all the value of the store where store name = St Cloud
        List<HashMap<String, ?>> values = response.then().extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("7.All value of store                : "+values);

        //8. Get the address of the store where store name = Rochester
        List<?> address = response.then().extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("8.Address of rochester              : "+address);

        //9. Get all the services of 8th store
        List<HashMap<?, ?>> services = response.then().extract().path("data[7].services");
        System.out.println("9.Services of 8th store             : "+services);

        //10. Get storeservices of the store where service name = Windows Store
        List<?> storeServices = response.then().extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");
        System.out.println("10.Store service of Windows store   : "+storeServices);

        //11. Get all the storeId of all the store
        List<?> allStoreId = response.then().extract().path("data.services.storeservices.storeId");
        System.out.println("11.Store id of store                : "+allStoreId);

        //12. Get id of all the store
        List<?> allIdStore = response.then().extract().path("data.id");
        System.out.println("12.All id of store                  : "+allIdStore);

        //13. Find the store names Where state = ND
        List<?> storeNameND = response.then().extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("13.Store Name                       : "+storeNameND);

        //14. Find the Total number of services for the store where store name = Rochester
        List<?> servicesOfRochester = response.then().extract().path("data.findAll{it.name=='Rochester'}.services");
        System.out.println("14.Rochester store services         : "+servicesOfRochester);

        //15. Find the createdAt for all services whose name = “Windows Store”
        List<?> createdAt = response.then().extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.createdAt");
        System.out.println("15.Windows Store createdAt          : "+createdAt);

        //16. Find the name of all services Where store name = “Fargo”
        List<?> fargoName = response.then().extract().path("data.findAll{it.name=='Fargo'}.services");
        System.out.println("16.All services of fargo store      : "+fargoName);

        //17. Find the zip of all the store
        List<?> zip = response.then().extract().path("data.zip");
        System.out.println("17.All zip of all the store         : "+zip);

        //18. Find the zip of store name = Roseville
        List<?> rosevilleZip = response.then().extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("18.Zip of Roseville                 : "+rosevilleZip);

        //19. Find the storeservices details of the service name = Magnolia Home Theater
        List<HashMap<?, ?>> servicesOfTheater = response.then().extract().path("data.find{it.services}.services.findAll{it.name=='Magnolia Home Theater'}.storeservices");
        System.out.println("19.All Services Of Theater          : "+servicesOfTheater);

        //20. Find the lat of all the stores
        List<?> lat = response.then().extract().path("data.lat");
        System.out.println("20.All lat of all the store         : "+lat);

    }
}
