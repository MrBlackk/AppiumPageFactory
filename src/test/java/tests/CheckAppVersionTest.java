package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;
import utils.Log4Test;

/**
 * Created by chv on 07.02.2017.
 *
 * Test to check app version
 */
public class CheckAppVersionTest extends TestBase{

    @Test(description = "Check application version")
    public void checkAppVersion(){
        Log4Test.test("Check application version");
        String appVersion = new StartPage(webDriver)
                .getAppVersion();

        Assert.assertEquals(appVersion, TestData.APP_VERSION, "App version is not correct");
    }
}
