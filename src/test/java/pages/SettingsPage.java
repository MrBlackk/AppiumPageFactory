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

    @FindBy(id = "com.mrb.alias:id/settings_sbTime")
    private MobileElement timeSlider;

    @FindBy(id = "com.mrb.alias:id/settings_sbPoints")
    private MobileElement pointsSlider;

    @FindBy(id = "com.mrb.alias:id/settings_tvTimeValue")
    private MobileElement timeValue;

    @FindBy(id = "com.mrb.alias:id/settings_tvPointsValue")
    private MobileElement pointsValue;

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

    /**
     * Set min value for Time slider
     */
    public SettingsPage setMinValueForTimeSlider() {
        Log4Test.test("Set Min value for Time slider");
        setSliderValue(timeSlider, 0);
        return this;
    }

    /**
     * Set min value for Points slider
     */
    public SettingsPage setMinValueForPointsSlider() {
        Log4Test.test("Set Min value for Points slider");
        setSliderValue(pointsSlider, 0);
        return this;
    }

    /**
     * Get Time slider value
     */
    public String getTimeSliderValue() {
        return timeValue.getText();
    }

    /**
     * Get Points slider value
     */
    public String getPointsSliderValue() {
        return pointsValue.getText();
    }
}
