package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.TouristPlacesPage;
import testBase.BaseClass;

public class TC007_ExploreAreasSection extends BaseClass {

	@Test
	public void ExploreAreasSection() {

		HomePage homePage = new HomePage(driver);
	
		homePage.clickMayBeLaterButton();
		String location = "Coimbatore";
		homePage.setLocationName(location);
		homePage.clickLocationFirstDropDown();
		homePage.clickTopTouristPlace();

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
		hotels.forEach(System.out::println);

		System.out.println("\nTop Restaurants in " + location + "\n");
		restaurant.forEach(System.out::println);

		System.out.println("\nTop Coffee Shops in " + location + "\n");
		coffee.forEach(System.out::println);
		
		System.out.println("\nTop Travel Agents in " + location + "\n");
		travelAgent.forEach(System.out::println);

		System.out.println("\nTop Things to do in " + location + "\n");
		thingsToDo.forEach(System.out::println);

	}

}
