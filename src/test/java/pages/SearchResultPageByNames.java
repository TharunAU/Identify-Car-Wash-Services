package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPageByNames extends BasePage{
	
	public SearchResultPageByNames(WebDriver driver){
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[starts-with(@class, 'input_search_close')]")
	WebElement closeButton;
	
	@FindBy(xpath="(//h3[contains(@class, 'jsx-7cbb814d75c86232') and contains(@class, 'font22')])[1]")
	WebElement firstResultName;
	
	@FindBy(xpath="(//div[contains(@class, 'locatcity') and contains(@class, 'font15')])[1]")
	WebElement firstResultLocation;
	
	//actions
	public String getFirstResultName() {
		return firstResultName.getText();
	}
	
	public String getFirstResultLocation() {
		return firstResultLocation.getText();
	}
	
	public void clickCloseButton() {
		closeButton.click();
	}
	
}
