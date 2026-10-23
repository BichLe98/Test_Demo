package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic_07_EX_Commands_04 {
    WebDriver driver;
    By registerButton = By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']");


    @BeforeClass
    public void beforeClass() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("dom.security.https_only_mode", false);
        firefoxOptions.addPreference("security.mixed_content.block_active_content", false);
        firefoxOptions.addPreference("security.mixed_content.block_display_content", false);
        driver = new FirefoxDriver(firefoxOptions);

        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforMethod(){
        driver.get("http://live.techpanda.org/index.php/");
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
    }

    @Test
    public void Login_01_Empty() {

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");



    }

    @Test
    public void Login_02_Invalid_Email() {
        driver.findElement(By.cssSelector("input#email")).sendKeys("test@gmail");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.findElement(By.cssSelector("input#email")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");

    }
    @Test
    public void Login_04_Incorrect() {

        driver.findElement(By.cssSelector("input#email")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456789");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(),"Invalid login or password.");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
