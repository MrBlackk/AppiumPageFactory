package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Log4Test;

/**
 * Created by chv on 07.02.2017.
 *
 * Start Activity
 */
public class StartPage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/start_tvVersion")
    private WebElement appVersion;
    @FindBy(id = "com.mrb.alias:id/start_btnNewGame")
    private WebElement newGameButton;
    @FindBy(id = "com.mrb.alias:id/start_btnContinue")
    private WebElement continueButton;

    public StartPage(WebDriver webDriver) {
        super(webDriver);
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
        return new TeamPage(webDriver);
    }

    /**
     * Tap New Game button with js
     */
    public TeamPage tapNewGameButton(){
        Log4Test.test("Tap js New Game button");
        tapJs(newGameButton);
        return new TeamPage(webDriver);
    }

    /**
     * Click Continue button
     */
    public ResultsPage clickContinueButton(){
        Log4Test.test("Click Continue button");
        continueButton.click();
        return new ResultsPage(webDriver);
    }
}
