package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import testBase.BaseClass;

public class TC003_GymSubMenuList extends BaseClass {

	@Test
	public void gymSubMenuList() {

		logger.info("------ Starting TC003_GymSubMenuList ------");

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		logger.info("------ Clicked May Be Later Button ------");

		homePage.setSubMenu("Fitness");
		logger.info("------ Clicked the Fitness Menu ------");

		List<String> gymSubMenuList = homePage.getGymSubMenuList();
		for (int i = 0; i < gymSubMenuList.size(); i++) {
			System.out.println((i + 1) + ". " + gymSubMenuList.get(i));
		}
		logger.info("------ Displayed the GYMs Sub menus ------");

		boolean flag = true;

		for (String x : gymSubMenuList) {
			if (!(x.toLowerCase().contains("gym") || x.toLowerCase().contains("fitness"))) {
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
