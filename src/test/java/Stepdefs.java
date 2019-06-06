import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Stepdefs { //ta nazwa jest ważna "Stepdefs" bo runner będzie jej szukał
    // w tej klasie szuka tego co jest zdefiniowane w contacts.feature

    AppiumDriver driver;

    ContactsMainPage contactsMainPage;
    ContactAlertsPage contactAlertsPage;
    ContactAddingPage contactAddingPage;


    @Before
    public void setUP() throws MalformedURLException {
        URL appiumServer = new URL("http://0.0.0.0:4723/wd/hub");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("deviceName","Nexus");
        caps.setCapability("appPackage","com.android.contacts");
        caps.setCapability("appActivity",".DialtactsContactsEntryActivity");

        driver = new AndroidDriver(appiumServer,caps); // mówimy że otwieramy nowe okno androida. Inicjalizacja strony
        contactsMainPage = new ContactsMainPage(driver); // Inicja;lizacja drovera .single caclulator page to jest nowa strona
        contactAlertsPage = new ContactAlertsPage(driver);
        contactAddingPage = new ContactAddingPage(driver);

    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Given("I am not logged in")
    public void i_am_not_logged_in() {
    }

    @When("I click add new contact button")
    public void i_click_add_new_contact_button() {
        contactsMainPage.addButton.click();
    }

    @Then("alert should be displayed")
    public void alert_should_be_displayed() {
        assert contactAlertsPage.googleAccountAlert.isDisplayed();
    }

    @Given("I am in the create new contact form")
    public void i_am_in_the_create_new_contact_form() {
    }

    @When("I dismiss alert")
    public void i_dismiss_alert() {
        contactAlertsPage.cancelButton.click();
    }

    @Then("Create ne contact from should be displayed")
    public void create_ne_contact_from_should_be_displayed() { assert  contactAddingPage.contactForm.isDisplayed();
    }



    @Given("I enter first name")
    public void i_enter_first_name() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(contactsMainPage.addButton));
        contactsMainPage.addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(contactAlertsPage.cancelButton));
        contactAlertsPage.cancelButton.click();
        wait.until(ExpectedConditions.visibilityOf(contactAddingPage.firstName));
        contactAddingPage.firstName.click();
        contactAddingPage.firstName.sendKeys("Bogdan");
    }

    @When("I discard creating contact")
    public void i_discard_creating_contact() {

        contactAddingPage.discardButton.click();
    }

    @Then("Discard alert should be displayed")
    public void discard_alert_should_be_displayed() {
    assert contactAlertsPage.contactDiscardAlert.isDisplayed();
    }

}
