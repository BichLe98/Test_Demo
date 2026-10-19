package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");

    }

    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("input-lastname")).sendKeys("Automation");
        driver.findElement(By.id("input-password")).sendKeys("Pass111@@");

    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("agree"));
        driver.findElement(By.className("btn-primary"));
        driver.findElement(By.className("pull-right"));

    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("telephone"));
        driver.findElement(By.name("email"));
        driver.findElement(By.name("firstname"));

    }
    @Test
    public void TC_04_Tagname() {
        // Thẻ HTML
        int textboxSize = driver.findElements(By.tagName("input")).size();
        System.out.println("Textbox number = " + textboxSize);

    }
    @Test
    public void TC_05_Link() {
        driver.findElement(By.linkText("Wish List"));
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Forgotten Password"));
        driver.findElement(By.linkText("Recurring payments"));



    }
    @Test
    public void TC_06_PartiaLink() {
        driver.findElement(By.partialLinkText("Forgotten"));
        driver.findElement(By.partialLinkText("payments"));
        driver.findElement(By.partialLinkText("List"));

    }
    @Test
    public void TC_07_Css() {
        driver.findElement(By.cssSelector("input#input-confirm"));//ID
        driver.findElement(By.cssSelector("input[name='telephone']"));//Name
        driver.findElement(By.cssSelector("a.agree"));//Class
        int textboxSize = driver.findElements(By.cssSelector("input")).size();
        System.out.println("Textbox number = " + textboxSize); // Tagname

        driver.findElement(By.cssSelector("a[href='https://opencart.abstracta.us:443/index.php?route=account/account']"));//Link



    }
    @Test
    public void TC_08_XPath() {
        driver.findElement(By.xpath("//input[@id='input-confirm']"));//ID
        driver.findElement(By.xpath("//input[@name='telephone']"));//Name
        driver.findElement(By.xpath("//a[@class='agree']"));//Class
        int textboxSize = driver.findElements(By.xpath("//input")).size();
        System.out.println("Textbox number = " + textboxSize); // Tagname

        driver.findElement(By.xpath("//a[@href='https://opencart.abstracta.us:443/index.php?route=account/account']"));//Link
        driver.findElement(By.xpath("//a[text()='My Account']"));

        driver.findElement(By.xpath("//a[contains(@href,'account/account')]")); //lấy tương đối


    }

    
    @AfterClass
    public void afterClass(){
    driver.quit();
    }
}
