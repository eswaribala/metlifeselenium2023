package com.metlife;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppiumTestDemo {

    private AppiumDriver appiumDriver;
    @Test
    public void testAndroidApp(){

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554").setAppPackage("com.example.vebdentalcare")
                .setAppActivity("MainActivity")
                // .setUnlockKey("unlockKey")
                .setNoReset(true)
                .eventTimings();

        try {
            appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
            WebElement el1 = (WebElement) appiumDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.TextView"));
            el1.click();
            WebElement el2 = (WebElement) appiumDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.TextView"));
            el2.click();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }




    }
}
