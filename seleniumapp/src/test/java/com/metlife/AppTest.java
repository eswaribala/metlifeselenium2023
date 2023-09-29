package com.metlife;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    private static WebDriver webDriver;
    private WebElement webElement;
    private static String url="https://www.python.org/";

    @BeforeAll
    public static void setup(){
        webDriver=new ChromeDriver();
    }

    //to open the browser

    @Test
    public void openBrowser(){
        webDriver.get(url);
    }

    @Test
    public void testSiteById(){
        webElement=webDriver.findElement(By.id("id-search-field"));
        assertEquals("input",webElement.getTagName());
    }



    @AfterAll
    public static void tearDown(){
        webDriver.close();
    }


}
