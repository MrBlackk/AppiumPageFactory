package core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by chv on 10.02.2017.
 * SwipeableDriver to use TouchActions
 */
public class SwipeableDriver extends RemoteWebDriver implements HasTouchScreen, HasInputDevices {

    private RemoteTouchScreen touch;

    public SwipeableDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }

    public SwipeableDriver(CommandExecutor executor, Capabilities desiredCapabilities) {
        super(executor, desiredCapabilities);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }

    @Override
    public TouchScreen getTouch() {
        return touch;
    }
}
