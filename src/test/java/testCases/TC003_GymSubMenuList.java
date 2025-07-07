package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_GymSubMenuList extends BaseClass{
	
	@Test(dataProvider = "TC003", dataProviderClass = DataProviders.class)
	public void gymSubMenuList(String subMenu) {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.setSubMenu(subMenu);
		List<String> gymSubMenuList = homePage.getGymSubMenuList();
		for(int i=0;i<gymSubMenuList.size();i++) {
			System.out.println((i+1)+". "+gymSubMenuList.get(i));
		}
		
	}
	
}
