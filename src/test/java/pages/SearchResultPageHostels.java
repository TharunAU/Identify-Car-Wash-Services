package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPageHostels extends BasePage {

	public SearchResultPageHostels(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "(//button[starts-with(@class, 'jsx') and contains(@class, 'resfilter_item')])[2]")
	WebElement topRatingsFilter;

	@FindBy(xpath = "(//button[starts-with(@class, 'jsx') and contains(@class, 'resfilter_item')])[4]")
	WebElement jdVerifiedFilter;

	@FindBy(xpath = "(//button[starts-with(@class, 'jsx') and contains(@class, 'resfilter_item')])[6]")
	WebElement jdTrustFilter;

	@FindBy(xpath = "//div[contains(@class, 'resultbox_textbox')]")
	List<WebElement> hotelSearchResults;

	@FindBy(xpath = "//div[contains(@class, 'resultbox_textbox')]//div[contains(@class, 'locatcity')]")
	List<WebElement> hotelLocationList;

	@FindBy(xpath = "//div[contains(@class, 'resultbox_textbox')]//h3")
	List<WebElement> hotelNameList;

	// actions
	public void clickTopRatingFilter() {
		topRatingsFilter.click();
	}

	public void clickJdVerifiedFilter() {
		jdVerifiedFilter.click();
	}

	public void clickJdTrustFilter() {
		jdTrustFilter.click();
	}

	public List<String> getHotelResultList() {
		int count = 0;
		
		List<String> result = new ArrayList<>();
		
		for (int i = 0; i < hotelSearchResults.size(); i++) {
			if (count == 5) {
				break;
			}
			result.add("\nName: " + hotelNameList.get(i).getText() + "\nLocation: " + hotelLocationList.get(i).getText());
			count++;
		}
		return result;
	}

}
