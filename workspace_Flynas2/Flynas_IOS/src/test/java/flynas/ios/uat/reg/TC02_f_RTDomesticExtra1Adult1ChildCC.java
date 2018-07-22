package flynas.ios.uat.reg;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;


import flynas.ios.workflows.*;

public class TC02_f_RTDomesticExtra1Adult1ChildCC extends BookingPageFlow{
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Reg"),"TC_02_oneWayDomesticBusiness");

	@Test(dataProvider = "testData",groups={"ios"})
	public  void TC_02_d_RTDomesticBusiness1AdultCC(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Adult,String Child,String infant, String promo, 
			String bookingClass, String bundle,
			String FlightType,String totalpass,String nationality,String docType,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype, 
			String charity,String Currency, String Description
			) throws Throwable {
		try {
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			// Handlepopup();
			String[] Credentials = pickCredentials("UserCredentials");
			
			String username =Credentials[0];
			String password =Credentials[1];
		
			String depDate = pickDate(deptDate);
			
			Homepage homepage = new Homepage();
						
			
			homepage.Login(username,password);
			homepage.select_Bookflights("registered");
					
 			inputBookingDetails(tripType, origin, dest, depDate, origin2, departure2, retdate,Adult, Child, infant,promo,Currency);
			clickFindFlightsBtn();
 			selectClass(bookingClass, bundle);
 			continueOnPsngrDtls();
 			Baggage(bookingtype, totalpass);
 			continueOnExtras();
			selectSeat(SelectSeat, bookingtype,"");
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			validate_ticketStatus();
			Reporter.SuccessReport("TC02_f_RTDomesticExtra1Adult1ChildCC", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC02_f_RTDomesticExtra1Adult1ChildCC", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value2"),xls.getCellValue("Origin", "Value"),xls.getCellValue("Destination", "Value"),
	    		xls.getCellValue("Departure Date", "Value"),"","",xls.getCellValue("Return Date", "Value"),xls.getCellValue("Adults Count", "Value2"),
	    		xls.getCellValue("Child Count", "Value2"),xls.getCellValue("Infant Count", "Value"),xls.getCellValue("Promo", "Value"),
	    		xls.getCellValue("Booking Class", "Value"),xls.getCellValue("Bundle", "Value2"),xls.getCellValue("Flight Type", "Value"),xls.getCellValue("Total Passenger", "Value2"),
	    		xls.getCellValue("Nationality", "Value"),xls.getCellValue("Document Type", "Value"),xls.getCellValue("Doc Number", "Value"),
	    		"",xls.getCellValue("Mobile", "Value"),xls.getCellValue("Email Address", "Value"),xls.getCellValue("Select Seat", "Value"),
	    		xls.getCellValue("Payment Type", "Value"),"",xls.getCellValue("Charity Donation", "Value"),xls.getCellValue("Currency", "Value"),
	    		"Validate Round Trip Domestic one Adult Business class Booking"}};
	}

}
