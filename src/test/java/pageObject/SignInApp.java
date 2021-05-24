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


    @FindBy(id = "com.tesco.payqwiq.ppe:id/addCardBtn") // Validate the Pay screen without cards
    @CacheLookup
    WebElement payScreenTitleText;


    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Setting displayed\"]") // Hamburger Menu
    @CacheLookup
    WebElement hamBurgerMenu;

    @FindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"action_cards\"]/android.widget.CheckedTextView")
    @CacheLookup
    WebElement myCardsMenu;

    @FindBy(id="com.android.permissioncontroller:id/permission_deny_button") //Deny the Camera Prompt on BountyScreen
    @CacheLookup
    WebElement denyCameraOptionAddCardScreen;

    //BountyAddCard Screen Field

    //CardNumber
    @FindBy(id = "com.tesco.payqwiq.ppe:id/card_number_edit")
    @CacheLookup
    WebElement txtCardNumber;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/card_expiry_edit")
    @CacheLookup
    WebElement txtExpiryDate;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/card_cvv_edit")
    @CacheLookup
    WebElement txtCVV;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/card_name_edit")
    @CacheLookup
    WebElement txtCardHolderName;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/card_postcode_edit")
    @CacheLookup
    WebElement txtPostCode;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/card_nickname_edit")
    @CacheLookup
    WebElement txtCardNickName;

    //Something went wrong screen
    @FindBy(id ="com.tesco.payqwiq.ppe:id/cardAddedTitle")
    @CacheLookup
    WebElement smWrngScreen;

    //Clik on 'add a new card'
    @FindBy(id="com.tesco.payqwiq.ppe:id/buttonAddCard")
    @CacheLookup
    WebElement addNewCard;

    //Click on "I'll do it later"
    @FindBy(id="com.tesco.payqwiq.ppe:id/buttonDoitLater")
    @CacheLookup
    WebElement doItLater;

    //Successful added card screen
    @FindBy(id="com.tesco.payqwiq.ppe:id/cardAddedTitle")
    @CacheLookup
    WebElement txtcardAddedScreen;

    //Next button on card addedd screen
    @FindBy(id="com.tesco.payqwiq.ppe:id/buttonDoneSuccess")
    @CacheLookup
    WebElement btnNext;

    //Animation screen
    @FindBy(id="com.tesco.payqwiq.ppe:id/buttonDone")
    @CacheLookup
    WebElement btnGotIt;

    //PayScreen after card got addedd
    @FindBy(id="com.tesco.payqwiq.ppe:id/txtCardExpiresDate")// Validate the Pay screen with cards
    @CacheLookup
    WebElement payScreenCardText;


    public void launchApp() throws InterruptedException {
        clickAccept.click();
        allwLocation.click();
        waithelper.WaitForElement(clickSkip, 10);

        //Validation of On-boarding screen
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/welcomeTitle").isEmpty()) {
            System.out.println("****App is failed to intialise****");
        } else {
            System.out.println("****App is initialised successfully****");
            clickSkip.click();
        }

        waithelper.WaitForElement(clickYesSignIn, 30);

        //Validation of Prep sign in screen
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/pre_signin_title").isEmpty()) {
            System.out.println("****Pre-sign page not displayed****");
        }else {
            System.out.println("*****Pre-sign in page displayed*****");
            clickYesSignIn.click();
        }
        waithelper.WaitForElement(signInPageTitleText, 30);
    }

    public void validateSignInTitle(String title){
        String title1=signInPageTitleText.getText();
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
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/heading").isEmpty()) {
            System.out.println("****Pin Saved screen not displayed");
        } else {
            System.out.println("****Pin Saved screen displayed****");
            ClickPinSaved.click();
        }

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

    }


}
