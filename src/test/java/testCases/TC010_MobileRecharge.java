package testCases;

import org.testng.annotations.Test;

import pages.HomePage;
import testBase.BaseClass;

public class TC010_MobileRecharge extends BaseClass{
	
	@Test
	public void MobileRecharge() {
		
		HomePage homePage = new HomePage(driver); 
		
		homePage.clickMayBeLaterButton();
	}
	
}
