package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chvs on 21.03.2017.
 *
 * Round Page
 */
public class RoundPage extends GeneralPage {

    @FindBy(xpath = "//*[@resource-id='com.mrb.alias:id/round_lvWords']//*[@resource-id='com.mrb.alias:id/results_adapter_tvWord']")
    private List<MobileElement> words;

    public RoundPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Get List of words
     */
    public List<String> getListOfWords() {
        List<String> wordValues = new ArrayList<String>();
        for (MobileElement word : words) {
            wordValues.add(word.getText());
        }
        return wordValues;
    }
}
