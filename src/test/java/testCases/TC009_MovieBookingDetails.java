package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.MoviesPage;
import pages.SearchResultMoviePage;
import testBase.BaseClass;

public class TC009_MovieBookingDetails extends BaseClass{

	@Test
	public void MovieBookingDetails() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.clickMoviesSection();
		
		MoviesPage movies = new MoviesPage(driver);
		
		movies.waitUntilHeadingTagAppears();
		movies.clickChosenLanguages("tamil,english,telugu");
		movies.clickChosenFormat("2d");
		movies.clickChosenJonour("comedy");
		movies.clickApplyFilterButton();
		movies.waitUntilFilteredHeadingTagAppears();
		movies.clickFirstMovie();
		
		SearchResultMoviePage movieSearch = new SearchResultMoviePage(driver);
		movieSearch.waitUntilMovieNameToAppear();
		String movie = movieSearch.getMovieName();
		System.out.println("Movie Name: "+movie);
		List<String> details = movieSearch.getMovieDetails();
		for(String x:details) {
			System.out.println(x);
		}
		
	}
	
}
