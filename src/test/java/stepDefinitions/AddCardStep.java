package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.AddCard;

import java.net.MalformedURLException;
import java.net.URL;

public class AddCardStep {

    public AddCard ap;
    public AndroidDriver<WebElement> driver;

    @Given("User launch and sign in to Pay+ app")
    public void user_launch_and_sign_in_to_pay_app() throws MalformedURLException, InterruptedException
    {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        dc.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+ "//apkFolder//pay+-ppe3-release (3).apk" );

        dc.setCapability("appPackage", "com.tesco.payqwiq.ppe");
        dc.setCapability("appActivity", "com.tesco.payqwiq.feature.launch.LaunchActivity");


        URL url = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<WebElement>(url, dc);
        ap = new AddCard(driver);

        ap.launchApp();

    }

    @Then("User enters Email as {string} and Password as {string} to sign in")
    public void user_enters_email_as_and_password_as_to_sign_in(String email, String password) throws InterruptedException
    {

        ap.signIn(email, password);
        ap.submitSignIn();
        ap.setPin();
        ap.storeReminderBrightness();

    }

    @Then("Initiates the BountyAdd card screen either from Pay or from my cards screen.")
    public void initiates_the_bounty_add_card_screen_either_from_pay_or_from_my_cards_screen() throws InterruptedException
    {
        ap.validateOriginOfInvokingBountyAddCard();

    }

    @When("Enter all card details and click on save CTA")
    public void enter_all_card_details_and_click_on_save_cta()
    {
        ap.addCard();

    }

    @Then("Card will be added successfully")
    public void card_will_be_added_successfully()
    {

        ap.cardAddedSuccess();

    }

    @Then("Added card should be reflected successfully.")
    public void added_card_should_be_reflected_successfully()
    {

        ap.verifyTheAddedCard();
        driver.quit();

    }

}
