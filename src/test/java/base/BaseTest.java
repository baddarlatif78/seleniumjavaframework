package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilities.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger =LogManager.getLogger(getClass());

    ConfigReader config = new ConfigReader();

    @BeforeMethod

    public void setup() {

    	 logger.info("========= Test Started =========");

    	    DriverFactory.initializeDriver(config.getBrowser());

    	    driver = DriverFactory.getDriver();

    	    logger.info("Browser Launched Successfully");

    	    driver.get(config.getURL());

    	    logger.info("Application Opened : " + config.getURL());


    }

    @AfterMethod

    public void tearDown() {

    	System.out.println("Driver in tearDown = " + driver);

        logger.info("Closing Browser");

        DriverFactory.quitDriver();

        logger.info("========= Test Finished =========");

    }

    public WebDriver getDriver() {

        return driver;

    }

}