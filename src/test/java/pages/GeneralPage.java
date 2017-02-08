package pages;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by chv on 07.02.2017.
 *
 * General Page
 */
abstract class GeneralPage {

    protected WebDriver webDriver;

    public GeneralPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Press Back button on android device
     */
    public void pressBackButton() {
        sendKeyEvent(4);
    }

    /**
     * Send key event method, for pressing android keys
     */
    private void sendKeyEvent(int keycode) {
        ImmutableMap.Builder<String, Integer> builder = ImmutableMap.builder();
        builder.put("keycode", keycode);

        ImmutableMap<String, Integer> parameters = builder.build();
        RemoteWebDriver remoteDriver = (RemoteWebDriver) webDriver;
        Command command = new Command(remoteDriver.getSessionId(), "keyEvent", parameters);

        try {
            remoteDriver.getCommandExecutor().execute(command);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Tap with JavaScriptExecutor
     */
    protected void tapJs(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        HashMap<String, Integer> coords = new HashMap<String, Integer>();
        coords.put("x", element.getLocation().getX());
        coords.put("y", element.getLocation().getY());
        js.executeScript("mobile: tap", coords);
    }
}
