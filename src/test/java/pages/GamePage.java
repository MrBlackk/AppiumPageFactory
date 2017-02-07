package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 07.02.2017.
 *
 * Game Activity
 */
public class GamePage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/game_tvWord")
    private WebElement word;

    public GamePage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Check that word is displayed
     */
    public boolean isWordDisplayed(){
        return word.isDisplayed();
    }
}
