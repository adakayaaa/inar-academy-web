package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {

	// Product Information
	@FindBy(id = "productSelect")
	private WebElement productDropdownElement;

	@FindBy(id = "quantityInput")
	private WebElement quantityInputField;

	@FindBy(id = "discountInput")
	private WebElement discountInputField;

	@FindBy(id = "totalInput")
	private WebElement totalPriceField;

	@FindBy(xpath = "//button[text()='Calculate']")
	private WebElement calculateButton;

	// Customer Information

	@FindBy(id = "name")
	private WebElement nameField;

	@FindBy(id = "street")
	private WebElement streetField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "state")
	private WebElement stateField;

	@FindBy(id = "zip")
	private WebElement zipCodeField;

	// Payment Information
	// card

	@FindBy(id = "visa")
	private WebElement visaCheckBox;

	@FindBy(id = "mastercard")
	private WebElement masterCardCheckBox;

	@FindBy(id = "amex")
	private WebElement americanExpressCheckBox;

	// card number

	@FindBy(id = "cardNumber")
	private WebElement cardNumberField;

	// expire date
	@FindBy(id = "expiryDate")
	private WebElement expireDateField;

	// Process Button

	@FindBy(xpath = "//button[text()='Process']")
	private WebElement processButton;

	public OrderPage() {
		super();
	}

	public void selectProduct(String productName) {
		Select productDropDown = new Select(productDropdownElement);
		productDropDown.selectByVisibleText(productName);
	}

	public void enterQuantity(String quantity) {
		quantityInputField.clear();
		quantityInputField.sendKeys(quantity);
	}

	public void enterDiscount(String discount) {
		discountInputField.clear();
		discountInputField.sendKeys(discount);
	}

	public void clickOnCalculateButton() {
		calculateButton.click();
	}

	public String calculatePrice(String productName, String quantity, String discount) throws InterruptedException {
		selectProduct(productName);
		enterQuantity(quantity);
		enterDiscount(discount);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,300)");
		Thread.sleep(1000);
		clickOnCalculateButton();

		return totalPriceField.getAttribute("value");

	}

	public void enterProduct(String productName, String quantity, String discount) throws InterruptedException {
		selectProduct(productName);
		enterQuantity(quantity);
		enterDiscount(discount);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,300)");
		Thread.sleep(1000);

		clickOnCalculateButton();
	}

	public void enterName(String name) {
		nameField.clear();
		nameField.sendKeys(name);
	}

	public void enterStreet(String street) {
		streetField.clear();
		streetField.sendKeys(street);
	}

	public void enterCity(String city) {
		cityField.clear();
		cityField.sendKeys(city);
	}

	public void enterState(String state) {
		stateField.clear();
		stateField.sendKeys(state);
	}

	public void enterZipCode(String zip) {
		zipCodeField.clear();
		zipCodeField.sendKeys(zip);

	}

	public void enterCustomerInfo(String name, String street, String city, String state, String zip) {
		enterName(name);
		enterStreet(street);
		enterCity(city);
		enterState(state);
		enterZipCode(zip);

	}

	public void selectPaymentMethod(String paymentMethod) {
		switch (paymentMethod.toLowerCase()) {
			case "visa":
				clickCheckBox(visaCheckBox);
				break;
			case "mastercard":
				clickCheckBox(masterCardCheckBox);
				break;
			case "american express":
				clickCheckBox(americanExpressCheckBox);
				break;
			default:
				System.out.println("Payment method doesn't exist");
				break;
		}
	}

	private void clickCheckBox(WebElement checkBox) {
		if (!checkBox.isSelected()) {
			checkBox.click();
		}
	}

	public void enterCardNumber(String cardNumber) {
		cardNumberField.clear();
		cardNumberField.sendKeys(cardNumber);
	}

	public void enterExpiryDate(String expireDate) {
		expireDateField.clear();
		expireDateField.sendKeys(expireDate);
	}

	public void enterPaymentInformation(String paymentMethod, String cardNumber, String expireDate) {
		selectPaymentMethod(paymentMethod);
		enterCardNumber(cardNumber);
		enterExpiryDate(expireDate);
	}

	public void clickOnProcessButton() {
		processButton.click();
	}

}
