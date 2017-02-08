package core;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.HttpMethod;
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

        ImmutableMap.Builder<String, CommandInfo> builder = ImmutableMap.builder();
        CommandInfo cmd = new CommandInfo("/session/:sessionId/appium/device/keyevent", HttpMethod.POST);
        builder.put("keyEvent", cmd);
        ImmutableMap<String, CommandInfo> mobileCommands = builder.build();
        HttpCommandExecutor mobileExecutor = new HttpCommandExecutor(mobileCommands, remoteAddress);

        webDriver = new RemoteWebDriver(mobileExecutor, createAppiumCapabilities());
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
