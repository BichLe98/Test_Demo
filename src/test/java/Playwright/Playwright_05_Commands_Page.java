package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Playwright_05_Commands_Page {
    WebDriver driver;
    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @BeforeClass
    public void beforeClass() {
        playwright = Playwright.create();

        browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false).setSlowMo(500));
        page = browser.newPage();

    }

    @Test
    public void TC_01_Command() throws InterruptedException {
        /* I-Navigation */

        page.navigate("https://www.facebook.com/");

        page.reload();
        page.goBack();
        page.goForward();

        page.url();
        page.title();
        page.waitForURL("");

        /* II- Locator */
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Yes"));
        page.getByLabel("First Name");
        page.getByPlaceholder("Search").fill("IMAC");
        page.getByText("Your Personal Details");
        page.getByAltText("HP LP3065");
        page.getByTitle("HP LP3065");
        page.getByTestId("input-username");
        page.locator("form input#input-firstname");
        page.locator("//div[@id='content']/h1");

        /* III - Action*/
        page.click("//div[@id='content']/h1");

        page.dblclick("//div[@id='content']/h1");

        page.hover("//div[@id='content']/h1");

        page.focus("");

        page.fill("input[name='age']","39");

        page.type("input[name='age']","39");

        // Ensure that matched element is a checkbox or a radio input
        page.check("");
        page.uncheck("");

        page.selectOption("div.toolbar-bottom select[title ='Sort By']","Name");
        // new Select(driver.findElement(By.cssSelector("div.toolbar-bottom select[title ='Sort By']"))).selectByVisibleText("");


        page.dragAndDrop("div#draggable","div#droptarget");
        // new Actions(driver).dragAndDrop(driver.findElement(By.cssSelector("")), driver.findElement(By.cssSelector("")));

        String projectPath = System.getProperty("user.dir");

        page.setInputFiles("input[type='file']", Paths.get(projectPath + "/uploadFiles/Test.text"));
        page.setInputFiles("input[type='file']", new Path[]{
                Paths.get(projectPath + "/uploadFiles/Test.pdf"),
                Paths.get(projectPath + "/uploadFiles/Test1.pdf")
        });
        page.textContent("div.page-title>h1");
        page.innerHTML("div.page-title>h1");
        page.innerText("div.page-title>h1");

        page.getAttribute("input#search","placeholder");
        // Search entire store here...

        page.isVisible("");
        page.isEnabled("");
        page.isDisabled("");
        page.isChecked("");
        page.isEditable("");

        page.waitForSelector("div.page-title>h1");

        page.waitForSelector(".toast-success",new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE).setTimeout(10000));

        page.waitForTimeout(50000);
        Thread.sleep(5000);

        // Ép kiểu tường minh
        Object jsValue = page.evaluate("document.domain;");
        String domainName =(String) jsValue;

        // Lấy ra Page Source Code
        page.content();
        // driver.getPageSource()

        page.isClosed();





        Locator locator = page.locator("//div[@id='content']/h1");
        locator.click();



    }

    @AfterClass
    public void afterClass(){
        page.clock();
        browser.close();
        playwright.close();
    }
}
