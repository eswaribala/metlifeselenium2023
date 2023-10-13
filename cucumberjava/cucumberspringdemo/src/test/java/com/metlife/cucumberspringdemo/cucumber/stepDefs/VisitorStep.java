package com.metlife.cucumberspringdemo.cucumber.stepDefs;

import com.metlife.cucumberspringdemo.cucumber.CucumberSpringConfiguration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//@CucumberContextConfiguration
public class VisitorStep  {

    private WebDriver webDriver;
    private WebElement webElement;


    @Given("I am on career.guru99.com")
    public void openBrowser(){

        webDriver=new EdgeDriver();
        webDriver.get("http://career.guru99.com");

    }
    @When("I click on career guide menu")
    public void clickOnMenu(){
        webDriver.findElement(By.xpath("//*[@id=\"java_technologies\"]/li[1]/a")).click();

    }

    @Then("I should see career guide page")
    public void gotToCareerGuide(){

        webDriver.navigate().to("https://career.guru99.com/top-50-array-interview-questions-answers/");
    }
}



