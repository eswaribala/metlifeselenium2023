package com.metlife;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Selenium4Feature {

    private WebDriver webDriver;
    private WebElement webElement;
    private File srcFile,destFile;
    private String baseUrl;

    @BeforeClass
    public void setup(){
        baseUrl="https://demo.guru99.com/test/newtours/index.php";
        webDriver=new ChromeDriver();
        webDriver.get(baseUrl);
    }

    @Test
    public void testScreenshot() throws IOException {
        webElement=webDriver.findElement (By.xpath("//img[contains(@src,'images/featured_destination.gif')]"));
        srcFile= webElement.getScreenshotAs(OutputType.FILE);
        destFile=new File("images","ariba.jpg");
        FileUtils.copyFile(srcFile,destFile);

    }

    @Test
    public void testOrXpath(){

        webElement=webDriver.findElement(By.xpath("//*[@href='index.php' or @type='text']"));
        String name=webElement.getTagName();
        System.out.println(name);
        assertTrue(name.equals("a"));


    }

    @Test

    public void testXpathStartsWith(){

        webDriver.get("https://demo.guru99.com/telecom/addcustomer.php");
        webElement=webDriver.findElement(By.xpath("//label[starts-with(@id,'message')]"));
        assertTrue(webElement.getAttribute("id").contains("message"));

    }

    @Test
    public void testXpathTable(){
        webDriver.get("https://www.livechennai.com/gold_silverrate.asp");

        List<WebElement> cols=webDriver.findElements(By.xpath("//*/div[2]/table[@class='table-price']/tbody/tr[3]/td"));

        System.out.println(cols.size());

        for(WebElement webElement1:cols){
            System.out.println(webElement1.getText());
        }
    }





}
