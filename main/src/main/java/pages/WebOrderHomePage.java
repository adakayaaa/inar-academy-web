package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebOrderHomePage extends BasePage {

	@FindBy(linkText = "View all orders")
	private WebElement viewAllOrdersLink;

	@FindBy(linkText = "View all products")
	private WebElement viewAllProductsLink;

	@FindBy(linkText = "Order")
	private WebElement ordersLink;

	public WebOrderHomePage() {
		super();
	}

	public void navigateToViewAllOrders() {
		viewAllOrdersLink.click();
	}

	public void navigateToViewAllProducts() {
		viewAllProductsLink.click();
	}

	public void navigateToOrder() {
		ordersLink.click();
	}

}
