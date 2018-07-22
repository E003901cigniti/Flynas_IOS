package flynas.ios.Prod.routes;

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


public class TC159_oneWayInternationalBusiness_JED_KWI extends BookingPageFlow{
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Routes"),"AllRoutes");

	@Test(dataProvider = "testData",groups={"Business"})
	public  void TC_159_oneWayInternationalBusiness_JED_KWI(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Audalt,String Child,String infant, String promo, 
			String bookingClass, String bundle,
			String FlightType,String totalpass,String namtionality,String Doctypr,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype, 
			String charity,String Currency, String Description) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			

			String[] Credentials = pickCredentials("PRODcredentials");
			String username =Credentials[0];
			String password =Credentials[1];
			
			login(username,password);
			selectBookFlights();			
						
			inputBookingDetails(tripType, origin, dest, deptDate, origin2, departure2, retdate,Audalt, Child, infant,promo,Currency);
			selectClass(bookingClass, bundle);
			continueOnPsngrDtls();
			continueOnExtras();
			continueOnSeatSelection();
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			String pnr = getReferenceNumber();
			verifyPNRforSadad(pnr);
			
			Reporter.SuccessReport("TC159_oneWayInternationalBusiness_JED_KWI", "Pass");
			
			}
		
	catch (Exception e) {
		e.printStackTrace();
			Reporter.failureReport("TC159_oneWayInternationalBusiness_JED_KWI", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value"),
	    		xls.getCellValue("Origin", "Value35"),
	    		xls.getCellValue("Destination", "Value35"),
	    		xls.getCellValue("Departure Date", "Value"),
	    		"",
	    		"",
	    		xls.getCellValue("Return Date", "Value"),
	    		xls.getCellValue("Adults Count", "Value"),
	    		xls.getCellValue("Child Count", "Value"),
	    		xls.getCellValue("Infant Count", "Value"),
	    		xls.getCellValue("Promo", "Value"),
	    		xls.getCellValue("Booking Class", "Value2"),
	    		"",
	    		xls.getCellValue("Flight Type", "Value"),
	    		xls.getCellValue("Total Passenger", "Value"),
	    		xls.getCellValue("Nationality", "Value"),
	    		xls.getCellValue("Document Type", "Value"),
	    		xls.getCellValue("Doc Number", "Value"),
	    		"",
	    		xls.getCellValue("Mobile", "Value"),
	    		xls.getCellValue("Email Address", "Value"),
	    		xls.getCellValue("Select Seat", "Value"),
	    		xls.getCellValue("Payment Type", "Value2"),
	    		"",
    			xls.getCellValue("Charity Donation", "Value"),
    			xls.getCellValue("Currency", "Value"),
    	    		"Validate oneWay International Business_JED_KWI"}};
	}

}