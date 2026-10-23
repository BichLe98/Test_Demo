package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Proxy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.channels.Selector;
import java.nio.file.Path;

public class Playwright_04_Commands_01 {
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
        browserType = playwright.firefox();
        browserType = playwright.webkit();
        playwright.close();

        // Web API testing
        APIRequest apiRequest = playwright.request();
        Selectors selectors = playwright.selectors();

        // Browser Type
        browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));// non-UI
        browserType.launch(new BrowserType.LaunchOptions().setHeadless(false)); // UI
        browserType.launch(new BrowserType.LaunchOptions().setSlowMo(250));
        browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setSlowMo(500).setHeadless(false));

        // Mặc định ko set đường dẫn để download về nó sẽ vào thư mực Download của OS
        String projectPath = System.getProperty("user.dir");
        browserType.launch(new BrowserType.LaunchOptions().setDownloadsPath(Path.of(projectPath + "\\downloadFile")));

        // Trỏ vào nơi chua thư mục đã cài đặt của trình duyệt
        browserType.launch(new BrowserType.LaunchOptions().setExecutablePath(Path.of("")));

        browserType.launch(new BrowserType.LaunchOptions().setProxy(new Proxy("")));

        // Chrome/ Edge: chạy với Profile nào
        browserType.launchPersistentContext(Path.of("C:\\Users\\Administrator\\AppData\\local\\Google\\Chrome\\User Data\\Profile 01"));
        browserType.launchPersistentContext(Path.of("C:\\Users\\Administrator\\AppData\\local\\Google\\Chrome\\User Data\\Profile 02"));



        // Ẩn danh (Incognito)
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false).setSlowMo(50));

        // browserContext = playwright.firefox().launchPersistentContext(Path.of(""));

        page = browser.newPage();
        page.navigate("https://www.facebook.com/");
    }

    @Test
    public void TC_01_() {



    }



    @AfterClass
    public void afterClass(){
        browser.close();
        playwright.close();
    }
}
