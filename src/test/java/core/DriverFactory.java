package core;

import com.saucelabs.common.SauceOnDemandAuthentication;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory{
    private static final String USERNAME = "your_user_name";
    private static final String ACCESS_KEY = "your_access_key";
    private static SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME, ACCESS_KEY);

    public AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        caps.setCapability(MobileCapabilityType.APP, "sauce-storage:org.tasks.apk");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        caps.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.4");

        URL sauceURL = new URL("http://" + authentication.getUsername() + ":"+ authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub");
        return new AndroidDriver<MobileElement>(sauceURL, caps);
    }

}
