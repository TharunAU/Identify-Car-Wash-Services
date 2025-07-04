package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FreeListingPhoneNumberPage;
import pages.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_FreeListing extends BaseClass{

	@Test(dataProvider = "TC002", dataProviderClass = DataProviders.class)
	public void freeListing(String phoneNumber) {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickFreeListingList();
		
		FreeListingPhoneNumberPage freelisting = new FreeListingPhoneNumberPage(driver);
		
		freelisting.setPhoneNumber(phoneNumber);
		freelisting.clickStartNowButton();
		String Message = freelisting.getErrorMessage();
		
		System.out.println("The Error Message is: "+Message);
		
		if(Message.equalsIgnoreCase("Please Enter a Valid Mobile Number")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
		
	}
	
}
