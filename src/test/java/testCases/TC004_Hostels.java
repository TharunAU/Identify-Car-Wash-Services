package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageHostels;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_Hostels extends BaseClass{

	@Test(dataProvider = "TC004", dataProviderClass = DataProviders.class)
	public void hostels(String city, String search) {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.setLocationName(city);
		homePage.clickLocationFirstDropDown();
		homePage.setSearch(search);
		homePage.clickSearchFirstDropDown();
		
		SearchResultPageHostels hostels = new SearchResultPageHostels(driver);
		
		hostels.selectFilter("Top Rated");
		hostels.selectFilter("Verified");
		hostels.selectFilter("Trust");
		List<String> results = hostels.getHotelResultList();
		for(String result:results) {
			System.out.println(result);
		}
		
	}
	
}
