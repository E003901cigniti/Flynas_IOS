package flynas.ios.workflows;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.Alert;

import com.ctaf.support.ExcelReader;
import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.BookingPageLocators;
import io.appium.java_client.MobileElement;



public class BookingPageFlow extends BookingPageLocators{
	
	public void selectCheckIn() throws Throwable{
		click_mobile("Check-in", "WCI Icon");
		}
	
	public void selectBookFlights() throws Throwable{
		click_mobile("Book", "Book Flights Icon");
	}
	
	public void selectMMB() throws Throwable{
		click_mobile("Manage", "MMB Icon");
	}
	
	public void selectBoardingPasses() throws Throwable{
		click_mobile("Boarding Passes", "Boarding Passes Icon");
	}
	
	public void selectHome() throws Throwable{
		click_mobile("Home", "Home Icon");
	}
	
	//bokking page
	
	
	
	public void inputBookingDetails(String tripType, String origin, String dest, String deptDate,
			String origin2, String departure2, String retDate, String adults, String child, String infant, String promo,String Currency) throws Throwable{
		
		waitforElement(BookingPageLocators.OWbtn);
		//Select Trip Mode
		if(tripType.equalsIgnoreCase("Round Trip")){
			click_mobile(BookingPageLocators.roundTrip, "Return tab");
		} else if(tripType.equalsIgnoreCase("One Way")){
			click_mobile(BookingPageLocators.oneWay, "One-way tab");
		} 
		
		click_mobile("Origin", "Origin tab");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	
		
		click_mobile(BookingPageLocators.search, "Search");
		type_mobile(BookingPageLocators.search, origin, "Origin");
		click_mobile(BookingPageLocators.searched_city.replace("#", origin), "Origin");
		type_mobile(BookingPageLocators.search, dest, "Destination");
		click_mobile(BookingPageLocators.searched_city.replace("#", dest), "Destination");
	
		if(tripType.equalsIgnoreCase("One Way"))
		{
//		click(BookingPageLocators.Departuredate, "Departure Date");
//			System.out.println(driver.getPageSource());
//			select_date(deptDate);
//			click(BookingPageLocators.Select_date, "Select Date");
		}
		
		if(tripType.equalsIgnoreCase("Round Trip"))
		{
//			click(BookingPageLocators.Departuredate, "DepartureDate");
//			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//			select_date(deptDate);
//			select_date(retDate);
//			click(BookingPageLocators.Select_date, "Select Date");
//			click(BookingPageLocators.Returndate_rtp, "Return Date");
//			select_date(retDate);
//			click(BookingPageLocators.Select_date, "Select Date");
		}
		if(tripType.equalsIgnoreCase("Multi City")){
			
			//click(BookingPageLocators.Departuredate_multicity, "DepartureDate");
		//	select_date(deptDate);
		//	click(BookingPageLocators.Select_date, "Select Date");
			Thread.sleep(3000);
			click(BookingPageLocators.origin_multicity, "Origin2");
			click_mobile(BookingPageLocators.search, "Search");
			type_mobile(BookingPageLocators.search, origin2, "Origin");
			click_mobile(BookingPageLocators.searched_city.replace("#", origin2), "Origin");
			type_mobile(BookingPageLocators.search, departure2, "Destination");
			click_mobile(BookingPageLocators.searched_city.replace("#", departure2), "Destination");
		
			
		}
		
		if((Integer.valueOf(adults)+Integer.valueOf(child)+Integer.valueOf(infant))>1)
		{
			click_mobile(BookingPageLocators.passengerCount, "Passenger count tab");
		
			if(Integer.valueOf(adults)>1){
				waitforElement(BookingPageLocators.Audaltplusbutton);
				for(int i=1;i<Integer.valueOf(adults);i++)
				{
				click(BookingPageLocators.Audaltplusbutton, "Adult");
				System.out.println("Adults: "+adults);
				}
			}
			if(Integer.valueOf(child)>0){
				for(int i=0;i<Integer.valueOf(child);i++)
				{
				click(BookingPageLocators.childplusbutton, "Child");
				System.out.println("Child: "+child);
				}
			}
			if(Integer.valueOf(infant)>0){	
				for(int i=0;i<Integer.valueOf(infant);i++)
				{
				click(BookingPageLocators.infantplusbutton, "Infant");
				System.out.println("Infant: "+infant);
				}
			}
			Iosdriver.findElementByAccessibilityId("Done").click();
		}	
			
		if(Currency!="")
		{
				click(BookingPageLocators.Currency, "Currency");
				Thread.sleep(2000);
				click(BookingPageLocators.currencytype(Currency), Currency);
		}
		
			click_mobile(BookingPageLocators.findFlights, "Find Flights");
			waitforElement(BookingPageLocators.Slectflighttitle);
			
	}

