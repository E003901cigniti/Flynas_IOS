package flynas.web.uat.errorMessages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;
import flynas.web.workflows.BookingPageFlow;

public class TC37_ValidatingErrOnNotSelectingFlight extends BookingPageFlow {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Errors_On_PnrRetrieval");

	@Test(dataProvider = "testData",groups={"Chrome"})
	
	public  void ValidatingErrOnNotSelectingFlight (String strDepatureDate, String Username, String Password,
					String strTripType, String strOrigin,String strDestination, String origin2, String departure2,
					String strReturnDate, String strAdultCount,String strChildCount, String strInfantCount,
					String strPromo, String Currency, String strPaymentType,String ErrorMessage,
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
			
			clickContinueBtn();		
			
			
			if(isElementDisplayedTemp(BookingPageLocators.MandatePrompt)){
				String ErrorMsg = getText(BookingPageLocators.MandatePrompt, "Error Message");
				if(ErrorMsg.contains(ErrorMessage)){
					Reporter.SuccessReport("Validating EorrorMessage On Not Selecting Flight", "Successfully verified the error message :"+ ErrorMsg);
					driver.close();
				}else{
					Reporter.failureReport("Validating EorrorMessage On Not Selecting Flight", "Error Message is not as expected");
					driver.close();
				}
				
			}
			else{
				Reporter.failureReport("Validating EorrorMessage On Not Selecting Flight", "Error promt not found");
				driver.close();
			}			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC37_ValidatingErrOnNotSelectingFlight", "Failed");
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
	    		xls.getCellValue("Payment Type", "Value1"),
	    		xls.getCellValue("ErrorMessage", "Value6"),
	    		"Validating EorrorMessage On Not Selecting Flight"}};
	}
	
	

}
