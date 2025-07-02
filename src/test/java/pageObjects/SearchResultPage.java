package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtil;

public class SearchResultPage extends BasePage{

	public SearchResultPage(WebDriver driver,WaitUtil util) {
		super(driver, util);
	}
	
	//locators
	@FindBy(xpath="(//button[starts-with(@class, 'jsx') and contains(@class, 'resfilter_item')])[7]")
	WebElement ratings;
	
	@FindBy(id="option-2")
	WebElement ratingOption4;
	
	@FindBy(xpath="//div[starts-with(@class, 'jsx') and contains(@class, 'resultbox_textbox')]")
	WebElement searchResults;
	
}
