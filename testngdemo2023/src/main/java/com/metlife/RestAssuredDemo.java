package com.metlife;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

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


}
