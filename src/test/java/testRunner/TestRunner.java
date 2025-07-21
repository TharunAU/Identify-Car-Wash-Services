package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepsDefinitions", "hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/html-report.html",
        "json:target/cucumber-reports/cucumber.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "rerun:target/failed_scenarios.txt"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void removeDriver() {
        driver.remove();
    }
    
    @BeforeSuite
    public void cleanAllureResults() {
        try {
            File resultsDir = new File("target/allure-results");
            if (resultsDir.exists()) {
                FileUtils.deleteDirectory(resultsDir);
                System.out.println("Cleaned old Allure results.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @AfterSuite
    public void generateAndOpenAllureReport() {
        try {
            // Use the full path to allure.cmd from Scoop
            String allureCmdPath = "C:\\Users\\2403758\\scoop\\shims\\allure.cmd";

            ProcessBuilder builder = new ProcessBuilder(allureCmdPath, "serve", "target/allure-results");
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
