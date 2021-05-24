package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.LaunchApp;

import java.net.URL;

public class LaunchStep {

    public LaunchApp lp;
    public AndroidDriver<WebElement> driver;



    @Given("User installs Pay+ App")
    public void user_installs_pay_app() throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        dc.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+ "//apkFolder//pay+-ppe3-release (3).apk" );


        dc.setCapability("appPackage", "com.tesco.payqwiq.ppe");
        dc.setCapability("appActivity", "com.tesco.payqwiq.feature.launch.LaunchActivity");


        URL url = new URL("http://localhost:4723/wd/hub");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
        lp=new LaunchApp(driver);


    }
    @When("User clicks on install agreement")
    public void user_clicks_on_install_agreement() throws InterruptedException {
        lp.installAgreement();
        Thread.sleep(2000);

    }

    @When("User allows device location")
    public void user_allows_device_location() throws InterruptedException {
        lp.alwaysAllowLocation();
        Thread.sleep(8000);

    }

    @When("user cliks on sign in CTA")
    public void user_cliks_on_sign_in_cta() throws InterruptedException {
        lp.skipOnBoarding();
        Thread.sleep(2000);
        lp.yesSignIn();

    }

    @Then("Page Sign in page {string} displays")
    public void page_sign_in_page_displayes(String title)
    {

        lp.validateTitle(title);

    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String emailaddress, String password) throws InterruptedException {
        lp.setUserName(emailaddress);
        lp.setUserPassword(password);
        Thread.sleep(3000);
        lp.login();

    }

    @When("enter the PIN")
    public void enter_the_pin() throws InterruptedException {
        lp.enterPIN();


    }

    @When("confirm PIN")
    public void confirm_pin() throws InterruptedException {
        lp.confirmPIN();

    }

    @When("accepts on pin saved screen")
    public void accepts_on_pin_saved_screen() throws InterruptedException {
        lp.pinSavedConfirm();
        lp.storeReminderIgnore();
        lp.brightnessDefault();

    }

    @Then("Pay screen {string} should be displayed")
    public void pay_screen_should_be_displayed(String titlePay) throws InterruptedException {
        lp.validateTitle1(titlePay);
    }

    @Then("Close the app")
    public void close_the_app() {
        driver.quit();

    }


}
