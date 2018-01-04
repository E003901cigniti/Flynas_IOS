package flynas.android.scripts.uat.routes;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.android.testObjects.BookingPageLocators;
import flynas.android.workflows.BookingPageFlow;
import flynas.android.workflows.Homepage;

public class TC150_oneWayDomesticBusinessChangeDate_AHB_ABT extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataForAndroid"),"TestData");

	@Test(dataProvider = "testData",groups={"Business"})
	public  void TC_150_oneWayDomesticBusinessChangeDate_AHB_ABT(String tripType, String origin, String dest,String deptDate, 
			String origin2,String departure2,String retdate,String Audalt,String Child,String infant,String promo,String strBookingClass,
			String FlightType,String totalpass,String namtionality,String Doctypr,String docNumber,String naSmiles,String Mobile,
			String email ,String SelectSeat,String paymenttype,String bookingtype,String charity,String Currency, String username,
			String password,String newDate,String Description
			) throws Throwable {
		try {

			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			//Handlepopup();
			
			String depDate = pickDate(deptDate);
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
			selectallSeats(SelectSeat, totalpass, tripType);
			payment(paymenttype,"");
			validate_ticketStatus();
			String PNRnumber = getReferenceNumber();
			System.out.println(PNRnumber);
			click(BookingPageLocators.tittleHome, "Home Img");
			handleRatingRequest();
			homepage.select_Managebooking("registered");
			registeredUsrManageFlight(PNRnumber);
			changeDate(PNRnumber, email, Mobile, "", newDate, SelectSeat, totalpass,strBookingClass,tripType);
			
			Reporter.SuccessReport("TC150_oneWayDomesticBusinessChangeDate_AHB_ABT", "Pass");

		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC150_oneWayDomesticBusinessChangeDate_AHB_ABT", "Failed");
		}
	}

	@DataProvider(name="testData")
	public Object[][] createdata1() {
		return (Object[][]) new Object[][] { 
			{xls.getCellValue("Trip Type", "Value"),
				xls.getCellValue("Origin", "Value26"),
				xls.getCellValue("Destination", "Value26"),
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
				
				
				xls.getCellValue("newdate", "Value"),
			"Validate oneWay Domestic Business ChangeDate_DMM_ABT"}};
	}


}
