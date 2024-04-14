package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage {

    WebDriver driver;
    WebDriverWait wait;

    //Constructor
    public RegistrationPage (WebDriver mainDriver){
        this.driver = mainDriver;
    }

    //Text Actions
    private void enterText (WebElement wb , String text) {
        wb.click();
        wb.clear();
        wb.sendKeys(text);
    }

    //Dropdown menu Actions
    private void selectOption ( List<WebElement> wb , String option) {
        for (WebElement element : wb){
            String optionText = element.getText();
            if (optionText.toLowerCase().contains(option.toLowerCase())) {
                element.click();
                break;
            }
        }
    }

    //Locators
    private WebElement firstNameWE() {
        return driver.findElement(By.cssSelector("input[id=firstname]"));
    }
    private WebElement lastNameWE() {
        return driver.findElement(By.cssSelector("input[id=last_name]"));
    }
    private WebElement phoneWE() {
        return driver.findElement(By.cssSelector("input[id=phone]"));
    }
    private WebElement emailWE() {
        return driver.findElement(By.cssSelector("input[id=user_email]"));
    }
    private WebElement passwordWE() {
        return driver.findElement(By.cssSelector("input[id=password]"));
    }
    private WebElement countryMenuButtonWE () {
        return driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select w-100']"));
    }
    private List<WebElement> countyMenuWE () {
        return driver.findElements(By.xpath("//a[@class='dropdown-item']"));
    }
    private WebElement captchaBorderWE () {
        return driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
    }
    private By captchaCheckboxWE () {
        return By.xpath("//div[@class='recaptcha-checkbox-border']");
    }
    private By signupButtonWE () {
        return By.cssSelector("#submitBTN");
    }
    private By messageBoxWE () {
        return By.xpath("//div[@class='contaier mt-5 mb-5']");
    }
    private By errorMidMsgWE () {
        return By.xpath("//div[@class='vt-col bottom-center']");
    }

    //Actions
    public void enterFirstName (String firstName) {
        enterText(firstNameWE(),firstName);
    }
    public void enterLastName (String lastName) {
        enterText(lastNameWE(),lastName);
    }
    public void enterPhoneNumber (String phoneNumber) {
        enterText(phoneWE(),phoneNumber);
    }
    public void enterEmail (String email){
        enterText(emailWE(),email);
    }
    public void enterPassword (String password){
        enterText(passwordWE(),password);
    }
    public void selectCountry (String country) {
        countryMenuButtonWE().click();
        selectOption(countyMenuWE(), country);
    }
    public void clickCaptcha () {

        driver.switchTo().frame(captchaBorderWE());
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement captchaCheckbox = wait.until(ExpectedConditions.elementToBeClickable(captchaCheckboxWE()));
        captchaCheckbox.click();
        driver.switchTo().defaultContent();
    }
    public void clickSignup () {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //Solving captcha timeout
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(signupButtonWE()));
        button.click();
    }
    public String getSuccessMessage () {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(messageBoxWE()));
        return message.getText();
    }
    public String getErrorMessage () {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMidMsgWE()));
        return message.getText();
    }

}
