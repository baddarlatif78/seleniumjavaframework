package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Wait until element is visible
    public void waitForElementVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    // Wait until element is clickable
    public void waitForElementClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

}