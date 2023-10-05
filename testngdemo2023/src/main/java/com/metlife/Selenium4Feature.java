package com.metlife;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
        EdgeOptions options = new EdgeOptions();
        options.addArguments("force-device-scale-factor=1.75");
        options.addArguments("high-dpi-support=1.75");
        WebDriver webDriver1=new EdgeDriver(options);
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) webDriver1;
        //javascriptExecutor.executeScript("window.scrollTo(0.5, document.body.scrollHeight,)");

        //WebElement html = webDriver1.findElement(By.tagName("html"));
       // html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD)); zoom in
      //  html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT)); //zoom out
        webDriver1.get(baseUrl);
       // webElement=webDriver1.findElement (By.xpath("//img[contains(@src,'images/featured_destination.gif')]"));
        webElement=webDriver1.findElement (By.xpath("//*/table/tbody/tr[4]/td/table/tbody/tr/td[2]"));
        javascriptExecutor.executeScript("window.scrollBy(2000,250)");
        //javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
       // Actions actions = new Actions(webDriver1);
      //  actions.moveToElement(webElement);
       // actions.perform();
        srcFile= webElement.getScreenshotAs(OutputType.FILE);
        destFile=new File("images","ariba1234.jpg");
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


    @Test
    public void testRelativeLocators(){

        webDriver.get("https://demo.guru99.com/V1/index.php");
        webElement=webDriver.findElement(By.xpath("//input[@name='uid']"));
        System.out.println(webElement.getTagName());
        WebElement lblElement = webDriver.findElement(with(By.tagName("td")).toLeftOf(webElement));
        System.out.println(lblElement.getTagName());
    }

    @Test
    public void testDynamicData(){

        webDriver=new FirefoxDriver();
        webDriver.get("https://www.bloomberg.com/markets/currencies");
        List<WebElement> betterElements=webDriver.findElements(By.xpath("//*[@data-type='better']"));
        List<WebElement> worseElements=webDriver.findElements(By.xpath("//*[@data-type='worse']"));
        boolean positive,negative=false;
        for(WebElement element:betterElements){
          System.out.println(element.getText());
          positive=element.getText().startsWith("+")||element.getText().startsWith("0");
          assertTrue(positive, "Positive"+element.getText());
        }

    }


    @Test
    public void testAjaxCall(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        //options.addArguments("--headless");
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        webDriver=new ChromeDriver(options);
        webDriver.get("http://localhost:63343/hsbcuitraining2023/bankapp/showusers.html");
        webElement=webDriver.findElement(By.xpath("//button"));
        webElement.click();
        //selenium4
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
       //read the data from console
       LogEntries logEntries= webDriver.manage().logs().get(LogType.BROWSER);

       List<LogEntry> logEntryList=logEntries.getAll();
       for(LogEntry logEntry:logEntryList){
           System.out.println(logEntry);
       }
        //webElement=webDriver.findElement(By.xpath("//*[@id='output']/p[1]"));
       List<WebElement> webElements=webDriver.findElements(By.cssSelector("p"));
       for(WebElement webElement1 :webElements)
        System.out.println(webElement1.getText());
       assertEquals(10,webElements.size());

    }

    @Test
    public void testDragAndDrop(){

        webDriver=new ChromeDriver();
        Actions actions=new Actions(webDriver);
        webDriver.get("https://jqueryui.com/droppable/");
        WebDriverWait webDriverWait=new WebDriverWait(webDriver,Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));

        WebElement src= webDriver.findElement(By.id("draggable"));
        WebElement dest= webDriver.findElement(By.id("droppable"));

        actions.dragAndDrop(src,dest).perform();




    }

    @Test
    public void testClickAndHold(){

        webDriver=new ChromeDriver();
        webDriver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        Actions actions=new Actions(webDriver);
        webElement=webDriver.findElement(By.xpath("//li[text()='C']"));
        actions.moveToElement(webElement);
        actions.clickAndHold().perform();


    }





}
