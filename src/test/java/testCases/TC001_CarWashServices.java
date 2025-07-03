package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageCarWash;
import testBase.BaseClass;

public class TC001_CarWashServices extends BaseClass{
	
	@Test
	public void carWashServices() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.setLocationName("Saravanampatti");
		homePage.clickLocationFirstDropDown();
		homePage.setSearch("Car Washing Services");
		homePage.clickSearchFirstDropDown();
		
		SearchResultPageCarWash carWash = new SearchResultPageCarWash(driver);
		
		carWash.clickRating();
		carWash.setRating();
		List<String> results = carWash.getSearchResults();
		
		for(String values:results) {
			System.out.println(values);
		}
		
	}
	
}
