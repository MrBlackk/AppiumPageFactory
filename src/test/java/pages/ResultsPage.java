package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 07.02.2017.
 *
 * Results Activity
 */
public class ResultsPage extends GeneralPage {

    @FindBy(id = "com.mrb.alias:id/results_btnStart")
    private WebElement startButton;

    public ResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click Start button
     */
    public GamePage clickStartButton(){
        startButton.click();
        return new GamePage(webDriver);
    }
}
