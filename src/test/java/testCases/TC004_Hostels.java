package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageHostels;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_Hostels extends BaseClass {

	@Test(dataProvider = "TC004", dataProviderClass = DataProviders.class)
	public void hostels(String city, String search) {

		logger.info("------ Started TC004_Hostels ------");

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		logger.info("------ Clicked May Be Later Button ------");
		homePage.setLocationName(city);
		homePage.clickLocationFirstDropDown();
		logger.info("------ Selected Location ------");
		homePage.setSearch(search);
		homePage.clickSearchFirstDropDown();
		logger.info("------ Searching Hostels in the Search Box ------");

		SearchResultPageHostels hostels = new SearchResultPageHostels(driver);

		hostels.selectFilter("Top Rated");
		logger.info("------ Selected Top Rated in Filters ------");
		hostels.selectFilter("Verified");
		logger.info("------ Selected Top JD Verified in Filters ------");
		hostels.selectFilter("Trust");
		logger.info("------ Selected Top JD Trust in Filters ------");

		List<String> results = hostels.getHotelResultList();
		for (String result : results) {
			System.out.println(result);
		}
		logger.info("------ Displayed the Search Results ------");

		boolean flag = true;

		for (String x : results) {
			if (!(x.toLowerCase().contains("coimbatore"))) {
				flag = false;
			}
		}

		if (flag) {
			Assert.assertTrue(true);
			logger.info("------ Test Case Passed ------");
		} else {
			Assert.fail();
			logger.info("------ Test Case Failed ------");
		}
		logger.info("----------------------------------------------------------------------------------------");

	}

}
