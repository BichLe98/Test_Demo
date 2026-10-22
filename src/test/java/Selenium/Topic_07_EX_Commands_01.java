package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_EX_Commands {
    WebDriver driver;
    By registerButton = By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']");


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void Register_01_Empty() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");


    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@133@12");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@133@122");

        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }
    @Test
    public void Register_03_Incorrect_Confirm_Email() {

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gamil.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gamil.com.vn");

        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Email nhập lại không đúng");

    }
    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gamil.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gamil.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123");

        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }
    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gamil.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gamil.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("1234567");

        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void Register_06_Invalid_Phone() {

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gamil.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gamil.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0933343");

        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
