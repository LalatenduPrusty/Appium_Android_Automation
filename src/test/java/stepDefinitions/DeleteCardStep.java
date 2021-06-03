package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.DeleteCard;

import java.net.MalformedURLException;
import java.net.URL;

public class DeleteCardStep extends BaseClass {

    //public DeleteCard remove;
    //public AndroidDriver<WebElement> driver;


    @Given("User install,launch and navigates to sign in screen")
    public void user_install_launch_and_navigates_to_sign_in_screen() throws MalformedURLException, InterruptedException
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
        remove = new DeleteCard(driver);

        remove.launchApp();


    }
    @Then("Enters Email as {string} and Password as {string} to sign in")
    public void enters_email_as_and_password_as_to_sign_in(String email, String password) throws InterruptedException
    {

        remove.signIn(email, password);

    }
    @Then("Navigates to My cards screen")
    public void navigates_to_my_cards_screen()
    {

        remove.navigateToMyCardsScreen();

    }
    @When("User selects any existing card to delete")
    public void user_selects_any_existing_card_to_delete()
    {

        remove.removeCard();

    }
    @Then("Card will be deleted from wallet and displayed with {string}")
    public void card_will_be_deleted_from_wallet_and_displayed_with(String string)
    {

        remove.removeCardConfirmation();

    }


}
