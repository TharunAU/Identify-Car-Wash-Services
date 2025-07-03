package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import testBase.BaseClass;

public class TC006_CategorySearchResults extends BaseClass{
	
	@Test
	public void categorySearchResults() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickCloseButton();
		homePage.clickPopularCategoryButton();
		homePage.setSearchValue("ac");
		List<String> results = homePage.getCategorySearchResults();
		for(String x:results) {
			System.out.println(x);
		}
		
	}
	
}
