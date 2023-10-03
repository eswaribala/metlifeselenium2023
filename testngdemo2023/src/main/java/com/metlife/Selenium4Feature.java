package com.metlife;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    }

    @Test
    public void testScreenshot() throws IOException {
        webDriver.get(baseUrl);
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
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MMMM/YYYY");
        assertTrue(formatter.format(LocalDate.now()).equals(cols.get(0).getText()));
        for(WebElement webElement1:cols){
            System.out.println(webElement1.getText());
        }
    }

    @Test
    public void testOpenTab(){
        webDriver.get("https://www.livechennai.com/gold_silverrate.asp");
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.navigate().to("https://www.canada411.ca/");
    }


    @Test
    public void testObjectLocation(){

        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) webDriver;
        //100%=1, 150%=1.5
        javascriptExecutor.executeScript("document.body.style.zoom='1'");
        webDriver.get("https://www.canada411.ca/");
        webElement=webDriver.findElement(By.xpath("//a[contains(@title,'Find a Business')]"));

        System.out.println(webElement.getRect().x+","+webElement.getRect().y+
                ","+webElement.getRect().getDimension().height+","+webElement.getRect().getDimension().width);

    }


}
