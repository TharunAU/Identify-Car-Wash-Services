package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchPageResultMobileRecharge;
import testBase.BaseClass;

public class TC010_MobileRecharge extends BaseClass{
	
	@Test
	public void MobileRecharge() {
		
		HomePage homePage = new HomePage(driver); 
		
		homePage.clickMayBeLaterButton();
		homePage.clickServiceMenu("Mobile");
		
		SearchPageResultMobileRecharge recharge = new SearchPageResultMobileRecharge(driver);
		
		recharge.setMobileNumber("8122537244");
		recharge.clickNewPlansButton();
		recharge.setPlan("Data");
		List<String> plans = recharge.getPlanDetails();
		for(String x:plans) {
			System.out.println(x);
		}
		
	}
	
}
