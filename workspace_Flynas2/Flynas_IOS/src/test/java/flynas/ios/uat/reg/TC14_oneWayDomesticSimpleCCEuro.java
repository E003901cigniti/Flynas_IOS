package flynas.ios.uat.reg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.BookingPageLocators;

import flynas.ios.workflows.*;

import flynas.ios.workflows.*;

import flynas.ios.workflows.*;

public class TC14_oneWayDomesticSimpleCCEuro extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Reg"),"FL_WEB_14");

	@Test(dataProvider = "testData",groups={"ios"})
	public  void TC_14_oneWayDomesticSimpleCCEuro(String tripType, String origin, String dest,String deptDate, String origin2,
			String departure2, String retdate,String Adult,String Child,String infant, String promo,String bookingClass, String bundle,
			String FlightType,String totalpass,String nationality,String docType,String docNumber,String naSmiles,String Mobile,
			String email ,String SelectSeat,String paymenttype,String bookingtype,String charity,String Currency, String Description
			) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			// Handlepopup();
			String[] Credentials = pickCredentials("UserCredentials");
			
			String username =Credentials[0];
			String password =Credentials[1];
		
			String depDate = pickDate(deptDate);
			String rtrndate = pickDate(retdate);
			
			Homepage homepage = new Homepage();
			SettingsPage settings = new SettingsPage();
			homepage.click_Settings();
			settings.set("Currency", Currency);
			settings.click_BackIcn();			
			homepage.Login(username,password);
			homepage.select_Bookflights("registered");
					
 			inputBookingDetails(tripType, origin, dest, depDate, origin2, departure2, rtrndate,Adult, Child, infant,promo,Currency);
 			clickFindFlightsBtn();
 			selectClass(bookingClass, bundle);
 			continueOnPsngrDtls();
			continueOnExtras();
			continueOnSeatSelection();
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			validate_ticketStatus();
			Reporter.SuccessReport("TC14_oneWayDomesticSimpleCCEuro", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC14_oneWayDomesticSimpleCCEuro", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value"),xls.getCellValue("Origin", "Value"),xls.getCellValue("Destination", "Value"),
	    		xls.getCellValue("Departure Date", "Value"),"","",xls.getCellValue("Return Date", "Value"),xls.getCellValue("Adults Count", "Value"),
	    		xls.getCellValue("Child Count", "Value"),xls.getCellValue("Infant Count", "Value"),xls.getCellValue("Promo", "Value"),
	    		xls.getCellValue("Booking Class", "Value"),xls.getCellValue("Bundle", "Value"),xls.getCellValue("Flight Type", "Value"),xls.getCellValue("Total Passenger", "Value"),
	    		xls.getCellValue("Nationality", "Value"),xls.getCellValue("Document Type", "Value"),xls.getCellValue("Doc Number", "Value"),
	    		"",xls.getCellValue("Mobile", "Value"),xls.getCellValue("Email Address", "Value"),xls.getCellValue("Select Seat", "Value"),
	    		xls.getCellValue("Payment Type", "Value"),"",xls.getCellValue("Charity Donation", "Value"),xls.getCellValue("Currency", "Value2"),
	    		"Validate one Way Domestic Simple booking with Euros"}};
	}
}
