package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;

/**
 * Created by chv on 07.02.2017.
 *
 * Test to check starting game
 */
public class StartNewGameTest extends TestBase {

    @Test(description = "Start New Game")
    public void startNewGame(){
        boolean result = new StartPage(webDriver)
                .clickNewGameButton()
                .clickNextButton()
                .clickNextButton()
                .clickStartButton()
                .isWordDisplayed();

        Assert.assertTrue(result, "Game was not started, word is not shown");
    }
}
