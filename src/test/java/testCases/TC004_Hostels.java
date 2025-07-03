package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageHostels;
import testBase.BaseClass;

public class TC004_Hostels extends BaseClass{

	@Test
	public void hostels() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.setLocationName("Saravanampatti");
		homePage.clickLocationFirstDropDown();
		homePage.setSearch("Hostels");
		homePage.clickSearchFirstDropDown();
		
		SearchResultPageHostels hostels = new SearchResultPageHostels(driver);
		
		hostels.clickTopRatingFilter();
		hostels.clickJdVerifiedFilter();
		hostels.clickJdTrustFilter();
		List<String> results = hostels.getHotelResultList();
		for(String result:results) {
			System.out.println(result);
		}
		
	}
	
}
