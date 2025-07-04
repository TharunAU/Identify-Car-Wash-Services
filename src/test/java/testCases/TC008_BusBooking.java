package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.BusBookingPage;
import pages.HomePage;
import pages.SearchResultPageBusBooking;
import testBase.BaseClass;

public class TC008_BusBooking extends BaseClass {

	@Test
	public void BusBooking() {

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		homePage.clickServiceMenu("Bus");

		BusBookingPage busBook = new BusBookingPage(driver);

		busBook.setDepartureCity("Coimbatore");
		busBook.setDestinationCity("Chennai");
		busBook.clickDateOfJourney();
		busBook.clickNextMonth();
		busBook.selectDate();
		busBook.clickSearchButton();

		SearchResultPageBusBooking busBookResult = new SearchResultPageBusBooking(driver);

		busBookResult.clickBusType();
		busBookResult.clickNonAcFilterCheckBox();
		busBookResult.clickSleeperFilterCheckBox();
		busBookResult.clickBusType();
		List<String> results = busBookResult.getBusDetails();

		for (String x : results) {
			System.out.println(x);
		}
	}

}
