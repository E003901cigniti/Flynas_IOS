package flynas.ios.Prod.routes;

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


public class TC58_multiCityInternationalEconomy_MED_KRT extends BookingPageFlow{

	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData_UAT_Routes"),"AllRoutes");

	@Test(dataProvider = "testData",groups={"Economy"})
	public  void TC_58_multiCityInternationalEconomy_MED_KRT(String tripType, String origin, String dest, 
			String deptDate, String origin2,String departure2, String retdate,String Audalt,String Child,String infant, String promo, 
			String bookingClass, String bundle,
			String FlightType,String totalpass,String namtionality,String Doctypr,String docNumber,
			String naSmiles,String Mobile,String email ,String SelectSeat,String paymenttype,String bookingtype, 
			String charity,String Currency, String Description) throws Throwable {
		try {

			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);

			//			click(BookingPageLocators.menu, "Menu");
			//			click(BookingPageLocators.login_lnk, "Login");
			//			login(username,password);
			selectBookFlights();			
			inputBookingDetails(tripType, origin, dest, deptDate, origin2, departure2, retdate,Audalt, Child, infant,promo,Currency);
			selectClass(bookingClass, bundle);
			continueOnPsngrDtls();
			continueOnExtras();
			continueOnSeatSelection();
			paymentoption("Otherpayment");
			payment(paymenttype,"");
			String pnr = getReferenceNumber();
			verifyPNRforSadad(pnr);
			Reporter.SuccessReport("TC58_multiCityInternationalEconomy_MED_KRT", "Pass");

		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC58_multiCityInternationalEconomy_MED_KRT", "Failed");
		}
	}

	@DataProvider(name="testData")
	public Object[][] createdata1() {
		return (Object[][]) new Object[][] { 
			{xls.getCellValue("Trip Type", "Value3"),
				xls.getCellValue("Origin", "Value58"),
				xls.getCellValue("Destination", "Value58"),
				xls.getCellValue("Departure Date", "Value"),
				xls.getCellValue("Origin2", "Value"),
				xls.getCellValue("Destination2", "Value"),
				xls.getCellValue("Return Date", "Value"),
				xls.getCellValue("Adults Count", "Value"),
				xls.getCellValue("Child Count", "Value"),
				xls.getCellValue("Infant Count", "Value"),
				xls.getCellValue("Promo", "Value"),
				xls.getCellValue("Booking Class", "Value"),
				xls.getCellValue("Bundle", "Value"),
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
			"Validate MultiCity International Economy_MED_KRT"}};
	}

}