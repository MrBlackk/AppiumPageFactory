package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 07.02.2017.
 *
 * Settings Activity
 */
public class SettingsPage extends GeneralPage{

    @FindBy(id = "com.mrb.alias:id/settings_btnNext")
    private WebElement nextButton;

    public SettingsPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click Next button
     */
    public ResultsPage clickNextButton(){
        nextButton.click();
        return new ResultsPage(webDriver);
    }
}
