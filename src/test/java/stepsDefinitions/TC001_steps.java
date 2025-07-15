package stepsDefinitions;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPageCarWash;
import testBase.CucumberBase;
import testRunner.TestRunner;
import utilities.SharedData;
import utilities.ExcelUtilityClass;

public class TC001_steps {

    private final Logger logger = CucumberBase.getLogger();
    private final WebDriver driver = TestRunner.getDriver();
    private final HomePage homePage = new HomePage(driver);
    private final SearchResultPageCarWash carWash = new SearchResultPageCarWash(driver);

    private final String sheetName = "TC001";
    private final String path = System.getProperty("user.dir") + "\\testData\\Identify-Car-Wash-Services_TestData.xlsx";
    private final ExcelUtilityClass excel = new ExcelUtilityClass(path, sheetName);

    @When("I set the location as {string}")
    public void setLocation(String rowIndexStr) {
        logger.info("------ Starting TC001_CarWashServices ------");
        int rowIndex = Integer.parseInt(rowIndexStr);

        loadTestRow(rowIndex);

        String location = SharedData.get("Location");
        homePage.clickMayBeLaterButton();
        homePage.setLocationName(location);
        homePage.clickLocationFirstDropDown();
        logger.info("------ Location set to: " + location + " ------");
    }

    @And("I search for {string}")
    public void searchForService(String rowIndexStr) {
        int rowIndex = Integer.parseInt(rowIndexStr);
        loadTestRow(rowIndex);

        String search = SharedData.get("Search");
        homePage.setSearch(search);
        homePage.clickSearchFirstDropDown();
        logger.info("------ Search term entered: " + search + " ------");
    }

    @Then("I should see a list of car wash services")
    public void verifySearchResultsVisible() {
        String heading = carWash.getHeading();
        logger.info("------ Search result heading: " + heading + " ------");
    }

    @And("I filter the services with rating more than {string}")
    public void applyFilters(String rowIndexStr) {
        int rowIndex = Integer.parseInt(rowIndexStr);
        loadTestRow(rowIndex);

        String filter = SharedData.get("Filter");
        String rating = SharedData.get("Rating");

        carWash.selectFilter(filter);
        carWash.setRating(rating);
        logger.info("------ Applied filter: " + filter + ", Rating: " + rating + " ------");
    }

    @And("I filter the people votings greater than twenty and display the top five services with their names and phone numbers")
    public void displayTopFiveServices() {
        List<String> results = carWash.getSearchResults();
        int count = 1;

        logger.info("------ Displaying top 5 car wash services ------");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (String value : results) {
            String[] values = value.split(" / ");
            System.out.println("\nCar Washing Service: " + values[0] + "\nContact Number: " + values[1]);
            excel.setCellData(value, count, 4);
            count++;
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    @And("I checking the list has five entries only and the search result contains the word car wash")
    public void validateFinalResults() {
        List<String> results = carWash.getSearchResults();
        String heading = carWash.getHeading();

        boolean isValid = results.size() == 5 && heading.toLowerCase().contains("car wash");

        if (isValid) {
            excel.setCellData("Pass", 1, 7);
            excel.setCellData("The search result contains 'Car Washing Services' and 'Saravanampatti, Coimbatore'", 1, 6);
            logger.info("------ Test Case Passed ------");
            Assert.assertTrue(true);
        } else {
            excel.setCellData("Fail", 1, 7);
            excel.setCellData("The search result does NOT contain expected terms", 1, 6);
            logger.error("------ Test Case Failed ------");
            Assert.fail();
        }

        logger.info("----------------------------------------------------------------------------------------");
    }

    private void loadTestRow(int rowIndex) {
        try {
            SharedData.loadTestRow(sheetName, rowIndex);
        } catch (IOException e) {
            logger.error("Failed to load test row from Excel", e);
            Assert.fail("Could not load test data for row " + rowIndex);
        }
    }
}
