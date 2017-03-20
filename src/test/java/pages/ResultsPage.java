package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import utils.Log4Test;

import java.util.List;

/**
 * Created by chv on 07.02.2017.
 *
 * Results Activity
 */
public class ResultsPage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/results_btnStart")
    private MobileElement startButton;
    @FindBy(id = "com.mrb.alias:id/team_adapter_tvName")
    private List<MobileElement> listTeams;

    public ResultsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Click Start button
     */
    public GamePage clickStartButton(){
        Log4Test.test("Click Start Button");
        startButton.click();
        return new GamePage(appiumDriver);
    }

    /**
     * Get Team names on Results page
     */
    public String getTeamNames() {
        return listTeams.get(0).getText() + ", " + listTeams.get(1).getText();
    }
}
