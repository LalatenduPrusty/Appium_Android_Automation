package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.SignInApp;
import java.net.MalformedURLException;
import java.net.URL;

public class SignInStep {

    public SignInApp lp;
    public AndroidDriver<WebElement> driver;



    @Given("User installs Pay+ App and on sign in screen")
    public void user_installs_pay_app_and_on_sign_in_screen() throws MalformedURLException, InterruptedException {

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
        lp=new SignInApp(driver);

        lp.launchApp();

    }
    @Then("Page title should be {string} displayed")
    public void page_title_should_be_displayed(String title) {
        lp.validateSignInTitle(title);


    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
        lp.signIn(email,password);

    }
    @When("Clicks on Sign in button")
    public void clicks_on_sign_in_button() throws InterruptedException {
        lp.submitSignIn();

    }
    @When("set the PIN")
    public void set_the_pin() throws InterruptedException {
        lp.setPin();

    }
    @When("Ignore the store reminder and keep brightness as default")
    public void ignore_the_store_reminder_and_keep_brightness_as_default() throws InterruptedException {
        lp.storeReminderBrightness();

    }
    @Then("Pay screen should be displayed")
    public void pay_screen_should_be_displayed_as_text_as() {
        lp.validatePayScreenTitle();

    }
    @Then("Close the browser.")
    public void close_the_browser() {
        driver.closeApp();

    }



}
