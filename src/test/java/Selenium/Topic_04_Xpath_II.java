package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Xpath_II {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Xpath() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");

        // Hàm text()
        driver.findElement(By.xpath("//h5[text()='Customer Service']"));

        // Hàm contains(text(),'')
        driver.findElement(By.xpath("//h5[contains(text(),'Customer')]"));

        // Hàm contains(string(),'')
        driver.findElement(By.xpath("//h5[contains(string(),'My Account')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'Account')]"));

        // Hàm and/or
        driver.findElement(By.xpath("//input[@id='input-firstname' or @name='firstname2']"));
        driver.findElement(By.xpath("//input[@id='input-firstname' and @name='firstname']"));

        //Hàm concat
        //VD: <div class ="pull-right">I'M Me "Automation"</div>
        //Xpath: //div[text()=concat("I'",'M Me "Automation"')]

        // Hàm inside: ngang hàng nhau cùng nằm trong 1 thẻ cha
        driver.findElement(By.xpath("//div[@id='account-register']//li[1]"));

    }
    @Test
    public void TC_02_Xpath() {
        // Hàm outside: không cùng nằm trong 1 thẻ cha
        driver.get("https://live.techpanda.org/index.php/mobile.html");
        driver.findElement(By.xpath("(//button[@title='Add to Cart'])[2]"));

    }

    @AfterClass
    public void afterClass(){
    driver.quit();
    }
}
