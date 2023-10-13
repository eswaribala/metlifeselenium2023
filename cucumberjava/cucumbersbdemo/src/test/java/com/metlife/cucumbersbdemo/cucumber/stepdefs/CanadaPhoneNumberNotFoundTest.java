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

//@CucumberContextConfiguration
public class CanadaPhoneNumberNotFoundTest {

    private WebDriver webDriver;
    private WebElement webElement;

    @Given("Visit www.canada411.ca, Find people Phone number text box, enter non existing phone number")
    public void testVisitWebSite(){
        webDriver=new EdgeDriver();
        webDriver.get("https://www.canada411.ca/");
        webDriver.findElement(By.id("c411PeopleReverseWhat")).sendKeys("647-846-8449");

        }

    @When("Click on the non existing phone number search button")
    public void  testSearchButton(){

        webDriver.findElement(By.id("c411PeopleReverseFind")).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

    }

    @Then("show the address not found")
    public void testAddressExistence(){


        if(!webDriver.findElements(By.xpath("//*[@id=\"ypgBody\"]/div[3]/div/div[1]/div[2]/div[1]/div[1]/h1/span")).isEmpty()){

            System.out.println(webDriver.findElement(By.xpath("//*[@id='ypgBody']/div[3]/div/div[1]/div[2]/div[1]/div[1]/h1/span")).getText());
        }
        else
            System.out.println("Phone Number not existing");
    }


}
