package com.metlife;

import com.metlife.models.PolicyHolder;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {



    @Test
    public void testRestCountriesStatusCodeToBe200(){

        given().get("https://restcountries.com/v2/all").then().statusCode(200);
    }


    @Test
    public void testRestUsersCountTobe10(){

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .assertThat()
                .body("id",hasSize(10));
    }


    @Test
    public void testRestCountriesName(){

        given()
                .when()
                .get("https://restcountries.com/v2/all")
                .then()
                .assertThat()
                .body("[0].name",equalTo("Afghanistan"));
    }


    @Test
    public void testRestCountriesSize(){

        given()
                .when()
                .get("https://restcountries.com/v2/all")
                .then()
                .assertThat()
                .body("size()",greaterThan(100));
    }


    @Test
    public void testAddPolicyHolder(){

        PolicyHolder policyHolder=new PolicyHolder();
        policyHolder.setPolicyNo(101);
        policyHolder.setFirstName("Sanjay");
        policyHolder.setLastName("kumar");
        policyHolder.setDob(new Date(1900+new Random().nextInt(120),
                1+new Random().nextInt(10),1+new Random().nextInt(25) ));
        policyHolder.setMobileNo(12435356667L);

        given()
                .body(policyHolder)
                .contentType("application/xml")
                .when()
                .post("http://localhost:7072/policyholders/v1.0/")
                .then()
                .statusCode(202);

    }





}
