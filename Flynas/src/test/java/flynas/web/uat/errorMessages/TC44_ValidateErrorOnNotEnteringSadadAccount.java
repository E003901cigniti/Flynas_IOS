package flynas.web.uat.errorMessages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;
import flynas.web.workflows.BookingPageFlow;

public class TC44_ValidateErrorOnNotEnteringSadadAccount extends BookingPageFlow {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Errors_On_PnrRetrieval");

	@Test(dataProvider = "testData",groups={"Chrome"})
	
	public  void ValidateErrorOnNotEnteringSadadAccount (String strDepatureDate, String Username, String Password,
					String strTripType, String strOrigin,String strDestination, String origin2, String departure2,
					String strReturnDate, String strAdultCount,String strChildCount, String strInfantCount,
					String strPromo, String Currency, String strPaymentType, String strBookingClass, 
					String strSelectSeat, String bookingtype, String ErrorMessage,
					String Description) throws Throwable
	{
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			
			String	deptdate = pickDate(strDepatureDate);
			String	ReturnDate = pickDate(strReturnDate);
			
			click(BookingPageLocators.login_lnk, "Login");
			switchtoChildWindow();
			login(Username,Password);
			
			inputBookingDetails(strTripType, strOrigin, strDestination, deptdate,origin2, departure2,ReturnDate,
					strAdultCount, strChildCount, strInfantCount, strPromo,Currency,strPaymentType);
			
			
			selectClass(strBookingClass, strTripType);
			
			//Clicking continue button on Passenger details page
			waitforElement(BookingPageLocators.passengerDetailsTittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			clickContinueBtn();
			
			//Clicking continue button on Baggage details page
			waitforElement(BookingPageLocators.baggagetittle);
			waitUtilElementhasAttribute(BookingPageLocators.body);
			clickContinueBtn();
			
			//Selecting seat
			selectSeat(strSelectSeat, bookingtype);
			
			//Click on payment Type
			clickPaymentType(strPaymentType);
			
			//Click Continue with out Entering Any amount
			clickContinueBtn();
									
			if(isElementDisplayedTemp(BookingPageLocators.MandatePrompt)){
				String ErrorMsg = getText(BookingPageLocators.MandatePrompt, "Error Message");
				if(ErrorMsg.contains(ErrorMessage)){
					Reporter.SuccessReport("Validating EorrorMessage on not entering SADAD account", "Successfully verified the error message :"+ ErrorMsg);
					driver.close();
				}else{
					Reporter.failureReport("Validating EorrorMessage on not entering SADAD account", "Error Message is not as expected");
					driver.close();
				}
				
			}
			else{
				Reporter.failureReport("Validating EorrorMessage on not entering SADAD account", "Error promt not found");
				driver.close();
			}			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC44_ValidateErrorOnNotEnteringSadadAccount", "Failed");
			driver.close();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{
	    		xls.getCellValue("Departure Date", "Value1"),	    		
	    		xls.getCellValue("username", "Value1"),
	    		xls.getCellValue("password", "Value1"),
	    		xls.getCellValue("Trip Type", "Value1"),
	    		xls.getCellValue("Origin", "Value1"),
	    		xls.getCellValue("Destination", "Value1"),
	    		"",
	    		"",
	    		xls.getCellValue("Return Date", "Value1"),
	    		xls.getCellValue("Adults Count", "Value1"),
	    		xls.getCellValue("Child Count", "Value1"),
	    		xls.getCellValue("Infant Count", "Value1"),
	    		xls.getCellValue("Promo", "Value1"),
	    		"",
	    		xls.getCellValue("Payment Type", "Value12"),
	    		xls.getCellValue("Booking Class", "Value1"),
	    		xls.getCellValue("Select Seat", "Value1"),
	    		"",
	    		xls.getCellValue("ErrorMessage", "Value12"),
	    		"Validating EorrorMessage On entering Invalid CC details"}};
	}
	

}
