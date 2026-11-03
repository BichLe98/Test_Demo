package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Playwright_06_EX_Commands_Mailchimp {
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
    public void TC_01_MailChimp() throws InterruptedException {
        page.navigate("https://login.mailchimp.com/signup/");
        Locator emailInput = page.locator("#email");
        Locator passwordInput = page.locator("#new_password");

        emailInput.fill("automationfc@gamil.com");
        emailInput.press("Tab");
        //Number
        passwordInput.fill("1234");
        passwordInput.press("Tab");

        PlaywrightAssertions.assertThat(page.locator("li.lowercase-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.uppercase-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.number-char.completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.special-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li[class='8-char not-completed']")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.username-check.completed")).isVisible();
        page.waitForTimeout(3000);

        //Lowercase
        passwordInput.fill("manual");
        passwordInput.press("Tab");

        PlaywrightAssertions.assertThat(page.locator("li.lowercase-char.completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.uppercase-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.number-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.special-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li[class='8-char not-completed']")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.username-check.completed")).isVisible();
        page.waitForTimeout(3000);

        // Uperrcase
        passwordInput.fill("MANUAL");
        passwordInput.press("Tab");

        PlaywrightAssertions.assertThat(page.locator("li.lowercase-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.uppercase-char.completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.number-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.special-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li[class='8-char not-completed']")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.username-check.completed")).isVisible();
        page.waitForTimeout(3000);

        // Specialcase
        passwordInput.fill("!@#$");
        passwordInput.press("Tab");

        PlaywrightAssertions.assertThat(page.locator("li.lowercase-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.uppercase-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.number-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.special-char.completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li[class='8-char not-completed']")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.username-check.completed")).isVisible();
        page.waitForTimeout(3000);

        // 8 char
        passwordInput.fill("12345678");
        passwordInput.press("Tab");

        PlaywrightAssertions.assertThat(page.locator("li.lowercase-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.uppercase-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.number-char.completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.special-char.not-completed")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li[class*='8-char'][class*='completed']")).isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.username-check.completed")).isVisible();
        page.waitForTimeout(3000);

        // Full
        passwordInput.fill("Manual123@");
        passwordInput.press("Tab");

        PlaywrightAssertions.assertThat(page.locator("li.lowercase-char.completed")).not().isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.uppercase-char.completed")).not().isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.number-char.completed")).not().isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.special-char.completed")).not().isVisible();
        PlaywrightAssertions.assertThat(page.locator("li[class*='8-char'][class*='completed']")).not().isVisible();
        PlaywrightAssertions.assertThat(page.locator("li.username-check.completed")).not().isVisible();
        page.waitForTimeout(3000);



    }

    @AfterClass
    public void afterClass(){
        page.clock();
        browser.close();
        playwright.close();
    }
}
