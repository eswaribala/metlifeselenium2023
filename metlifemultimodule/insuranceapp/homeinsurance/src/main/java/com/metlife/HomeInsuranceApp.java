package com.metlife;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class HomeInsuranceApp
{
   private WebDriver webDriver;

   @BeforeClass
   public void setup(){

       webDriver=new ChromeDriver();

   }

    @Test(retryAnalyzer = com.metlife.listeners.RetryListener.class)
    public void testGoogle(){
        webDriver.get("https://www.rediffmail123.com");
        webDriver.quit();
    }

}
