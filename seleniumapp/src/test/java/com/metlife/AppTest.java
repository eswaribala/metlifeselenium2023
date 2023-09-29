package com.metlife;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
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



    @AfterAll
    public static void tearDown(){
        webDriver.close();
    }


}
