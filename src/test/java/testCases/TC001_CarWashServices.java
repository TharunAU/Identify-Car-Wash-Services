package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageCarWash;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC001_CarWashServices extends BaseClass {

	@Test(dataProvider = "TC001", dataProviderClass = DataProviders.class)
	public void carWashServices(String city, String search) {

		logger.info("------ Starting TC001_CarWashServices ------");

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		logger.info("------ Clicked May be Later Button ------");
		homePage.setLocationName(city);
		homePage.clickLocationFirstDropDown();
		logger.info("------ Selected Location ------");
		homePage.setSearch(search);
		homePage.clickSearchFirstDropDown();
		logger.info("------ Searching Car Washing Services in the Search Box ------");

		SearchResultPageCarWash carWash = new SearchResultPageCarWash(driver);

		carWash.selectFilter("Rating");
		carWash.setRating("4");
		logger.info("------ Selected Rating ------");
		List<String> results = carWash.getSearchResults();
		String resultHeading = carWash.getHeading();

		for (String values : results) {
			System.out.println(values);
			logger.info("------ Displaying Search Results ------");
		}

		if (results.size() == 5 && resultHeading.toLowerCase().contains("car wash")) {
			Assert.assertTrue(true);
			logger.info("------ Test Case Passed ------");
		} else {
			Assert.fail();
			logger.info("------ Test Case Failed ------");
		}

		logger.info("----------------------------------------------------------------------------------------");

	}

}
