package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chv on 07.02.2017.
 *
 * Test base class
 */
public abstract class TestBase {

    protected AppiumDriver<MobileElement> appiumDriver;

    @BeforeClass
    protected void setUp() throws MalformedURLException {
        URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");

        appiumDriver = new AndroidDriver<MobileElement>(remoteAddress, createAppiumCapabilities());
    }

    /**
     * Create Appium DesiredCapabilities
     */
    private DesiredCapabilities createAppiumCapabilities (){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", new File(
                "app/app-debug-0.5.10.apk").getAbsolutePath());
        capabilities.setCapability(CapabilityType.VERSION, 4.4);
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "android");
        capabilities.setCapability("newCommandTimeout", 200);
        capabilities.setCapability("appWaitActivity",
                "com.mrb.alias.start.StartActivity");
        return capabilities;
    }

    @AfterClass
    protected void tearDown(){
        appiumDriver.quit();
    }
}
