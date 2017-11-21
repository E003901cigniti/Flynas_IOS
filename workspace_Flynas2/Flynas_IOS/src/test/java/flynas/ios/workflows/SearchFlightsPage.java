package flynas.ios.workflows;

import java.util.concurrent.TimeUnit;

import flynas.ios.testObjects.BookingPageLocators;
import flynas.ios.testObjects.Locators;

public class SearchFlightsPage extends Locators {
	
	public void waitforpageload ()throws Throwable
	{
		waitforElement(Locators.oneWay);
	}
	
	public void selectOneWay ()throws Throwable
	{
		click(Locators.oneWay, "One Way");
	}
	
	public void selectRoundTrip ()throws Throwable
	{
		click(Locators.roundTrip, "Round Trip");
	}
	
	public void selectMultiCity ()throws Throwable
	{
		click(Locators.multiCity, "Multi City");
	}
	
	public void selectOrigin1 () throws Throwable{
		
		click(Locators.origin, "Origin");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public void selectOrigin2 () throws Throwable{
		
		click(Locators.origin_multicity, "Origin2");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public void selectCities(String Origin, String Destination) throws Throwable{
		
		click_mobile(Locators.search, "Search");
		type_mobile(Locators.search, Origin, "Origin");
		click_mobile(Locators.searched_city.replace("#", Origin), "Origin");
		type_mobile(Locators.search, Destination, "Destination");
		click_mobile(Locators.searched_city.replace("#", Destination), "Destination");
		
	}
	
	public void selectOnewayDate() throws Throwable{
		
	}
	public void selectTwowayDates() throws Throwable{
		
	}
	
	public void selectAdultCount(int adults) throws Throwable{
		if(Integer.valueOf(adults)>1){
			for(int i=1;i<Integer.valueOf(adults);i++)
			{
				click(Locators.Audaltplusbutton, "Adult");
				System.out.println("Adults: "+adults);
			}
		}
	}
	
	public void selectChildCount(int chldrn) throws Throwable{
		if(Integer.valueOf(chldrn)>1){
			for(int i=1;i<Integer.valueOf(chldrn);i++)
			{
				click(Locators.childplusbutton, "Children");
				System.out.println("Children: "+chldrn);
			}
		}
	}
	
	public void selectInfantCount(int infants) throws Throwable{
		if(Integer.valueOf(infants)>1){
			for(int i=1;i<Integer.valueOf(infants);i++)
			{
				click(Locators.infantplusbutton, "Infants");
				System.out.println("Infants: "+infants);
			}
		}
	}
	
	public void selectcurrency(String currency) throws Throwable
	{
		click(Locators.cuurencytab, "Currencytab");
		click(Locators.currency(currency),"currency");
	}
	
	public void selectSmilePointsPymnt ()throws Throwable
	{
		click(Locators.SmilePointsRadioBtn, "Multi City");
	}
	
	public void ClickFindFlights ()throws Throwable
	{
		click_mobile(BookingPageLocators.findFlights, "Find Flights");
	}
	
	

}
