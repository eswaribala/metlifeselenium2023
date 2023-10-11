package com.metlife;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RestAssuredDemo {



    @Test
    public void testRestCountriesStatusCodeToBe200(){

        given().get("https://restcountries.com/v2/all").then().statusCode(200);
    }


}
