package com.metlife;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class AutoITDemo {

    private WebDriver webDriver;
    private WebElement webElement;
    private WebDriverWait webDriverWait;

    @BeforeClass
    public void setup(){
        webDriver=new ChromeDriver();
    }

   @Test
    public void testCloseBeforeParentBeforeChildWindow(){

        webDriver.get("https://secure.indeed.com/account/login");
        webDriverWait=new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.findElement(By.id("login-google-button")).click();
        Set<String> handles=webDriver.getWindowHandles();
        webDriverWait.until(numberOfWindowsToBe(handles.size()));
        Iterator<String> itr=handles.iterator();
        String pw=itr.next();
        String cw= itr.next();
        webDriver.switchTo().window(pw);
        System.out.println("Parent Window Title"+webDriver.getTitle());
        webDriver.switchTo().window(pw).close();
        webDriver.switchTo().window(cw);
        System.out.println("Child Window Title"+webDriver.getTitle());
        webDriver.switchTo().window(cw).close();


    }

    //test auto it script

    @Test
    public void testFileUploadAutoIT() throws InterruptedException, IOException {

        webDriver.get("https://www.ilovepdf.com/pdf_to_word");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.cssSelector("a[id='pickfiles']")).click();
        Thread.sleep(3000);
        //autoit exe software for selecting file
        Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\uploadv113.exe");

    }



}
