package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import testBase.CucumberBase;
import testRunner.TestRunner;

public class hooks {

    private WebDriver driver;
    private Logger logger;

    @Before
    public void setUpScenario(Scenario scenario) {
        try {
            String os = System.getProperty("os", "windows");
            String browser = System.getProperty("browser", "chrome");

            CucumberBase.setup(os, browser);
            driver = CucumberBase.getDriver();
            logger = CucumberBase.getLogger();

            TestRunner.setDriver(driver);

            logger.info("----------------------------------------------------------------------------------------");
            logger.info("Starting Scenario: " + scenario.getName());
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage(), e);
        }
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        try {
            logger.info("Ending Scenario: " + scenario.getName());
            logger.info("Status: " + scenario.getStatus());

            if (scenario.isFailed()) {
                try {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");
                    logger.warn("Screenshot captured for failed scenario.");
                } catch (Exception ex) {
                    logger.error("Failed to capture screenshot: " + ex.getMessage());
                }
            }

        } finally {
            CucumberBase.tearDown();
            logger.info("Browser closed.");
            logger.info("----------------------------------------------------------------------------------------");
        }
    }
}
