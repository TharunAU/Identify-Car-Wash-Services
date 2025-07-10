package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchPageResultMobileRecharge;
import testBase.BaseClass;

public class TC010_MobileRecharge extends BaseClass {

	@Test
	public void MobileRecharge() {

		logger.info("------ Starting TC010_MobileRecharge ------");

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		logger.info("------ Clicked May Be Later Button ------");
		homePage.clickServiceMenu("Mobile");
		logger.info("------ Selected Mobile Service Menu ------");

		SearchPageResultMobileRecharge recharge = new SearchPageResultMobileRecharge(driver);

		recharge.setMobileNumber("8122537244");
		logger.info("------ Entered Valid Mobile Number ------");
		recharge.clickNewPlansButton();
		logger.info("------ Clicked New Plans Button in the Window ------");
		recharge.setPlan("Data");
		logger.info("------ Clicked Data plan in the plans Sub Menu ------");
		List<String> plans = recharge.getPlanDetails();
		for (String x : plans) {
			System.out.println(x);
		}
		List<Integer> amount = recharge.getAmountsFromData();
		logger.info("------ Displayed Results ------");

		boolean flag = true;

		for (Integer x : amount) {
			if (!(x <= 1000)) {
				flag = false;
			}
		}

		if (flag) {
			Assert.assertTrue(true);
			logger.info("------ Test Case Passed ------");
		} else {
			Assert.fail();
			logger.info("------ Test Case Failed ------");
		}
		logger.info("----------------------------------------------------------------------------------------");

	}

}
