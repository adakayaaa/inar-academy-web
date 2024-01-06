import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.WebOrderHomePage;
import pages.WebOrderLoginPage;
import utils.BrowserUtils;
import utils.Driver;

public class WebOrderTest extends Hooks {

	@Test
	void testSeleniumWebDriver() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");

		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();
		orderPage.enterProduct("Books", "10", "10");
		orderPage.enterCustomerInfo("Francois", "Main", "NewYork", "NW", "1004");

		BrowserUtils.scrollVertically(800);
		Thread.sleep(1000);

		orderPage.enterPaymentInformation("visa", "4938281746192845", "01/28");
		orderPage.clickOnProcessButton();

	}

}
