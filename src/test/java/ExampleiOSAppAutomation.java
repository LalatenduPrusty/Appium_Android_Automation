import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class ExampleiOSAppAutomation {


    public static void main(String[] args) throws Exception
    {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 12");
        //dc.setCapability("bundleId","com.apple.calculator");
        dc.setCapability(MobileCapabilityType.APP,"/Users/lalatenduprusty/Library/Developer/Xcode/DerivedData/UIKitCatalog-hjlwvypgpjgpisawiilferafqmne/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");

        URL url = new URL("http://localhost:4723/wd/hub");

        IOSDriver driver = new IOSDriver(url, dc);
    }

}
