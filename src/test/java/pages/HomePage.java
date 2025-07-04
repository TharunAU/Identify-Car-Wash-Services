package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtil;

public class HomePage extends BasePage {
	
	JavascriptExecutor js;

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
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
	
	@FindBy(xpath="//button[contains(normalize-space(),'Fitness')]")
	WebElement fitnessButton;
	
	@FindBy(xpath="//div[@id = 'panel4']//a")
	List<WebElement> gymList;
	
	@FindBy(xpath="//*[@id='home-page-container']/div[3]/span")
	WebElement closeButton;
	
	@FindBy(xpath="//button[@id='popular_categories']")
	WebElement popularCategoryButton;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath="//div[contains(@class,'sidemenu_text')]")
	List<WebElement> searchResults;
	
	@FindBy(xpath="//button[@id='hk_srchbtn']")
	WebElement searchResultClose;
	
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
	
	public void clickFitnessButton() {
		for (int i = 0; i < 20; i++) {
		    try {
		        if (fitnessButton.isDisplayed()) {
		            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", fitnessButton);
		            fitnessButton.click();
		            break;
		        }
		    } catch (Exception e) {
		        // Element not found yet, scroll down further
		        js.executeScript("window.scrollBy(0, 300);");
		    }
		}
	}
	
	public List<String> getGymSubMenuList() {
		List<String> result = new ArrayList<>();
		for(WebElement x:gymList) {
			String value = x.getText().toLowerCase();
			if(value.contains("gym") || value.contains("fitness")) {
				result.add(x.getText());
			}
		}
		return result;
	}
	
	public void clickCloseButton() {
		closeButton.click();
	}
	
	public void clickPopularCategoryButton() {
		popularCategoryButton.click();
	}
	
	public void setSearchValue(String search) {
		searchBox.sendKeys(search);
	}
	
	public List<String> getCategorySearchResults() {
		List<String> results = new ArrayList<>();
		for(WebElement x:searchResults) {
			results.add(x.getText());
		}
		return results;
	}
	
	public void clickSearchResultClose() {
		searchResultClose.click();
	}
	
}
