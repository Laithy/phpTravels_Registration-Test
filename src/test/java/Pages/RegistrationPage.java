package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {

    WebDriver driver;

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
    private void selectOption (WebElement wbButton, List<WebElement> wb , String option) {
        for (WebElement prnt : wb){
            String optionText = prnt.getText();
            if (optionText.contains(option)) {
                prnt.click();
                break;
            }
        }
    }

    //Text fields
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
        selectOption(countryMenuButtonWE(), countyMenuWE(), country);
    }

}
