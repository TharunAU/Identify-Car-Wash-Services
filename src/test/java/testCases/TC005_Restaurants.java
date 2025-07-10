package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageRestaurant;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC005_Restaurants extends BaseClass {

	@Test(dataProvider = "TC005", dataProviderClass = DataProviders.class)
	public void restaurants(String city, String search) {

		logger.info("------ Starting TC005_Restaurants ------");

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		logger.info("------ Clicked May Be Later Button ------");
		homePage.setLocationName(city);
		homePage.clickLocationFirstDropDown();
		logger.info("------ Selected Location ------");
		homePage.setSearch(search);
		homePage.clickSearchFirstDropDown();
		logger.info("------ Searching Restaurants in the Search Box ------");

		SearchResultPageRestaurant restaurant = new SearchResultPageRestaurant(driver);

		restaurant.selectFilter("Cuisines");
		logger.info("------ Selected Cuisines in the Filters ------");
		restaurant.setCuisine("South");
		logger.info("------ Selected South Indian in the Cuisines Filter ------");
		restaurant.selectFilter("Online");
		logger.info("------ Selected Online Delivery in the Filters ------");
		restaurant.selectFilter("Open");
		logger.info("------ Selected Open Now in the Filters ------");
		List<String> results = restaurant.getRestaurantSearchResults();
		List<Integer> ratings = restaurant.getNoOfRatings();
		for (String result : results) {
			System.out.println(result);
		}
		logger.info("------ Displaying the Results ------");

		boolean flag = true;

		for (Integer x : ratings) {
			if (x < 20) {
				flag = false;
				break;
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
