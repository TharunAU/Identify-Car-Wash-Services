package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtil;

public class SearchResultMoviePage extends BasePage {

	public SearchResultMoviePage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//a[@class='color111']")
	WebElement movieName;

	@FindBy(xpath = "//div[contains(@class,'movcard_name') and contains(@class,'font18')]")
	List<WebElement> theatresAvailable;

	@FindBy(xpath = "//div[contains(@class,'fw500 ') and contains(@class,'font14') and contains(@class,'color111 ')]")
	List<WebElement> locationsAvailable;

	@FindBy(xpath = "//ul[@class = 'movie_showlist']/descendant::span[1]")
	List<WebElement> showTimings;

	// actions
	public void waitUntilMovieNameToAppear() {
		WaitUtil.waitForOneElement(driver, movieName, 10);
	}

	public String getMovieName() {
		return movieName.getText();
	}

	public List<String> getMovieDetails() {
		List<String> details = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < theatresAvailable.size(); i++) {
			if (count == 5) {
				break;
			}
			details.add("\nTheatre Name: " + theatresAvailable.get(i).getText() + "\nLocation Name: "
					+ locationsAvailable.get(i).getText() + "\nShow Timings: " + showTimings.get(i).getText());
			count++;
		}
		return details;
	}

}
