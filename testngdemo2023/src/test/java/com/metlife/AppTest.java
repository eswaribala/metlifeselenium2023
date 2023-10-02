package com.metlife;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class AppTest
{


    private WebDriver webDriver;
    private String baseUrl;

    @BeforeClass
    public void browserSetup(){

        webDriver=new ChromeDriver();
        baseUrl="https://www.travelsupermarket.com";

    }

    @Test
    public void testTitle(){

        webDriver.get(baseUrl);
        assertEquals("Compare Travel Deals | TravelSupermarket",webDriver.getTitle());

    }




}
