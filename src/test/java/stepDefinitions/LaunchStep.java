package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.LaunchApp;

import java.net.URL;

public class LaunchStep extends BaseClass
{

    @Given("User installs Pay+ App")
    public void user_installs_pay_app() throws Exception {

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

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
        logger.info("****Initiate Android Driver****");
        launch=new LaunchApp(driver);


    }
    @When("User clicks on install agreement")
    public void user_clicks_on_install_agreement() throws InterruptedException
    {
        logger.info("****Install the Privacy Agreement****");
        launch.installAgreement();

    }

    @When("User allows device location")
    public void user_allows_device_location() throws InterruptedException
    {
        logger.info("****Allowing LocationPrompt****");
        launch.alwaysAllowLocation();

    }

    @When("user clicks on sign in CTA")
    public void user_clicks_on_sign_in_cta() throws InterruptedException
    {
        logger.info("****Skipping On-boarding screens****");
        launch.skipOnBoarding();
        logger.info("****Click to display Sign in screen****");
        launch.yesSignIn();

    }

    @Then("Page Sign in page {string} displays")
    public void page_sign_in_page_displayes(String title)
    {
        logger.info("****Verifying the sign in page****");
        launch.validateTitle(title);

    }


}
