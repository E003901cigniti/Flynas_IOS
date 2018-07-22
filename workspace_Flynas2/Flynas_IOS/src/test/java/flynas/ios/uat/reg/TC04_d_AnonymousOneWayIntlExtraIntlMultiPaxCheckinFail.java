package flynas.ios.uat.reg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.*;
import flynas.ios.workflows.*;

public class TC04_d_AnonymousOneWayIntlExtraIntlMultiPaxCheckinFail extends BookingPageFlow {
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Reg"),"TC04_oneWayDomAdultCheckin");

	@Test(dataProvider = "testData",groups={"ios"})
	public  void TC0_4_d_AnonymousOneWayIntlExtraIntlMultiPaxCheckinFail2(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Adult,String Child,String infant, String promo, 
			String bookingClass, String bundle,	String FlightType,String totalpass,String nationality,String Doctype,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype,String newDate,
			String charity,String Currency, String Description
			) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			// Handlepopup();
			
			String depDate = pickDate(deptDate);
			String rtrndate = pickDate(retdate);
			
			Homepage homepage = new Homepage();
					
			homepage.select_Bookflights("Anonymous");
					
			inputBookingDetails(tripType, origin, dest, depDate, origin2, departure2, rtrndate,Adult, Child, infant,promo,Currency);
			clickFindFlightsBtn();
			selectClass(bookingClass, bundle);
			String[] passenger = inputPassengerDetails(FlightType,totalpass,nationality,Doctype,docNumber, naSmiles,Mobile,email,"","","");
 			continueOnExtras();
 			continueOnSeatSelection();
 			paymentoption("Otherpayment");
			payment(paymenttype,"");
			validate_ticketStatus();
			String PNRnumber = getReferenceNumber();
			System.out.println(PNRnumber);
			navigatetoHmPg();
			handleRatingRequest();
			homepage.select_OnlineCheckIn("Anonymous");
			searchFlightCheckin(PNRnumber,passenger[1]);
			verifyAnonymousCheckinFail();
			
			Reporter.SuccessReport("TC04_d_AnonymousOneWayIntlExtraIntlMultiPaxCheckinFail", "Pass");
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC04_d_AnonymousOneWayIntlExtraIntlMultiPaxCheckinFail", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value"),
	    		xls.getCellValue("Origin", "Value2"),
	    		xls.getCellValue("Destination", "Value2"),
	    		xls.getCellValue("Departure Date", "Value2"),
	    		"",
	    		"",
	    		xls.getCellValue("Return Date", "Value2"),
	    		xls.getCellValue("Adults Count", "Value2"),
	    		xls.getCellValue("Child Count", "Value2"),
	    		xls.getCellValue("Infant Count", "Value2"),
	    		xls.getCellValue("Promo", "Value"),
	    		xls.getCellValue("Booking Class", "Value"),
	    		xls.getCellValue("Bundle", "Value2"),
	    		xls.getCellValue("Flight Type", "Value2"),
	    		xls.getCellValue("Total Passenger", "Value2"),
	    		xls.getCellValue("Nationality", "Value"),
	    		xls.getCellValue("Document Type", "Value"),
	    		xls.getCellValue("Doc Number", "Value"),
	    		"",
	    		xls.getCellValue("Mobile", "Value"),
	    		xls.getCellValue("Email Address", "Value"),
	    		xls.getCellValue("Select Seat", "Value"),
	    		xls.getCellValue("Payment Type", "Value"),
	    		"",
	    		xls.getCellValue("New Date", "Value"),
    			xls.getCellValue("Charity Donation", "Value"),
    			xls.getCellValue("Currency", "Value"),
	    		"Validate One way Intl with Multi pax Checkin failure"}};
	}
	

}
