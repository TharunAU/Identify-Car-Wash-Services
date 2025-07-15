package stepsDefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FreeListingPhoneNumberPage;
import pages.HomePage;
import testBase.CucumberBase;
import testRunner.TestRunner;
import utilities.SharedData;

public class TC002_steps {

    private final Logger logger = CucumberBase.getLogger();
    private final WebDriver driver = TestRunner.getDriver();
    private final HomePage homePage = new HomePage(driver);
    private final FreeListingPhoneNumberPage freeListingPage = new FreeListingPhoneNumberPage(driver);

    private final String sheetName = "TC002";
    private String errorMessage;

    @When("I Navigate to the free listing page")
    public void navigateToFreeListingPage() {
        homePage.clickFreeListingList();
        logger.info("------ Clicked Free Listing Option ------");
    }

    @And("I fill the phone number field with an invalid phone number {string} from Excel")
    public void fillInvalidPhoneNumber(String rowIndexStr) {
        int rowIndex = Integer.parseInt(rowIndexStr);

        try {
            SharedData.loadTestRow(sheetName, rowIndex);
        } catch (Exception e) {
            logger.error("Failed to load test data", e);
            Assert.fail("Could not load test data: " + e.getMessage());
        }

        String phoneNumber = SharedData.get("PhoneNumber");
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            logger.error("PhoneNumber field is empty or missing in sheet: " + sheetName);
            Assert.fail("Missing test data for PhoneNumber");
        }

        freeListingPage.setPhoneNumber(phoneNumber);
        logger.info("------ Entered Invalid Phone Number: " + phoneNumber + " ------");
    }

    @And("I submit the form")
    public void submitFreeListingForm() {
        freeListingPage.clickStartNowButton();
        logger.info("------ Clicked Start Now Button ------");
    }

    @Then("I should see an error message for the invalid phone number")
    public void retrieveErrorMessage() {
        errorMessage = freeListingPage.getErrorMessage();
        logger.info("------ Retrieved Error Message: " + errorMessage + " ------");
    }

    @And("I capture and display the error message")
    public void displayErrorMessage() {
        System.out.println("The Error Message is: " + errorMessage);
    }

    @And("I am checking the error message")
    public void validateErrorMessage() {
        if ("Please Enter a Valid Mobile Number".equalsIgnoreCase(errorMessage)) {
            logger.info("------ Test Case Passed ------");
            Assert.assertTrue(true);
        } else {
            logger.error("------ Test Case Failed ------");
            Assert.fail("Unexpected error message received");
        }

        logger.info("----------------------------------------------------------------------------------------");
    }
}