	public void select_date(String deptdate) throws Throwable
	{
		
		String dd = deptdate.split("-")[0];
		String mmYY = deptdate.split("-")[1];
				
		  boolean blnFlag =true;
		  while (blnFlag) 
		  {
			//  WebElement ele_CalendarView = driver.findElement(By.xpath("//*[@resource-id='com.flynas.android.app:id/calendar_view']/following::[@class='android.widget.LinearLayout']"));
			  List<WebElement> lst_MonthandYear = driver.findElements(By.xpath("//*[@resource-id='com.flynas.android.app:id/title']"));
			  if(lst_MonthandYear.get(0).getText().equalsIgnoreCase(mmYY))
			  {
				  driver.findElement(By.xpath("//*[@text='"+dd+"']")).click();
				  blnFlag = false;
			  }
			  else
			  {
				  Dimension   size = driver.manage().window().getSize();
				  System.out.println(size);
					   
				  //Find swipe start and end point from screen's with and height.
				  //Find starty point which is at bottom side of screen.
				  int starty = (int) (size.height * 0.80);
				  //Find endy point which is at top side of screen.
				  int endy = (int) (size.height * 0.30);
				  //Find horizontal point where you wants to swipe. It is in middle of screen width.
				  int startx = size.width / 2;
				  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

				  //Swipe from Bottom to Top.
				  AndroidDriver2.swipe(startx, starty, startx, endy, 3000);
				  Thread.sleep(2000);
				 
			  }
			  
				  
			  
		  }
	}
		
			
			
		
	/*	selectCity(BookingPageLocators.selectOrigin, "Origin", origin);
		click(BookingPageLocators.dest, "Destination");
		Thread.sleep(2000);
		selectCity(BookingPageLocators.selectDest, "Destination", dest);
		click(BookingPageLocators.dpDate,"Departure Date");
		selectDate(BookingPageLocators.selectDate,"Departure Date",deptDate);*/
	/*	if(tripType.equalsIgnoreCase("Round Trip")){
			//click(BookingPageLocators.rtDate,"Return Date");
			selectDate(BookingPageLocators.selectDate,"Return Date",retDate);
		}
		if(tripType.equalsIgnoreCase("Multi City")){
			click(BookingPageLocators.secOrigin, "Origin");
			selectCity(BookingPageLocators.selectSecOrigin, "Origin", origin2);
			selectCity(BookingPageLocators.selectSecDest, "Destination", departure2);
			click(BookingPageLocators.rtDate,"Return Date");
			selectDate(BookingPageLocators.selectDate,"Return Date",retDate);
		}
		if(Integer.valueOf(adults)>=1){
			click(BookingPageLocators.adult, "Adult");
			System.out.println("Adults: "+adults);
			driver.findElement(By.xpath("//div[text()='"+adults+"']")).click();
			//selectValueFromDropDown(BookingPageLocators.selectAdult, "Adult", adults);
		}
		if(Integer.valueOf(child)>=1){
			click(BookingPageLocators.child, "Child");
			driver.findElement(By.xpath("//div[text()='"+child+"']")).click();
			//selectValueFromDropDown(BookingPageLocators.selectChild, "Child", child);
		}
		if(Integer.valueOf(infant)>=1){
			click(BookingPageLocators.infant, "Infant");
			driver.findElement(By.xpath("//div[text()='"+child+"']")).click();
			//selectValueFromDropDown(BookingPageLocators.selectInfant, "Infant", infant);
		}
		if(!promo.equalsIgnoreCase("")){
			type(BookingPageLocators.promo, promo, "Promo");
		}
		click(BookingPageLocators.findFlights,"Find Flights");
		return true;*/
	


