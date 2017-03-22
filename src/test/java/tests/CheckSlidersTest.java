package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SettingsPage;
import pages.StartPage;

/**
 * Created by chvs on 21.03.2017.
 * <p/>
 * Changing value on Time and Point sliders
 */
public class CheckSlidersTest extends TestBase {

    @Test(description = "Check Min value of sliders")
    public void checkMinValuesSlidersTest() {
        String expectedMinSliderValue = "10";

        SettingsPage settingsPage = new StartPage(appiumDriver)
                .tapNewGameButton()
                .tapNextButton()
                .setMinValueForTimeSlider()
                .setMinValueForPointsSlider();

        String actualTimeValue = settingsPage.getTimeSliderValue();
        String actualPointsValue = settingsPage.getPointsSliderValue();

        Assert.assertEquals(actualTimeValue, expectedMinSliderValue, "Time min slider value is not correct");
        Assert.assertEquals(actualPointsValue, expectedMinSliderValue, "Points min slider value is not correct");
    }

    @Test(description = "Check default value of sliders")
    public void checkDefaultValuesSlidersTest() {
        String expectedMinSliderValue = "40";

        SettingsPage settingsPage = new StartPage(appiumDriver)
                .tapNewGameButton()
                .tapNextButton();

        String actualTimeValue = settingsPage.getTimeSliderValue();
        String actualPointsValue = settingsPage.getPointsSliderValue();

        Assert.assertEquals(actualTimeValue, expectedMinSliderValue, "Time default slider value is not correct");
        Assert.assertEquals(actualPointsValue, expectedMinSliderValue, "Points default slider value is not correct");
    }
}
