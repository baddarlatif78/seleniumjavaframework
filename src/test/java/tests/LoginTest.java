package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ScreenshotUtil;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData",dataProviderClass = dataprovider.DataProviders.class)

		public void verifyLogin(String username,
		                        String password) {

		    LoginPage login = new LoginPage(driver);

		    logger.info("Executing Login Test");
		    login.login(username, password);

		    if(username.equals("student")
		            && password.equals("Password123")) {

		        Assert.assertTrue(login.isLoginSuccessful());
		        logger.info("Login Validation Completed");

		    } else {

		        Assert.assertEquals(login.getErrorMessage(),"Your username is invalid!"

		        );

		    }

		}
       // ScreenshotUtil.captureScreenshot(driver, "LoginPassed");
    }
