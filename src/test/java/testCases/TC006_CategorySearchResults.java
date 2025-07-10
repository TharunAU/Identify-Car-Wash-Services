package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC006_CategorySearchResults extends BaseClass {

	public boolean flag = true;

	@BeforeMethod
	public void categorySearch() {

		if (flag) {
			logger.info("------ Starting TC006_CategorySearchResults ------");
			HomePage homePage = new HomePage(driver);
			homePage.clickMayBeLaterButton();
			logger.info("------ Clicked May Be Later Button ------");
			homePage.clickCloseButton();
			logger.info("------ Clicked Close Button for a pop up ------");
			homePage.clickPopularCategoryButton();
			logger.info("------ Clicked Popular Category Button ------");
			flag = false;
		}
	}

	@Test(dataProvider = "TC006", dataProviderClass = DataProviders.class, priority = 2)
	public void categorySearchResults(String search) {

		HomePage homePage = new HomePage(driver);

		homePage.setSearchValue(search);
		logger.info("------ Searching " + search + " in the Seach Box ------");
		System.out.println("\n" + search.toUpperCase() + " Search Result: \n");
		logger.info("------ Displaying the Search Results ------");
		List<String> results = homePage.getCategorySearchResults();
		for (String x : results) {
			System.out.println(x);
		}

		homePage.clickSearchResultClose();

		if (results.size() >= 1) {
			Assert.assertTrue(true);
			logger.info("------ Test Case Passed ------");
		} else {
			Assert.fail();
			logger.info("------ Test Case Failed ------");
		}
		logger.info("----------------------------------------------------------------------------------------");

	}

}
