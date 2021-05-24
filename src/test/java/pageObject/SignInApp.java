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

    @FindBy(id = "com.tesco.payqwiq.ppe:id/skipTextButton") //Skip on-boarding screens
    @CacheLookup
    WebElement clickSkip;

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

    @FindBy(id = "com.tesco.payqwiq.ppe:id/button") //Click on Pin saved screen
    @CacheLookup
    WebElement ClickPinSaved;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/negativeButton") //Ignore storeReminder
    @CacheLookup
    WebElement noStoreReminder;

    @FindBy(id = "android:id/button2") //Keep brightness as default
    @CacheLookup
    WebElement brightnessDefault;


    @FindBy(id = "com.tesco.payqwiq.ppe:id/addCardBtn") // Validate the Pay screen without cards
    @CacheLookup
    WebElement payScreenTitleText;


    //com.tesco.payqwiq.ppe:id/barcodeImageView
    //com.tesco.payqwiq.ppe:id/txtCardExpiresDate
    @FindBy(id="com.tesco.payqwiq.ppe:id/txtCardExpiresDate")// Validate the Pay screen with cards
    @CacheLookup
    WebElement payScreenCardText;

    public void launchApp() throws InterruptedException {
        clickAccept.click();
        allwLocation.click();
        waithelper.WaitForElement(clickSkip, 10);
        clickSkip.click();
        waithelper.WaitForElement(clickYesSignIn, 30);
        clickYesSignIn.click();
        waithelper.WaitForElement(signInPageTitleText, 30);
    }

    public void validateSignInTitle(String title){
        String title1=signInPageTitleText.getText();
        //System.out.println(title1);
        if (title.equals(title1)){
            System.out.println("**********Test Passed***********");
        }else {
            System.out.println("**********Test Failed***********");
        }

    }

    public void signIn(String email, String password) throws InterruptedException {
        emailText.clear();
        emailText.sendKeys(email);
        passwordText.click();
        passwordText.sendKeys(password);
        waithelper.WaitForElement(clickSubmit, 30);

    }

    public void submitSignIn() throws InterruptedException {
        clickSubmit.click();
    }

    public void setPin() throws InterruptedException {
        waithelper.WaitForElement(pin1, 30);
        pin1.click();
        pin2.click();
        pin3.click();
        pin4.click();
        Thread.sleep(2000);
        pin1.click();
        pin2.click();
        pin3.click();
        pin4.click();
        waithelper.WaitForElement(ClickPinSaved, 30);
        ClickPinSaved.click();
        waithelper.WaitForElement(noStoreReminder, 30);

    }

    public void storeReminderBrightness() throws InterruptedException {
        noStoreReminder.click();
        waithelper.WaitForElement(brightnessDefault, 30);
        brightnessDefault.click();
        Thread.sleep(3000); //Pay screen clubcard text propert id="com.tesco.payqwiq.ppe:id/view_clubcard_clubcard_name"
    }

    public void validatePayScreenTitle()
    {
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/addCardBtn").isEmpty()) {
            System.out.println("**********Wallet with Funding Cards***********");
        }
        else{
            System.out.println("**********Wallet with no funding Cards***********");

        }


        /*
        String title4=payScreenTitleText.getText();
        String title5=payScreenCardText.getText();
        System.out.println(title5);
        //System.out.println(title4);
        if(title3.equals(title4)){
            System.out.println("**********Wallet with no funding Cards***********");
        }else {
            System.out.println("**********Wallet with Funding Cards***********");
        }*/
    }


}
