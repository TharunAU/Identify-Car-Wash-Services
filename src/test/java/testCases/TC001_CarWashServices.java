package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageCarWash;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC001_CarWashServices extends BaseClass{
	
	@Test(dataProvider = "TC001", dataProviderClass = DataProviders.class)
	public void carWashServices(String city, String search) {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.setLocationName(city);
		homePage.clickLocationFirstDropDown();
		homePage.setSearch(search);
		homePage.clickSearchFirstDropDown();
		
		SearchResultPageCarWash carWash = new SearchResultPageCarWash(driver);
		
		carWash.selectFilter("Rating");
		carWash.setRating("4");
		List<String> results = carWash.getSearchResults();
		
		for(String values:results) {
			System.out.println(values);
		}
		
	}
	
}
