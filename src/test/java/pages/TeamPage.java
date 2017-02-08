package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * Created by chv on 07.02.2017.
 *
 * Team Activity
 */
public class TeamPage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/team_btnNext")
    private WebElement nextButton;
    @FindBy(id = "com.mrb.alias:id/team_adapter_tvName")
    private List<WebElement> listTeams;

    public TeamPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click Next button
     */
    public SettingsPage clickNextButton(){
        nextButton.click();
        return new SettingsPage(webDriver);
    }

    /**
     * Get Team names on Team page
     */
    public String getTeamNames() {
        return listTeams.get(0).getText() + ", " + listTeams.get(1).getText();
    }
}
