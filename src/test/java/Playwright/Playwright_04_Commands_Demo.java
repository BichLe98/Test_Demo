package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Proxy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class Playwright_04_Commands_Demo {
    WebDriver driver;
    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @BeforeClass
    public void beforeClass() {
        playwright = Playwright.create(); // Ko có tham số (parameter/ param)

       browserType = playwright.chromium();
        System.out.println("Chrome Path = " + browserType.executablePath());
       System.out.println("Browser Engine = " + browserType.name());

        browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setSlowMo(500).setHeadless(false));




        page = browser.newPage();

    }

    @Test
    public void TC_01_() {
        page.navigate("https://www.facebook.com/");

    }


    @AfterClass
    public void afterClass(){
        browser.close();
        playwright.close();
    }
}
