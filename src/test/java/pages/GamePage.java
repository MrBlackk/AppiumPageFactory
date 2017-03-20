package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 07.02.2017.
 *
 * Game Activity
 */
public class GamePage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/game_tvWord")
    private MobileElement word;

    public GamePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Check that word is displayed
     */
    public boolean isWordDisplayed(){
        return word.isDisplayed();
    }
}
