package com.metlife;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class NetBankingApp
{
    private WebDriver webDriver;
    @BeforeClass
    public void setup(){
        webDriver=new ChromeDriver();

    }
    @Test
    public void testRediff()  {

        webDriver.get("https://rediffmail.com");
        //Thread.sleep(2000);
        webDriver.quit();
    }
}
