package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void TC_01_OrangeHRM() {
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Assert.assertTrue(isLoadingIconHidden());

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Assert.assertTrue(isLoadingIconHidden());

        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Assert.assertTrue(isLoadingIconHidden());

        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Kennedy");

        String employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/" +
                "following-sibling::div/input")).getDomProperty("value");

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Assert.assertTrue(isLoadingIconHidden());
        Assert.assertTrue(isLoadingIconHidden());

        Assert.assertEquals(driver.findElement(By.name("firstName")).getDomProperty("value"),"John");
        Assert.assertEquals(driver.findElement(By.name("lastName")).getDomProperty("value"),"Kennedy");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/" +
                "following-sibling::div/input")).getDomProperty("value"),employeeID);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconHidden());

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']" +
                "/following-sibling::button[contains(string(),'Add')]")).click();

        driver.findElement(By.xpath("//label[text()='Number']/parent::div" +
                "/following-sibling::div/input")).sendKeys("123-6569-86326");

        driver.findElement(By.xpath("//label[text()='Comments']/parent::div" +
                "/following-sibling::div/textarea")).sendKeys("Passport Due Date" + "10/2027");

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Assert.assertTrue(isLoadingIconHidden());

    }
    // Khi mở page ra thì loading icon hiển thị trong vòng 10s mới biến mất
    // Hàm này được gọi thì có bị fail ko? >> ko bị fail
    private boolean isLoadingIconHidden() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)) // Trong vòng 30s nếu chưa thỏa mãn điều kiện sẽ chờ tiếp
                .until(ExpectedConditions.invisibilityOfAllElements(driver
                        .findElements(By.cssSelector("div.oxd-loading-spinner"))));


    }

    @Test
    public void TC_02_() {

    }

    @AfterClass
    public void afterClass(){
    driver.quit();
    }
}
