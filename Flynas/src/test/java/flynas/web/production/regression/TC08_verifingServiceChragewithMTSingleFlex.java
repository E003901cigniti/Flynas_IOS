package flynas.web.production.regression;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;
import flynas.web.workflows.BookingPageFlow;

public class TC08_verifingServiceChragewithMTSingleFlex extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataIBEProdReg"),"TC08");

	@Test(dataProvider = "testData",groups={"Production"})
	public  void TC_08_verifingServiceChragewithMTSingleFlex( String username,String password,String bookingClass,String mobilenum,
			String paymentType,String newDate,String departuredate,String rtnDate,String origin,String dest,String triptype,String adult,
			String child,String totalpass,String infant,String seatSelect,String nationality,String docNum,String flightType,String Doctype,
			String origin2,String dest2,String Description) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			String deptDate = pickDate(departuredate);	
			String rtrnDate = pickDate(rtnDate);
			click(BookingPageLocators.login_lnk, "Login");
			login(username,password);
			inputBookingDetails(triptype,origin, dest, deptDate , origin2,dest2, rtrnDate,adult, child, infant,"","","");
			selectClass(bookingClass, "");
			waitforElement(BookingPageLocators.passengerDetailsTittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			clickContinueBtn();
			waitforElement(BookingPageLocators.baggagetittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			if(isElementDisplayedTemp(BookingPageLocators.baggagetittle)==true){
				clickContinueBtn();
			}else{
				System.out.println("No Baggage Availabel");
			}
			waitforElement(BookingPageLocators.selectseattittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			if(isElementDisplayedTemp(BookingPageLocators.selectseattittle)==true){
				selectSeat(seatSelect, "");
			}else{
				System.out.println("No Seat Page Available");
			}
			
			payment(paymentType, "");
			String strpnr = getReferenceNumber();
			verifingStatusSadad();
			verifingServiceCharge(triptype, bookingClass, totalpass);
			
			Reporter.SuccessReport("TC08_verifingServiceChragewithMTSingleFlex", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC08_verifingServiceChragewithMTSingleFlex", "Failed");
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
		    		xls.getCellValue("Select Seat", "Value"),
		    		xls.getCellValue("Nationality", "Value"),
		    		xls.getCellValue("Doc Number", "Value"),
		    		xls.getCellValue("Flight Type", "Value"),
		    		xls.getCellValue("Document Type", "Value"),
		    		xls.getCellValue("Origin2", "Value"),
		    		xls.getCellValue("Destination2", "Value"),
		    		"Verifying Service Charge with Multi Trip Flex Domestic"}};
	}

}
