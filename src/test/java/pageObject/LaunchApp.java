package pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class LaunchApp
{

    public AndroidDriver<WebElement> ldriver;

    WaitHelper waithelper;

    public LaunchApp(AndroidDriver<WebElement> rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
        waithelper = new WaitHelper(ldriver);
    }


    @FindBy(id = "android:id/button1")
    @CacheLookup
    WebElement accept;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_always_button")
    @CacheLookup
    WebElement allwLocation;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/skipTextButton")
    @CacheLookup
    WebElement skip;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/buttonYes")
    @CacheLookup
    WebElement signIn;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/signInTitle")
    @CacheLookup
    WebElement pgTitle;


    public void installAgreement()
    {
        waithelper.WaitForElement(accept,10);
        accept.click();
    }

    public void alwaysAllowLocation()
    {
        waithelper.WaitForElement(allwLocation,10);
        allwLocation.click();
    }

    public void skipOnBoarding()
    {
        waithelper.WaitForElement(skip,10);
        skip.click();
    }

    public void yesSignIn()
    {
        waithelper.WaitForElement(signIn,10);
        signIn.click();
    }

    public void validateTitle(String title)
    {
        waithelper.WaitForElement(pgTitle,10);
        String title1 = pgTitle.getText();
        if (title.equals(title1))
        {

            System.out.println("Sign-in page is displayed");
            ldriver.quit();
        } else {
            System.out.println("Test Failed....");
        }
    }



}







