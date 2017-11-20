package flynas.web.uat.errorMessages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;
import flynas.web.workflows.BookingPageFlow;

public class TC17_Err_6_ConformBooking1Adt1ChildRT extends BookingPageFlow{
ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"ErrorMessage_6");
	
	@Test(dataProvider = "testData",groups={"Chrome"})
	public void TC_17_Err_6_ConformBooking1Adt1ChildRT(String strTripType,String strFlightType,String strOrigin,String strDestination,
			String strDepatureDate,String origin2,String departure2, String strReturnDate, String strTotalPessenger,String strAdultCount,
			String strChildCount,String strInfantCount,String strPromo,String strBookingClass,String strNationality,String strDocumentType,
			String strDocumentNum,String strNaSmile,String strMobile,String strEmail,String strSelectSeat,String strPaymentType,String bookingtype,
			String strNewDate, String charity,String Currency,String description)throws Throwable{
				try{
					
					
					TestEngine.testDescription.put(HtmlReportSupport.tc_name, description);
					String depdate = pickDate(strDepatureDate);
					String	retdate = pickDate(strReturnDate);
				
					
					String trip = strTripType.split("/")[0];
					inputBookingDetails(trip, strOrigin, strDestination, depdate,origin2,departure2, retdate,
							strAdultCount, strChildCount, strInfantCount, strPromo,Currency,strPaymentType);
					selectClass(strBookingClass, trip);
					inputPassengerDetails(strFlightType, strTotalPessenger, strNationality, strDocumentType, 
							strDocumentNum, strNaSmile, strMobile, strEmail,"","","");
					waitforElement(BookingPageLocators.baggagetittle);
					waitUtilElementhasAttribute(BookingPageLocators.body);
					if(isElementDisplayedTemp(BookingPageLocators.baggagetittle)){
					clickContinueBtn();
						}else{
							System.out.println("No Baggage Page");
						}
					waitForElementPresent(BookingPageLocators.selectseattittle, "Select Seat Tittle");
					waitUtilElementhasAttribute(BookingPageLocators.body);
					if(isElementDisplayedTemp(BookingPageLocators.selectseattittle)==true){
					click(BookingPageLocators.continueBtn, "Contiue");
						if(isElementDisplayedTemp(BookingPageLocators.ok)){
							click(BookingPageLocators.ok, "OK");
						}
					}
					payment(strPaymentType,"");
					String strPNR = getReferenceNumber();
							
					searchFlightCheckin(strPNR, strEmail, "", "");
					performCheckin("", "", "");
					validateCheckin();
								
					Reporter.SuccessReport("TC17_Err_6_ConformBooking1Adt1ChildRT", "Pass");
					
					
			
					}catch(Exception e){
						e.printStackTrace();
						Reporter.failureReport("TC17_Err_6_ConformBooking1Adt1ChildRT", "Fail");
						
					}
	}
		
		@DataProvider(name="testData")
		public Object[][] createdata1() {
		    return (Object[][]) new Object[][] {{
		    	xls.getCellValue("Trip Type", "Value"),
		    	xls.getCellValue("Flight Type", "Value"),
		    	xls.getCellValue("Origin", "Value2"),
		    	xls.getCellValue("Destination", "Value2"),
		    	xls.getCellValue("Departure Date", "Value2"),"","",
		    	xls.getCellValue("Return Date", "Value2"),
		    	xls.getCellValue("total pass", "Value2"),
		    	xls.getCellValue("Adults Count", "Value"),
		    	xls.getCellValue("Child Count", "Value2"),
		    	xls.getCellValue("Infant Count", "Value"),
		    	xls.getCellValue("Promo", "Value"),
		    	xls.getCellValue("Booking class", "Value"),
		    	xls.getCellValue("Nationality", "Value"),
		    	xls.getCellValue("Document Type", "Value"),
		    	xls.getCellValue("Doc Number", "Value"),
		    	"1234567890",
    			xls.getCellValue("Mobile", "Value"),
    			xls.getCellValue("Email Address", "Value"),
    			xls.getCellValue("Select Seat", "Value"),
    			"Credit Card","",
    			xls.getCellValue("New Date", "Value"),
    			xls.getCellValue("Charity Donation", "Value"),"",
    			"Validating Error Message for Conform Booking 1 Adult 1 Child RT"}};
	}

}
