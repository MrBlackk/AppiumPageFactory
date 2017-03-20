package pages;

import core.Key;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Log4Test;

import java.util.HashMap;

/**
 * Created by chv on 07.02.2017.
 *
 * General Page
 */
abstract class GeneralPage {

    protected AppiumDriver appiumDriver;

    public GeneralPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    /**
     * Press Back button on android device
     */
    public void pressBackButton() {
        Log4Test.test("Press Back button");
        sendKeyEvent(Key.BACK_BUTTON);
    }

    /**
     * Press button from Key enum
     */
    protected void pressButton(Key key) {
        Log4Test.test("Press " + key + " button");
        sendKeyEvent(key);
    }

    /**
     * Send key event method, for pressing android keys
     */
    private void sendKeyEvent(Key key) {
        ((AndroidDriver) appiumDriver).pressKeyCode(key.getValue());
    }

    /**
     * Tap with JavaScriptExecutor
     */
    protected void tapJs(MobileElement element){
        HashMap<String, Integer> coords = new HashMap<String, Integer>();
        coords.put("x", element.getLocation().getX());
        coords.put("y", element.getLocation().getY());
        appiumDriver.executeScript("mobile: tap", coords);
    }
}
