package pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchApp {

    public AndroidDriver<WebElement> ldriver;

    public LaunchApp(AndroidDriver<WebElement> rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
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

    @FindBy(id = "com.tesco.payqwiq.ppe:id/signInEmailField")
    @CacheLookup
    WebElement email;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/signInPasswordField")
    @CacheLookup
    WebElement pwd;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/signInButton")
    @CacheLookup
    WebElement submit;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/pinKeyboardKey1")
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

    @FindBy(id = "com.tesco.payqwiq.ppe:id/button")
    @CacheLookup
    WebElement pinDone;

    @FindBy(id = "com.tesco.payqwiq.ppe:id/negativeButton")
    @CacheLookup
    WebElement storeReminderNo;

    @FindBy(id = "android:id/button2")
    @CacheLookup
    WebElement brightnessDeflt;


    @FindBy(id = "b89e1585-8867-4d1c-80d4-1f71ae9d7704")
    @CacheLookup
    WebElement payScreenTitle;

    public void installAgreement(){
        accept.click();
    }

    public void alwaysAllowLocation(){
        allwLocation.click();
    }

    public void skipOnBoarding(){
        skip.click();
    }

    public void yesSignIn(){
        signIn.click();
    }

    public void setUserName (String emailaddress){
        email.clear();
        email.sendKeys(emailaddress);

    }

    public void setUserPassword (String password){
        pwd.click();
        pwd.sendKeys(password);

    }

    public void validateTitle(String title){
        String title1=pgTitle.getText();
        if (title.equals(title1)){
            System.out.println("Sign in page displayed");
        }else {
            System.out.println("Test Failed....");
        }

    }

    public void validateTitle1(String titlePay) throws InterruptedException {
        String title2=payScreenTitle.getText();
        if (titlePay.equals(title2)){
            System.out.println("Pay screen is displayed");
        }else {
            System.out.println("Test Failed....");
        }
        Thread.sleep(3000);

    }

    public void login() throws InterruptedException {
        submit.click();
        Thread.sleep(5000);
    }

    public void enterPIN() throws InterruptedException {
        pin1.click();
        pin2.click();
        pin3.click();
        pin4.click();
        Thread.sleep(1000);
    }

    public void confirmPIN() throws InterruptedException {
        pin1.click();
        pin2.click();
        pin3.click();
        pin4.click();
        Thread.sleep(3000);
    }

    public void pinSavedConfirm() throws InterruptedException {
        pinDone.click();
        Thread.sleep(2000);
    }

    public void storeReminderIgnore() throws InterruptedException{
        storeReminderNo.click();
        Thread.sleep(2000);
    }

    public void brightnessDefault() throws InterruptedException {
        brightnessDeflt.click();
        Thread.sleep(3000);
    }



}







