package flynas.web.production.routes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;
import flynas.web.workflows.BookingPageFlow;

public class TC24_roundTripDomesticEconomy_DMM_TUU extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataProdRoutes"),"Chrome_TestData");

	@Test(dataProvider = "testData",groups={"Economy"})
	public  void TC_24_roundTripDomesticEconomy_DMM_TUU( String bookingClass,
			String mobilenum, String paymentType, String newDate,String Departuredate,String rtnDate, String origin,
			String dest,String triptype,String adult,String child,String infant,String seatSelect,
			String Description) throws Throwable {
		try {
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			String deptDate = pickDate(Departuredate);
			String retrnDate = pickDate(rtnDate);
			String[] Credentials = pickCredentials("UserCredentials");
				String username =Credentials[0];
				String password =Credentials[1];					
				
				click(BookingPageLocators.login_lnk, "Login");				
				login(username,password);
			inputBookingDetails(triptype,origin, dest, deptDate , "", "", retrnDate,adult, child, infant,"","","");
			selectClass(bookingClass, triptype);
			continueOnPassengerDetails();
			coninueOnBaggage();
			continueOnSeatSelection();
			payment(paymentType, "");
			String strpnr = getReferenceNumber();
			String strPNR = strpnr.trim();
			System.out.println(strPNR);
			verifyPNRforSadad();
		
			Reporter.SuccessReport("TC24_roundTripDomesticEconomy_DMM_TUU", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC24_roundTripDomesticEconomy_DMM_TUU", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{
	    		
	    		xls.getCellValue("Booking Class", "Value"),
	    		xls.getCellValue("Mobile", "Value"),
	    		"SADAD",
	    		xls.getCellValue("NewDate", "Value"),
	    		xls.getCellValue("Departure Date", "Value"),
	    		xls.getCellValue("Return Date", "Value"),
	    		xls.getCellValue("Origin", "Value24"),
	    		xls.getCellValue("Destination", "Value24"),
	    		xls.getCellValue("Trip Type", "Value2"),
	    		xls.getCellValue("Adults Count", "Value"),
	    		xls.getCellValue("Child Count", "Value"),
	    		xls.getCellValue("Infant Count", "Value"),
	    		"Extra Leg Room",
	    		"Validate RoundTrip International Economy_DMM_TUU"}};
	}
}