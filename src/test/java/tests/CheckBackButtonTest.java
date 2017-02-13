package tests;

import core.Key;
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
        TeamPage teamPage = new StartPage(webDriver)
                .clickNewGameButton();

        String expectedText = teamPage.getTeamNames();
        teamPage.clickNextButton()
                .clickNextButton()
                .clickStartButton()
                .pressBackButton();

        String actualText = new StartPage(webDriver)
                .clickContinueButton()
                .getTeamNames();

        Assert.assertEquals(actualText, expectedText, "Team names are different");
    }
}
