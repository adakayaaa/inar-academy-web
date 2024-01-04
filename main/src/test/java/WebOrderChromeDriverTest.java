import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.OrderPage;
import pages.WebOrderHomePage;
import pages.WebOrderLoginPage;
import java.time.Duration;

public class WebOrderChromeDriverTest {

    WebDriver driver;

    @BeforeEach
    void setUpTestEnvironment() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void testSeleniumWebDriver() throws InterruptedException {
        driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
        HomePage homePage = new HomePage(driver);
        WebOrderLoginPage webOrderLoginPage = homePage.clickOnWebOrderLink();
        WebOrderHomePage webOrderHomePage=webOrderLoginPage.login("Inar", "Academy");
        OrderPage orderPage=webOrderHomePage.navigateToOrder();
        orderPage.enterProduct("Books","10","10");
        orderPage.enterCustomerInfo("Francois","Main","NewYork","NW","1004");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,800)");
        Thread.sleep(1000);

        orderPage.enterPaymentInformation("visa","4938281746192845","01/28");
        orderPage.clickOnProcessButton();


    }

    @AfterEach
    void tearDownTestEnvironment() {
        if (driver != null) {
            driver.quit();
        }
    }
}
