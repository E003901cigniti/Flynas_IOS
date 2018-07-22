
package flynas.ios.uat.reg;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.BookingPageLocators;
import flynas.ios.workflows.BookingPageFlow;


public class TC04_oneWayDomesticoneAdultCheckin extends BookingPageFlow{
		
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Reg"),"TC04_oneWayDomAdultCheckin");

	@Test(dataProvider = "testData",groups={"ios"})
	public  void TC_04_oneWayDomesticoneAdultCheckin(String tripType, String origin, String dest,String deptDate,
			String origin2,String departure2, String retdate,String Adult,String Child,String infant, String promo, 
			String bookingClass, String bundle,String FlightType,String totalpass,String nationality,String docType,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype, 
			String charity,String Currency,String username,String password, String Description) throws Throwable {
		try {

			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);

			selectBookFlights();			
			inputBookingDetails(tripType, origin, dest, deptDate, origin2, departure2, retdate,Adult, Child, infant,promo,Currency);
			selectClass(bookingClass, bundle);
			
			String[] name = inputPassengerDetails(FlightType,totalpass,nationality,docType,docNumber,naSmiles,Mobile,email,"","","");
			
			waitforElement(BookingPageLocators.passengertitle);
			scrollJS(BookingPageLocators.selectExtras_btn);
			click(BookingPageLocators.selectExtras_btn, "Select Extras");
			
			
			Baggage(bookingtype, totalpass);
			click(BookingPageLocators.selectSeat_btn, "Continue To Select Seat");
			selectallSeats(SelectSeat, totalpass, tripType);
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			String pnr = getReferenceNumber().trim();
			validate_ticketStatus(pnr);
			selectHome(); 
			selectCheckIn(); 
			searchFlightCheckin(pnr,name[1]);
			performCheckin();
			if(isElementPresent(BookingPageLocators.travelDocuments)==true){
				click(BookingPageLocators.continuebtn, "Continue");
				driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
			}
			validateCheckin();

			Reporter.SuccessReport("TC04_oneWayDomesticoneAdultCheckin", "Pass");

		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC04_oneWayDomesticoneAdultCheckin", "Failed");
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
				xls.getCellValue("Booking Class", "Value"),xls.getCellValue("Bundle", "Value"),
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
				xls.getCellValue("username", "Value"),
				xls.getCellValue("password", "Value"),
			   "Validate oneWay Domestic one Adult Checkin"}};
	}

}