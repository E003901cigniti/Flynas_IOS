package flynas.ios.uat.routes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.BookingPageLocators;
import flynas.ios.workflows.BookingPageFlow;
import flynas.ios.workflows.Homepage;


public class TC62_roundTripDomesticEconomyAddExtra_RUH_AHB extends BookingPageFlow{
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Routes"),"AllRoutes");

	@Test(dataProvider = "testData",groups={"Economy"})
	public  void TC_62_roundTripDomesticEconomyAddExtra_RUH_AHB(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Audalt,String Child,String infant, String promo, 
			String bookingClass, String bundle,String FlightType,String totalpass,String namtionality,String Doctypr,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype, 
			String charity,String Currency,String username,String password, String Description) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			
//			click(BookingPageLocators.menu, "Menu");
//			click(BookingPageLocators.login_lnk, "Login");
//			login(username,password);
			
			selectBookFlights();			
			inputBookingDetails(tripType, origin, dest, deptDate, origin2, departure2, retdate,Audalt, Child, infant,promo,Currency);
			selectClass(bookingClass, bundle);
			waitforElement(BookingPageLocators.passengertitle);
			scrollJS(BookingPageLocators.selectExtras_btn);
			click(BookingPageLocators.selectExtras_btn, "Select Extras");
			Baggage(bookingtype, totalpass);
			Select_Meal();
			if(isElementPresent(BookingPageLocators.seatSelectionTittle)==true){
				selectallSeats(SelectSeat, totalpass, tripType);
			}else{
				System.out.println("No Seat Available");
			}
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			String pnr = getReferenceNumber();
			validate_ticketStatus(pnr);
			Reporter.SuccessReport("TC62_roundTripDomesticEconomyAddExtra_RUH_AHB", "Pass");
			
			}
		
	catch (Exception e) {
		e.printStackTrace();
			Reporter.failureReport("TC62_roundTripDomesticEconomyAddExtra_RUH_AHB", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value2"),
	    		xls.getCellValue("Origin", "Value62"),
	    		xls.getCellValue("Destination", "Value62"),
	    		xls.getCellValue("Departure Date", "Value"),
	    		"",
	    		"",
	    		xls.getCellValue("Return Date", "Value"),
	    		xls.getCellValue("Adults Count", "Value"),
	    		xls.getCellValue("Child Count", "Value"),
	    		xls.getCellValue("Infant Count", "Value"),
	    		xls.getCellValue("Promo", "Value"),
	    		xls.getCellValue("Booking Class", "Value"),
	    		xls.getCellValue("bundle", "Value"),
	    		xls.getCellValue("Flight Type", "Value"),
	    		xls.getCellValue("Total Passenger", "Value"),
	    		xls.getCellValue("Nationality", "Value"),
	    		xls.getCellValue("Document Type", "Value"),
	    		xls.getCellValue("Doc Number", "Value"),
	    		"",
	    		xls.getCellValue("Mobile", "Value"),
	    		xls.getCellValue("Email Address", "Value"),
	    		xls.getCellValue("Select Seat", "Value"),
	    		xls.getCellValue("Payment Type", "Value"),
	    		"",
    			xls.getCellValue("Charity Donation", "Value"),
    			xls.getCellValue("Currency", "Value"),
    			xls.getCellValue("username", "Value"),
    			xls.getCellValue("password", "Value"),
	    		"Validate RoundTrip Domestic Economy Add Extra_RUH_AHB"}};
	}

}