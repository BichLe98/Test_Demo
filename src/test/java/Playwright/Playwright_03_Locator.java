package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Playwright_03_Locator {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void beforeClass() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false).setSlowMo(50));
        page = browser.newPage();

    }

    @Test
    public void TC_01_Role() {
        page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Yes"));
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Account"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));


    }
    @Test
    public void TC_02_Lable() {
        page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

        page.getByLabel("First Name");
        page.getByLabel("E-Mail");
        page.getByLabel("Yes");
        page.getByLabel("Subsrible");

    }
    @Test
    public void TC_03_Placeholder() {
        page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

        page.getByPlaceholder("Search").fill("IMAC");
        page.getByPlaceholder("E-Mail").fill("abc@gmail.com");
        page.getByPlaceholder("First Name").fill("Automation FC");

    }
    @Test
    public void TC_04_Text() {
        page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

        page.getByText("Your Personal Details");
        page.getByText("First Name");
        page.getByText("Privacy Policy");

    }
    @Test
    public void TC_05_AltText() {
        page.navigate("https://opencart.abstracta.us/index.php?route=product/category&path=18");

        page.getByAltText("HP LP3065");
        page.getByAltText("MacBook");
        page.getByAltText("MacBook Air");
        page.getByAltText("Sony VAIO");

    }
    @Test
    public void TC_06_Title() {
        page.navigate("https://opencart.abstracta.us/index.php?route=product/category&path=18");

        page.getByTitle("HP LP3065");
        page.getByTitle("MacBook");
        page.getByTitle("MacBook Air");
        page.getByTitle("Sony VAIO");

    }
    @Test
    public void TC_07_TestID() {
        page.navigate("https://vb-bank-demo.vercel.app/login");

        page.getByTestId("input-username");
        page.getByTestId("input-password");
        page.getByTestId("btn-login");

    }
    @Test
    public void TC_08_Css() {
        page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

        page.locator("form input#input-firstname");
        page.locator("input[name='agree']");
        page.locator("div#content>h1");
        page.locator("a[href*='account/address']");
        page.locator("input[value='Continue']");


    }
    @Test
    public void TC_09_Xpath() {
        page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

        page.locator("//lable[contains(string(),'Yes')]/input");
        page.locator("//input[@id='input-firstname']");
        page.locator("//a[text()='Address Book']");
        page.locator("//div[@id='content']/h1");

    }



    @AfterClass
    public void afterClass(){
        browser.close();
        playwright.close();
    }
}