	private void While(boolean displayed) {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings("unchecked")
	public void selectClass(String bookingClass, String tripType) throws Throwable{
		Thread.sleep(1000);
		boolean flag=false;
		//List<MobileElement> flights = Iosdriver.findElementsByAccessibilityId("bg-frame-gray");
		List<WebElement> flights = driver.findElements(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell"));
	//	String fare = driver.findElement(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[3]")).getAttribute("label");
		//List<WebElement> ClassArrow = driver.findElements(By.xpath("//*[@label='icn arrow down red']"));
		List<MobileElement> ClassArrow = Iosdriver.findElementsByAccessibilityId("icn arrow down red");
		//List<WebElement> classupArrow = driver.findElements(By.xpath("//*[@label='icn arrow up red']"));
		List<MobileElement> classupArrow = Iosdriver.findElementsByAccessibilityId("icn arrow up red");
		//List<WebElement> soldout = driver.findElements(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[@label='SOLD OUT']"));
		if(ClassArrow.size()==0 && classupArrow.size()==0){
			while(classupArrow.size()==0){
				click(BookingPageLocators.rightarrow, "Flight select Right Arrow");
				flights = driver.findElements(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell"));
				flights.get(1).click();
				ClassArrow = Iosdriver.findElementsByAccessibilityId("icn arrow down red");
				classupArrow = Iosdriver.findElementsByAccessibilityId("icn arrow up red");
				
			}
		}
			

		if(bookingClass.equalsIgnoreCase("Economy"))
		{
			if(isElementPresent(BookingPageLocators.economyOW)==true)
			{
				click(BookingPageLocators.economyOW,"Economy");
			}
			else
			{
				for(int i=0;i<ClassArrow.size();i++)
				{
					ClassArrow.get(i).click();
					if(isElementPresent(BookingPageLocators.economyOW(i+2))==true)
					{
						click(BookingPageLocators.economyOW(i+2),"Economy");
						break;
					}
					
				}	
			}
		
		} 
		else if(bookingClass.equalsIgnoreCase("Flex"))
		{
			if(isElementPresent(BookingPageLocators.flexOW)==true)
			{
				click(BookingPageLocators.flexOW,"Economy");
			}
			else
			{
				for(int i=0;i<ClassArrow.size();i++)
				{
					ClassArrow.get(i).click();
					if(isElementPresent(BookingPageLocators.flexOW(i+2))==true)
					{
						click(BookingPageLocators.flexOW(i+2),"Economy");
						break;
					}
					
				}	
			}
		}
		else if(bookingClass.equalsIgnoreCase("Business"))
		{
			if(isElementPresent(BookingPageLocators.busOW)==true)
			{
				click(BookingPageLocators.busOW,"Economy");
			}
			else
			{
				for(int i=0;i<ClassArrow.size();i++)
				{
					ClassArrow.get(i).click();
					if(isElementPresent(BookingPageLocators.busOW(i+2))==true)
					{
						click(BookingPageLocators.busOW(i+2),"Economy");
						break;
					}
					
				}	
			}
		}
		
		
		boolean b = tripType.equalsIgnoreCase("One Way");
		if(b == false)
			{
			selectClass(bookingClass, "One Way");
			}
	}
	
	
	public String[] inputPassengerDetails(String domOrInt,String totalPass,String nationality,String travelDoc,
			String docNum, String naSmiles, String mobileNum, String emailId,String fname,String lname,String payment2) 
					throws Throwable{
		
		waitforElement(BookingPageLocators.passengertitle);
		String lastName="TestFname",firstname="TestLname";
		String Passenger="Adult";
		String[] FirstLastName = null;
		try{
			for(Integer count = 1; count<=Integer.valueOf(totalPass); count++)
			{
				click(BookingPageLocators.title, "Tittle");
				type(By.xpath("//XCUIElementTypePicker/XCUIElementTypePickerWheel"), "Mr", "Tittle");
				Iosdriver.findElementByAccessibilityId("Done").click();
				//click(BookingPageLocators.fName, "Firstname");
				type(BookingPageLocators.fName,lastName , "firstName");
				//Iosdriver.findElementByAccessibilityId("Done").click();
				//click(BookingPageLocators.lName, "Lastname");
				type(BookingPageLocators.lName, firstname, "LastName");
				//Iosdriver.findElementByAccessibilityId("Done").click();
				
				click(BookingPageLocators.dateofbirth, "Date Of Birth");
				if(Passenger.contains("Child")){
					type(By.xpath("//XCUIElementTypePickerWheel[3]"), "2008", "Date Of Birth");
					Iosdriver.findElementByAccessibilityId("Done").click();
				}
				else
					if(Passenger.contains("Infant")){
						type(By.xpath("//XCUIElementTypePickerWheel[3]"), "2016", "Date Of Birth");
						Iosdriver.findElementByAccessibilityId("Done").click();
				}
					else{
						type(By.xpath("//XCUIElementTypePickerWheel[3]"), "1998", "Date Of Birth");
						Iosdriver.findElementByAccessibilityId("Done").click();
					}
				Iosdriver.findElementByAccessibilityId("Done").click();
				
				click(BookingPageLocators.idnumber, "Idnumber");
				type(BookingPageLocators.idnumber, docNum, "ID Number");
				Iosdriver.findElementByAccessibilityId("Done").click();
				
				if(isElementPresent(BookingPageLocators.idexpdate)==true){
					click(BookingPageLocators.idexpdate, "ID Expiry date");
					type(By.xpath("//XCUIElementTypePickerWheel[3]"), "2023", "ID Expiry Date");
					Iosdriver.findElementByAccessibilityId("Done").click();
					}
				else{
					System.out.println("NO ID Expiry Date");////*[@label='icn add']/preceding-sibling::XCUIElementTypeStaticText[2]
				}
				
				if(!naSmiles.equalsIgnoreCase("")){
					if(isElementPresent(BookingPageLocators.smily)==true){
						type(BookingPageLocators.smily, naSmiles, "naSmilyNumber");
						Iosdriver.findElementByAccessibilityId("Done").click();
						
					}
					else{
						System.out.println("No Smily");////*[@label='icn add']/preceding-sibling::XCUIElementTypeStaticText[2]
					}
				}
				if(Integer.parseInt(totalPass) > 1 && count < Integer.parseInt(totalPass))
				{
					int total = 0;
					for(int i=total;i<Integer.parseInt(totalPass);i++){
						List<WebElement> icnadd = driver.findElements(By.xpath("//*[@label='icn add']"));
					//	String Passengername = icnadd.get(i).findElement(By.xpath("preceding-sibling::XCUIElementTypeStaticText[2]")).getAttribute("value");
						List<WebElement> Passengername = driver.findElements(By.xpath("//*[@label='icn add']/preceding-sibling::XCUIElementTypeStaticText[2]"));
						Passenger= Passengername.get(i).getText();
						icnadd.get(i).click();
						total=total+1;
						Thread.sleep(1000);
						break;
						
					}
					
					
				}
			} 
			scrollJS(BookingPageLocators.selectExtras_btn);
			click(BookingPageLocators.mobilenum, "MobileNumber");
			type(BookingPageLocators.mobilenum, mobileNum, "MobileNumber");
			Iosdriver.findElementByAccessibilityId("Done").click();
			click(BookingPageLocators.emailAddress, "MobileNumber");
			type(BookingPageLocators.emailAddress, emailId, "Email Address");
			Iosdriver.findElementByAccessibilityId("Done").click();
			Thread.sleep(1000);
			click(BookingPageLocators.selectExtras_btn, "Continue to Select Extras");
			 FirstLastName = new String[2];
			 FirstLastName[0] =firstname;
			 FirstLastName[1] =lastName;
			 return FirstLastName;
			
		}catch(Exception e){
			e.printStackTrace();
			return FirstLastName;
			
		}
		
		
	
	}
	
//	public boolean inputExtras(String charity) throws Throwable{
//		//click(BookingPageLocators.continueBtn, "Continue");
//		
//				
//		if (Integer.parseInt(charity)>1){
//			
//			String chariity = getAttribute(BookingPageLocators.charitydisable, "disabled","Charity");
//			if(chariity.equalsIgnoreCase("true"))
//			{
//				System.out.println("Charity is disabled");
//				click(BookingPageLocators.continuebtn, "Continue");
//
//			}
//			else
//			{
//			
//			click(BookingPageLocators.selectCharity,"Charity");
//			Thread.sleep(2000);
//			click(By.xpath("//div[contains(text(),'"+charity+"')]"), "Charity Amount");
//			Thread.sleep(3000);
//			click(BookingPageLocators.continuebtn, "Continue");
//			}
//		}
//		else
//		{
//			click(BookingPageLocators.continuebtn, "Continue");
//		}
//		return true;
//	}

	public boolean selectallSeats(String seatSelect,String totalpass,String tripType) throws Throwable {
		
		waitforElement(BookingPageLocators.seatSelectionTittle);
		if(isElementDisplayedTemp(BookingPageLocators.seatSelectionTittle)==true){
		List<WebElement> ele = driver.findElements(BookingPageLocators.seatplusbutton); 
		if(ele.size()==0){
			click(BookingPageLocators.payment_btn, "Payment");
		}else{
			List<WebElement> seatplus = driver.findElements(BookingPageLocators.seatplusbutton);
			seatplus.get(0).click();
			for(int i=0;i<seatplus.size();i++){
				if(seatSelect.equalsIgnoreCase("Extra Leg Room")){
					List<WebElement> extrsleg = driver.findElements(BookingPageLocators.ExtraLegSeats);
					for(int j=0;j<extrsleg.size();j++){
						if(!extrsleg.get(j).getAttribute("label").equalsIgnoreCase("1A")){
							extrsleg.get(j).click();
							Thread.sleep(1000);
							break;
						}
					}
				}else if(seatSelect.equalsIgnoreCase("Business")){
					List<WebElement> business = driver.findElements(BookingPageLocators.businessSeats);
					for(int k=0;k<business.size();k++){
						if(!business.get(k).getAttribute("label").equalsIgnoreCase("1A")){
							business.get(k).click();
							Thread.sleep(1000);
							break;
						}
					}
				}
			}
			click(BookingPageLocators.payment_btn, "Payment");
		}
	}else{
		System.out.println("No Baggage Page");
	}
	return true;
	}
		
//	public boolean selectSeat(String seatSelect, String bookingtype,String triptype) throws Throwable {
//		
//		if(bookingtype.equalsIgnoreCase("CodeShare")||bookingtype.equalsIgnoreCase("PartcodeShare"))
//		{
//			click(BookingPageLocators.continuebtn, "Continue");
//		}
//		else
//		{
//			waitForElementPresent(BookingPageLocators.seatplusbutton, "Seat Adding Button");
//		
//			click(BookingPageLocators.seatplusbutton, "Seat Adding Button");
//			Thread.sleep(2000);
//			if(seatSelect.equalsIgnoreCase("Extra Leg Room"))
//			{
//				click(BookingPageLocators.ExtraLegSeats, "Extra Seats");
//				/*List<WebElement> Extralegseats = driver.findElements(BookingPageLocators.ExtraLegSeats);
//				for(int i=1 ;i<=Extralegseats.size();i++)
//				{
//					
//						click(BookingPageLocators.ExtraSeats(i), "Extra Seats");
//					
//						if(isElementPresent(BookingPageLocators.continuebtn)==true)
//						{
//							System.out.println("Seat Selected");
//							break;
//						}
//						
//					
//					else
//					{
//						continue;
//					}
//					
//				
//				}*/
//				
//			
//			}
//				
//			else if(seatSelect.equalsIgnoreCase("Premium"))
//				click(BookingPageLocators.selPremSeat,"Premium");
//			else if(seatSelect.equalsIgnoreCase("Upfront"))
//				click(BookingPageLocators.selUpfrontSeat,"Upfront");
//			else if(seatSelect.equalsIgnoreCase("Extra Leg Room2"))
//				click(BookingPageLocators.selExLeg2Seat,"Extra Leg Room2");
//			else if(seatSelect.equalsIgnoreCase("Standard"))
//				click(BookingPageLocators.selStdSeat,"Standard");
//			else if(seatSelect.equalsIgnoreCase("Business"))
//			{
//				/*List<WebElement> seats = driver.findElements(By.xpath("//android.widget.ImageView"));
//				for(int i=0;i<seats.size();i++)
//				{
//					seats.get(i).click();
//					Thread.sleep(1000);
//					if(isElementPresent(BookingPageLocators.continuebtn)==true)
//					{
//						System.out.println("Seat Selected");
//						break;
//					}
//					else
//					{
//						continue;
//					}
//					
//				}*/
//				driver.findElement(By.xpath("//*[@resource-id='com.flynas.android.app:id/select_seat_column1_image']")).click();
//			}
//		}
//		click(BookingPageLocators.continuebtn, "Continue");
//		return true;
//}
	
	public void paymentoption(String paymentType) throws Throwable {
		waitforElement(BookingPageLocators.Payment_title);
		WebElement elm;
		if(paymentType.equalsIgnoreCase("ApplePay")){
			click(BookingPageLocators.applepay, "Apple Pay");
		}
		else{
			//click_mobile("Other Payment Options","Other payment options");
			click(BookingPageLocators.otherpaymentoptions, "Other Payment options");	
		}
		
	}
	
	public boolean payment(String paymentType,String pnr) throws Throwable 
	{		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		System.out.println(paymentType);
			if(paymentType.equalsIgnoreCase("Credit Card"))
			{
				type(BookingPageLocators.cardNumber,configProps.getProperty("cardNumber"),"Card Number");
				type(BookingPageLocators.cardName,configProps.getProperty("cardHolderName"),"Card Holder Name");
				Iosdriver.findElementByAccessibilityId("Done").click();
				type(BookingPageLocators.expdate,configProps.getProperty("ExpDate"),"Expiry Date");
				type(BookingPageLocators.cvvNum,configProps.getProperty("cvv"),"cvv");
				Iosdriver.findElementByAccessibilityId("Done").click();
			} 	
			else if(paymentType.equalsIgnoreCase("Voucher"))
			{
				type(BookingPageLocators.voucherNum,configProps.getProperty("voucher"),"Voucher");
				click(BookingPageLocators.retrieveVoucher, "Retrieve Voucher");
			} 
			else if(paymentType.equalsIgnoreCase("SADAD"))
			{
				click(BookingPageLocators.tabSadad,"Sadad");
				swipeVertical(0.50f);
			}
			else if(paymentType.equalsIgnoreCase("Nas"))
			{
				click(BookingPageLocators.tabNasCredit, "NAS CREDIT");
				type(BookingPageLocators.creditShellAmount, "", "Amount");
			}
		
			//click(BookingPageLocators.terms, "Terms And Condition");
			click_mobile(BookingPageLocators.Purchase, "Purchase");
		return true;
	}
	
	public String getReferenceNumber() throws Throwable{
		
		String refnum=null;
		waitForElementPresent(BookingPageLocators.summaryRefNumber, "Reference Number");
		List<WebElement> pnr = driver.findElements(BookingPageLocators.summaryRefNumber);
		for(int i=0;i<pnr.size();i++)
		{
			refnum = pnr.get(i).getAttribute("value");
			System.out.println("******"+refnum);
			break;
		}
		return refnum;
		
		
	}
	
	public void searchFlight(String referenceNum, String email, String mobile, String Search) throws Throwable{
		waitForElementPresent(BookingPageLocators.bookingReference, "Reference Number");
		type(BookingPageLocators.bookingReference, referenceNum, "Reference Number");
		type(BookingPageLocators.email_mb, email, "Email");
		Iosdriver.findElementByAccessibilityId("Done").click();
		waitforElement(BookingPageLocators.findBookings);
		click(BookingPageLocators.findBookings, "Find Bookings");	
	
	}
	
	
//	public void searchFlightCheckin(String referenceNum, String email, String mobile, String lastName) throws Throwable{
//		// add validation
//		driver.get(configProps.getProperty("URL_Checkin"));
//		Thread.sleep(5000);
//		type(BookingPageLocators.sfpbookingReference, referenceNum, "Reference Number");
//		//type(BookingPageLocators.sfpEmail, email, "Email");
//		//type(BookingPageLocators.sfpMoblie, mobile, "Mobile");
//		type(BookingPageLocators.lastName_mb, lastName, "Last Name");
//		click(BookingPageLocators.continuebtn, "Find Bookings");		
//	}
	
	
	public String changeDate(String referenceNum, String email, String mobile, String lastName, String newDate, 
			String selectSeat,String totalpassString ,String bookingclass,String tripType) throws Throwable{
		
		click(BookingPageLocators.btnchngFlight, "Change Flight");
		List<WebElement> flighttochng = driver.findElements(BookingPageLocators.flightToChange);
		for(int i=0;i<flighttochng.size();i++)
		{
			flighttochng.get(i).click();
		}
	//	click(BookingPageLocators.flightToChange, "Select Flight");
		click(BookingPageLocators.continuebtn, "Continue");
		select_date(newDate);
		click(BookingPageLocators.selectDateButton_mb, "Select");
		Thread.sleep(6000);
		selectClass(bookingclass, tripType);
		Thread.sleep(5000);
		String newDateto=driver.findElement(By.xpath("//*[@resource-id='com.flynas.android.app:id/extraFlightDate']")).getText();
		String Date[] = newDateto.split(",");
		String Datesplit[] = Date[1].split(" ");
		String newdate[] = newDate.split("-");
		if(Datesplit[1].contains(newdate[0]))
		{
			click(BookingPageLocators.cnfmChanges, "Conform Changes");
			Reporter.SuccessReport("Verifing Change Date", "Successfully Changed");
		}
		else
		{
			Reporter.failureReport("Verifing Change Date", "Failed To Change Date");
		}
				return getReferenceNumber();
	}	
	
/*	public void searchFlightinCheckin(String referenceNum, String email, String mobile, String lastName) throws Throwable{
		// add validation
		driver.get(configProps.getProperty("URL_Checkin"));
		Thread.sleep(5000);
		type(BookingPageLocators.sfpbookingReference, referenceNum, "Reference Number");
		//type(BookingPageLocators.sfpEmail, email, "Email");
		//type(BookingPageLocators.sfpMoblie, mobile, "Mobile");
		type(BookingPageLocators.sfpLastName, lastName, "Last Name");
		
		click(BookingPageLocators.sfpChekin, "Check in");
	}*/
	
	
	public void performCheckin(String SelectSeat,String paymenttype, String strPassenger) throws Throwable
	{
		waitForElementPresent(BookingPageLocators.passengers_incheckin, "Passenger In Checkin");
		List<WebElement> passengers_incheckin = driver.findElements(BookingPageLocators.passengers_incheckin);
		for(int  i=0;i<passengers_incheckin.size();i++)
		{
			passengers_incheckin.get(i).click();
		}
		click(BookingPageLocators.passengers_checkterms, "Terms And Conditions");
		click(BookingPageLocators.continuebtn, "Continue");
		
	}

	public void Baggage(String bookingtype,String totalpass) throws Throwable
	{
		waitforElement(BookingPageLocators.baggageTittle);
		int j=0;
		if(isElementPresent(BookingPageLocators.baggageTittle)==true){
			click(BookingPageLocators.baggageAddPlusButton, "Baggage");
			List<WebElement> bag1  = driver.findElements(BookingPageLocators.baggagePlusButton);
			bag1.get(j).click();
			j=j+3;
			List<WebElement> updownBtn = driver.findElements(BookingPageLocators.baggageAdddownButton);
			if(updownBtn.size()>1){
				for(int i=1;i<updownBtn.size()-1;i++)
				{
					updownBtn.get(i).click();
					bag1  = driver.findElements(BookingPageLocators.baggagePlusButton);
					bag1.get(3).click();
					j=j+3;
				}
			}
			
		}else{
			System.out.println(" No Baggage Page");
		}
	}	
	
	public void validateCheckin() throws Throwable
	{
		waitForElementPresent(BookingPageLocators.checkinConformation, "Check-in Conformation");
		if(isElementPresent(BookingPageLocators.checkinConformation,"Check-in Conformation"))
		{
			Reporter.SuccessReport("Validating check in", "Checkin is Done");
		}
		else
		{
			Reporter.failureReport("Validating check in", "Check in is Not Done");
		}
	}
	
	public void validate_ticketStatus(String pnr) throws Throwable
	{
		//Thread.sleep(10000);
		//System.out.println(getText(BookingPageLocators.summaryStatus,"Status"));
		if(Iosdriver.findElementByAccessibilityId(BookingPageLocators.summaryStatus).getText().equalsIgnoreCase("Confirmed"))
		{
			Reporter.SuccessReport("Ticket Confirmation", "Ticket has booked with PNR" + pnr);
		}
		else
		{
			Reporter.failureReport("Ticket Conformation", "Ticket has not booked");
		}
		
	}
	
	public void verifyPNRforSadad(String pnr) throws Throwable{
		
		if(Iosdriver.findElementByAccessibilityId(BookingPageLocators.SadadStatus).getText().equalsIgnoreCase("Pending"))
		{
			Reporter.SuccessReport("Ticket Confirmation", "Ticket has booked with PNR" + pnr);
		}
		else
		{
			Reporter.failureReport("Ticket Conformation", "Ticket has not booked");
		}
	}
	
	public static String pickDate(String xlsDate){
		
		String[] depdate = xlsDate.split("\\^");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, Integer.parseInt(depdate[1])); // Adding 1 days
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		return newDate;
		
	}
	
//	public void selctClasswithCodeshare(String bookingtype,String bookingClass,String tripType) throws Throwable
//	{
//		boolean flag=false;
//		int count=0;
//		if(!tripType.equalsIgnoreCase("One Way"))
//		{
//			for(int j=0;j<2;j++)
//			{
//				List<WebElement> ClassArrow = driver.findElements(BookingPageLocators.selectFlightUpDownArrow);
//				if(ClassArrow.size()!=0)
//				{
//					for(int i=0;i<=ClassArrow.size();i++)
//					{
//						count=0;
//						ClassArrow.get(i).click();
//						if(isElementPresent(BookingPageLocators.flexOW)==true)
//						{
//							String FlightNum = getText(BookingPageLocators.flightNumber, "Flight");
//							System.out.println(FlightNum);
//							for(int k=0;k<FlightNum.length();k++)
//							{
//								char result = FlightNum.charAt(k);
//							 	if(Character.isDigit(result))
//							 	{
//							 		count++;
//							 	}
//						}
//						if(count==8 && bookingtype.equalsIgnoreCase("CodeShare"))
//						{
//							click(BookingPageLocators.flexOW, "Flex");
//							Thread.sleep(2000);
//							break;
//						
//						}
//						else
//						
//							if(count==7 && bookingtype.equalsIgnoreCase("PartcodeShare"))
//							{
//								click(BookingPageLocators.flexOW, "Flex");
//								Thread.sleep(2000);
//								break;
//							
//							}
//							else
//							{
//								ClassArrow.get(i).click();
//							}
//		
//						
//						
//					}
//						else
//						{
//							System.out.println("No Flex");
//							ClassArrow.get(i).click();
//						}
//				}
//			}
//				else
//				{
//					System.out.println("No Flights");
//				}
//		}
//		}
//			
//	}
	
	public void Select_A_Meal() throws Throwable
	{
		      //waitForElementPresent(BookingPageLocators.mealTitle, "Meal");
				if(isElementDisplayedTemp(BookingPageLocators.mealTitle)){
				swipeVertical(0.50f);
				List<WebElement>  MealExpButtons = driver.findElements(BookingPageLocators.mealExpansionButton);
				//List<WebElement> MealsNames = driver.findElements(BookingPageLocators.mealNames);
		
				for(int i=0;i<MealExpButtons.size();i++)
				{
					MealExpButtons.get(i).click();
					swipeVertical(0.50f);
					List<WebElement> icndelt = driver.findElements(BookingPageLocators.mealcloseButton);
					for(int j=0;j<icndelt.size();i++){
						icndelt.get(j).click();
						List<WebElement> mealadd = driver.findElements(BookingPageLocators.mealAddBtn);
						mealadd.get(j).click();
						List<WebElement> avaiMeal = driver.findElements(BookingPageLocators.availableMeal);
						for(int k=0;k<avaiMeal.size();k++)
						{
							if(avaiMeal.get(k).isDisplayed()==true){
								avaiMeal.get(k).click();
								break;
							}
						}break;
					}
					
				}
				swipeVertical(0.50f);	
				click(BookingPageLocators.selectSeat_btn, "Select Seat");
			}else{
				System.out.println("Meal Not Available");
			}
	}
	public void Selecting_loung() throws Throwable
	{
		if(isElementPresent(BookingPageLocators.Loung)==true){
		List<WebElement> Loung = driver.findElements(BookingPageLocators.Loung);
		
			for(int i=1 ;i<=Loung.size()-2;i++)
		{
			if(Loung.get(i).findElement(By.tagName("input")).getAttribute("value")=="true")
			{
				Loung.get(i).click();
				break;
			}
			else
			{
				Loung.get(i+1).click();
				break;
			}
		}
		}
		
		else
		{
			System.out.println("No Loung");
		}
		//click(BookingPageLocators.continueBtn, "Continue");
	}
	public  void cancelFlight(String referenceNum,String email,String mobile,String lastname) throws Throwable
	{
		
		waitForElementPresent(BookingPageLocators.cancelflightBtn, "Cancel Flight");
		click(BookingPageLocators.cancelflightBtn, "Cancel Flight");
		List<WebElement> flighttocancel = driver.findElements(BookingPageLocators.flightToChange);
		for(int i=0;i<flighttocancel.size();i++)
		{
			flighttocancel.get(i).click();
		}
		//click(BookingPageLocators.flightToChange, "Select Flight");
		click(BookingPageLocators.continuebtn, "Continue");
		waitforElement(BookingPageLocators.cnfmChanges);
		click(BookingPageLocators.cnfmChanges, "Conform Changes");
		if(isElementDisplayedTemp(BookingPageLocators.ok)==true)
		{
			click(BookingPageLocators.ok, "Ok To Cancel Flight");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		
		
	}
	public void verifyConformcharges() throws Throwable
	{
		if(isElementPresent(BookingPageLocators.conformedAftercharges)==true)
		{
			Reporter.SuccessReport("Verifing Confirmed after clicking conform charges", "Successfully Verified");
		}
		else
		{
			Reporter.failureReport("Verifing Confirmed after clicking conform charges", "fail to verify");
		}
	}
//	public void Baggage_Extra()
//	{
//		List<WebElement>  Adults = driver.findElements(BookingPageLocators.Adult_baggagae);
//		for(int i=0;i<Adults.size();i++)
//		{
//			String value=Adults.get(i).getText();
//			if(value.equalsIgnoreCase("Adult 1"))
//			{
//				Adults.get(i).click();
//				ImplicitWait();
//				List<WebElement>  Baggage_weight = driver.findElements(BookingPageLocators.Baggage_weight);
//				for(int j=1;j<=Baggage_weight.size();j++)
//				{
//					Baggage_weight.get(j).click();
//					ImplicitWait();
//					break;
//
//				}
//				break;
//
//			}
//			else
//				if(value.equalsIgnoreCase("Child 1"))
//				{
//					Adults.get(i).click();
//					ImplicitWait();
//					List<WebElement>  Baggage_weight = driver.findElements(BookingPageLocators.Baggage_weight);
//					for(int j=1;j<=Baggage_weight.size();j++)
//					{
//						Baggage_weight.get(j).click();
//						ImplicitWait();
//						break;
//					}
//
//					
//				}
//		}
//
//	}
	public void Handlepopup() throws Throwable
	{
		if(isElementPresent(BookingPageLocators.Deny)==true)
		{
			click(BookingPageLocators.Deny, "DENY");
		}
	}
	public void login(String email,String pwd) throws Throwable
	{ if(isElementPresent(BookingPageLocators.login_lnk)==false)
		{
		scrollJS(BookingPageLocators.logout_lnk);
		click(BookingPageLocators.logout_lnk, "Logout");
		}
		click(BookingPageLocators.login_lnk, "Login");
		type(BookingPageLocators.email, email, "EmailAddress");
		type(BookingPageLocators.password, pwd, "Password");
		click(BookingPageLocators.login_btn, "Login");
	}
	public void verifyCancel() throws Throwable
	{
		waitforElement(BookingPageLocators.conformCancel);
		if(getAttribute(BookingPageLocators.conformCancel, "value", "Conform Cancel").equalsIgnoreCase("Confirmed")){
			Reporter.SuccessReport("Verifing Flight Cancel", "Canceled");
		}else{
			Reporter.SuccessReport("Verifing Flight Cancel", "Not canceled");
		}
	}
	
	public String[] pickCredentials(String Sheetname){
		ExcelReader xls = new ExcelReader(configProps.getProperty("Credentialsdata"),Sheetname);
		int count = xls.getRowCount(Sheetname);
		int index = ((int)(Math.random() * count-1)) + 1;;
		String[] credentials =new String[5];
		credentials[0] = xls.getCellValue("credentials"+index, "userid");
		credentials[1] = xls.getCellValue("credentials"+index, "password");
		credentials[2] = xls.getCellValue("credentials"+index, "firstname");
		credentials[3] = xls.getCellValue("credentials"+index, "lastname");
		return credentials;
	}
	
}

