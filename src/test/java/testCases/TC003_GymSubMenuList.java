package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import testBase.BaseClass;

public class TC003_GymSubMenuList extends BaseClass{
	
	@Test
	public void gymSubMenuList() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMayBeLaterButton();
		homePage.clickFitnessButton();
		List<String> gymSubMenuList = homePage.getGymSubMenuList();
		for(int i=0;i<gymSubMenuList.size();i++) {
			System.out.println((i+1)+". "+gymSubMenuList.get(i));
		}
		
	}
	
}
