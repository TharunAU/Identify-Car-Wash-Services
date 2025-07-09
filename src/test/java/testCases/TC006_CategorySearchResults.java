package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC006_CategorySearchResults extends BaseClass {

	@Test(priority = 1)
	public void categorySearch() {
		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		homePage.clickCloseButton();
		homePage.clickPopularCategoryButton();
	}

	@Test(dataProvider = "TC006", dataProviderClass = DataProviders.class, priority = 2)
	public void categorySearchResults(String search) {

		HomePage homePage = new HomePage(driver);

		homePage.setSearchValue(search);
		System.out.println("\n"+search.toUpperCase()+" Search Result: \n");
		List<String> results = homePage.getCategorySearchResults();
		for (String x : results) {
			System.out.println(x);
		}
		
		homePage.clickSearchResultClose();
		
		if(results.size()>=1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}

	}

}
