package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_EX_Commands_03 {
    WebDriver driver;
    By registerButton = By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']");


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_MailChimp() throws InterruptedException {
        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#new_username")).sendKeys(Keys.TAB);
        By passwordTextbox = By.cssSelector("input#new_password");
        By signUpButton = By.cssSelector("button#create-account-enabled");
        // Number
        driver.findElement(passwordTextbox).sendKeys("123456");
        driver.findElement(passwordTextbox).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(signUpButton).isEnabled());
        By newsletterCheckboxy = By.cssSelector("input[id='marketing_newsletter']");
        Assert.assertFalse(driver.findElement(newsletterCheckboxy).isSelected());



        // Lowercase
        driver.findElement(passwordTextbox).clear();
        driver.findElement(passwordTextbox).sendKeys("nanual");
        driver.findElement(passwordTextbox).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(signUpButton).isEnabled());

        Assert.assertFalse(driver.findElement(newsletterCheckboxy).isSelected());

        // Uperrcase
        driver.findElement(passwordTextbox).clear();
        driver.findElement(passwordTextbox).sendKeys("NANUAL");
        driver.findElement(passwordTextbox).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(signUpButton).isEnabled());

        Assert.assertFalse(driver.findElement(newsletterCheckboxy).isSelected());

        // Specialcase
        driver.findElement(passwordTextbox).clear();
        driver.findElement(passwordTextbox).sendKeys("!@#$");
        driver.findElement(passwordTextbox).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(signUpButton).isEnabled());

        Assert.assertFalse(driver.findElement(newsletterCheckboxy).isSelected());

        // 8 char
        driver.findElement(passwordTextbox).clear();
        driver.findElement(passwordTextbox).sendKeys("12345678");
        driver.findElement(passwordTextbox).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class*='8-char'][class*='completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(signUpButton).isEnabled());

        Assert.assertFalse(driver.findElement(newsletterCheckboxy).isSelected());

        // Full
        driver.findElement(passwordTextbox).clear();
        driver.findElement(passwordTextbox).sendKeys("Manual123@");
        driver.findElement(passwordTextbox).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class*='8-char'][class*='completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(signUpButton).isEnabled());

        Assert.assertFalse(driver.findElement(newsletterCheckboxy).isSelected());



    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
