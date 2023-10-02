package com.metlife;


import com.metlife.dao.AppDao;
import com.metlife.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class App
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


    @Test(dataProvider = "userData")
    public void testLoginForm(User user){

        webDriver.get("https://demo.guru99.com/test/newtours/");
        webDriver.findElement(By.name("userName")).sendKeys(user.getUserName());
        webDriver.findElement(By.name("password")).sendKeys(user.getPassword());
        webDriver.findElement(By.name("submit")).click();
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


}
