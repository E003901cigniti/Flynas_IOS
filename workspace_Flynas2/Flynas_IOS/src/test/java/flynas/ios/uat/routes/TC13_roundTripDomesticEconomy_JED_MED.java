package flynas.ios.uat.routes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.BookingPageLocators;
import flynas.ios.workflows.BookingPageFlow;
import flynas.ios.workflows.Homepage;


public class TC13_roundTripDomesticEconomy_JED_MED extends BookingPageFlow{
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"TestData");

	@Test(dataProvider = "testData",groups={"Economy"})
	public  void TC_13_roundTripDomesticEconomy_JED_MED(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Audalt,String Child,String infant, String promo, 
			String strBookingClass,
			String FlightType,String totalpass,String namtionality,String Doctypr,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype, 
			String charity,String Currency,String username,String password, String Description) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			String	depdate = pickDate(deptDate);
			String	rtrndate = pickDate(retdate);
			
//			click(BookingPageLocators.menu, "Menu");
//			click(BookingPageLocators.login_lnk, "Login");
//			login(username,password);
			selectBookFlights();			
			inputBookingDetails(tripType, origin, dest, depdate, origin2, departure2, rtrndate,Audalt, Child, infant,promo,Currency);
			selectClass(strBookingClass, tripType);
			waitforElement(BookingPageLocators.passengertitle);
			scrollJS(BookingPageLocators.selectExtras_btn);
			click(BookingPageLocators.selectExtras_btn, "Select Extras");
			waitforElement(BookingPageLocators.baggageTittle);
			if(isElementDisplayedTemp(BookingPageLocators.baggageTittle)==true){
				scrollJS(BookingPageLocators.selectSeat_btn);
				click(BookingPageLocators.selectSeat_btn, "Select Seat");
			}
			waitforElement(BookingPageLocators.seatSelectionTittle);
			if(isElementDisplayedTemp(BookingPageLocators.seatSelectionTittle)==true){
				click(BookingPageLocators.payment_btn, "Payment");
			}else{
				System.out.println("No Seat Available");
			}
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			String pnr = getReferenceNumber();
			validate_ticketStatus(pnr);
			selectHome();
			selectMMB();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			if(isElementPresent(BookingPageLocators.pnr(pnr))==false){
				scrollJS(BookingPageLocators.pnr(pnr));
			}
			click(BookingPageLocators.manage(pnr), "Manage");
			cancelFlight(pnr, email, "", "");
			verifyCancel();
			Reporter.SuccessReport("TC13_roundTripDomesticEconomy_JED_MED", "Pass");
			
			}
		
	catch (Exception e) {
		e.printStackTrace();
			Reporter.failureReport("TC13_roundTripDomesticEconomy_JED_MED", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xls.getCellValue("Trip Type", "Value2"),
	    		xls.getCellValue("Origin", "Value13"),
	    		xls.getCellValue("Destination", "Value13"),
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
	    		xls.getCellValue("Payment Type", "Value2"),
	    		"",
    			xls.getCellValue("Charity Donation", "Value"),
    			xls.getCellValue("Currency", "Value"),
    			xls.getCellValue("username", "Value"),
    			xls.getCellValue("password", "Value"),
	    		"Validate RoundTrip Domestic Economy_JED_MED"}};
	}

}