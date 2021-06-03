package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.SignInApp;
import java.net.MalformedURLException;
import java.net.URL;

public class SignInStep extends BaseClass {

    //public SignInApp login;
    //public AndroidDriver<WebElement> driver;



    @Given("User installs Pay+ App and on sign in screen")
    public void user_installs_pay_app_and_on_sign_in_screen() throws MalformedURLException, InterruptedException
    {
        // Added logger to the project
        logger= Logger.getLogger("PayPlusProject");
        PropertyConfigurator.configure("log4j.properties");

        //File f = new File("src");
        //File fs = new File(f,"pay+-ppe3-release (3).apk");

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        dc.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+ "//apkFolder//pay+-ppe3-release (3).apk" );
        //dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());


        dc.setCapability("appPackage", "com.tesco.payqwiq.ppe");
        dc.setCapability("appActivity", "com.tesco.payqwiq.feature.launch.LaunchActivity");


        URL url = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<WebElement>(url,dc);
        login=new SignInApp(driver);

        logger.info("****App launched successfully****");
        login.launchApp();

    }
    @Then("Page title should be {string} displayed")
    public void page_title_should_be_displayed(String title)
    {
        logger.info("****Sign-in page displayed****");
        login.validateSignInTitle(title);


    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException
    {
        logger.info("****Provided wallet details****");
        login.signIn(email,password);

    }
    @When("Clicks on Sign in button")
    public void clicks_on_sign_in_button() throws InterruptedException
    {
        logger.info("****Clicked on sign in button****");
        login.submitSignIn();

    }
    @When("set the PIN")
    public void set_the_pin() throws InterruptedException
    {
        logger.info("****Set the PIN****");
        login.setPin();

    }
    @When("Ignore the store reminder and keep brightness as default")
    public void ignore_the_store_reminder_and_keep_brightness_as_default() throws InterruptedException
    {
        logger.info("****Acknowledged Reminder and brightness prompts ****");
        login.storeReminderBrightness();

    }
    @Then("Pay screen should be displayed")
    public void pay_screen_should_be_displayed_as_text_as()
    {
        logger.info("****Pay screen validated successfully****");
        login.validatePayScreenTitle();

    }
    @Then("Close the browser.")
    public void close_the_browser()
    {
        logger.info("****Quit the driver****");
        login.closeApp();

    }



}
