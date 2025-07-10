package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BusBookingPage;
import pages.HomePage;
import pages.SearchResultPageBusBooking;
import testBase.BaseClass;

public class TC008_BusBooking extends BaseClass {

	@Test
	public void BusBooking() {

		logger.info("------ Starting TC008_BusBooking ------");

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		logger.info("------ Clicked May Be Later Button ------");
		homePage.clickServiceMenu("Bus");
		logger.info("------ Clicked Bus Service Menu ------");

		BusBookingPage busBook = new BusBookingPage(driver);

		busBook.setDepartureCity("Coimbatore");
		logger.info("------ Selected Coimbatore in the Departure City ------");
		busBook.setDestinationCity("Chennai");
		logger.info("------ Selected Chennai in the Destination City ------");
		busBook.clickDateOfJourney();
		busBook.clickNextMonth();
		busBook.selectDate();
		logger.info("------ Selected Date ------");
		busBook.clickSearchButton();
		logger.info("------ Clicked Search Button ------");

		SearchResultPageBusBooking busBookResult = new SearchResultPageBusBooking(driver);

		busBookResult.clickBusType();
		logger.info("------ Clicked Bus Type ------");
		busBookResult.clickNonAcFilterCheckBox();
		logger.info("------ Selected Non Ac CheckBox ------");
		busBookResult.clickSleeperFilterCheckBox();
		logger.info("------ Selected Sleeper CheckBox ------");
		busBookResult.clickBusType();
		WebElement nonAcFilter = busBookResult.getNonAcFilter();
		WebElement sleeperFilter = busBookResult.getSleeperFilterCheckBox();
		List<String> results = busBookResult.getBusDetails();

		for (String x : results) {
			System.out.println(x);
		}
		logger.info("------ Displayed Results ------");

		if (nonAcFilter.isEnabled() && sleeperFilter.isEnabled()) {
			Assert.assertTrue(true);
			logger.info("------ Test Case Passed ------");
		} else {
			Assert.fail();
			logger.info("------ Test Case Failed ------");
		}
		logger.info("----------------------------------------------------------------------------------------");
	}

}
