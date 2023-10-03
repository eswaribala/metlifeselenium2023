package com.metlife;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */

//run from run button on the top
@Test
public class App 
{


    @DataProvider
    public Object[][] data() {
        return new String[][]{new String[]{"data1"}, new String[]{"data2"}};
    }
    @Test(dataProvider = "data")
    public void test(String d) {
        Assert.assertEquals("First Line\nSecond Line", "First Line\nSecond Line");
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

}
