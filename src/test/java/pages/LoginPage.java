package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;
import utilities.ActionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {

    WebDriver driver;
    private WaitHelper waitHelper;
    private ActionHelper action;
    private static final Logger logger =LogManager.getLogger(LoginPage.class);
    

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        action = new ActionHelper(driver);

    }

    @FindBy(id = "username")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "submit")
    WebElement btnLogin;

    @FindBy(xpath = "//h1")
    WebElement successMessage;
    
    @FindBy(id="error")
    WebElement errorMessage;

    public void enterUsername(String username) {
    	//waitHelper.waitForElementVisible(txtUsername);
    	 logger.info("Entering Username");
    	    action.type(txtUsername, username);
    }

    public void enterPassword(String password) {
    	//waitHelper.waitForElementVisible(txtPassword);
    	logger.info("Entering Password");

        action.type(txtPassword, password);
    }

    public void clickLogin() {
    	//waitHelper.waitForElementClickable(btnLogin);
    	  logger.info("Clicking Login Button");

    	    action.click(btnLogin);
    }

    public void login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }

    public String getSuccessMessage() {

    	return action.getText(successMessage);

    }
    
    public boolean isLoginSuccessful() {

        return successMessage.isDisplayed();

    }

    public String getErrorMessage() {

        return errorMessage.getText();

    }

}