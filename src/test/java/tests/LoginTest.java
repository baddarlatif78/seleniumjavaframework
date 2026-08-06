package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ScreenshotUtil;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData",
		      dataProviderClass = dataprovider.DataProviders.class)
		public void verifyLogin(String username, String password) {

		    LoginPage login = new LoginPage(driver);

		    logger.info("Executing Login Test");

		    login.login(username, password);

		    // Valid login
		    if (username.equals("student") &&
		        password.equals("Password123")) {

		        Assert.assertTrue(login.isLoginSuccessful());
		        logger.info("Login Validation Completed");
		    }

		    // Valid username, wrong password
		    else if (username.equals("student") &&
		             !password.equals("Password123")) {

		        Assert.assertEquals(
		                login.getErrorMessage(),
		                "Your password is invalid!");
		    }

		    // Invalid username
		    else {

		        Assert.assertEquals(
		                login.getErrorMessage(),
		                "Your username is invalid!");
		    }
		}
    }
