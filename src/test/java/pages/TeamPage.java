package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.FindBy;
import utils.Log4Test;

import java.util.List;

/**
 * Created by chv on 07.02.2017.
 *
 * Team Activity
 */
public class TeamPage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/team_btnNext")
    private MobileElement nextButton;
    @FindBy(id = "com.mrb.alias:id/team_adapter_tvName")
    private List<MobileElement> listTeams;

    public TeamPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Click Next button
     */
    public SettingsPage clickNextButton(){
        Log4Test.test("Click Next button");
        nextButton.click();
        return new SettingsPage(appiumDriver);
    }

    /**
     * Get Team names on Team page
     */
    public String getTeamNames() {
        return listTeams.get(0).getText() + ", " + listTeams.get(1).getText();
    }

    /**
     * Tap teamNo team on screen
     */
    public TeamPage tapTeamNo(int teamNo) {
        Log4Test.test("Tap team No" + teamNo);
        new TouchAction(appiumDriver).tap(listTeams.get(teamNo - 1)).perform();
        return this;
    }
}
