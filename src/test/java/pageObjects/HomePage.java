package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtil;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//div[starts-with(@class, 'jsx-c21ded63fbf3c5d8') and contains(@class, 'maybelater')]/a")
	WebElement mayBeLaterButton;

	@FindBy(xpath = "//div[@class = 'input_location_box ']//input")
	WebElement locationTab;

	@FindBy(xpath = "//div[starts-with(@class, 'input_search_result')]//li[2]/a")
	WebElement firstLocationDropDown;
	
	@FindBy(xpath = "//div[contains(@class, 'input_seach_box_results')]/input")
	WebElement searchTab;
	
	@FindBy(xpath = "//div[starts-with(@class, 'input_search_result')]//li[1]")
	WebElement searchfirstDropDown;
	
	@FindBy(xpath="//div[starts-with(@class, 'jd_floatbox')]/a[1]")
	WebElement freeListingList;
	
	//actions
	public void clickMayBeLaterButton() {
		WaitUtil.waitForOneElement(driver, mayBeLaterButton, 30);
		mayBeLaterButton.click();
	}
	
	public void setLocationName(String location) {
		locationTab.sendKeys(location);
	}
	
	public void clickLocationFirstDropDown() {
		firstLocationDropDown.click();
	}
	
	public void setSearch(String search) {
		searchTab.sendKeys(search);
	}
	
	public void clickSearchFirstDropDown() {
		searchfirstDropDown.click();
	}
	
	public void clickFreeListingList() {
		freeListingList.click();
	}

}
