package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtil;

public class SearchResultPageCarWash extends BasePage {

	public SearchResultPageCarWash(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "(//button[starts-with(@class, 'jsx') and contains(@class, 'resfilter_item')])[7]")
	WebElement ratings;

	@FindBy(id = "option-2")
	WebElement ratingOption4;

	@FindBy(xpath = "//div[starts-with(@class, 'jsx') and contains(@class, 'resultbox_textbox')]")
	List<WebElement> searchResults;

	@FindBy(xpath = "//div[starts-with(@class, 'jsx') and contains(@class, 'resultbox_textbox')]//following::h3")
	List<WebElement> carNames;

	@FindBy(xpath = "//div[starts-with(@class, 'jsx') and contains(@class, 'resultbox_textbox')]//following::span[contains(@class, 'callcontent')]")
	List<WebElement> phoneNumbers;

	@FindBy(xpath = "//div[contains(@class, 'resultbox_textbox')]//li[starts-with(@class, 'resultbox_countrate')]")
	List<WebElement> peopleRatings;

	// actions
	public void clickRating() {
		ratings.click();
	}

	public void setRating() {
		ratingOption4.click();
	}

	public List<String> getSearchResults() {
		WaitUtil.waitForMultipleElement(driver, searchResults, 20);

		int count = 0;
		int size = Math.min(phoneNumbers.size(), Math.min(peopleRatings.size(), carNames.size()));

		List<String> result = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			if (count == 5) {
				break;
			}

			String value = peopleRatings.get(i).getText().split(" ")[0].replace(",", "");
			String name = carNames.get(i).getText();
			String phoneNumber = phoneNumbers.get(i).getText();

			int rating = Integer.parseInt(value);

			if (rating > 20 && !phoneNumber.equals("Show Number")) {
				result.add("\nCar Names: " + name + "\nContact Number: " + phoneNumber);
				count++;
			}
		}

		return result;

	}

}
