package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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
     * Tap Next button
     */
    public SettingsPage tapNextButton(){
        Log4Test.test("Tap Next button");
        tap(nextButton);
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
        tap(listTeams.get(teamNo - 1));
        return this;
    }
}
