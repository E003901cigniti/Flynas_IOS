package flynas.ios.uat.reg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.ios.workflows.*;

public class TC04_b_RtIntlOneAdultCheckinfail extends BookingPageFlow{
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Reg"),"TC04_oneWayDomAdultCheckin");

	@Test(dataProvider = "testData",groups={"ios"})
	public  void TC04b_RtIntlOneAdultCheckinFail ( String tripType, 
			String origin, String dest, String deptDate,String origin2,String departure2, String retdate,
			String Adult,String Child,String infant, String promo, String bookingClass, String bundle, String FlightType,String totalpass,String nationality,String docType,
			String docNumber, String naSmiles,String Mobile,String email ,String SelectSeat,
			String paymenttype, String bookingtype,String Charity, 
			String Currency,String Description) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			
			//Initializing departure date and return date
			String depDate = pickDate(deptDate);
			String retrndate = pickDate(retdate);
			
			//User Login
			String[] Credentials = pickCredentials("UserCredentials");
			String username =Credentials[0];
			String password =Credentials[1];
						
			Homepage homepage = new Homepage();
						
			
			homepage.Login(username,password);
			homepage.select_Bookflights("registered");
			
			//Entering Booking Details
			inputBookingDetails(tripType, origin, dest, depDate, origin2,departure2,retrndate,Adult, Child, infant,promo,Currency);
			clickFindFlightsBtn();
			//Selecting flight and traveling class
			selectClass(bookingClass, bundle);
			
			//Clicking continue button on Passenger details page
			continueOnPsngrDtls();
			continueOnExtras();
			continueOnSeatSelection();
			//selectSeat(SelectSeat, bookingtype,"");
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			String strpnr = getReferenceNumber();
			String PNR = strpnr.trim();
			System.out.println(PNR);
			validate_ticketStatus();
			navigatetoHmPg();
			handleRatingRequest();
			homepage.select_OnlineCheckIn("registered");
			verifyPNRinCheckinList(PNR,false);
			
			
			Reporter.SuccessReport("TC04_b_RtIntlOneAdultCheckinFail", "Passed");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC04_b_RtIntlOneAdultCheckinFail", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{
	    			xls.getCellValue("Trip Type", "Value2"),
		    		xls.getCellValue("Origin", "Value2"),
		    		xls.getCellValue("Destination", "Value2"),
		    		xls.getCellValue("Departure Date", "Value2"),
		    		"",
		    		"",
		    		xls.getCellValue("Return Date", "Value2"),
		    		xls.getCellValue("Adults Count", "Value"),
		    		xls.getCellValue("Child Count", "Value"),
		    		xls.getCellValue("Infant Count", "Value"),
		    		xls.getCellValue("Promo", "Value"),
		    		xls.getCellValue("Booking Class", "Value"),xls.getCellValue("Bundle", "Value"),
		    		xls.getCellValue("Flight Type", "Value2"),
		    		xls.getCellValue("Total Passenger", "Value"),
		    		xls.getCellValue("Nationality", "Value"),
		    		xls.getCellValue("Document Type", "Value"),
		    		xls.getCellValue("Doc Number", "Value"),
		    		xls.getCellValue("na Smiles", "Value"),
		    		xls.getCellValue("Mobile", "Value"),
		    		xls.getCellValue("Email Address", "Value"),
		    		xls.getCellValue("Select Seat", "Value"),
		    		xls.getCellValue("Payment Type", "Value"),
		    		"",
	    			xls.getCellValue("Charity Donation", "Value"),
	    			"",
		    		"Validate check-in failure for booking more than 48 hrs, RT international simple booking "}};
	}

}