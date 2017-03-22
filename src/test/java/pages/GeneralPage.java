package pages;

import core.Key;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;
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

    /**
     * Set slider value, 0 - min value
     */
    protected void setSliderValue(MobileElement slider, int value){
        int startX = slider.getLocation().getX();
        int yAxis = slider.getLocation().getY();

        int moveToXDirection = value + startX;
        new TouchAction(appiumDriver)
                .longPress(startX, yAxis)
                .moveTo(moveToXDirection, yAxis)
                .release()
                .perform();
    }

    /**
     * Tap an element
     * @param element - element to tap
     */
    protected void tap(MobileElement element){
        new TouchAction(appiumDriver).tap(element).perform();
    }

    public static void scrollToElement(AndroidDriver driver, String elementName, boolean scrollDown) {
        String listID = ((RemoteWebElement) driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")")).getId();
        String direction;
        if (scrollDown) {
            direction = "down";
        } else {
            direction = "up";
        }
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        scrollObject.put("element", listID);
        scrollObject.put("text", elementName);
        driver.executeScript("mobile: scrollTo", scrollObject);
    }

    public MobileElement scrollToElementByName(String elementName, String listId) {
        MobileElement element = (MobileElement) ((AndroidDriver) appiumDriver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"" + listId + "\"))" +
                ".scrollIntoView(new UiSelector().text(\"" + elementName + "\"));");
        return element;
    }

    public void scrollToElement(String elementName) {
        while (appiumDriver.findElements(By.name(elementName)).size() == 0) {
            Dimension dimensions = appiumDriver.manage().window().getSize();
            Double screenHeightStart = dimensions.getHeight() * 0.5;
            int scrollStart = screenHeightStart.intValue();
            Double screenHeightEnd = dimensions.getHeight() * 0.2;
            int scrollEnd = screenHeightEnd.intValue();
            appiumDriver.swipe(0, scrollStart, 0, scrollEnd, 5000);
        }
    }
}
