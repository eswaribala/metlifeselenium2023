package com.metlife;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
   private WebElement webElement;
   @BeforeClass
   public void setup(){

       webDriver=new ChromeDriver();
       webDriver.get("https://www.rediffmail.com");

   }

    @Test(retryAnalyzer = com.metlife.listeners.RetryListener.class)
    public void testGoogle() throws InterruptedException {
       webDriver.navigate().to("https://www.rediffmail.com");
       webElement=webDriver.findElement(By.xpath("//*[@id=\"OAS_subsection1\"]"));

       Thread.sleep(1000);
       // webDriver.get("https://www.rediffmail123.com");
        //webDriver.quit();
    }

}
