package com.metlife.cucumbersbdemo.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class UploadFile {

    private WebDriver webDriver;
    private WebElement webElement;
    @Given("Visit site demo.guru99.com and check the path test upload")
    public void testVisitDemoSite(){
        webDriver=new EdgeDriver();
        webDriver.get("https://demo.guru99.com/test/upload/");
    }

    @When("click on file upload type send the file")
    public void testSelectingFileToUpload(){

        webElement = webDriver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        webElement.sendKeys("I:\\metlifews\\cucumberjava\\cucumbersbdemo\\pom.xml");

    }

    @Then("Once file selected click upload button")
    public void testClickUploadButton(){

// check the "I accept the terms of service" check box
        webDriver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        webDriver.findElement(By.name("send")).click();
    }

}
