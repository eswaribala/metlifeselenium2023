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

public class Selenium4Fetaure {

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
        destFile=new File("ariba.jpg");
        FileUtils.copyFile(srcFile,destFile);


    }



}
