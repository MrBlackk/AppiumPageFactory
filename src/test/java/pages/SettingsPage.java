package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import utils.Log4Test;

/**
 * Created by chv on 07.02.2017.
 *
 * Settings Activity
 */
public class SettingsPage extends GeneralPage{

    @FindBy(id = "com.mrb.alias:id/settings_btnNext")
    private MobileElement nextButton;

    public SettingsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Click Next button
     */
    public ResultsPage clickNextButton(){
        Log4Test.test("Click Next button");
        nextButton.click();
        return new ResultsPage(appiumDriver);
    }
}
