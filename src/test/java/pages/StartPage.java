package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        newGameButton.click();
        return new TeamPage(webDriver);
    }

    /**
     * Tap New Game button with js
     */
    public TeamPage tapNewGameButton(){
        tapJs(newGameButton);
        return new TeamPage(webDriver);
    }

    /**
     * Click Continue button
     */
    public ResultsPage clickContinueButton(){
        continueButton.click();
        return new ResultsPage(webDriver);
    }
}
