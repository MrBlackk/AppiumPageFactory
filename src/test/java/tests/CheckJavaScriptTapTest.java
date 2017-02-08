package tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.StartPage;

/**
 * Created by chv on 08.02.2017.
 * Js tap
 */
public class CheckJavaScriptTapTest extends TestBase{

    @Test(description = "JS tap")
    public void jsTapTest(){
        // just for test purpose
        String teams = new StartPage(webDriver)
                .tapNewGameButton()
                .getTeamNames();
    }
}
