package flynas.android.scripts.uat.routes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import flynas.android.testObjects.BookingPageLocators;
import flynas.android.workflows.BookingPageFlow;
import flynas.android.workflows.Homepage;

public class TC172_roundTripInternationalBusiness_JED_ATZ extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataForAndroid"),"TestData");

	@Test(dataProvider = "testData",groups={"Flex"})
	public  void TC_172_roundTripInternationalBusiness_JED_ATZ(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Audalt,String Child,String infant, String promo, 
			String strBookingClass,
			String FlightType,String totalpass,String namtionality,String Doctypr,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype, 
			String charity,String Currency, String Description
			) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			//Handlepopup();
			
			String[] Credentials = pickCredentials("UserCredentials");
			
			String username =Credentials[0];
			String password =Credentials[1];

			String depDate = pickDate(deptDate);
			retdate = pickDate(retdate);
			Homepage homepage = new Homepage();
						
			homepage.select_TittleMenu();
			homepage.Click_login();
			homepage.Login(username,password);
			homepage.select_Bookflights("registered");
			inputBookingDetails(tripType, origin, dest, depDate, origin2, departure2, retdate,Audalt, Child, infant,promo,Currency);
			selectClass(strBookingClass, tripType);
			waitforElement(BookingPageLocators.title);
			scrollToText("Email Address*");
			if(isElementDisplayedTemp(BookingPageLocators.continuebtn)==false)
			{
				scrollToElement(BookingPageLocators.continuebtn);
			}
			click(BookingPageLocators.continuebtn, "Continue");
			if(isElementDisplayed(BookingPageLocators.baggagetittle)==true)
			{
				click(BookingPageLocators.continuebtn, "Continue");
			}else{
				System.out.println("No Baggage Available");
			}
			if(isElementDisplayed(BookingPageLocators.seatSelecttionTittle)==true)
			{
				click(BookingPageLocators.continuebtn, "Continue");
			}else{
				System.out.println("No Seat Available");
			}
			payment(paymenttype,"");
			validate_ticketStatus();

			String PNRnumber = getReferenceNumber();
			System.out.println(PNRnumber);

			click(BookingPageLocators.tittleHome, "Home Img");
			handleRatingRequest();
			homepage.select_OnlineCheckIn("registered");
			registeredUsrManageFlight(PNRnumber);
			performCheckin();
			cntinueOnTravelDocument();
			cntinueRandomSeatSelection();
			confirmRandomSeatSelection();
			validateCheckin();
			
			Reporter.SuccessReport("TC172_roundTripInternationalBusiness_JED_ATZ", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC172_roundTripInternationalBusiness_JED_ATZ", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value2"),
	    		xls.getCellValue("Origin", "Value48"),
	    		xls.getCellValue("Destination", "Value48"),
	    		xls.getCellValue("Departure Date", "Value"),
	    		"",
	    		"",
	    		xls.getCellValue("Return Date", "Value"),
	    		xls.getCellValue("Adults Count", "Value"),
	    		xls.getCellValue("Child Count", "Value"),
	    		xls.getCellValue("Infant Count", "Value"),
	    		xls.getCellValue("Promo", "Value"),
	    		xls.getCellValue("Booking Class", "Value3"),
	    		xls.getCellValue("Flight Type", "Value"),
	    		xls.getCellValue("Total Passenger", "Value"),
	    		xls.getCellValue("Nationality", "Value"),
	    		xls.getCellValue("Document Type", "Value"),
	    		xls.getCellValue("Doc Number", "Value"),
	    		xls.getCellValue("na Smiles", "Value"),
	    		xls.getCellValue("Mobile", "Value"),
	    		xls.getCellValue("Email Address", "Value"),
	    		xls.getCellValue("Select Seat", "Value"),
	    		xls.getCellValue("Payment Type", "Value2"),
	    		"",
    			xls.getCellValue("Charity Donation", "Value"),
    			xls.getCellValue("Currency", "Value"),
    			"Validate oneWay International Business_JED_ATZ"}};
	}
	

}
