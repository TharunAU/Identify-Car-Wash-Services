package testCases;

import org.testng.annotations.Test;

import pageObjects.FreeListingPhoneNumberPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_FreeListing extends BaseClass{

	@Test
	public void freeListing() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickFreeListingList();
		
		FreeListingPhoneNumberPage freelisting = new FreeListingPhoneNumberPage(driver);
		
		freelisting.setPhoneNumber("0000000000");
		freelisting.clickStartNowButton();
		String Message = freelisting.getErrorMessage();
		
		System.out.println("The Error Message is: "+Message);
		
	}
	
}
