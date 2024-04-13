package stepDefinition;

import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class RegistrationStepDefinition {

    WebDriver driver = null;
    RegistrationPage regPage;
    SoftAssert soft ;
    String firstName;

    @Given("The user opens the browser")
    public void init_driver (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        regPage = new RegistrationPage(driver);
        soft = new SoftAssert();
    }
    @And("Navigates to the site \"(.*)\"$")
    public void siteNavigation (String website) {
        driver.navigate().to(website);
        driver.manage().window().maximize();
        String currentWebsite = driver.getCurrentUrl();
        Assert.assertTrue(currentWebsite.contains(website),"Website isn't right");
    }

    @When("The user enters his first name \"(.*)\" in the first name field$")
    public void enter_firstName (String firstName) {
        regPage.enterFirstName(firstName);
        this.firstName = firstName;
        // Check whether the first name starts with a capital letter or not
        soft.assertTrue(Character.isUpperCase(firstName.charAt(0)) ,
                "==> The first name doesn't start with a capital letter");
    }
    @And("enters his Last name \"(.*)\" in the last name field$")
    public void enter_lastName (String lastName){
        regPage.enterLastName(lastName);

        // Check whether the first name starts with a capital letter or not
        soft.assertTrue(Character.isUpperCase(lastName.charAt(0)) ,
                "==> The last name doesn't start with a capital letter");

        // Check whether the last name is different from the first name
        soft.assertTrue(!this.firstName.equals(lastName),
                "==> Last name is the same as the first name");
    }
    @And("Picks his home country \"(.*)\"$")
    public void select_country (String country) {
        regPage.selectCountry(country);
    }
    @And("Enters his Mobile number \"(.*)\"$")
    public void enter_mobileNumber (String phoneNumber) {
        regPage.enterPhoneNumber(phoneNumber);

        //Check whether the phone number consists of 11 numbers
        soft.assertTrue(phoneNumber.length()==11,
                "==> Phone number is invalid");
    }
    @And("Enters his valid email \"(.*)\" in the email field$")
    public void enter_email (String email) {
        regPage.enterEmail(email);
    }
    @And("Enters his valid password \"(.*)\" in the password field$")
    public void enter_password (String password) {
        regPage.enterPassword(password);

        //Check whether the phone number consists of 11 numbers
        soft.assertTrue(password.length()==8,
                "==> The password does not consist of 8 characters");

        //Check whether the password contains both upper and lower case characters
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        char temp;

        for (int i = 0; i<password.length(); i++){
            temp = password.charAt(i);
            if (Character.isUpperCase(temp)){
               uppercaseCount ++;
            }
            if (Character.isLowerCase(temp)){
                lowercaseCount ++;
            }
        }

        soft.assertTrue(uppercaseCount>0,
                "==> Password does not contain uppercase characters");
        soft.assertTrue(lowercaseCount>0,
                "==> Password does not contain lowercase characters");
    }
    @And("Check the captcha box")
    public void click_captcha () {
        regPage.clickCaptcha();
    }
    @And("Press the Signup button")
    public void click_signup () {
        regPage.clickSignup();
    }

    @Then("User should see a success msg \"(.*)\"$")
    public void check_msg (String message) {
        System.out.println("Captured text is "+regPage.getSuccessMessage());
        soft.assertTrue(regPage.getSuccessMessage().contains(message),
                "==> Success message isn't displayed");
    }
    @Then("User should see a error msg \"(.*)\"$")
    public void check_error_msg (String message) {
        System.out.println("Captured text is "+ regPage.getErrorMessage());
        soft.assertTrue(regPage.getErrorMessage().contains(message) ,
                "==> Error message isn't displayed");
    }
    @And("Close the browser")
    public void close_driver () throws InterruptedException {
        Thread.sleep(2000);

        driver.quit();
        soft.assertAll();
    }

}
