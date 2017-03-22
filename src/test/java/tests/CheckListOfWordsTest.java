package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GamePage;
import pages.RoundPage;
import pages.StartPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chvs on 21.03.2017.
 * <p/>
 * Check list of words
 */
public class CheckListOfWordsTest extends TestBase {

    @Test(description = "Check list from one word")
    public void checkOneWordTest() throws InterruptedException {
        GamePage gamePage = new StartPage(appiumDriver)
                .tapNewGameButton()
                .tapNextButton()
                .setMinValueForTimeSlider()
                .tapNextButton()
                .tapStartButton();

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add(gamePage.getCurrentWord());
        Thread.sleep(10000); // wait for 10 sec to finish game //todo: wait for time disappear

        gamePage.tapPlusButton();
        List<String> actualWords = new RoundPage(appiumDriver).getListOfWords();

        Assert.assertEquals(actualWords, expectedWords, "List of words is not correct");
    }
}
