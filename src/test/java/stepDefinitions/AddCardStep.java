package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.AddCard;

import java.net.MalformedURLException;
import java.net.URL;

public class AddCardStep extends BaseClass {

    //public AddCard add;
    //public AndroidDriver<WebElement> driver;

    @Given("User launch and sign in to Pay+ app")
    public void user_launch_and_sign_in_to_pay_app() throws MalformedURLException, InterruptedException
    {

        // Added logger to the project
        logger= Logger.getLogger("PayPlusProject");
        PropertyConfigurator.configure("log4j.properties");

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
        add = new AddCard(driver);
        logger.info("****App launched successfully****");
        add.launchApp();

    }

    @Then("User enters Email as {string} and Password as {string} to sign in")
    public void user_enters_email_as_and_password_as_to_sign_in(String email, String password) throws InterruptedException
    {
        logger.info("****Login is successful****");
        add.signIn(email, password);
        add.submitSignIn();
        add.setPin();
        add.storeReminderBrightness();

    }

    @Then("Initiates the BountyAdd card screen either from Pay or from my cards screen.")
    public void initiates_the_bounty_add_card_screen_either_from_pay_or_from_my_cards_screen() throws InterruptedException
    {
        logger.info("****Invoking Bounty Add Card****");
        add.validateOriginOfInvokingBountyAddCard();

    }

    @When("Enter all card details and click on save CTA")
    public void enter_all_card_details_and_click_on_save_cta()
    {
        logger.info("****Card details saved successfully****");
        add.addCard();

    }

    @Then("Card will be added successfully")
    public void card_will_be_added_successfully()
    {
        logger.info("****Card added successfully****");
        add.cardAddedSuccess();

    }

    @Then("Added card should be reflected successfully.")
    public void added_card_should_be_reflected_successfully()
    {
        logger.info("****Added card displayed into the wallet****");
        add.verifyTheAddedCard();
        driver.quit();

    }

}
