package testCases;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPageByNames;
import testBase.BaseClass;

public class TC007_SearchByNames extends BaseClass{
	
	@Test
	public void searchByNames() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.setLocationName("Saravanampatti");
		homePage.clickLocationFirstDropDown();
		homePage.setSearch("Parthiv");
		homePage.clickSearchButton();
		
		SearchResultPageByNames names = new SearchResultPageByNames(driver);
		
		String name = names.getFirstResultName();
		String location = names.getFirstResultLocation();
		
		System.out.println("\nName: "+name+"\nLocation: "+location);
		
		names.clickCloseButton();
	}
	
}
