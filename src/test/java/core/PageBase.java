package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Field;

public abstract class PageBase {

    public MobileElement getListView(){
        return driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")");
    }

    public AndroidDriver<MobileElement> driver;

    public PageBase(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }
}
