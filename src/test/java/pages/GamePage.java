package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import utils.Log4Test;

/**
 * Created by chv on 07.02.2017.
 *
 * Game Activity
 */
public class GamePage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/game_tvWord")
    private MobileElement word;

    @FindBy(id = "com.mrb.alias:id/game_btnPlus")
    private MobileElement plusButton;

    @FindBy(id = "com.mrb.alias:id/game_btnMinus")
    private MobileElement minusButton;

    public GamePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Check that word is displayed
     */
    public boolean isWordDisplayed(){
        return word.isDisplayed();
    }

    /**
     * Get current word from screen
     */
    public String getCurrentWord(){
        return word.getText();
    }

    /**
     * Tap Plus Button
     */
    public void tapPlusButton(){
        Log4Test.test("Tap Plus button");
        tap(plusButton);
    }
}
