package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.Margin;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Playwright_05_Commands_Demo {
    WebDriver driver;
    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @BeforeClass
    public void beforeClass() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome")
                .setHeadless(true).setSlowMo(500));
        page = browser.newPage();

    }

    @Test
    public void TC_01_Command() throws InterruptedException {
        page.navigate("https://live.techpanda.org/index.php/customer/account/create/");

        // page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/desktops.png")).setFullPage(true));

        page.pdf(new Page.PdfOptions().setPath(Paths.get("target/reports/dashboard.pdf"))
                .setFormat("A4")
                .setPrintBackground(true) // giữ màu nền  - nếu không nền bị bỏ trắng
                .setLandscape(false)
                .setMargin(new Margin().setTop("1cm").setBottom("1cm")));

    }

    @AfterClass
    public void afterClass(){
        page.clock();
        browser.close();
        playwright.close();
    }
}
