package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Playwright_07_TextBox_TextArea {
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
    public void TC_01_() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Deprecated
        page.locator("input[name='username']").fill("Admin");
        page.locator("input[name='password']").fill("admin123");
        page.locator("button.orangehrm-login-button").click();

        page.locator("//span[text()='PIM']").click();
        page.locator("//a[text()='Add Employee']").click();

        page.locator("input[name='firstName']").fill("Harry");
        page.locator("input[name='lastName']").fill("Truman");

        String employeeID = page.locator("//label[text()='Employee Id']/parent::div/following-sibling::div/input").inputValue();

        page.locator("//button[contains(string(),'Save')]").click();

      assertThat(page.locator("input[name='firstName']")).hasValue("Harry");
        assertThat(page.locator("input[name='lastName']")).hasValue("Truman");
        assertThat(page.locator("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).hasValue(employeeID);

        page.locator("//a[text()='Immigration']").click();
        page.locator("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]").click();
        page.locator("//label[text()='Number']/parent::div/following-sibling::div/input").fill("123-6569-86326");
        page.locator("//label[text()='Comments']/parent::div/following-sibling::div/textarea").fill("Passport Due Date\n10/2027");

        page.locator("//button[contains(string(),'Save')]").click();





    }



    @AfterClass
    public void afterClass(){
        page.close();
        browser.close();
        playwright.close();
    }
}
