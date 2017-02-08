package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * Created by chv on 07.02.2017.
 *
 * Results Activity
 */
public class ResultsPage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/results_btnStart")
    private WebElement startButton;
    @FindBy(id = "com.mrb.alias:id/team_adapter_tvName")
    private List<WebElement> listTeams;

    public ResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click Start button
     */
    public GamePage clickStartButton(){
        startButton.click();
        return new GamePage(webDriver);
    }

    /**
     * Get Team names on Results page
     */
    public String getTeamNames() {
        return listTeams.get(0).getText() + ", " + listTeams.get(1).getText();
    }
}
