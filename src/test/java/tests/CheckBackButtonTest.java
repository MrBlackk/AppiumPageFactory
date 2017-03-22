package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;
import pages.TeamPage;

/**
 * Created by chv on 08.02.2017.
 *
 * Check back button
 */
public class CheckBackButtonTest extends TestBase {

    @Test(description = "Check Team Names after pressing Back button on device")
    public void backButtonTest() {
        TeamPage teamPage = new StartPage(appiumDriver)
                .tapNewGameButton();

        String expectedText = teamPage.getTeamNames();
        teamPage.tapNextButton()
                .tapNextButton()
                .tapStartButton()
                .pressBackButton();

        String actualText = new StartPage(appiumDriver)
                .tapContinueButton()
                .getTeamNames();

        Assert.assertEquals(actualText, expectedText, "Team names are different");
    }
}
