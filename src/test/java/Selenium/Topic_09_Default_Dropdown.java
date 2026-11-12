package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Sauce() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input#login-button")).click();

        By sortDropdownBy = By.cssSelector("select.product_sort_container");
        new Select(driver.findElement(sortDropdownBy)).selectByVisibleText("Name (Z to A)"); // Name (Z to A)
        Assert.assertEquals(new Select(driver.findElement(sortDropdownBy)).getFirstSelectedOption().getText(),"Name (Z to A)");


        // Dropdown ko phải multiple
      // Assert.assertFalse(sortDropdown.isMultiple());

       // Chọn
       // sortDropdown.selectByIndex(2);// price (low to high)
        //sortDropdown.selectByValue("az");// Name (A to Z)
       // sortDropdown.selectByContainsVisibleText("high to low");// price (high to low)

       // sortDropdown.selectByVisibleText("Name (Z to A)"); // Name (Z to A)

        // Bỏ chọn
       // sortDropdown.deselectByIndex(2);// price (low to high)
       // sortDropdown.deselectByValue("az");// Name (A to Z)
       // sortDropdown.deSelectByContainsVisibleText("high to low");// price (high to low)
        //sortDropdown.deselectByVisibleText("Name (Z to A)"); // Name (Z to A)

        // Kiểm tra chọn thành công
       // Assert.assertEquals(sortDropdown.getFirstSelectedOption().getText(),"Name (Z to A)");

        // Kiểm tra số lượng item bao nhiêu
       // Assert.assertEquals(sortDropdown.getOptions().size(),4);
    }

    @Test
    public void TC_02_Rode() {
        driver.get("https://rode.com/en-au/support/where-to-buy");

        Select countryDropdown = new Select(driver.findElement(By.cssSelector("select#country")));
        countryDropdown.selectByVisibleText("Vietnam");

        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("Ho Chi Minh");

        driver.findElement(By.xpath("//button[text()='Search']")).click();

        // chờ cho 16 dealer xuất hiện trong vòng 15s (ko quan tâm là hiển thị hay ko)
        // Lấy hết các dealer vào 1 danh sách element
        List<WebElement> dealerList = new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//h3[text()='Dealers']/following-sibling::div/div//h4"),16));

        Assert.assertEquals(dealerList.size(),16);










    }

    @AfterClass
    public void afterClass(){
    driver.quit();
    }
}
