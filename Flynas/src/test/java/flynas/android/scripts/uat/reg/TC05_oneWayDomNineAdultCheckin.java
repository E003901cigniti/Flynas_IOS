package flynas.android.scripts.uat.reg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.android.testObjects.BookingPageLocators;
import flynas.android.testObjects.HomePageLocators;
import flynas.android.workflows.BookingPageFlow;
import flynas.android.workflows.Homepage;

public class TC05_oneWayDomNineAdultCheckin extends BookingPageFlow {
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataForAndroid"),"TC05_oneWayDom8AdultCheckin");

	@Test(dataProvider = "testData",groups={"Android"})
	public  void TC_05_oneWayDomNineAdultCheckin(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Audalt,String Child,String infant, String promo, 
			String strBookingClass,	String FlightType,String totalpass,String namtionality,String Doctypr,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype,String newDate,
			String charity,String Currency, String Description
			) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			// Handlepopup();
			
			String[] Credentials = pickCredentials("UATcredentials");
			
			String username =Credentials[0];
			String password =Credentials[1];
			String LastName =Credentials[3];
		
			String depDate = pickDate(deptDate);
			String rtrndate = pickDate(retdate);
			
			Homepage homepage = new Homepage();
						
			homepage.select_TittleMenu();
			homepage.Click_login();
			homepage.Login(username,password);
			homepage.select_Bookflights("registered");
			
			inputBookingDetails(tripType, origin, dest, depDate, origin2, departure2,rtrndate,Audalt, Child, infant,promo,Currency);
			selectClass(strBookingClass, tripType);
			inputPassengerDetails(FlightType,totalpass,namtionality,Doctypr,docNumber, naSmiles,Mobile,email,"","","");
			waitForElementPresent(BookingPageLocators.baggagetittle, "Baggage Tittle");
			Baggage(bookingtype,totalpass);
			click(BookingPageLocators.continuebtn, "continue");
			waitForElementPresent(BookingPageLocators.seatSelecttionTittle, "seat Tittle");
			selectSeat(SelectSeat, bookingtype, tripType);
			//selectallSeats(SelectSeat, totalpass,"");
			payment(paymenttype,"");
			validate_ticketStatus();
			String PNRnumber = getReferenceNumber();
			System.out.println(PNRnumber);
			navigatetoHmPg();
			handleRatingRequest();
			homepage.select_OnlineCheckIn("registered");
			searchFlightCheckin(PNRnumber, LastName);
			performCheckin();
			cntinueOnTravelDocument();
			cntinueRandomSeatSelection();
			confirmRandomSeatSelection();
			validateCheckin();
			
			Reporter.SuccessReport("TC05_oneWayDomNineAdultCheckin", "Pass");			
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC05_oneWayDomNineAdultCheckin", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value"),xls.getCellValue("Origin", "Value"),xls.getCellValue("Destination", "Value"),
	    		xls.getCellValue("Departure Date", "Value"),"",	"",
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
	    		"",
	    		xls.getCellValue("Mobile", "Value"),
	    		xls.getCellValue("Email Address", "Value"),
	    		xls.getCellValue("Select Seat", "Value"),
	    		xls.getCellValue("Payment Type", "Value"),
	    		"",
	    		xls.getCellValue("New Date", "Value"),
    			xls.getCellValue("Charity Donation", "Value"),
    			xls.getCellValue("Currency", "Value"),
	    		"Validate One way Domestic with 9 Adualt Checkin"}};
	}

}
