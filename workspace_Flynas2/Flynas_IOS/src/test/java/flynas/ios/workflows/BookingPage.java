package flynas.ios.workflows;

import java.util.concurrent.TimeUnit;

import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.BookingPageLocators;
import flynas.ios.testObjects.Locators;

public class BookingPage extends Locators {
	
	public static void waitforpageload ()throws Throwable
	{
		waitforElement(Locators.OWbtn);
	}
	
	public static void tripType(String triptype)throws Throwable
	{
		if(triptype.equalsIgnoreCase("One Way"))
		click(Locators.OWbtn, "One Way");
		else if (triptype.equalsIgnoreCase("Round Trip"))
			click(Locators.roundtrip, "Round Trip");
		else if (triptype.equalsIgnoreCase("Multi City"))
			click(Locators.multiCity, "Multi City");
	}
	
	public static void clickOrigin1 () throws Throwable{
		click(Locators.origin, "Origin");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public static void clickOrigin2 () throws Throwable{
		
		click(Locators.origin_multicity, "Origin2");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public static void selectCities(String Origin, String Destination) throws Throwable{
		
		click_mobile(Locators.search, "Search");
		type_mobile(Locators.search, Origin, "Origin");
		click_mobile(Locators.searched_city.replace("#", Origin), "Origin");
		if(Destination!=""){
		type_mobile(Locators.search, Destination, "Destination");
		click_mobile(Locators.searched_city.replace("#", Destination), "Destination");
		}
	}
	
	public static void select_dates(String deptDate, String retDate) throws Throwable{
		click(Locators.Departuredate, "Departure Date");
		projectUtilities.select_date(deptDate);
		if(retDate!="") 
		projectUtilities.select_date(retDate);
		click(Locators.Select_date, "Select Date");
	}
	
	public static void selectpsngrCount(int adults, int chldrn, int infants) throws Throwable{
		if(adults+chldrn+infants <= 9 )
		{try{
			if(Integer.valueOf(adults)>1){
				for(int i=1;i<Integer.valueOf(adults);i++)
				{
				click(Locators.Audaltplusbutton, "Adult");
				System.out.println("Adults: "+adults);
				}
			}
			if(Integer.valueOf(chldrn)>0){
				for(int i=1;i<Integer.valueOf(chldrn);i++)
				{
					click(Locators.childplusbutton, "Children");
					System.out.println("Children: "+chldrn);
				}
			}
			if(Integer.valueOf(infants)>0){
				for(int i=1;i<Integer.valueOf(infants);i++)
				{
					click(Locators.infantplusbutton, "Infants");
					System.out.println("Infants: "+infants);
				}
			}
			Reporter.SuccessReport("Adding passenger count", "Passenger count added successfully");
			}
		catch(Exception e){
			Reporter.failureReport("Adding passenger count", "Could not add passenger count");
		}
		}
		else {
			Reporter.failureReport("Adding passenger count", "Total passenger count can't be greater than 9");
		}	
	}
	
	public static void ClickFindFlights() throws Throwable
	{
		click_mobile(BookingPageLocators.findFlights, "Find Flights");
	}
	
	

}
