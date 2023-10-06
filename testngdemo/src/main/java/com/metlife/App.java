package com.metlife;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.testng.Assert.assertEquals;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */

//run from run button on the top
@Test
public class App 
{

    private WebDriver webDriver;
   @BeforeClass
    public void setup(){
       webDriver=new ChromeDriver();
    }


    @DataProvider
    public Object[][] data() {
        return new String[][]{new String[]{"data1"}, new String[]{"data2"}};
    }
    @Test(dataProvider = "data")
    public void test(String d) {
        assertEquals("First Line\nSecond Line", "First Line\nSecond Line");
    }
    //Instantiate the browser driver (e.g., ChromeDriver)



    @Test
    public void testDropDownAllowsMultipleSelection () {

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://autopract.com/selenium/dropdown4/");
        driver.manage().window().maximize();
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Maldives')]")).click();
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        String baseURL = "https://demo.guru99.com/test/newtours/register.php";

        driver.get(baseURL);

        Select drpCountry = new Select(driver.findElement(By.name("country")));
        drpCountry.selectByVisibleText("ANTARCTICA");

        //Selecting Items in a Multiple SELECT elements
        driver.get("http://jsbin.com/osebed/2");
        Select fruits = new Select(driver.findElement(By.id("fruits")));
        fruits.selectByVisibleText("Banana");
        fruits.selectByIndex(1);

    }

