package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionHelper {

    private WaitHelper waitHelper;

    public ActionHelper(WebDriver driver) {
        waitHelper = new WaitHelper(driver);
    }

    // Click
    public void click(WebElement element) {

        waitHelper.waitForElementClickable(element);

        element.click();
    }

    // Type Text
    public void type(WebElement element, String text) {

        waitHelper.waitForElementVisible(element);

        element.clear();

        element.sendKeys(text);
    }

    // Read Text
    public String getText(WebElement element) {

        waitHelper.waitForElementVisible(element);

        return element.getText();
    }

    // Check Displayed
    public boolean isDisplayed(WebElement element) {

        waitHelper.waitForElementVisible(element);

        return element.isDisplayed();
    }

}