package pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class SignInApp {

    public AndroidDriver<WebElement> ldriver;

    WaitHelper waithelper;

    public SignInApp(AndroidDriver<WebElement> rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
        waithelper = new WaitHelper(ldriver);
    }

    @FindBy(id = "android:id/button1")//Accept install agreement policy
    @CacheLookup
    WebElement clickAccept;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_always_button") //Allow Location Prompt
    @CacheLookup
    WebElement allwLocation;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/welcomeTitle") // OnBoarding text
    @CacheLookup
    WebElement txtOnBoarding;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/skipTextButton") //Skip on-boarding screens
    @CacheLookup
    WebElement clickSkip;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/pre_signin_title") // Pre-sign in screen text
    @CacheLookup
    WebElement txtPreSignInScreen;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/buttonYes") //Yes to sign in flow
    @CacheLookup
    WebElement clickYesSignIn;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/signInTitle") // Validate Sign in page text
    @CacheLookup
    WebElement signInPageTitleText;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/signInEmailField") // Email address
    @CacheLookup
    WebElement emailText;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/signInPasswordField") // Password
    @CacheLookup
    WebElement passwordText;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/signInButton") // Click on sign in CTA
    @CacheLookup
    WebElement clickSubmit;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/pinKeyboardKey1") //Enter 4 digit PIN
    @CacheLookup
    WebElement pin1;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/pinKeyboardKey2")
    @CacheLookup
    WebElement pin2;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/pinKeyboardKey3")
    @CacheLookup
    WebElement pin3;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/pinKeyboardKey4")
    @CacheLookup
    WebElement pin4;

    @FindBy (id = "com.tesco.payqwiq.ppe:id/heading") // Pin Saved text
    @CacheLookup
    WebElement txtPinSavedScreen;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/button") //Click on Pin saved screen
    @CacheLookup
    WebElement ClickPinSaved;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/negativeButton") //Ignore storeReminder
    @CacheLookup
    WebElement noStoreReminder;

    @FindBy(id = "android:id/button2") //Keep brightness as default
    @CacheLookup
    WebElement brightnessDefault;

    //PayScreen after card got addedd
    @FindBy(id="com.tesco.payqwiq.ppe:id/txtCardExpiresDate")// Validate the Pay screen with cards
    @CacheLookup
    WebElement payScreenCardText;


    public void launchApp() throws InterruptedException
    {
        waithelper.WaitForElement(clickAccept,10);
        clickAccept.click();
        waithelper.WaitForElement(allwLocation,10);
        allwLocation.click();
        waithelper.WaitForElement(clickSkip, 10);

        //Validation of On-boarding screen
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/welcomeTitle").isEmpty())
        {
            System.out.println("****App is failed to initialise****");
        } else {
            System.out.println("****App is initialised successfully****");
            clickSkip.click();
        }

        waithelper.WaitForElement(clickYesSignIn, 30);

        //Validation of Prep sign in screen
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/pre_signin_title").isEmpty())
        {
            System.out.println("****Pre-sign page not displayed****");
        }else {
            System.out.println("*****Pre-sign in page displayed*****");
            clickYesSignIn.click();
        }
        waithelper.WaitForElement(signInPageTitleText, 30);
    }

    public void validateSignInTitle(String title)
    {
        String title1=signInPageTitleText.getText();
        if (title.equals(title1)){
            System.out.println("**********Sign-in Page displayed***********");
        }else {
            System.out.println("**********Failed to display Sign-in Page***********");
        }

    }

    public void signIn(String email, String password)
    {
        emailText.clear();
        emailText.sendKeys(email);
        passwordText.click();
        passwordText.sendKeys(password);
        waithelper.WaitForElement(clickSubmit, 30);

    }

    public void submitSignIn()
    {
        clickSubmit.click();
    }

    public void setPin()
    {
        waithelper.WaitForElement(pin1, 30);
        pin1.click();
        pin2.click();
        pin3.click();
        pin4.click();
        //Thread.sleep(2000);
        waithelper.WaitForElement(pin1, 30);
        pin1.click();
        pin2.click();
        pin3.click();
        pin4.click();
        waithelper.WaitForElement(ClickPinSaved, 30);
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/heading").isEmpty()) {
            System.out.println("****Pin Saved screen not displayed");
        } else {
            System.out.println("****Pin Saved screen displayed****");
            ClickPinSaved.click();
        }

        waithelper.WaitForElement(noStoreReminder, 30);

    }

    public void storeReminderBrightness() throws InterruptedException
    {
        noStoreReminder.click();
        waithelper.WaitForElement(brightnessDefault, 30);
        brightnessDefault.click();
        Thread.sleep(3000); //Pay screen clubcard text propert id="com.tesco.payqwiq.ppe:id/view_clubcard_clubcard_name"
    }

    public void validatePayScreenTitle()
    {
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/addCardBtn").isEmpty())
        {
            System.out.println("**********Wallet with Funding Cards***********");
        }
        else{
            System.out.println("**********Wallet with no funding Cards***********");
        }

    }

    public void closeApp()
    {
        ldriver.quit();
    }


}
