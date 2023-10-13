package com.metlife.cucumbersbdemo.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

@CucumberContextConfiguration
public class CanadaPhoneNumberTest {

    private WebDriver webDriver;
    private WebElement webElement;

    @Given("Visit https://www.canada411.ca/, Find people Phone number text box, enter phone number")
    public void testVisitWebSite(){
        webDriver=new EdgeDriver();
        webDriver.get("https://www.canada411.ca/");
        webDriver.findElement(By.id("c411PeopleReverseWhat")).sendKeys("905-841-0191");

        }

    @When("Click on the search button")
    public void  testSearchButton(){

        webDriver.findElement(By.id("c411PeopleReverseFind")).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

    }

    @Then("If phone number exists show the address")
    public void testAddressExistence(){

        if(!webDriver.findElements(By.xpath("//*[@id=\"ypgBody\"]/div[3]/div/div[1]/div[2]/div[1]/div[1]/h1/span")).isEmpty()){

            System.out.println(webDriver.findElement(By.xpath("//*[@id='ypgBody']/div[3]/div/div[1]/div[2]/div[1]/div[1]/h1/span")).getText());
        }
        else
            System.out.println("Phone Number not existing");
    }


}
