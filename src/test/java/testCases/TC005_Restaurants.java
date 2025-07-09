package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageRestaurant;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC005_Restaurants extends BaseClass{
	
	@Test(dataProvider = "TC005", dataProviderClass = DataProviders.class)
	public void restaurants(String city, String search){
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.setLocationName(city);
		homePage.clickLocationFirstDropDown();
		homePage.setSearch(search);
		homePage.clickSearchFirstDropDown();
		
		SearchResultPageRestaurant restaurant = new SearchResultPageRestaurant(driver);
		
		restaurant.selectFilter("Cuisines");
		restaurant.setCuisine("South");
		restaurant.selectFilter("Online");
		restaurant.selectFilter("Open");
		List<String> results = restaurant.getRestaurantSearchResults();
		List<Integer> ratings = restaurant.getNoOfRatings();
		for(String result:results) {
			System.out.println(result);
		}
		
		boolean flag = true;

		for (Integer x : ratings) {
			if (!(x>=1000)) {
				flag = false;
			}
		}

		if (flag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
		
	}
	
}
