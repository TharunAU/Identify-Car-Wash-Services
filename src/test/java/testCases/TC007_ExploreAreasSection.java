package testCases;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TouristPlacesPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtilityClass;

public class TC007_ExploreAreasSection extends BaseClass {

	@Test(dataProvider = "TC007", dataProviderClass = DataProviders.class)
	public void ExploreAreasSection(String location) {
		logger.info("------ Starting TC007_ExploreAreasSection ------");
		
		String path=".\\testData\\Identify-Car-Wash-Services_TestData.xlsx";
		
		
		ExcelUtilityClass obj = new ExcelUtilityClass(path, "TC007");

		HomePage homePage = new HomePage(driver);

		homePage.clickMayBeLaterButton();
		logger.info("------ Clicked May Be Later Button ------");
		homePage.setLocationName(location);
		homePage.clickLocationFirstDropDown();
		logger.info("------ Selected Location ------");
		homePage.clickTopTouristPlace();
		logger.info("------ Selected Top Tourist Place in that Location ------");

		TouristPlacesPage tourist = new TouristPlacesPage(driver);
		tourist.clickCloseButtonForLocation();
		// Hotels
		List<String> hotels = tourist.getHotelDetails();
		// Restaurant
		List<String> restaurant = tourist.getRestaurantDetails();
		// Coffee Shops
		List<String> coffee = tourist.getCoffeeShop();
		// Restaurant
		List<String> travelAgent = tourist.getTravelAgentDetails();
		// Coffee Shops
		List<String> thingsToDo = tourist.getThingsToDo();

		System.out.println("\nTop Hotels in " + location + "\n");

		AtomicInteger counter = new AtomicInteger(0);

		hotels.forEach(hotel ->{
			int count = counter.incrementAndGet();
			obj.setCellData(hotel,count,1);
			String [] value = hotel.split(" , ");
			System.out.println("Hotel Name : "+value[0]+"\nRating : "+value[1]);

		});
		
		logger.info("------ Displayed Top Hotels ------");
		counter.set(0);
		System.out.println("\nTop Restaurants in " + location + "\n");
		restaurant.forEach(restaurants ->{
			int count = counter.incrementAndGet();
			obj.setCellData(restaurants,count ,2);
			String [] value = restaurants.split(" , ");
			System.out.println("Restaurant Name  : "+value[0]+"\nRating : "+value[1]);

		});
		logger.info("------ Displayed Top Restaurants ------");
		counter.set(0);
		System.out.println("\nTop Coffee Shops in " + location + "\n");
		coffee.forEach(coffeeShop ->{
			int count = counter.incrementAndGet();
			obj.setCellData(coffeeShop,count,3);
			String [] value = coffeeShop.split(" , ");
			System.out.println("Coffee Shop Name : "+value[0]+"\nRating : "+value[1]);

		});
		logger.info("------ Displayed Top Coffee Shops ------");
		counter.set(0);
		System.out.println("\nTop Travel Agents in " + location + "\n");
		travelAgent.forEach(travelAgents ->{
			int count = counter.incrementAndGet();
			obj.setCellData(travelAgents,count,4);
			String [] value = travelAgents.split(" , ");
			System.out.println("Travel Agents : "+value[0]+"\nRating : "+value[1]);

		});
		logger.info("------ Displayed Top Travel Agents ------");
		
		counter.set(0);
		System.out.println("\nTop Things to do in " + location + "\n");
		thingsToDo.forEach(thingsToDoValue ->{
			int count = counter.incrementAndGet();
			obj.setCellData(thingsToDoValue,count,5);
			String [] value = thingsToDoValue.split(" , ");
			System.out.println("Things To Do : "+value[0]+"\nRating : "+value[1]);
			System.out.println(count);

		});
		logger.info("------ Displayed Top Things To Do ------");
		
		for(int i=0; i<5;i++) {
			
		}
		

		if (hotels.isEmpty() || restaurant.isEmpty() || coffee.isEmpty() || travelAgent.isEmpty()
				|| thingsToDo.isEmpty()) {
			logger.info("------ Test Case Failed ------");
			Assert.fail();
			obj.setCellData("All the fields does Not have 5 Results",1,7);
			obj.setCellData("Fail",1,8);

		} else {
			logger.info("------ Test Case Passed ------");
			Assert.assertTrue(true);
			obj.setCellData("All the fields have 5 Results",1,7);
			obj.setCellData("Pass",1,8);

		}

		logger.info("----------------------------------------------------------------------------------------");

	}

}
