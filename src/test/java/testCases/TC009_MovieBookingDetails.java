package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.MoviesPage;
import pages.SearchResultMoviePage;
import testBase.BaseClass;

public class TC009_MovieBookingDetails extends BaseClass {

	@Test
	public void MovieBookingDetails() {
		logger.info("------ Starting TC009_MovieBookingDetails ------");

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		logger.info("------ Clicked May Be Later Button ------");
		homePage.clickMoviesSection();
		logger.info("------ Clicked Movies Section ------");

		MoviesPage movies = new MoviesPage(driver);

		movies.waitUntilHeadingTagAppears();
		movies.clickChosenLanguages("tamil,english,telugu");
		logger.info("------ Selected Prefered Languages in the filter ------");
		movies.clickChosenFormat("2d");
		logger.info("------ Selected 2D in the format Filter ------");
		movies.clickChosenJonour("comedy");
		logger.info("------ Selected Comedy in the Genre Filter ------");
		movies.clickApplyFilterButton();
		logger.info("------ Clicked Apply Button ------");

		SoftAssert softAssert = new SoftAssert();
		WebElement comedyJonourFilterCheckBox = movies.getComedyJonourFilterCheckBox();
		if (comedyJonourFilterCheckBox.isEnabled()) {
			softAssert.assertTrue(true);
			logger.info("------ Selection of Comedy Genre is verified ------");
		} else {
			softAssert.fail();
			logger.info("------ Selection of Comedy Genre is not reflected ------");
		}

		movies.waitUntilFilteredHeadingTagAppears();
		movies.clickFirstMovie();
		logger.info("------ First Movie in the Results is Selected ------");

		SearchResultMoviePage movieSearch = new SearchResultMoviePage(driver);
		movieSearch.waitUntilMovieNameToAppear();
		String movie = movieSearch.getMovieName();
		System.out.println("Movie Name: " + movie);
		List<String> details = movieSearch.getMovieDetails();
		for (String x : details) {
			System.out.println(x);
		}
		logger.info("------ Displayed the Results ------");
		logger.info("----------------------------------------------------------------------------------------");

		softAssert.assertAll();
	}

}
