package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtil;


public class BasePage {

	WebDriver driver;
	WaitUtil util;

	BasePage(WebDriver driver,WaitUtil util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver,this);
	}

}
