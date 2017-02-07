package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 07.02.2017.
 *
 * Team Activity
 */
public class TeamPage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/team_btnNext")
    private WebElement nextButton;

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
}
