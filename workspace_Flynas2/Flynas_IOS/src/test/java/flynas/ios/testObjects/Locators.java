package flynas.ios.testObjects;

import org.openqa.selenium.By;

import com.ctaf.accelerators.ActionEngine;

public class Locators extends ActionEngine{
	
	//*************** Home Page *******************************************************************
	
	
	public static By bookFlights = By.xpath("//*[@resource-id='com.flynas.android.app:id/mainFunctionTitle1']");
	public static By onlineCheckin = By.xpath("//*[@text='Online check-in']");
	public static By manageBookings = By.xpath("//*[@resource-id='com.flynas.android.app:id/mainFunctionView3']");
	public static By tittleMenu = By.xpath("//*[@resource-id='com.flynas.android.app:id/titleMenu']");
	public static By login = By.xpath("//*[@resource-id='com.flynas.android.app:id/navDrawMemberName']");
	public static By email = By.xpath("//*[@resource-id='com.flynas.android.app:id/loginViewEmailText']");
	public static By pasword = By.xpath("//*[@resource-id='com.flynas.android.app:id/loginViewPasswordText']");
	public static By Login_btn = By.xpath("//*[@resource-id='com.flynas.android.app:id/loginViewLoginBtn']");
	public static By logout_btn = By.xpath("//*[@text='Log Out']");
	
	
	//**************** Search Flights Page *********************************************************
	
	public static By roundTrip = By.xpath("//*[@label='Return']");
	public static By oneWay = By.xpath("//*[@label='One-way']");
	public static By multiCity = By.xpath("//*[@label='Multi-City']");
	
	public static By origin = By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeButton");
	public static By origin_multicity = By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther[4]/XCUIElementTypeButton");
	public static By Departuredate = By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeButton");
	
	
	public static String search = "Search";
	public static By searchEdit = By.xpath("//*[@label='Search']");
	public static String searched_city = "#";
	
	public static By Audaltplusbutton = By.xpath("//*[@label='Adult']/following::XCUIElementTypeButton[2]");
	public static By childplusbutton = By.xpath("//*[@label='Child']/following::XCUIElementTypeButton[2]");
	public static By infantplusbutton = By.xpath("//*[@label='Infant']/following::XCUIElementTypeButton[2]");
	
	public static final By cuurencytab = By.xpath("//*[@label='Currency']/preceding::XCUIElementTypeButton");;
	
	public static By  currency(String Currency) {
		return By.xpath("//*[@text='"+Currency+"']");
	}
	
	//SmilePointsRadioBtn is not tested need to test and edit 
	public static By SmilePointsRadioBtn = By.xpath("//*[@label='Pay with SMILE Points']/preceding::XCUIElementTypeOther/XCUIElementTypeOther");
	
	public static String findFlights = "Find Flights";
	
	
	//**************** Select Flight Page **********************************************************
	
	//**************** Passenger Details Page ******************************************************
	
	//**************** Select Extras Page **********************************************************
	
	//**************** Select Seats Page ***********************************************************
	
	//**************** Payment Page ****************************************************************
	
	
	
	
	
}
