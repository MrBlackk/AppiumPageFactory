package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

    protected WebDriver webDriver;

    @BeforeClass
    protected void setUp() throws MalformedURLException {
        URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
        webDriver = new RemoteWebDriver(remoteAddress, createAppiumCapabilities());
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
        webDriver.quit();
    }
}
