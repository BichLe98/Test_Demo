package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Playwright_06_Commands_Locator {
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
        // Locator Chainning
        Locator footerLink = page.locator("div.footer");

        Locator myAccountLink = footerLink.locator("footerLink");


        // Handle DataTable
        Locator row = page.locator("div.oxd-table-row")
                .filter(new Locator.FilterOptions().setHasText("John Smith"));
        row.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Edit")).click();

        Locator rows = page.locator("div.oxd-table-row");
        rows.nth(0); // Element đầu tiên
        rows.nth(2); // thứ 3
        rows.nth(row.count()-1); // cuối cùng

        row.first();
        row.last();

        // List<Locator> textboxes = page.locator("//input").all();
        List<Locator> countryText = page.locator("//tr//td(3)").all();
        List<String> allText = new ArrayList<String>();
            for(Locator locator : countryText)

            {
                allText.add(locator.textContent());

            }

            Locator saveButton = page.locator("button.oxd-button").and(page.getByText("Save"));
            saveButton.click();

        Locator cancelButton = page.locator("button.oxd-button").and(page.getByText("Cancel"));

        Locator searchBox = page.locator("input[placeholder='Type for hints...']");
        searchBox.pressSequentially("John", new Locator.PressSequentiallyOptions().setDelay(100));

        searchBox.press("Ctrl + A");
        searchBox.press("Ctrl + C");
        searchBox.press("Ctrl + V");

        Locator createLoginSwitch = page.locator(".oxd-switch-input input[type='checkbox']");

        // Đảm bảo switch luôn ở trạng thái ON, bất kể trước đó ddabf ON hay OFF
        createLoginSwitch.setChecked(true);
        assertThat(createLoginSwitch).isChecked();

        searchBox.selectOption("");

        List<String> items = page.selectOption("","");

        searchBox.dragTo(createLoginSwitch);

        searchBox.inputValue();
        Locator countryLocator = page.locator("//tr//td[3]");

        List<String> countryName = countryLocator.allTextContents();
        int countryNumber = countryLocator.count();

        Assert.assertTrue(countryName.contains("Argentina"));
        Assert.assertFalse(countryName.isEmpty());

        // Selenium
        WebDriver driver = new FirefoxDriver();
        List<WebElement> countryElements = driver.findElements(By.xpath("//tr//td[3]"));
        countryElements.get(0);

        List<String> coutryText = new ArrayList<>();
        for (WebElement element : countryElements){
            coutryText.add(element.getText());
        }

        Assert.assertTrue(countryName.contains("Argentina"));

        WebElement elemen = driver.findElement(By.cssSelector(""));
        Rectangle firstNameRect = elemen.getRect();
        firstNameRect.getX();
        firstNameRect.getY();
        firstNameRect.getWidth();
        firstNameRect.getHeight();

        Locator firstNameLocator = page.locator("");

        Assert.assertTrue(firstNameLocator.isVisible());

        PlaywrightAssertions.setDefaultAssertionTimeout(10000);
        PlaywrightAssertions.assertThat(firstNameLocator).isVisible();
        PlaywrightAssertions.assertThat(firstNameLocator).isChecked();
        PlaywrightAssertions.assertThat(firstNameLocator).isHidden();
        PlaywrightAssertions.assertThat(firstNameLocator).isEnabled();

        Locator searchTextbox = page.locator("input#search");
        Locator button = page.locator("button");

        PlaywrightAssertions.assertThat(searchTextbox).hasAttribute("placeholder","Search entire store here...");
        PlaywrightAssertions.assertThat(searchTextbox).hasClass("input-text required-entry");
        PlaywrightAssertions.assertThat(searchTextbox).hasCount(1);
        PlaywrightAssertions.assertThat(button).hasCount(5);

        searchTextbox.fill("LG");
        PlaywrightAssertions.assertThat(searchTextbox).hasValue("LG");

        PlaywrightAssertions.assertThat(firstNameLocator).isVisible();
        PlaywrightAssertions.assertThat(firstNameLocator).isHidden();
        PlaywrightAssertions.assertThat(firstNameLocator).isDisabled();
        PlaywrightAssertions.assertThat(firstNameLocator).isEnabled();

        // Phủ định ngược lại
        PlaywrightAssertions.assertThat(searchTextbox).not().hasValue("Samsung");
        PlaywrightAssertions.assertThat(firstNameLocator).not().isFocused();
        PlaywrightAssertions.assertThat(firstNameLocator).not().isChecked();
        PlaywrightAssertions.assertThat(firstNameLocator).not().isEditable();
        PlaywrightAssertions.assertThat(firstNameLocator).not().isEmpty();
        PlaywrightAssertions.assertThat(firstNameLocator).not().isAttached();




        BoundingBox firstNameBounding = firstNameLocator.boundingBox();
        double x = firstNameBounding.x;
        double y = firstNameBounding.y;
        double z = firstNameBounding.width;
        double k = firstNameBounding.height;


        //Assertions
        String homepageTitle = page.title();
        PlaywrightAssertions.assertThat(page).hasTitle("");
        PlaywrightAssertions.assertThat(page).hasURL("*/");











        // page
        page.click("button[title='Save']");

        // Locator (Recommend)
        Locator deleteButton = page.locator("button[title='Save']");
                deleteButton.click();


    }

    @AfterClass
    public void afterClass(){
        page.clock();
        browser.close();
        playwright.close();
    }
}
