import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class ExampleAndroidAppAutomation {

    public static void main(String[] args) throws Exception
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

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);


    }




}
