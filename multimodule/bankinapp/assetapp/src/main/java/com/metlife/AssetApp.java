package com.metlife;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class AssetApp
{
    private WebDriver webDriver;
    @BeforeClass
    public void setup(){
        webDriver=new ChromeDriver();

    }
    @Test
    public void testPython() {

        webDriver.get("https://www.python.org");
        //Thread.sleep(2000);
        webDriver.quit();
    }
}
