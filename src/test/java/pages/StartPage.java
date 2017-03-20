package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import utils.Log4Test;

/**
 * Created by chv on 07.02.2017.
 *
 * Start Activity
 */
public class StartPage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/start_tvVersion")
    private MobileElement appVersion;
    @FindBy(id = "com.mrb.alias:id/start_btnNewGame")
    private MobileElement newGameButton;
    @FindBy(id = "com.mrb.alias:id/start_btnContinue")
    private MobileElement continueButton;

    public StartPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Get application version text
     */
    public String getAppVersion(){
        return appVersion.getText();
    }

    /**
     * Click New Game button
     */
    public TeamPage clickNewGameButton(){
        Log4Test.test("Click New Game button");
        newGameButton.click();
        return new TeamPage(appiumDriver);
    }

    /**
     * Tap New Game button with js
     */
    public TeamPage tapNewGameButton(){
        Log4Test.test("Tap js New Game button");
        tapJs(newGameButton);
        return new TeamPage(appiumDriver);
    }

    /**
     * Click Continue button
     */
    public ResultsPage clickContinueButton(){
        Log4Test.test("Click Continue button");
        continueButton.click();
        return new ResultsPage(appiumDriver);
    }
}
