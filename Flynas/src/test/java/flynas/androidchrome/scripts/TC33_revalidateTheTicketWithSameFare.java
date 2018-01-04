package flynas.androidchrome.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

import flynas.web.workflows.BookingPageFlow;

public class TC33_revalidateTheTicketWithSameFare extends BookingPageFlow{
ExcelReader xls = new ExcelReader(configProps.getProperty("TestDataForAndroid"),"FL_WEB_33");
	
	@Test(dataProvider = "testData",groups={"Chrome"})
	public void TC_33_revalidateTheTicketWithSameFare(String strTripType, String strFlightType, String strOrigin,
			String strDestination, String strDepatureDate, String origin2,String departure2,String strReturnDate, String strTotalPessenger,
			String strAdultCount, String strChildCount, String strInfantCount, String strPromo, 
			String strBookingClass, String strNationality, String strDocumentType,	String strDocumentNum,
			String strNaSmile,  String strMobile, String strEmail, String strSelectSeat, String strPaymentType,String bookingtype,
			String strNewDate, String charity,String Currency)throws Throwable{
				try{
										
					String description = "Revalidate the ticket with samr fare";
					TestEngine.testDescription.put(HtmlReportSupport.tc_name, description);
					String deptdate = pickDate(strDepatureDate);
					inputBookingDetails(strTripType, strOrigin, strDestination, deptdate,origin2, departure2,strReturnDate,
							strAdultCount, strChildCount, strInfantCount, strPromo,Currency,strPaymentType);
					selectClass(strBookingClass, strTripType);
					String strLastName[] = inputPassengerDetails(strFlightType, strTotalPessenger, strNationality, strDocumentType, 
							strDocumentNum, strNaSmile, strMobile, strEmail,"","","");
					inputExtras(charity);
					selectSeat(strSelectSeat, bookingtype);
					payment(strPaymentType,"");
					String strpnr = getReferenceNumber();
					String strPNR = strpnr.trim();
					validate_ticketStatus(strPNR);
					
					//how to get last name 
					changeDate(strPNR, strEmail, strMobile, strLastName[1], strNewDate, strSelectSeat,strTotalPessenger,strBookingClass,0);
					validateFare(strBookingClass);
					
					Reporter.SuccessReport("TC33_revalidateTheTicketWithSameFare", "Pass");
					driver.close();
			
					}catch(Exception e){
						e.printStackTrace();
						Reporter.SuccessReport("TC33_revalidateTheTicketWithSameFare", "Fail");
						driver.close();
					}
	}
		
		@DataProvider(name="testData")
		public Object[][] createdata1() {
		    return (Object[][]) new Object[][] {{
		    	xls.getCellValue("Trip Type", "Value"),
		    	xls.getCellValue("Flight Type", "Value"),
		    	xls.getCellValue("Origin", "Value"),
		    	xls.getCellValue("Destination", "Value"),
		    	xls.getCellValue("Departure Date", "Value"),
		    	"",
		    	"",
		    	xls.getCellValue("Return Date", "Value"),
		    	xls.getCellValue("Total Passenger", "Value"),
		    	xls.getCellValue("Adults Count", "Value"),
		    	xls.getCellValue("Child Count", "Value"),
		    	xls.getCellValue("Infant Count", "Value"),
		    	xls.getCellValue("Promo", "Value"),
		    	xls.getCellValue("Booking Class", "Value"),
		    	xls.getCellValue("Nationality", "Value"),
		    	xls.getCellValue("Document Type", "Value"),
		    	xls.getCellValue("Doc Number", "Value"),
		    	"1234567890",
    			xls.getCellValue("Mobile", "Value"),
    			xls.getCellValue("Email Address", "Value"),
    			xls.getCellValue("Select Seat", "Value"),
    			"Credit Card",
    			"",
    			xls.getCellValue("New Date", "Value"),
    			xls.getCellValue("Charity Donation", "Value"),""}};
	}
}
