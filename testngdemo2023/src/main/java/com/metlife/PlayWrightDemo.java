package com.metlife;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class PlayWrightDemo {

    @Test
    public void pageScreenShot(){
        try (Playwright playwright = Playwright.create()) {
            List<BrowserType> browserTypes = Arrays.asList(
                    playwright.chromium(),
                    playwright.webkit(),
                    playwright.firefox()
            );
            for (BrowserType browserType : browserTypes) {
                try (Browser browser = browserType.launch()) {
                    BrowserContext context = browser.newContext();
                    Page page = context.newPage();
                    page.navigate("https://playwright.dev/");
                    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + browserType.name() + ".png")));
                }
            }
        }
    }

    @Test
    public void testFrame() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType firefox = playwright.firefox();
            Browser browser = firefox.launch();
            Page page = browser.newPage();
            page.navigate("https://www.google.com/chrome/browser/canary.html");
            dumpFrameTree(page.mainFrame(), "");
            browser.close();
        }
    }
    static void dumpFrameTree(Frame frame, String indent) {
        System.out.println(indent + frame.url());
        for (Frame child : frame.childFrames()) {
            dumpFrameTree(child, indent + "  ");
        }
    }
}
