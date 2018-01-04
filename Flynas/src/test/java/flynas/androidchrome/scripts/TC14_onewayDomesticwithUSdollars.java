package flynas.androidchrome.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;
import flynas.web.workflows.BookingPageFlow;

public class TC14_onewayDomesticwithUSdollars extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"FL_WEB_13");

	@Test(dataProvider = "testData",groups={"Chrome"})
	public  void TC_14_onewayDomesticwithUSdollars(String tripType, String origin, String dest, 
			String deptDate,String origin2,String departure2, String retdate,String Audalt,String Child,String infant, String promo, String strBookingClass,
			String FlightType,String totalpass,String nationality,String Doctypr,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype,
			String charity,String Currency,String Description
			) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			String	deptdate = pickDate(deptDate);
			inputBookingDetails(tripType, origin, dest, deptdate, origin2,departure2,retdate,Audalt, Child, infant,promo,Currency,paymenttype);
			selectClass(strBookingClass, tripType);
			String lastname[]=inputPassengerDetails(FlightType,totalpass,nationality,Doctypr,docNumber, naSmiles,Mobile,email,"","","");
			System.out.println(lastname);
			waitforElement(BookingPageLocators.baggagetittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			if(isElementDisplayedTemp(BookingPageLocators.baggagetittle)==true){
				click(BookingPageLocators.continueBtn, "Continue");
			}else{
				System.out.println("No Baggage Page");
			}
			waitforElement(BookingPageLocators.selectseattittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			if(isElementDisplayedTemp(BookingPageLocators.selectseattittle)==true){
				selectallSeatstoremove(SelectSeat, totalpass, tripType);
			}
			
			payment(paymenttype,"");
			String PNR=getReferenceNumber();
			String strPNR = getReferenceNumber();
			
			System.out.println(strPNR);
			
			validate_ticketStatus(strPNR);
			
			Reporter.SuccessReport("TC13_onewayDomesticwithUSdollars", "Passed");
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.SuccessReport("TC13_onewayDomesticwithUSdollars", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value"),
	    		xls.getCellValue("Origin", "Value"),
	    		xls.getCellValue("Destination", "Value"),
	    		xls.getCellValue("Departure Date", "Value"),
	    		"",
	    		"",
	    		xls.getCellValue("Return Date", "Value"),
	    		xls.getCellValue("Adults Count", "Value"),
	    		xls.getCellValue("Child Count", "Value"),
	    		xls.getCellValue("Infant Count", "Value"),
	    		xls.getCellValue("Promo", "Value"),
	    		xls.getCellValue("Booking Class", "Value"),
	    		xls.getCellValue("Flight Type", "Value"),
	    		xls.getCellValue("Total Passenger", "Value"),
	    		xls.getCellValue("Nationality", "Value"),
	    		xls.getCellValue("Document Type", "Value"),
	    		xls.getCellValue("Doc Number", "Value"),
	    		"1234567890",
	    		xls.getCellValue("Mobile", "Value"),
	    		xls.getCellValue("Email Address", "Value"),
	    		xls.getCellValue("Select Seat", "Value"),
	    		"Credit Card",
	    		"",
    			xls.getCellValue("Charity Donation", "Value"),
    			xls.getCellValue("Currency", "Value"),
	    		"Validate One way Domestic with USDollars"}};
	}
}
