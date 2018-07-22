package flynas.ios.uat.reg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.*;
import flynas.ios.workflows.*;

public class TC03_b_AnonymousOneWayIntlSimpleChangeDate extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Reg"),"TC_03_oneWayDomesticChangeDate");

	@Test(dataProvider = "testData",groups={"ios"})
	public  void TC_03b_AnonymousOneWayDomesticSimpleChangeDate(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Adult,String Child,String infant, String promo, 
			String bookingClass, String bundle,	String FlightType,String totalpass,String nationality,String Doctype,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype,String newDate,
			String charity,String Currency, String Description
			) throws Throwable {
		try {

			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			// Handlepopup();
		
			String depDate = pickDate(deptDate);
			Homepage homepage = new Homepage();
			
			homepage.select_Bookflights("Anonymous");
					
			inputBookingDetails(tripType, origin, dest, depDate, origin2, departure2, retdate,Adult, Child, infant,promo,Currency);
			clickFindFlightsBtn();
			selectClass(bookingClass, bundle);
			String[] passenger = inputPassengerDetails(FlightType,totalpass,nationality,Doctype,docNumber, naSmiles,Mobile,email,"","","");
 			continueOnExtras();
 			cntinueRandomSeatSelection();
 			confirmRandomSeatSelection();
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			validate_ticketStatus();
			String PNRnumber = getReferenceNumber();
			System.out.println(PNRnumber);
			navigatetoHmPg();
			handleRatingRequest();
			homepage.select_Managebooking("Anonymous");
			searchFlightMMB(PNRnumber, passenger[1]);
			newDate = pickDate(newDate);
			String strPNRChangeDate = changeDate(PNRnumber,email, Mobile, "", newDate, SelectSeat, totalpass,bookingClass,bundle);
			
			if(strPNRChangeDate.trim().equalsIgnoreCase(PNRnumber)){
			Reporter.SuccessReport("TC03b_AnonymousOneWayIntlSimpleChangeDate", "Pass");
			}
			else{
				Reporter.failureReport("TC03b_AnonymousOneWayIntlSimpleChangeDate", "PNR Did not match");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC03b_oneWayDomesticEcoChangeDate", "Failed");
		}
	}

	@DataProvider(name="testData")
	public Object[][] createdata1() {
		return (Object[][]) new Object[][] { 
			{	
				xls.getCellValue("Trip Type", "Value"),xls.getCellValue("Origin", "Value2"),xls.getCellValue("Destination", "Value2"),
				xls.getCellValue("Departure Date", "Value"),"","",xls.getCellValue("Return Date", "Value"),	xls.getCellValue("Adults Count", "Value"),
				xls.getCellValue("Child Count", "Value"),xls.getCellValue("Infant Count", "Value"),	xls.getCellValue("Promo", "Value"),
				xls.getCellValue("Booking Class", "Value"),xls.getCellValue("Bundle", "Value"),	xls.getCellValue("Flight Type", "Value2"),xls.getCellValue("Total Passenger", "Value"),
				xls.getCellValue("Nationality", "Value"),xls.getCellValue("Document Type", "Value"),xls.getCellValue("Doc Number", "Value"),
				"",xls.getCellValue("Mobile", "Value"),xls.getCellValue("Email Address", "Value"),xls.getCellValue("Select Seat", "Value"),
				xls.getCellValue("Payment Type", "Value"),"",xls.getCellValue("New Date", "Value"),	xls.getCellValue("Charity Donation", "Value"),
				xls.getCellValue("Currency", "Value"),"Validate One way International with one Adult Economy Change Date"}};
			}


}
