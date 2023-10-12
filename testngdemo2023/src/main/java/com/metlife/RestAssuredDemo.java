package com.metlife;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.metlife.models.PolicyHolder;

import groovy.xml.slurpersupport.NodeChild;
import io.restassured.http.ContentType;

import io.restassured.internal.path.xml.NodeChildrenImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
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
    public void testAddPolicyHolder() throws JsonProcessingException {

        PolicyHolder policyHolder=new PolicyHolder();
        policyHolder.setPolicyNo(100);
        policyHolder.setFirstName("Parameswari");
        policyHolder.setLastName("Bala");
        policyHolder.setDob(new Date(1900+new Random().nextInt(120),
                1+new Random().nextInt(10),1+new Random().nextInt(25) ));
        policyHolder.setMobileNo(1234567890L);
        String newPolicyHolderXml = new XmlMapper().writeValueAsString(policyHolder);

       String mobileNo= given()
                .body(newPolicyHolderXml)
                .contentType("application/xml")
                .accept(ContentType.XML)
                .when()
                .post("http://localhost:7072/policyholders/v1.0/")
                .then()
                .statusCode(202)
                .extract()
                .path("PolicyHolder.mobileNo");
        Assert.assertTrue(mobileNo.length()==10, "String message");

    }

   @Test
    public void testGetPolicyHolders()  {
       NodeChildrenImpl nodes = given()
               .contentType("application/xml")
                .accept(ContentType.XML)
                .when()
                .get("http://localhost:7072/policyholders/v1.0/")
                .then()
                .statusCode(200)
                .extract()
                .path("List.item.policyNo");

      assertThat(nodes, hasItems("102","100"));


    }



}
