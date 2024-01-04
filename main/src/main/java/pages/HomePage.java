package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    //Locators
    private By webOrderLink = By.linkText("Weborder");
    private By webAutomationLink = By.linkText("Webautomation");
    private By targetMarketLink = By.linkText("Target Market");
    private By bookingLink = By.linkText("Booking");
    private By handlingCertifications = By.linkText("Handling Certifications");
    private By fileUploading = By.linkText("File Uploading");
    private By exploreInarTestingWorldTitleTest = By.cssSelector("h1.display-1.text-fifth");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Page actions with Java methods
    public  WebOrderLoginPage clickOnWebOrderLink() {
        driver.findElement(webOrderLink).click();
        return new WebOrderLoginPage(driver);
    }

    public void clickOnWebAutomationLink() {
        driver.findElement(webAutomationLink).click();
    }

    public void clickOnTargetMarketLink() {
        driver.findElement(targetMarketLink).click();
    }

    public void clickOnBookingLink() {
        driver.findElement(bookingLink).click();
    }

    public void clickOnHandlingCertificationsLink() {
        driver.findElement(handlingCertifications).click();
    }

    public void clickOnFileUploadingLink() {
        driver.findElement(fileUploading).click();
    }

    public String getWelcomeText() {
        return driver.findElement(exploreInarTestingWorldTitleTest).getText();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

}
