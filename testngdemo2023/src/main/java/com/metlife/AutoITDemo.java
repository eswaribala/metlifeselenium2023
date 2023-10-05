package com.metlife;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.ilovepdf.com/pdf_to_word");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("a[id='pickfiles']")).click();
        Thread.sleep(3000);
        //autoit exe software for selecting file
        Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\uploadv113.exe");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span[id='processTaskTextBtn']")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(230));
        //its wait till page is totally loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id='pickfiles']")));

        driver.findElement(By.cssSelector("a[id='pickfiles']")).click();
        Thread.sleep(5000);
        File f=new File("/visit.docx");
        if(f.exists())
        {
            Assert.assertTrue(f.exists());
            // if(f.delete())
            //   System.out.println("file deleted");
        }



    }


    @Test
    public void testUploadFile(){
        String baseUrl = "https://demo.guru99.com/test/upload/";
        WebDriver driver = new EdgeDriver();

        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("I:\\metlifews\\testngdemo\\pom.xml");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
    }


    @Test
    public void testDownloadOptions(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://localhost:63343/hsbcuitraining2023/bankapp/Download.html");
        WebElement webElement=driver.findElement(By.xpath("//a"));
        webElement.click();
        Alert alert = driver.switchTo().alert();
        // for clicking on ok button
       // alert.accept();
        // for clicking on cancel button
        alert.dismiss();
        // for getting alert text message
        //   alert.getText();
        // for sending some text inside the alert
        //  alert.sendKeys("alert string");
    }

    @Test
    public void testNormalizeSpace(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
        //webDriver.findElement(By.xpath("//*[@id=\"check2\"]")).click();
        webDriver.findElement(By.xpath("//*[normalize-space(text()='France')]")).click();
    }


    @Test
    public void testMouseHover(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/automation-demos");
        System.out.println("demoqa webpage Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Adding wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement hoverElement1 = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div/div[2]/div/div/div[1]/div[4]/button"));
        WebElement hoverElement2 = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div/div[2]/div/div/div[1]/div[4]/div/div[1]/div/div[1]/div/div[1]/ul/li[2]/a/div[2]/h3"));

        //Mouse hover menuOption 'Music'
        actions.moveToElement(hoverElement1).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.moveToElement(hoverElement2).perform();
        System.out.println("Done Mouse hover on Button");



    }

    @Test
    public void testDataFromExcel() throws IOException {

        File file=new File("I:\\metlifews\\Canada411Input.xlsx");
        FileInputStream fileInputStream=new FileInputStream(file);
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        Iterator<Row> itr=  sheet.iterator();
        Row row=null;
        Cell cell=null;
        Iterator<Cell> cellIterator=null;
        while(itr.hasNext()){
            row= itr.next();
            cellIterator=row.iterator();
            while(cellIterator.hasNext()){
                cell= cellIterator.next();
                if(cell.getCellType().equals(CellType.STRING)){
                    System.out.println(cell.getStringCellValue());
                }
            }

        }





    }







}
