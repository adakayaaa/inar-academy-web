package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
    private WebDriver driver;

    //Product Information
    private By productDropdownElement = By.id("productSelect");
    private By quantityInputField = By.id("quantityInput");
    private By discountInputField = By.id("discountInput");
    private By totalPriceField = By.id("totalInput");
    private By calculateButton = By.xpath("//button[text()='Calculate']");

    //Customer Information
    private By nameField = By.id("name");
    private By streetField = By.id("street");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By zipCodeField = By.id("zip");

    //Payment Information
        //card
    private By visaCheckBox= By.id("visa");
    private By masterCardCheckBox= By.id("mastercard");
    private By americanExpressCheckBox= By.id("amex");

        //card number
    private By cardNumberField = By.id("cardNumber");

        //expire date
    private By expireDateField = By.id("expiryDate");

    //Process Button
    private By processButton =By.xpath("//button[text()='Process']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(String productName) {
        WebElement dropdownElement = driver.findElement(productDropdownElement);
        Select productDropDown = new Select(dropdownElement);
        productDropDown.selectByVisibleText(productName);
    }

    public void enterQuantity(String quantity) {
        WebElement quantityElement = driver.findElement(quantityInputField);
        quantityElement.clear();
        quantityElement.sendKeys(quantity);
    }

    public void enterDiscount(String discount) {
        WebElement discountElement = driver.findElement(discountInputField);
        discountElement.clear();
        discountElement.sendKeys(discount);
    }

    public void clickOnCalculateButton() {
        driver.findElement(calculateButton).click();
    }

    public String calculatePrice(String productName, String quantity, String discount) throws InterruptedException {
        selectProduct(productName);
        enterQuantity(quantity);
        enterDiscount(discount);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,300)");
        Thread.sleep(1000);
        clickOnCalculateButton();

        WebElement totalPriceElement = driver.findElement(totalPriceField);
        return totalPriceElement.getAttribute("value");

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

    public void enterName(String name){
        WebElement nameElement= driver.findElement(nameField);
        nameElement.clear();
        nameElement.sendKeys(name);
    }
    public void enterStreet(String street){
        WebElement streetElement= driver.findElement(streetField);
        streetElement.clear();
        streetElement.sendKeys(street);
    }
    public void enterCity(String city){
        WebElement cityElement= driver.findElement(cityField);
        cityElement.clear();
        cityElement.sendKeys(city);
    }

    public void enterState(String state){
        WebElement stateElement= driver.findElement(stateField);
        stateElement.clear();
        stateElement.sendKeys(state);
    }
    public void enterZipCode(String zip){
        WebElement zipCodeElement= driver.findElement(zipCodeField);
        zipCodeElement.clear();
        zipCodeElement.sendKeys(zip);

    }

    public void enterCustomerInfo(String name, String street, String city, String state, String zip){
        enterName(name);
        enterStreet(street);
        enterCity(city);
        enterState(state);
        enterZipCode(zip);

    }

    public void selectPaymentMethod(String paymentMethod){
        switch (paymentMethod.toLowerCase()){
            case "visa":
                clickCheckBox(visaCheckBox);
                break;
            case "mastercard" :
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

    private void clickCheckBox(By checkBoxLocater) {
        WebElement checkBox =driver.findElement(checkBoxLocater);
        if(!checkBox.isSelected()){
            checkBox.click();
        }
    }

    public void enterCardNumber(String cardNumber){
        WebElement cardNumberElement= driver.findElement(cardNumberField);
        cardNumberElement.clear();
        cardNumberElement.sendKeys(cardNumber);
    }

    public void enterExpiryDate(String expireDate){
        WebElement expiryDateElement= driver.findElement(expireDateField);
        expiryDateElement.clear();
        expiryDateElement.sendKeys(expireDate);
    }

    public void enterPaymentInformation(String paymentMethod,String cardNumber, String expireDate){
        selectPaymentMethod(paymentMethod);
        enterCardNumber(cardNumber);
        enterExpiryDate(expireDate);
    }

    public void clickOnProcessButton(){
        driver.findElement(processButton).click();
    }






}
