package pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class DeleteCard {


    public AndroidDriver<WebElement> ldriver;

    WaitHelper waithelper;

    public DeleteCard(AndroidDriver<WebElement> rdriver)
    {
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

    @FindBy(id="com.tesco.payqwiq.ppe:id/snackbar_text")
    @CacheLookup
    WebElement errorSnackbarMesasgeSignInScreen;

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

    @FindBy(id = "android:id/message")
    @CacheLookup
    WebElement errorPopUpAfterPin;

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

    //My cards option from menu section
    @FindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"action_cards\"]/android.widget.CheckedTextView")
    @CacheLookup
    WebElement myCardsMenu;

    //My cards screen text validation when no cards into the wallet "Add debit or credit card"
    @FindBy(id = "com.tesco.payqwiq.ppe:id/card_list_add_card_title")
    @CacheLookup
    WebElement txtMyCards;

    //Add card button from My cards screen when no cards present
    @FindBy(id = "com.tesco.payqwiq.ppe:id/cardListAddCardButton")
    @CacheLookup
    WebElement btnAddCardMyCards;

    //Added Card under My cards csreen
    @FindBy(id = "com.tesco.payqwiq.ppe:id/card_details_layout")
    @CacheLookup
    WebElement txtFundingCarsMyCards;

    //remove card symbol
    @FindBy(id="com.tesco.payqwiq.ppe:id/remove_card")
    @CacheLookup
    WebElement btnRemoveCardSymbol;

    //remove card confirmation popup 'remove' button
    @FindBy(id="android:id/button1")
    @CacheLookup
    WebElement btnRemoveCardYes;

    //remove card confirmation popup 'cancel' button
    @FindBy(id="android:id/button2")
    @CacheLookup
    WebElement btnRemoveCardCancel;





    public void launchApp() throws InterruptedException
    {
        clickAccept.click();
        waithelper.WaitForElement(allwLocation, 10);
        allwLocation.click();
        waithelper.WaitForElement(clickSkip, 20);

        //Validation of On-boarding screen
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/welcomeTitle").isEmpty()) {
            System.out.println("****App is failed to initialize****");
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
        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/signInTitle").isEmpty()) { //does not exist
            System.out.println("****Sign in page is not displayed****");
        }else {
            System.out.println("****Sign in page is displayed successfully****");
        }
    }

    public void signIn(String email, String password) throws InterruptedException
    {
        emailText.clear();
        emailText.sendKeys(email);
        passwordText.click();
        passwordText.sendKeys(password);
        waithelper.WaitForElement(clickSubmit, 30);
        clickSubmit.click();
        //Validation whether user able to pass correct credentials

        if(ldriver.findElementsById("com.tesco.payqwiq.ppe:id/snackbar_text").isEmpty()) {
            System.out.println("*****Able to submit user credentials****");

        }else {
            System.out.println("*****Unable to submit user credentials*****");
            ldriver.quit();
        }

        //Set the PIN
        waithelper.WaitForElement(pin1, 30);
        pin1.click();
        pin2.click();
        pin3.click();
        pin4.click();
        waithelper.WaitForElement(pin1, 20);
        //Thread.sleep(6000);
        pin1.click();
        pin2.click();
        pin3.click();
        pin4.click();
        //Thread.sleep(2000);
        waithelper.WaitForElement(ClickPinSaved, 30);
        if (ldriver.findElementsById("android:id/button1").isEmpty()) {

            //Validation of displaying PIN saved screen

            if (ldriver.findElementsById("com.tesco.payqwiq.ppe:id/heading").isEmpty()) {
                System.out.println("****Pin Saved screen not displayed****");

            } else {
                System.out.println("****Pin Saved screen displayed****");
                ClickPinSaved.click();
                waithelper.WaitForElement(noStoreReminder, 30);
            }
        } else {
            System.out.println("****Error popup****");
            ldriver.quit();
        }

        //Handling Store reminder and default brightness
        noStoreReminder.click();
        waithelper.WaitForElement(brightnessDefault, 30);
        brightnessDefault.click();
        System.out.println("****Successfully navigates to Pay screen****");
        Thread.sleep(3000);

        //Validation whether the wallet having cards or not
        if (ldriver.findElementsById("com.tesco.payqwiq.ppe:id/addCardBtn").isEmpty())
        {
            System.out.println("**********Wallet with Funding Card(s)***********");

        } else {
            System.out.println("****Wallet with no funding Cards****");
            ldriver.quit();
        }

    }

    public void navigateToMyCardsScreen ()
    {

        waithelper.WaitForElement(hamBurgerMenu, 20);
        hamBurgerMenu.click();
        waithelper.WaitForElement(myCardsMenu, 20);
        myCardsMenu.click();
        waithelper.WaitForElement(btnAddCardMyCards, 20);
    }

    public void removeCard()
    {
        txtFundingCarsMyCards.click();
        waithelper.WaitForElement(btnRemoveCardSymbol,20);
        btnRemoveCardSymbol.click();
        btnRemoveCardYes.click();

    }

    public void removeCardConfirmation()
    {
        waithelper.WaitForElement(txtMyCards,10);
        if(ldriver.findElementById("com.tesco.payqwiq.ppe:id/card_list_add_card_title").getText()=="Add debit or credit card")
        {
            System.out.println("***Card deleted successfully****");
            ldriver.quit();
        }else
        {
            System.out.println("****Remove Card Failed****");
            ldriver.quit();
        }
    }



}
