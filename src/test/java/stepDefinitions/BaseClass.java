package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import pageObject.AddCard;
import pageObject.DeleteCard;
import pageObject.LaunchApp;
import pageObject.SignInApp;


public class BaseClass {

    public static Logger logger;
    public AndroidDriver<WebElement> driver;
    public LaunchApp launch;
    public SignInApp login;
    public AddCard add;
    public DeleteCard remove;
}
