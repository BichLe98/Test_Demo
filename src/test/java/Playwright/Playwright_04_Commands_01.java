package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.Proxy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.channels.Selector;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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

        // Lấy ra đường dẫn cài đặt của trình duyệt
        browserType.executablePath();

        // Cloud testing: BrowserStack/ Soucelab/ Device Farm/LambdaTest
        // EndPoint: GRID URL/ HUB URL
        browserType.connect("");

        // Chrome Dev Tool
        browserType.connectOverCDP("");

        // Browser
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false).setSlowMo(50));
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false).setSlowMo(50).setChannel("nsedge"));

        // Kiểm tra browser có đang hoạt động/ chạy không
        browser.isConnected();

        // Trả về  danh sách browser tab/window đang mở
        browser.contexts();

        // Trả về type của browser
        browser.browserType();
        if(browser.browserType().name().equals("firefox")){
            //Action
        }

        // close browser
        browser.close();

        // Trả về version của browser
        browser.version();
        // 156.0

        // Trả về page để thao tác với element
        browser.newPage();

        // Trả về 1 context thao tác vơi windown/ tab
        // Creates a new browser context. It won't share cookies/cache with other browser contexts.
       browserContext = browser.newContext();

       // Launches browser that uses persistent storage located at userDataDir and returns the only context.
        // Closing this context will automatically close the browser.
       browserContext = playwright.firefox().launchPersistentContext(Path.of(""));

        // Browser Context
        browserContext = browser.newContext();

        // Get ra cookie
        List<Cookie> cookies = browserContext.cookies();
        // Gán cookie
        browserContext.addCookies(cookies);
        browserContext.clearCookies();

        browserContext.setGeolocation(new Geolocation(15.240436,108.938062));

        // Giả lập internet offline
        browserContext.setOffline(true);

        browserContext.grantPermissions(new ArrayList<>());
        browserContext.clearPermissions();



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
