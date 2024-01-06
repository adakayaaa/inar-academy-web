package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Locators
	@FindBy(linkText = "Weborder")
	private WebElement webOrderLink;

	@FindBy(linkText = "Webautomation")
	private WebElement webAutomationLink;

	@FindBy(linkText = "Target Market")
	private WebElement targetMarketLink;

	@FindBy(linkText = "Booking")
	private WebElement bookingLink;

	@FindBy(linkText = "Handling Certifications")
	private WebElement handlingCertifications;

	@FindBy(linkText = "File Uploading")
	private WebElement fileUploading;

	@FindBy(css = "h1.display-1.text-fifth")
	private WebElement exploreInarTestingWorldTitleTest;

	public HomePage() {
		super();
	}

	// Page actions with Java methods
	public void clickOnWebOrderLink() {
		webOrderLink.click();
	}

	public void clickOnWebAutomationLink() {
		webAutomationLink.click();
	}

	public void clickOnTargetMarketLink() {
		targetMarketLink.click();
	}

	public void clickOnBookingLink() {
		bookingLink.click();
	}

	public void clickOnHandlingCertificationsLink() {
		handlingCertifications.click();
	}

	public void clickOnFileUploadingLink() {
		fileUploading.click();
	}

	public String getWelcomeText() {
		return exploreInarTestingWorldTitleTest.getText();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

}
