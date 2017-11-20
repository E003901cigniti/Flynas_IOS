package flynas.web.production.routes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;
import flynas.web.workflows.BookingPageFlow;

public class TC90_oneWayDomesticFlex_AHB_WAE extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataProdRoutes"),"Chrome_TestData");

	@Test(dataProvider = "testData",groups={"Flex"})
	public  void TC_90_oneWayDomesticFlex_AHB_WAE( String bookingClass,
			String mobilenum,
			String paymentType,
			String newDate,
			String Departuredate,String rtnDate,
			String origin,
			String dest,String triptype,String adult,String child,String infant,String seatSelect,
			String newdate,	String strTolPass,String domOrInt,String Description) throws Throwable {
		try {
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			String deptDate = pickDate(Departuredate);
			String retrnDate = pickDate(rtnDate);
			/*click(BookingPageLocators.login_lnk, "Login");
		
			Thread.sleep(3000);
			login(username,password);*/
			
			
			inputBookingDetails(triptype,origin, dest, deptDate , "", "", retrnDate,adult, child, infant,"","","");
			selectClass(bookingClass, triptype);
			inputPassengerDetails(domOrInt, strTolPass, "Afghanistan", "National ID Card", 
					"F123456", "1234567890", mobilenum, "flynasqa@gmail.com","","","");
			waitforElement(BookingPageLocators.baggagetittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			if(isElementDisplayedTemp(BookingPageLocators.baggagetittle)==true){
			clickContinueBtn();
			}else{
				System.out.println("No Baggae Page Available");
			}
			waitforElement(BookingPageLocators.selectseattittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			if(isElementDisplayedTemp(BookingPageLocators.selectseattittle)){
				clickContinueBtn();
				if(isElementDisplayedTemp(BookingPageLocators.ok))
					click(BookingPageLocators.ok, "OK");
			}
			payment(paymentType, "");
			String strpnr = getReferenceNumber();
			String strPNR = strpnr.trim();
			System.out.println(strPNR);
			verifyPNRforSadad();
		
							
		
			Reporter.SuccessReport("TC90_oneWayDomesticFlex_AHB_WAE", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC90_oneWayDomesticFlex_AHB_WAE", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{
	    		
	    		xls.getCellValue("Booking Class", "Value2"),
	    		xls.getCellValue("Mobile", "Value"),
	    		"SADAD",
	    		xls.getCellValue("NewDate", "Value"),
	    		xls.getCellValue("Departure Date", "Value"),
	    		xls.getCellValue("Return Date", "Value"),
	    		xls.getCellValue("Origin", "Value28"),
	    		xls.getCellValue("Destination", "Value28"),
	    		xls.getCellValue("Trip Type", "Value"),
	    		xls.getCellValue("Adults Count", "Value2"),
	    		xls.getCellValue("Child Count", "Value"),
	    		xls.getCellValue("Infant Count", "Value"),
	    		"Extra Leg Room",
	    		"01-April 2017",
	    		xls.getCellValue("Total Passenger", "Value2"),
	    		xls.getCellValue("Flight Type", "Value"),
	    		"Validate oneWay Domestic Flex_ABH_WAE"}};
	}

}
