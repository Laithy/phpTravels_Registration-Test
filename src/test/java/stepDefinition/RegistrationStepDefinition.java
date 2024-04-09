package stepDefinition;

import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegistrationStepDefinition {

    WebDriver driver = null;
    RegistrationPage regPage;

    @Given("The user opens the browser")
    public void init_driver (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        regPage = new RegistrationPage(driver);
    }
    @And("Navigates to the site \"(.*)\"$")
    public void siteNavigation (String website) throws InterruptedException {
        driver.navigate().to(website);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        String currentWebsite = driver.getCurrentUrl();
        Assert.assertTrue(currentWebsite.contains(website),"Website isn't right");
    }

    @When("The user enters his first name \"(.*)\" in the first name field$")
    public void enter_firstName (String firstName) {
        regPage.enterFirstName(firstName);
    }
    @And("enters his Last name \"(.*)\" in the last name field$")
    public void enter_lastName (String lastName){
        regPage.enterLastName(lastName);
    }
    @And("Picks his home country \"(.*)\"$")
    public void select_country (String country) throws InterruptedException {
        regPage.selectCountry(country);
    }
    @And("Enters his Mobile number \"(.*)\"$")
    public void enter_mobileNumber (String phoneNumber) {
        regPage.enterPhoneNumber(phoneNumber);
    }
    @And("Enters his valid email \"(.*)\" in the email field$")
    public void enter_email (String email) {
        regPage.enterEmail(email);
    }
    @And("Enters his valid password \"(.*)\" in the password field$")
    public void enter_password (String password) {
        regPage.enterPassword(password);
    }

    @And("Close the browser")
    public void close_driver () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
