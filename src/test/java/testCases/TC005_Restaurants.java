package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageRestaurant;
import testBase.BaseClass;

public class TC005_Restaurants extends BaseClass{
	
	@Test
	public void restaurants(){
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.setLocationName("Saravanampatti");
		homePage.clickLocationFirstDropDown();
		homePage.setSearch("Restaurants");
		homePage.clickSearchFirstDropDown();
		
		SearchResultPageRestaurant restaurant = new SearchResultPageRestaurant(driver);
		
		restaurant.clickCuisineFilter();
		restaurant.clickOnSouthIndianDropDown();
		restaurant.clickOnlineOrderFilter();
		restaurant.clickOpenNowFilter();
		List<String> results = restaurant.getRestaurantSearchResults();
		for(String result:results) {
			System.out.println(result);
		}
		
	}
	
}
