package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_WebBrowser() {
        // Mở ra url bất kì
        driver.get("https://live.techpanda.org/");

        // Đóng tab (dùng để handle windown
        driver.close();

        // Đóng trình duyệt (Browser)
        driver.quit();

        // Đi tìm 1 element ở page hiện tại
        driver.findElement(By.id(""));

        // Tìm nhiều element gống nhau ở page hiện tại
        driver.findElements(By.cssSelector(""));

        // Lấy ra title của page hiện tại
        //1-Thao tác/vrify trực tiếp (chỉ dùng 1 lần)
        Assert.assertEquals(driver.getTitle(),"Home page");

        // Khai báo biến để thao tác/verify ( dùng từ 2 lần trở lên)
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle,"Home page");

        // Lấy ra source code của page hiện tại(HTML/CSS/JS/JQUERY)
        driver.getPageSource();
        Assert.assertTrue(driver.getPageSource().contains("$500.000"));

        // Lấy ra url của page hiện tại
        driver.getCurrentUrl();

        // Thao tác với Windown
        // Lấy ra ID của tab/ windown hiện tại
        driver.getWindowHandle();

        // Lấy ra tất cả ID của tab/ windown đang có
        driver.getWindowHandles();

        // Thao tác trực tiếp
        driver.manage().deleteAllCookies();
        // Hạ browser xuống thanh taskbar
        driver.manage().window().minimize();
        // Browser phóng to  thanh taskbar
        driver.manage().window().maximize();
        // Chế độ fullscreen
        driver.manage().window().fullscreen();
        // Lấy ra kích thước của browser chiều rộng và chiều cao
        driver.manage().window().getSize();
        //Browser mở vs kích thước nào (Responsive)
        driver.manage().window().setSize(new Dimension(1920,1080));

        driver.manage().window().getPosition();

        driver.manage().window().setPosition(new Point(0,0));

        // Lấy ra cookie của phiên hiện tại
        driver.manage().getCookies();
        // Gán cookie vào tab hiện tại
        //driver.manage().addCookie();
        // Xóa cookie bất kì
        //driver.manage().deleteCookie();
        driver.manage().deleteCookieNamed("");

        driver.manage().deleteAllCookies();

        //Wait ngầm định để tìm element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().getImplicitWaitTimeout();

        // Wait ngầm định để thực thi JS
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().getScriptTimeout();

        // Wait ngần định để page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().getPageLoadTimeout();

        driver.manage().logs().get("");
        driver.manage().logs().getAvailableLogTypes();
    }

    @Test
    public void TC_02_WebElement() {
        driver.findElement(By.cssSelector("")).click(); //Gọi trực tiếp

        WebElement webElement = driver.findElement(By.cssSelector("")); // khai báo biến
        // Click vào button/link/checkbox/dropdown
        webElement.click();
        
        // Dùng với loại element dang editabe(Textbox/ Texarea/ Dropdown)
        // Xóa dữ liệu đang có trước khi nhập mới
        webElement.clear();

        // Nhập dữ liệu (Textbox/ Texarea/ Dropdown)
        webElement.sendKeys("abc@gmail.com");
        webElement.sendKeys(Keys.ENTER);

        // Dùng để kiểm tra 1 element đang hiển thị
        // Có kích thước cụ thể /nhìn thấy được
        // Áp dụng cho tất cả các loại element
        // Hiển thị trả về true/ko thì false
        Assert.assertTrue(webElement.isDisplayed());
        Assert.assertFalse(webElement.isDisplayed());

        // Áp dụng cho tất cả các loại element
        // Kiểm tra element có thể tháo tác được không(ko bị disabled)
        // disabled = read-only(pnly view)
        Assert.assertFalse(webElement.isEnabled());

        // Áp dụng cho 3 loại element (checkbox/radio/dropdown)
        //This operation only applies to input elements such as checkboxes, options in a select and radio buttons.
        Assert.assertFalse(webElement.isSelected());

        // Các hàm có tiền tố là getXXX() thì phải trả về dữ liệu
        // Trả về các text của element  - bao gồm cả sub-element text
        webElement.getText();

        //
        webElement.getAttribute("class");
        //input-text required-entry validation-failed
        webElement.getDomAttribute("class");
        //input-text required-entry validation-failed
        webElement.getDomProperty("className");
        //input-text required-entry validation-failed

        //Background color/ font/ size/ color/..
        webElement.getCssValue("");
        // Helvetica Neue, Verdana, Arial, sans-serif

        // Position/ Size (Browser)
        // Location/ Size (Element)
        // Lấy ra vị trí của element so ới màn hình
        // Lấy ra tại vị trí góc trên cùng bên trái
        Point firstNameLocation = webElement.getLocation();
        firstNameLocation.getX();
        firstNameLocation.getY();

        // Lấy ra kích thước của element (rộng x cao)
        Dimension firstNameSize = webElement.getSize();
        firstNameSize.getHeight();
        firstNameSize.getWidth();

        // Bao gồm cả Dimension/ Point
        Rectangle firstNameRect = webElement.getRect();
        firstNameRect.getDimension();
        firstNameRect.getPoint();

        // Dùng để xử lý các element nằm trong Shadow DOM
        webElement.getShadowRoot();

        // Dựa vào Locator truyền vào có thể lấy ra tagname của element đó
        String tagnmar = webElement.getTagName();

        webElement.getAccessibleName();
        webElement.getAriaRole();

        // Đồng nghĩa việc tự tay  bấm gửi/ đăng kí
        // Bắt buộc nằm trong thẻ form mới dùng được
        webElement.submit();


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