   @Test
    public void testAllDropDown(){
        //Creating instance of Chrome driver
        WebDriver driver = new ChromeDriver();

        //Step#2- Launching URL
        driver.get("https://demoqa.com/select-menu");

        //Maximizing window
        driver.manage().window().maximize();

        //Step#3- Selecting the dropdown element by locating its id
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));

        //Step#4- Printing the options of the dropdown
        //Get list of web elements
        List<WebElement> lst = select.getOptions();

        //Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for(WebElement options: lst)
            System.out.println(options.getText());

        //Step#5- Selecting the option as 'Purple'-- selectByIndex
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Step#6- Selecting the option as 'Magenta'-- selectByVisibleText
        System.out.println("Select the Option by Text Magenta");
        select.selectByVisibleText("Magenta");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Step#7- Selecting an option by its value
        System.out.println("Select the Option by value 6");
        select.selectByValue("6");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

    }

    @Test
    public void testCheckBox(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));

        //Radio Button1 is selected
        radio1.click();
        System.out.println("Radio Button Option 1 Selected");

        //Radio Button1 is de-selected and Radio Button2 is selected
        radio2.click();
        System.out.println("Radio Button Option 2 Selected");

        // Selecting CheckBox
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));

        // This will Toggle the Check box
        option1.click();

        // Check whether the Check box is toggled on
        if (option1.isSelected()) {
            System.out.println("Checkbox is Toggled On");

        } else {
            System.out.println("Checkbox is Toggled Off");
        }



        //Selecting Checkbox and using isSelected Method
        driver.get("https://demo.guru99.com/test/facebook.html");
        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));
        for (int i=0; i<2; i++) {
            chkFBPersist.click ();
            System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());
        }


    }


    @Test
    public void testImplicitWait(){
        WebDriver driver = new ChromeDriver();
        //selenium4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String eTitle = "Demo Guru99 Page";
        String aTitle = "" ;
        // launch Chrome and redirect it to the Base URL
        driver.get("http://demo.guru99.com/test/guru99home/" );
        //Maximizes the browser window
        driver.manage().window().maximize() ;
        //get the actual value of the title
        aTitle = driver.getTitle();
        //compare the actual title with the expected title
        if (aTitle.equals(eTitle))
        {
            System.out.println( "Test Passed") ;
        }
        else {
            System.out.println( "Test Failed" );
        }
    }
    @Test
    public void testExplicitWait(){
       WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium-tutorial.com/courses");
        //selenium4
        WebElement elem1 =new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.linkText("LIFETIME MEMBERSHIP TO ALL LIVE TRAININGS")));
        System.out.println(elem1.getText());

        elem1.click();
    }
    @Test
    public void testFluentWait(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium-tutorial.com/courses");
        //selenium4
       Wait<WebDriver> fw= new FluentWait<WebDriver>(driver)
       .withTimeout(Duration.ofSeconds(1))
       .pollingEvery(Duration.ofSeconds(1))
               .ignoring(NoSuchElementException.class);
       fw.until(ExpectedConditions.elementToBeClickable(By.linkText("LIFETIME MEMBERSHIP TO ALL LIVE TRAININGS"))).click();;
       fw.until(ExpectedConditions.urlContains("lifetime-membership-club"));
    }

    @Test
    public void testNewLocators(){
        WebDriver driver = new ChromeDriver();

        //Launch a web browser and navigate to https://www.softwaretestingmaterial.com/
        driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");

        //Locate the web element 'Your Name' text field
        WebElement yourNameLabel = driver.findElement(By.xpath("//input[@name='firstname']"));

        //Locate the web element 'Your Email' text field
        WebElement yourEmailLabel = driver.findElement(By.xpath("//input[@name='lastname']"));

                //Locate 'Your Email' text field which is to the left of 'Your Name' text field and enter the text
                WebElement txtEmailLabel = driver.findElement(with(By.tagName("input")).toLeftOf(yourNameLabel));
        txtEmailLabel.sendKeys("email@email.com");

        //Locate 'Your Name' text field which is to the right of 'Your Email' text field and enter the text
        WebElement txtNameLabel = driver.findElement(with(By.tagName("input")).toRightOf(yourEmailLabel));
        txtNameLabel.sendKeys("YourName");

        //Locate the web element 'Selenium Tutorial' and open it
       // WebElement seleniumTutorial = driver.findElement(with(By.tagName("input")).below(subject));
       /// seleniumTutorial.click();

        //Locate the web element 'Java Tutorial' and open it
      //  WebElement javaTutorial = driver.findElement(with(By.tagName("input")).above(subject));
       // javaTutorial.click();
    }


    @Test
    public void testScreenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        WebElement logo=driver.findElement (By.xpath("//img[contains(@src,'images/featured_destination.gif')]"));
                File file=logo.getScreenshotAs(OutputType.FILE);
        File destFile =new File("logo.png");
        FileUtils.copyFile(file,destFile);
    }

    @Test
    public void testTab(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.crmpro.com/");
    }
    @Test
    public void testWindow(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.crmpro.com/");
    }
    @Test
    public void testObjectLocation() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        WebElement logo=driver.findElement (By.xpath("//img[contains(@src,'images/featured_destination.gif')]"));
        System.out.println("Height:" +logo.getRect().getDimension().getHeight());
        System.out.println("Height:" +logo.getRect().getDimension().getWidth());
        System.out.println("X Location: " +logo.getRect().getX());
        System.out.println("Y Location: " +logo.getRect().getY());
    }


    @Test
    public void testDynamicData() throws MalformedURLException {
        String baseUrl = "https://www.doordash.com/en-US";

        ChromeOptions options = new ChromeOptions();
       // options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        //options.addArguments("--headless");
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        WebDriver webDriver = new ChromeDriver( options);
        webDriver.manage().window().maximize();
        webDriver.get(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> iframeElements = webDriver.findElements(By.tagName("iframe"));
        System.out.println("Total number of iframes are " + iframeElements.size());
        webDriver.switchTo().frame(0);
        //webDriver.findElement(By.xpath("//*[@id='challenge-stage']/div/label/input")).click();
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get(baseUrl);
       javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight,)");

    }

    @Test
    public void dynamicDatav1(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.bloomberg.com/markets/currencies");
        List<WebElement> greenWebElementList = webDriver.findElements(By.xpath("//*[@data-type=\"better\"]"));
        List<WebElement> redWebElementList = webDriver.findElements(By.xpath("//*[@data-type=\"worse\"]"));

        for (WebElement greenWebElement : greenWebElementList) {
            String greenCellText = greenWebElement.getText();
            System.out.println("greenCellText: " + greenCellText);
            boolean isPositive = greenCellText.startsWith("+") || greenCellText.startsWith("0");
            Assert.assertTrue(isPositive, "green cell text: " + greenCellText);
        }

        for (WebElement redWebElement : redWebElementList) {
            String redCellText = redWebElement.getText();
            System.out.println("redCellText: " + redCellText);
            boolean isNegative = redCellText.startsWith("-");
            Assert.assertTrue(isNegative, "red cell text: " + redCellText);
        }
    }


    @Test
    public void testAjax(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://demos.telerik.com/aspnet-ajax/ajax/examples/loadingpanel/explicitshowhide/defaultcs.aspx");
        /*Wait for grid to appear*/
        By container = By.cssSelector(".demo-container");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(container));

        /*Get the text before performing an ajax call*/
        WebElement noDatesTextElement = webDriver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
        String textBeforeAjaxCall = noDatesTextElement.getText().trim();

        /*Click on the date*/
        webDriver.findElement(By.linkText("4")).click();

        /*Wait for loader to disappear */
        By loader = By.className("raDiv");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        /*Get the text after ajax call*/
        WebElement selectedDatesTextElement = webDriver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
        wait.until(ExpectedConditions.visibilityOf(selectedDatesTextElement));
        String textAfterAjaxCall = selectedDatesTextElement.getText().trim();

        /*Verify both texts before ajax call and after ajax call text.*/
        Assert.assertNotEquals(textBeforeAjaxCall, textAfterAjaxCall);

        String expectedTextAfterAjaxCall = "Wednesday, October 4, 2023";

        /*Verify expected text with text updated after ajax call*/
        assertEquals(textAfterAjaxCall, expectedTextAfterAjaxCall);
    }

    @Test
    public void testJSExecutorsClick(){

        WebDriver driver=new ChromeDriver();
        Actions action=new Actions(driver);
        driver.get("https://www.facebook.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id='reg_pages_msg']/a"));
        //click
        action.moveToElement(element).click();


    }
    @Test
    public void testJSExecutorsDragDrop(){

        WebDriver driver=new ChromeDriver();
        Actions action=new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/droppable/");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        action.dragAndDrop(source, target).perform();

    }

    @Test
    public void testJSExecutorsClickAndHold(){

        WebDriver driver=new ChromeDriver();
        Actions actions=new Actions(driver);
        String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
        driver.get(url);
// Locate the element C by By.xpath.
        WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']"));

// Move the cursor to the position of element C.
        actions.moveToElement(titleC); // Call clickAndHold() method to perform click and hold operation.
        actions.clickAndHold().perform();

    }

    @Test
    public void testKeysUp(){
        WebDriver driver=new ChromeDriver();
        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");

        //Create object of the Actions class
        Actions actions = new Actions(driver);


        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");


        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));

        currentAddress.sendKeys("43 School Lane London EC71 9GO");


        // Select the Current Address using CTRL + A
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        // Copy the Current Address using CTRL + C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB);
        actions.build().perform();

        //Paste the Address in the Permanent Address field using CTRL + V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();


        //Compare Text of current Address and Permanent Address
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));


    }

    @Test
    public void alertWindow() throws Exception{

        WebDriver driver = new ChromeDriver();
        driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
        driver.findElement(By.xpath("//*[@id='content']/button")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String print = alert.getText();
        System.out.println(print);
        alert.accept();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='content']/button")).click();
        Thread.sleep(3000);
        alert.dismiss();
        driver.close();
    }

    @Test
    public void testPopup(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //this is js alerts

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Alert alerts1 = driver.switchTo().alert();

        System.out.println(alerts1.getText());

        alerts1.accept();

        if(driver.getPageSource().contains("sucessfully clicked an alert"))

            System.out.println("sucessfully clicked an alert");


        //this is js confirm

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        Alert alerts2 = driver.switchTo().alert();

        System.out.println(alerts2.getText());

        alerts2.dismiss();

        if(driver.getPageSource().contains("you clicked: Cancel"))

            System.out.println("you clicked: Cancel");


        //js Prompt

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert alerts3 = driver.switchTo().alert();

        System.out.println(alerts3.getText());

        alerts2.sendKeys("this is selenium 4");

        alerts3.accept();

        if(driver.getPageSource().contains("you entered: this is selenium 4"))

            System.out.println("you entered: this is selenium 4");
    }

    @Test
    public void testPlayVideo() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.w3.org/2010/05/video/mediaevents.html");
        WebElement video = driver.findElement(By.tagName("video"));
        video.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].play();", video);
        Thread.sleep(5000);
        js.executeScript("arguments[0].pause();", video);

    }

   @Test
    public void handleMultipleWindows(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.get("https://demoqa.com/browser-windows");
       // Opening all the child window
       driver.findElement(By.id("windowButton")).click();
       driver.findElement(By.id("messageWindowButton")).click();

       String MainWindow = driver.getWindowHandle();
       System.out.println("Main window handle is " + MainWindow);

       // To handle all new opened window
       Set<String> s1 = driver.getWindowHandles();
       System.out.println("Child window handle is" + s1);
       Iterator<String> i1 = s1.iterator();

       // Here we will check if child window has other child windows and when child window
       //is the main window it will come out of loop.
       while (i1.hasNext()) {
           String ChildWindow = i1.next();
           if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
               driver.switchTo().window(ChildWindow);
               driver.close();
               System.out.println("Child window closed");
           }
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
   public void testFileUploadAutoIT() throws IOException, InterruptedException {

       WebDriver driver=new EdgeDriver();
       driver.get("https://www.ilovepdf.com/pdf_to_word");
       driver.manage().window().maximize();
       driver.findElement(By.cssSelector("a[id='pickfiles']")).click();
       Thread.sleep(3000);
       //To call the AutoIt script
       Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\uploadv5.exe");
       driver.close();



   }

    @Test
    public void testFileDownloadAutoIT() throws IOException, InterruptedException {


        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        // Set ChromePref and pass the download folder path with key

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.ilovepdf.com/pdf_to_word");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("a[id='pickfiles']")).click();
        Thread.sleep(3000);
        //autoit exe software for selecting file
        Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\uploadv5.exe");

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
    public void testMultipleUploadFileV2() throws IOException, InterruptedException {



            WebDriver driver=new EdgeDriver();

            driver.get("http://demo.automationtesting.in/Register.html");

            WebElement button=driver.findElement(By.xpath("//*[@id='imagesrc']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        Thread.sleep(3000);

        //round1- first file
        executor.executeScript("arguments[0].click();", button);
        Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\uploadv7.exe"+" "+ "D:\\pictures\\axis.png");

        Thread.sleep(5000);

        //round2-  second file
        executor.executeScript("arguments[0].click();", button);
        Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\uploadv7.exe"+" "+ "D:\\pictures\\butterfly.jpg");

        Thread.sleep(5000);

        //round3-  third file file
        executor.executeScript("arguments[0].click();", button);
        Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\uploadv7.exe"+" "+ "D:\\pictures\\bus.jpg");
        Thread.sleep(5000);
    }

    @Test
    public void testPopupV1(){
        // Open browser

        webDriver.get("https://secure.indeed.com/account/login");
        //implicit wait
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait webDriverWait=new WebDriverWait(webDriver,Duration.ofSeconds(10));

        webDriver.findElement(By.id("login-google-button")).click();
        // window handles
        Set w = webDriver.getWindowHandles();

        webDriverWait.until(numberOfWindowsToBe(w.size()));

        // window handles iterate
        Iterator t = w.iterator();
        String ch = (String) t.next();
        String pw = (String) t.next();
        webDriver.switchTo().window(pw);
        System.out.println("Parent window title: "+ webDriver.getTitle());
        // switching child window
        webDriver.switchTo().window(pw).close();
        webDriver.switchTo().window(ch);
        //webDriverWait.until(numberOfWindowsToBe(2));

       System.out.println("Child window title "+ webDriver.getTitle());
        // close the child browser window
       webDriver.close();
        // switching parent window
      //  webDriver.switchTo().window(pw);
        //System.out.println("Parent window title: "+ webDriver.getTitle());
        webDriver.quit();
        }

        @Test
        public void testDownloadOptions(){
            WebDriver driver=new ChromeDriver();
            driver.get("http://localhost:63343/hsbcuitraining2023/bankapp/Download.html");
            WebElement webElement=driver.findElement(By.xpath("//a"));
            webElement.click();
            Alert alert = driver.switchTo().alert();
            // for clicking on ok button
            alert.accept();
            // for clicking on cancel button
            //alert.dismiss();
            // for getting alert text message
         //   alert.getText();
            // for sending some text inside the alert
          //  alert.sendKeys("alert string");
        }
        @Test
        public void testMouseHover() throws InterruptedException {
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
            WebElement hoverElement1 = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div/div[2]/div/div/div[1]/div[3]/button"));
            WebElement hoverElement2 = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/div[1]/div/div[1]/ul/li[3]/a/div[2]/h3"));

            //Mouse hover menuOption 'Music'
            actions.moveToElement(hoverElement1).perform();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            actions.moveToElement(hoverElement2).perform();
            System.out.println("Done Mouse hover on Button");


        }

    @Test
    public void testDataFromExcel() throws IOException {

        File file = new File("I:\\metlifews\\Canada411Input.xls");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("TestSheet-1");
        Iterator<Row> itr = sheet.iterator();
        Row row = null;
        Cell cell = null;
        Iterator<Cell> cellIterator = null;
        itr.next();
        List<String> phoneNumbers=new ArrayList<>();
        while (itr.hasNext()) {
            row = itr.next();
            cellIterator = row.iterator();
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                if (cell.getCellType().equals(CellType.STRING)) {
                    System.out.println(cell.getStringCellValue());
                    phoneNumbers.add(cell.getStringCellValue());
                }
            }
        }
        webDriver.close();
        webDriver=new ChromeDriver();
        WebElement webElement=null;
        for(String phoneNumber:phoneNumbers) {
            webDriver.get("https://www.canada411.ca/");
            webDriver.findElement(By.xpath("//input[@id='c411PeopleReverseWhat']")).sendKeys(phoneNumber);
            webDriver.findElement(By.xpath("//input[@id='c411PeopleReverseFind']")).click();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

            if(!webDriver.findElements(By.xpath("//*[@id=\"ypgBody\"]/div[3]/div/div[1]/div[2]/div[1]/div[1]/h1/span")).isEmpty()) {
               webElement=webDriver.findElement(By.xpath("//*[@id=\"ypgBody\"]/div[3]/div/div[1]/div[2]/div[1]/div[1]/h1/span"));
                   System.out.println(webElement.getText());
           }
        }
       webDriver.quit();
    }


    @Test
    public void writeDataToExcel() throws Exception {
        Workbook workbook = new XSSFWorkbook();

//Create a blank sheet

       Sheet sheet = workbook.createSheet("Users Data");

//Prepare data to be written as an Object[]


        Map<String, String> data = new TreeMap<String,String>();
        data.put("user1", Base64.getUrlEncoder().encodeToString("Password@1".getBytes()));
        data.put("user2", Base64.getUrlEncoder().encodeToString("Password@2".getBytes()));
        data.put("user3", Base64.getUrlEncoder().encodeToString("Password@3".getBytes()));
        data.put("user4", Base64.getUrlEncoder().encodeToString("Password@4".getBytes()));

//Iterate over data and write to sheet

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);
            String value = data.get(key);
            int cellnum = 0;
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(key);
            cell = row.createCell(cellnum++);
            cell.setCellValue(String.valueOf(value));


        }

//Write the workbook in file system

        try {
            FileOutputStream out = new FileOutputStream(new File("users.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("users.xlsx written successfully on disk.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readDecryptedData() throws Exception {

        File file = new File("I:\\metlifews\\testngdemo\\users.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("Users Data");
        Iterator<Row> itr = sheet.iterator();
        Row row = null;
        Cell cell = null;
        Iterator<Cell> cellIterator = null;
        HashMap<String,String> users=new HashMap<String,String>();
        String key=null;
        String value=null;
        while (itr.hasNext()) {
            row = itr.next();
            cellIterator = row.iterator();
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                if (cell.getCellType().equals(CellType.STRING)) {
                    key=cell.getStringCellValue();
                    cell = cellIterator.next();
                    value=cell.getStringCellValue();
                    users.put(key,value);
                }
            }
        }

        Set<Map.Entry<String,String>> set=users.entrySet();
        Iterator<Map.Entry<String,String>> itrUsers= set.iterator();
        Map.Entry<String,String> entry=null;
        String decryptedData=null;
        while(itrUsers.hasNext()){
            entry= itrUsers.next();
            decryptedData= new String(Base64.getUrlDecoder().decode(entry.getValue()));
            System.out.println(entry.getKey()+","+decryptedData);
        }

    }

    @Test

    public void testReadPDFTable() throws IOException {
        //Load a sample PDF document
        PdfDocument pdf = new PdfDocument("I:\\metlifews\\data.pdf");

        //Create a StringBuilder instance
        StringBuilder builder = new StringBuilder();
        //Create a PdfTableExtractor instance
        PdfTableExtractor extractor = new PdfTableExtractor(pdf);

        //Loop through the pages in the PDF
        for (int pageIndex = 0; pageIndex < pdf.getPages().getCount(); pageIndex++) {
            //Extract tables from the current page into a PdfTable array
            PdfTable[] tableLists = extractor.extractTable(pageIndex);

            //If any tables are found
            if (tableLists != null && tableLists.length > 0) {
                //Loop through the tables in the array
                for (PdfTable table : tableLists) {
                    //Loop through the rows in the current table
                    for (int i = 0; i < table.getRowCount(); i++) {
                        //Loop through the columns in the current table
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            //Extract data from the current table cell and append to the StringBuilder
                            String text = table.getText(i, j);
                            builder.append(text + " | ");
                        }
                        builder.append("\r\n");
                    }
                }
            }
        }

        //Write data into a .txt document
        FileWriter fw = new FileWriter("ExtractTable.txt");
        fw.write(builder.toString());
        fw.flush();
        fw.close();
    }


    @Test
  public void testDesktopPoupWindow() throws IOException {
        Process proc=Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\popup.exe");
        InputStream is = proc.getInputStream();
        int retCode = 0;
        while(retCode != -1)
        {
            retCode = is.read();
        }
        System.out.println("Now Exiting");
  }

    @Test
    public void testIEDownload() throws IOException, InterruptedException {
       webDriver.close();
       webDriver.quit();
        Process proc=Runtime.getRuntime().exec("I:\\metlifews\\autoitws\\ie4.exe");
        InputStream is = proc.getInputStream();
        int retCode = 0;
        while(retCode != -1)
        {
            retCode = is.read();
        }
        System.out.println("Now Exiting");
    }

}
