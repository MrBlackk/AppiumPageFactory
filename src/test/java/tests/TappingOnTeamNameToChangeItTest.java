package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;
import pages.TeamPage;
import utils.Log4Test;

/**
 * Created by chv on 10.02.2017.
 * Tapping on team name to change it
 */
public class TappingOnTeamNameToChangeItTest extends TestBase {

    @Test(description = "Tap teams test")
    public void tapTeamNameTest() {
        String beforeTapTeams = new StartPage(webDriver)
                .clickNewGameButton()
                .getTeamNames();

        String afterTapTeams = new TeamPage(webDriver)
                .tapTeamNo(1)
                .tapTeamNo(2)
                .getTeamNames();

        Log4Test.info("Team names before tap: " + beforeTapTeams + "; after: " + afterTapTeams);
        Assert.assertNotEquals(beforeTapTeams, afterTapTeams, "Team names the same, but should be changed after tap");
    }
}
