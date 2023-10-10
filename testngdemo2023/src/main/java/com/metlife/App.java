package com.metlife;


import com.metlife.dao.AppDao;
import com.metlife.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

import static org.testng.AssertJUnit.assertEquals;


public class App
{


    private WebDriver webDriver;
    private String baseUrl;

    @BeforeClass
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        //options.addArguments("--headless");
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");

        webDriver=new ChromeDriver(options);
        baseUrl="https://www.travelsupermarket.com";

    }

   @Test
    public void testTitle(){

      webDriver.get(baseUrl);
       assertEquals("Compare Travel Deals | TravelSupermarket",webDriver.getTitle());

    }


    @Test(dataProvider = "userData")
    public void testLoginForm(User user)  {

        webDriver.get("https://demo.guru99.com/test/newtours/index.php");
        webDriver.findElement(By.xpath("//input[@name='userName']")).sendKeys(user.getUserName());
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(user.getPassword());
        webDriver.findElement(By.xpath("//input[@name='submit']")).click();
        //explicit wait
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Enter your userName and password correct')]")));
       System.out.println(webElement.getText());
       assertEquals("Enter your userName and password correct",  webElement.getText());

    }



   @DataProvider(name = "userData")
    public Object[][] fetchData(){
        List<User> users=AppDao.generateUsers();
        Object[][] objArray=new Object[users.size()][];
       for(int i=0;i<users.size();i++){
          objArray[i]=new Object[1];
          objArray[i][0]=users.get(i);       }
       return objArray;

    }

    @DataProvider(name = "userData12")
    public Iterator<User> fetchData12(){

        return AppDao.generateUsers().iterator();

    }

}
