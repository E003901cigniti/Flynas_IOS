package flynas.android.scripts.uat.reg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.android.testObjects.BookingPageLocators;
import flynas.android.workflows.BookingPageFlow;
import flynas.android.workflows.Homepage;

public class TC07_roundTripDomFourAdultBusins extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataForAndroid"),"TC07_RTDom4adultBusinessCC");

	@Test(dataProvider = "testData",groups={"Android"})
	public  void TC_07_roundTripDomFourAdultBusins(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Audalt,String Child,String infant, 
			String promo, 
			String strBookingClass,
			String FlightType,String totalpass,String namtionality,String Doctypr,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype, 
			String charity,String Currency, String Description
			) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			// Handlepopup();
			String depDate = pickDate(deptDate);
			String rtrndate = pickDate(retdate);
			
			Homepage homepage = new Homepage();
			homepage.select_Bookflights("Anonymous");
					
 			inputBookingDetails(tripType, origin, dest, depDate, origin2, departure2, rtrndate,Audalt, Child, infant,promo,Currency);
 			selectClass(strBookingClass, tripType);
			inputPassengerDetails(FlightType,totalpass,namtionality,Doctypr,docNumber, naSmiles,Mobile,email,"","","");
			waitForElementPresent(BookingPageLocators.baggagetittle, "Baggage Tittle");
			if(isElementPresent(BookingPageLocators.baggagetittle)){
				click(BookingPageLocators.continuebtn, "Continue");
			}else{
				System.out.println("No Baggage is Available");				
			}
			waitForElementPresent(BookingPageLocators.seatSelecttionTittle, "seat Tittle");
			if(isElementPresent(BookingPageLocators.seatSelecttionTittle)){
				click(BookingPageLocators.continuebtn, "Continue");
			}else{
				System.out.println("No Seat is Available");				
			}
			payment(paymenttype,"");
			validate_ticketStatus();
			Reporter.SuccessReport("TC07_roundTripDomFourAdultBusins", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC07_roundTripDomFourAdultBusins", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value"),xls.getCellValue("Origin", "Value"),xls.getCellValue("Destination", "Value"),
	    		xls.getCellValue("Departure Date", "Value"),"",	"",	xls.getCellValue("Return Date", "Value"),xls.getCellValue("Adults Count", "Value"),
	    		xls.getCellValue("Child Count", "Value"),xls.getCellValue("Infant Count", "Value"),xls.getCellValue("Promo", "Value"),
	    		xls.getCellValue("Booking Class", "Value"),	xls.getCellValue("Flight Type", "Value"),xls.getCellValue("Total Passenger", "Value"),
	    		xls.getCellValue("Nationality", "Value"),xls.getCellValue("Document Type", "Value"),xls.getCellValue("Doc Number", "Value"),
	    		"",xls.getCellValue("Mobile", "Value"),xls.getCellValue("Email Address", "Value"),xls.getCellValue("Select Seat", "Value"),
	    		xls.getCellValue("Payment Type", "Value"),"",xls.getCellValue("Charity Donation", "Value"),xls.getCellValue("Currency", "Value"),
	    		"Validate Round Trip Domestic Four Adualt With Business"}};
	}


}
