package flynas.web.production.regression;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;
import flynas.web.workflows.BookingPageFlow;

public class TC25_verifingServiceChargeMTSingleEcoIntlTR extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataIBEProdReg"),"TC25");

	@Test(dataProvider = "testData",groups={"Production"})
	public  void TC_25_verifingServiceChargeMTSingleEcoIntlTR( String username,String password,String bookingClass,String mobilenum,
			String paymentType,String naSmile,String departuredate,String rtnDate,String origin,String dest,String triptype,
			String adult,String child,String totalpass,String infant,String seatSelect,String nationality,String docNum,
			String flightType,String Doctype,String BookingClassSr,String origin2,String dept2,String Description) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			String deptDate = pickDate(departuredate);
			String rtrnDate = pickDate(rtnDate);
			click(BookingPageLocators.Arabic_pdctn_AR("Türkçe"), "Türkçe Language");
			click(BookingPageLocators.login_lnk, "Login");
			login(username,password);
			inputBookingDetails_Tarkish(triptype,origin, dest, deptDate ,origin2,dept2, rtrnDate,adult, child, infant,"","");
			selectClass(bookingClass,triptype);
			continueOnPassengerDetails();
			coninueOnBaggage();
			continueOnSeatSelection();
			payment(paymentType,"");
			verifyPNRforSadad_Tarkish();
			
			verifingServiceCharge(triptype, BookingClassSr.trim(), totalpass);
			
			Reporter.SuccessReport("TC25_verifingServiceChargeMTSingleEcoIntlTR", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.SuccessReport("TC25_verifingServiceChargeMTSingleEcoIntlTR", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
		  return (Object[][]) new Object[][] { 
	    		{
	    			xls.getCellValue("User Name", "Value"),
		    		xls.getCellValue("Password", "Value"),
		    		xls.getCellValue("Booking Class", "Value"),
		    		xls.getCellValue("Mobile", "Value"),
		    		xls.getCellValue("Payment Type", "Value"),
		    		"",
		    		xls.getCellValue("Departure Date", "Value"),
		    		xls.getCellValue("Return Date", "Value"),
		    		xls.getCellValue("Origin", "Value"),
		    		xls.getCellValue("Destination", "Value"),
		    		xls.getCellValue("Trip Type", "Value"),
		    		xls.getCellValue("Adults Count", "Value"),
		    		xls.getCellValue("Child Count", "Value"),
		    		xls.getCellValue("total pass", "Value"),
		    		"0",
		    		"",
		    		xls.getCellValue("Nationality", "Value"),
		    		xls.getCellValue("Doc Number", "Value"),
		    		xls.getCellValue("Flight Type", "Value"),
		    		xls.getCellValue("Document Type", "Value"),
		    		xls.getCellValue("BookingClassSr", "Value"),
		    		xls.getCellValue("Origin2", "Value"),
		    		xls.getCellValue("Destination2", "Value"),
		    		"Verifing Service Charge MT Single Economy International TR"}};
	}

}
