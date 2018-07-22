package flynas.ios.workflows;

import java.text.ParseException;
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

import flynas.ios.testObjects.Locators;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;



public class BookingPageFlow extends Locators{
	
	//*********Home page actions****************
	public void handleRatingRequest() throws Throwable
	{
		if(isElementPresent(Locators.loveFlynasApp)==true)
		{
			click(Locators.noThanks, "No Thanks");
		}
		else
		{
			System.out.println("No Rating Request");
		}
	}
	
	public void selectCheckIn() throws Throwable{
		try{
		Iosdriver.findElement(Locators.checkinbtn).click();
		Reporter.SuccessReport("Clicking on CheckIn Icon", "Chekin icon Cicked successfuly");
		}
		catch(Exception e){
		Reporter.failureReport("Clicking on CheckIn Icon", "Failed to click on Checkin Icon");	
		}
		}
	
	public void selectBookFlights() throws Throwable{
		try{
			Iosdriver.findElement(Locators.bookbtn).click();
			//click_mobile(Locators.bookflights,"Book Icon");
			Reporter.SuccessReport("Clicking on Book Icon", "Book icon");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on Book Icon", "Book Icon");	
			}
		}
	
	public void selectMMB() throws Throwable{
		try{
			Iosdriver.findElement(Locators.managebtn).click();
			Reporter.SuccessReport("Clicking on Manage Icon", "Manage icon");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on Manage Icon", "Manage Icon");	
			}
	}
	
	public void selectBoardingPasses() throws Throwable{
		try{
			Iosdriver.findElement(Locators.brdngPsbtn).click();
			Reporter.SuccessReport("Clicking on Boarding Passes Icon", "Boarding Passes icon Cicked successfuly");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on Boarding Passes Icon", "Failed to click on Boarding Passes Icon");	
			}
	}
	
	public void selectHome() throws Throwable{
		Iosdriver.findElement(Locators.homebtn).click();
		try{
			Iosdriver.findElement(Locators.homebtn).click();
			Reporter.SuccessReport("Clicking on home Icon", "home icon Cicked successfuly");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on home Icon", "Failed to click on home Icon");	
			}

	}
	
	//booking page
	
	
	
	public void inputBookingDetails(String tripType, String origin, String dest, String deptDate,
			String origin2, String departure2, String retDate, String adults, String child, String infant, String promo,String Currency) throws Throwable{
		
		waitforElement(Locators.OWbtn);
		//Select Trip Mode
		if(tripType.equalsIgnoreCase("Round Trip")){
			click_mobile(Locators.roundTrip, "Return tab");
		} else if(tripType.equalsIgnoreCase("One Way")){
			click_mobile(Locators.oneWay, "One-way tab");
		} 
		
		click(Locators.origin, "Origin");
		//click_mobile("Origin", "Origin tab");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		click_mobile(Locators.search, "Search");
		type_mobile(Locators.search, origin, "Origin");
		click_mobile(Locators.searched_city.replace("#", origin), "Origin");
		type_mobile(Locators.search, dest, "Destination");
		click_mobile(Locators.searched_city.replace("#", dest), "Destination");
	
		if(tripType.equalsIgnoreCase("One Way"))
		{
			
//			click(Locators.Departuredate, "Departure Date");
//			select_date(deptDate);
//			click(Locators.Select_date, "Select Date");
		}
		if(tripType.equalsIgnoreCase("Round Trip"))
		{
//			click(Locators.Departuredate, "DepartureDate");
//			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//			select_date(deptDate);
//			select_date(retDate);
//			click(Locators.Select_date, "Select Date");
		}
		if(tripType.equalsIgnoreCase("Multi City")){
			
			//click(Locators.Departuredate_multicity, "DepartureDate");
		//	select_date(deptDate);
		//	click(Locators.Select_date, "Select Date");
			Thread.sleep(3000);
			click(Locators.origin_multicity, "Origin2");
			click_mobile(Locators.search, "Search");
			type_mobile(Locators.search, origin2, "Origin");
			click_mobile(Locators.searched_city.replace("#", origin2), "Origin");
			type_mobile(Locators.search, departure2, "Destination");
			click_mobile(Locators.searched_city.replace("#", departure2), "Destination");
		
			
		}
		
		if((Integer.valueOf(adults)+Integer.valueOf(child)+Integer.valueOf(infant))>1)
		{
			click(Locators.passengerCount, "Passenger count tab");
		
			if(Integer.valueOf(adults)>1){
				waitforElement(Locators.Audaltplusbutton);
				for(int i=1;i<Integer.valueOf(adults);i++)
				{
				click(Locators.Audaltplusbutton, "Adult");
				System.out.println("Adults: "+adults);
				}
			}
			if(Integer.valueOf(child)>0){
				for(int i=0;i<Integer.valueOf(child);i++)
				{
				click(Locators.childplusbutton, "Child");
				System.out.println("Child: "+child);
				}
			}
			if(Integer.valueOf(infant)>0){	
				for(int i=0;i<Integer.valueOf(infant);i++)
				{
				click(Locators.infantplusbutton, "Infant");
				System.out.println("Infant: "+infant);
				}
			}
			Iosdriver.findElementByAccessibilityId("Done").click();
		}	
		
//			click_mobile(Locators.findFlights, "Find Flights");
//			waitforElement(Locators.Slectflighttitle);
			
	}
	
	public void select_dates(String deptDate, String retDate) throws Throwable{
		click(Locators.Departuredate, "Departure Date");
		select_date(deptDate);
		if(retDate!="") 
		select_date(retDate);
		click(Locators.Select_date, "Select Date");
	}
	
	public void selectPayWithSmilePoint() throws Throwable{
		scrollToElement(Locators.smilePointsbtn);
		click(Locators.smilePointsbtn,"Smile points");
	}
	
	public void clickFindFlightsBtn() throws Throwable{
		Thread.sleep(3000);
		scrollToText("Find Flights");
		click_mobile(Locators.findFlights, "Find Flights");
	}
	
	public void selectcurrency(String currency) throws Throwable{
		click(Locators.Currency, "Currency");
		Thread.sleep(2000);
		click(Locators.currencytype(currency), "Currency");
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
		
			
			
	
	@SuppressWarnings("unchecked")
	public void selectClass(String bookingClass, String bundle) throws Throwable
	{
		Thread.sleep(10000);
		boolean soldout = false;
		while (isElementPresent(Locators.passengertitle) == false){
			List<MobileElement> flights = Iosdriver.findElements(Locators.FlightAcrdions);
			//following 'while' loop check for the availability on selected date and selects next date if no flights are displayed
			int j = 0;
			while(flights.size()==0 && j < 7){
				click(Locators.rightarrow, "Flight select Right Arrow");
				click(Locators.datebtn(1),"Selecting next date");
				Thread.sleep(5000);//wait to load next day flights
				flights = Iosdriver.findElements(Locators.FlightAcrdions);
				j++;
				}
			
			System.out.println("Flights -"+flights.size());
			//following loop checks if the class to be selected is available for each flight and selects if available
			for(int i=1;i<=flights.size();i++)
			{	if(bookingClass.equalsIgnoreCase("Economy")){
					if(isElementPresent(Locators.simpleOW(i))==true)
					{	soldout = false;
						click(Locators.simpleOW(i),"Economy class");
						//selecting bundle
						if(bundle.equalsIgnoreCase("Light")){
							click(Locators.lightbtn(i), "Selecting Light bundle");
						}
						else if(bundle.equalsIgnoreCase("Plus")){
							click(Locators.Plusbtn(i), "Selecting Plus bundle");
						}
						else if(bundle.equalsIgnoreCase("Premium")){
							click(Locators.Premiumbtn(i), "Selecting Premium bundle");
						}
						break;
					}else{
						soldout = true;
						if(i<flights.size())
						flights.get(i).click();
					}
				}
				else if(bookingClass.equalsIgnoreCase("Business")){
					if(isElementPresent(Locators.busOW(i))==true)
					{	soldout = false;
						click(Locators.busOW(i),"Business class");
						break;
					}else{
						soldout=true;
						if(i<flights.size())
						flights.get(i).click();
					}
				}
			}
			if(soldout == true){
				//selecting next date if no flight has the class listed
				click(Locators.rightarrow, "Flight select Right Arrow");
				click(Locators.datebtn(1),"Selecting next date");
				Thread.sleep(5000);//wait to load next day flights
			}
			Thread.sleep(5000);//wait required to load nxt page
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void selectClasswithCodeshare(String bookingtype,String bookingClass) throws Throwable
	{
		boolean soldout = false;
		while(isElementPresent(Locators.passengertitle)==false)	
		{
			List<MobileElement> flights = Iosdriver.findElements(Locators.FlightAcrdions);
			//following 'while' loop check for the availability on selected date and selects next date if no flights are displayed
			int j = 0;
			while(flights.size()==0 && j < 7){
				click(Locators.rightarrow, "Flight select Right Arrow");
				click(Locators.datebtn(1),"Selecting next date");
				Thread.sleep(5000);//wait to load next day flights
				flights = Iosdriver.findElements(Locators.FlightAcrdions);
				j++;
				}
			System.out.println("Flights -"+flights.size());
			//following loop counts number of digits for each flight and then selects the class if listed.
			for(int i=1;i<=flights.size();i++)
				{	int count=0;
					MobileElement flightnumber = (MobileElement) Iosdriver.findElement(Locators.flightNumber(i));
					String FlightNum = flightnumber.getText().trim();
					System.out.println(FlightNum);
					System.out.println(FlightNum.length());
					for(int k=0;k<FlightNum.length();k++){
							char result = FlightNum.charAt(k);
						 	if(Character.isDigit(result)){
					 		count++;}
						}
					System.out.println("Number Count :"+count);
					
					if((count==4||count==8) && bookingtype.equalsIgnoreCase("CodeShare")){
							if(bookingClass.equalsIgnoreCase("Economy")){
								if(isElementPresent(Locators.csEco(i))==true)
								{	soldout = false;
									click(Locators.csEco(i),"Economy class");
									if(isElementPresent(Locators.csplusbtn(i))==true){
										Reporter.failureReport("verifying if bundles are displayed with code share flights", "Bundles Displayed");}
									break;
								}else{
									soldout = true;
									if(i<flights.size())
									flights.get(i).click();
								}
							}
							else if(bookingClass.equalsIgnoreCase("Business")){
								if(isElementPresent(Locators.csbus(i))==true)
								{	soldout = false;
									click(Locators.csbus(i),"Business class");
									break;
								}else{
									soldout=true;
									if(i<flights.size())
									flights.get(i).click();
								}
							}
						}
					else if((4 < count && count < 8)  && bookingtype.equalsIgnoreCase("PartcodeShare")){
						if(bookingClass.equalsIgnoreCase("Economy")){
							if(isElementPresent(Locators.csEco(i))==true)
							{	soldout = false;
								click(Locators.csEco(i),"Economy class");
								if(isElementPresent(Locators.csplusbtn(i))==true){
									Reporter.failureReport("verifying if bundles are displayed with code share flights", "Bundles Displayed");}
								break;
							}else{
								soldout = true;
								if(i<flights.size())
									flights.get(i).click();
							}
						}
						else if(bookingClass.equalsIgnoreCase("Business")){
							if(isElementPresent(Locators.csbus(i))==true)
							{	soldout = false;
								click(Locators.csbus(i),"Business class");
								break;
							}else{
								soldout=true;
								if(i<flights.size())
								flights.get(i).click();
							}
						}
					}
					
					else{
						if(i<flights.size())
							flights.get(i).click();}
				}
			
			if(soldout == true){
				//selecting next date if no flight has the class listed
				click(Locators.rightarrow, "Flight select Right Arrow");
				click(Locators.datebtn(1),"Selecting next date");
				Thread.sleep(5000);//wait to load next day flights
			}
			Thread.sleep(5000);//wait to load next day flights
		}
			
	}
	
	
	public String[] inputPassengerDetails(String domOrInt,String totalPass,String nationality,String travelDoc,
			String docNum, String naSmiles, String mobileNum, String emailId,String fname,String lname,String payment2) 
					throws Throwable{
		
		waitforElement(Locators.passengertitle);
		String firstname=null;
		String lastName="Test";
		
		String[] FirstLastName = null;
		try{
			for(Integer count = 1; count<=Integer.valueOf(totalPass); count++)
			{	
				String[] Fnames = {"Zenia","Brielle","Alec","Grady","Mikayla","Kalia","Jared","Mallory","Moana","Clinton","Renee","Griffin","Merritt","Jenna","Zoe","Carla","Amber","Ayanna","Elvis","Camilla","Scarlet","Andrew","Joel","Timon","Thor","Shad","Simone","Dexter","Tana","Helen","Robert","Veda","Kirby","Molly","Jones","Williams","Bond","Dawney","Stathom","Stevens","Mccall","Bernard","Sanford","Matthews","Collier","Hooper","Clemons","Graham","Richmond","Richard","Morton","Watts","Bryan","Woods"};
				int Fnameindex = (int) (Math.random() * Fnames.length);    		
				firstname =  Fnames[Fnameindex];
				
				
				String Passenger=driver.findElement(Locators.passengertype).getText();
				click_mobile(Locators.title, "Tittle");
				if(Passenger.contains("Adult"))
					type(By.xpath("//XCUIElementTypePicker/XCUIElementTypePickerWheel"), "Mr.", "Title");
				else 
					type(By.xpath("//XCUIElementTypePicker/XCUIElementTypePickerWheel"), "Ms.", "Title");
				
				Iosdriver.findElementByAccessibilityId("Done").click();
				click(Locators.fName, "Firstname");
				type(Locators.fName,firstname , "firstName");
				Iosdriver.findElementByAccessibilityId("Done").click();
				click(Locators.lName, "Lastname");
				type(Locators.lName, lastName, "LastName");
				Iosdriver.findElementByAccessibilityId("Done").click();
				
				click(Locators.dateofbirth, "Date Of Birth");
				if(Passenger.contains("Adult"))
					type(By.xpath("//XCUIElementTypePickerWheel[3]"), "1998", "Date Of Birth");
				else if(Passenger.contains("Infant"))
					type(By.xpath("//XCUIElementTypePickerWheel[3]"), "2017", "Date Of Birth");
				else
					type(By.xpath("//XCUIElementTypePickerWheel[3]"), "2007", "Date Of Birth");
				
				Iosdriver.findElementByAccessibilityId("Done").click();
				
				click(Locators.idnumber, "Idnumber");
				type(Locators.idnumber, randomString(10), "ID Number");
				Iosdriver.findElementByAccessibilityId("Done").click();
				
				if(isElementPresent(Locators.idexpdate)==true){
					click(Locators.idexpdate, "ID Expiry date");
					type(By.xpath("//XCUIElementTypePickerWheel[3]"), "2023", "ID Expiry Date");
					Iosdriver.findElementByAccessibilityId("Done").click();
					}
				else{
					System.out.println("NO ID Expiry Date");////*[@label='icn add']/preceding-sibling::XCUIElementTypeStaticText[2]
				}
				
				if(!naSmiles.equalsIgnoreCase("")){
					if(isElementPresent(Locators.smily)==true){
						type(Locators.smily, naSmiles, "naSmilyNumber");
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
			scrollJS(Locators.selectExtras_btn);
			click(Locators.mobilenum, "MobileNumber");
			type(Locators.mobilenum, mobileNum, "MobileNumber");
			Iosdriver.findElementByAccessibilityId("Done").click();
			click(Locators.emailAddress, "MobileNumber");
			type(Locators.emailAddress, emailId, "Email Address");
			Iosdriver.findElementByAccessibilityId("Done").click();
			Thread.sleep(1000);
			click(Locators.selectExtras_btn, "Continue to Select Extras");
			if(isElementPresent(Locators.emailAddress)==true){
				click(Locators.selectExtras_btn, "Continue to Select Extras");
			}
				
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
//		//click(Locators.continueBtn, "Continue");
//		
//				
//		if (Integer.parseInt(charity)>1){
//			
//			String chariity = getAttribute(Locators.charitydisable, "disabled","Charity");
//			if(chariity.equalsIgnoreCase("true"))
//			{
//				System.out.println("Charity is disabled");
//				click(Locators.continuebtn, "Continue");
//
//			}
//			else
//			{
//			
//			click(Locators.selectCharity,"Charity");
//			Thread.sleep(2000);
//			click(By.xpath("//div[contains(text(),'"+charity+"')]"), "Charity Amount");
//			Thread.sleep(3000);
//			click(Locators.continuebtn, "Continue");
//			}
//		}
//		else
//		{
//			click(Locators.continuebtn, "Continue");
//		}
//		return true;
//	}

	public boolean selectallSeats(String seatSelect,String totalpass,String tripType) throws Throwable {
		
		waitforElement(Locators.seatSelectionTittle);
		if(isElementDisplayedTemp(Locators.seatSelectionTittle)==true){
		List<WebElement> ele = driver.findElements(Locators.seatplusbutton); 
		if(ele.size()==0){
			click(Locators.payment_btn, "Payment");
		}else{
			List<WebElement> seatplus = driver.findElements(Locators.seatplusbutton);
			seatplus.get(0).click();
			for(int i=0;i<seatplus.size();i++){
				if(seatSelect.equalsIgnoreCase("Extra Leg Room")){
					List<WebElement> extrsleg = driver.findElements(Locators.ExtraLegSeats);
					for(int j=0;j<extrsleg.size();j++){
						if(!extrsleg.get(j).getAttribute("label").equalsIgnoreCase("1A")){
							extrsleg.get(j).click();
							Thread.sleep(1000);
							break;
						}
					}
				}else if(seatSelect.equalsIgnoreCase("Business")){
					List<WebElement> business = driver.findElements(Locators.businessSeats);
					for(int k=0;k<business.size();k++){
						if(!business.get(k).getAttribute("label").equalsIgnoreCase("1A")){
							business.get(k).click();
							Thread.sleep(1000);
							break;
						}
					}
				}
			}
			click(Locators.payment_btn, "Payment");
		}
	}else{
		System.out.println("No Baggage Page");
	}
	return true;
	}

	public boolean selectSeat(String seatSelect, String bookingtype,String triptype) throws Throwable {
		System.out.println("Seat type "+seatSelect);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		if(isElementDisplayed(Locators.seatSelectionTittle)==true){
			List<WebElement> Seatplsbtn = driver.findElements(Locators.seatplusbutton);
			System.out.println("Number of add Seat buttons : "+Seatplsbtn.size());
			if(Seatplsbtn.size()==0 || bookingtype.equalsIgnoreCase("CodeShare") || bookingtype.equalsIgnoreCase("PartcodeShare")){
				click_mobile("Continue to Payment","Continue to payment on seat selection");
			}else{
				waitForElementPresent(Locators.seatplusbutton, "Seat Adding Button");
				click(Locators.seatplusbutton, "Seat Adding Button");
				driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
				boolean selectseat = (isElementDisplayed(Locators.elmWithText("Spacious")) || isElementDisplayed(Locators.elmWithText("Business")));
				while(selectseat==true){
					scrollToElement(Locators.elmWithText(seatSelect));
					List<WebElement> Seats = driver.findElements(Locators.seatsofType(seatSelect));
					int seatno = (int) (Math.random() * (Seats.size()-1));
					System.out.println("Selecting seat "+seatno);
					Seats.get(seatno).click();
					driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
					selectseat = (isElementDisplayed(Locators.elmWithText("Spacious")) || isElementDisplayed(Locators.elmWithText("Business")));
					}
				click_mobile("Continue to Payment","Continue to payment on seat selection");
			}
		}
		else
		{
			System.out.println("No Seats Available");
		}
		return true;
	}
	
//	public boolean selectSeat(String seatSelect, String bookingtype,String triptype) throws Throwable {
//		
//		if(bookingtype.equalsIgnoreCase("CodeShare")||bookingtype.equalsIgnoreCase("PartcodeShare"))
//		{
//			click(Locators.continuebtn, "Continue");
//		}
//		else
//		{
//			waitForElementPresent(Locators.seatplusbutton, "Seat Adding Button");
//		
//			click(Locators.seatplusbutton, "Seat Adding Button");
//			Thread.sleep(2000);
//			if(seatSelect.equalsIgnoreCase("Extra Leg Room"))
//			{
//				click(Locators.ExtraLegSeats, "Extra Seats");
//				/*List<WebElement> Extralegseats = driver.findElements(Locators.ExtraLegSeats);
//				for(int i=1 ;i<=Extralegseats.size();i++)
//				{
//					
//						click(Locators.ExtraSeats(i), "Extra Seats");
//					
//						if(isElementPresent(Locators.continuebtn)==true)
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
//				click(Locators.selPremSeat,"Premium");
//			else if(seatSelect.equalsIgnoreCase("Upfront"))
//				click(Locators.selUpfrontSeat,"Upfront");
//			else if(seatSelect.equalsIgnoreCase("Extra Leg Room2"))
//				click(Locators.selExLeg2Seat,"Extra Leg Room2");
//			else if(seatSelect.equalsIgnoreCase("Standard"))
//				click(Locators.selStdSeat,"Standard");
//			else if(seatSelect.equalsIgnoreCase("Business"))
//			{
//				/*List<WebElement> seats = driver.findElements(By.xpath("//android.widget.ImageView"));
//				for(int i=0;i<seats.size();i++)
//				{
//					seats.get(i).click();
//					Thread.sleep(1000);
//					if(isElementPresent(Locators.continuebtn)==true)
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
//		click(Locators.continuebtn, "Continue");
//		return true;
//}
	
	public void paymentoption(String paymentType) throws Throwable {
		waitforElement(Locators.Payment_title);
		if(paymentType.equalsIgnoreCase("ApplePay")){
			click(Locators.applepay, "Apple Pay");
		}
		else{
			//click_mobile("Other Payment Options","Other payment options");
			click(Locators.otherpaymentoptions, "Other Payment options");	
		}
		
	}
	
	public boolean payment(String paymentType,String pnr) throws Throwable 
	{	
		waitforElement(Locators.cardNumber);	
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		System.out.println(paymentType);
			if(paymentType.equalsIgnoreCase("Credit Card"))
			{	scrollJS(Locators.Purchasebtn);
				click(Locators.cardNumberbtn, "Card Number Field");	
				type(Locators.cardNumber,configProps.getProperty("cardNumber"),"Card Number");
				click(Locators.cardNamebtn, "Card Name Field");	
				type(Locators.cardName,configProps.getProperty("cardHolderName"),"Card Holder Name");
				click(Locators.expdatebtn, "Expiry date Field");
				type(Locators.expdate,configProps.getProperty("ExpDate"),"Expiry Date");
				click(Locators.cvvNumbtn, "Cvv Field");
				type(Locators.cvvNum,configProps.getProperty("cvv"),"cvv");
				swipeUpwords();
				click_mobile("Purchase","Purchase button");
				waitforElement(Locators.securePgTilte);
				click_mobile("Submit","Submit button");
			} 	
			else if(paymentType.equalsIgnoreCase("Voucher"))
			{
				type(Locators.voucherNum,configProps.getProperty("voucher"),"Voucher");
				click(Locators.retrieveVoucher, "Retrieve Voucher");
			} 
			else if(paymentType.equalsIgnoreCase("SADAD"))
			{	
				click(Locators.tabSadad,"Sadad");
				swipeVertical(0.50f);
				click_mobile("Purchase","Purchase button");
			}
			else if(paymentType.equalsIgnoreCase("Nas"))
			{
				click(Locators.tabNasCredit, "NAS CREDIT");
				type(Locators.creditShellAmount, "", "Amount");
			}
		
			return true;
	}
	
	public static void swipeUpwords()
	{
		 //Custom swipe metho
		 org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.50);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		  //Swipe from Bottom to Top.
		  ((MobileDriver<WebElement>) driver).swipe(startx, starty, startx, endy, 3000);
		 
	}
	
	public boolean nasmilespayment(String Username,String Password) throws Throwable {
		boolean flag =false;
		waitforElement(Locators.Payment_title);
		System.out.println(paymentType);
		scrollToElement(Locators.continuebtn);
		click(Locators.tabNaSmiles,"Sadad");
		
		type(Locators.naSmileId,Username, "naSmileID");
		type(Locators.naSmilepwd,Password, "naSmilePwd");
		click(Locators.naSmileslogin, "Log-in");
		Thread.sleep(2000);
		if(isElementDisplayedTemp(Locators.redeem)==false)
		{
			System.out.println("NO Sufficient points");
			flag= false;
		}
		else
		{
		click(Locators.redeem, "Redeem");
		Thread.sleep(2000);
		payment("Credit Card", "");			
		flag = true;
		}
		return flag;
	}
	
	public String getReferenceNumber() throws Throwable{
		
		String refnum=null;
		waitForElementPresent(Locators.summaryRefNumber, "Reference Number");
		List<WebElement> pnr = driver.findElements(Locators.summaryRefNumber);
		for(int i=0;i<pnr.size();i++)
		{
			refnum = pnr.get(i).getAttribute("value");
			System.out.println("******"+refnum);
			break;
		}
		return refnum;
		
		
	}
	
	public void searchFlight(String referenceNum, String email, String mobile, String Search) throws Throwable{
		waitForElementPresent(Locators.bookingReference, "Reference Number");
		type(Locators.bookingReference, referenceNum, "Reference Number");
		type(Locators.email_mb, email, "Email");
		Iosdriver.findElementByAccessibilityId("Done").click();
		waitforElement(Locators.findBookings);
		click(Locators.findBookings, "Find Bookings");	
	
	}
	
	public void searchFlightMMB(String referenceNum, String Lastname) throws Throwable{
		// add validation
		//driver.get(configProps.getProperty("URL_Search"));
		waitForElementPresent(Locators.bookingReference, "Booking Reference");
		type(Locators.bookingReference, referenceNum, "Reference Number");
		//type(Locators.email_mb, email, "Email");
		//Thread.sleep(5000);
		//type(Locators.sfpMoblie, mobile, "Mobile");
		type(Locators.lastName_mb, Lastname, "Last Name");
		click(Locators.findBookings,"Find Booking");	
		
	}
	

	public void searchFlightCheckin(String referenceNum, String Lastname) throws Throwable{
		waitForElementPresent(Locators.bookingReference, "CheckIn Reference");
		click(Locators.bookingReferencebtn, "Booking reference field");
		type(Locators.bookingReference, referenceNum, "Reference Number");
		click(Locators.lastName_CI_btn, "Booking reference field");
		type(Locators.lastName_CI, Lastname, "Lastname");
		click(Locators.Checkinbtn, "Check-in");	
	}
	
	public String changeDate(String referenceNum, String email, String mobile, String lastName, String newDate, 
			String selectSeat,String totalpassString ,String bookingclass,String bundle) throws Throwable{
		
		click(Locators.btnchngFlight, "Change Flight");
		List<WebElement> flighttochng = driver.findElements(Locators.flightToChange);
		for(int i=0;i<flighttochng.size();i++)
		{
			flighttochng.get(i).click();
		}
	//	click(Locators.flightToChange, "Select Flight");
		click(Locators.continuebtn, "Continue");
		select_date(newDate);
		click(Locators.selectDateButton_mb, "Select");
		Thread.sleep(6000);
		selectClass(bookingclass, bundle);
		Thread.sleep(5000);
		String newDateto=driver.findElement(By.xpath("")).getText();
		String Date[] = newDateto.split(",");
		String Datesplit[] = Date[1].split(" ");
		String newdate[] = newDate.split("-");
		if(Datesplit[1].contains(newdate[0]))
		{
			click(Locators.cnfmChanges, "Conform Changes");
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
		type(Locators.sfpbookingReference, referenceNum, "Reference Number");
		//type(Locators.sfpEmail, email, "Email");
		//type(Locators.sfpMoblie, mobile, "Mobile");
		type(Locators.sfpLastName, lastName, "Last Name");
		
		click(Locators.sfpChekin, "Check in");
	}*/
	
	
	public void performCheckin() throws Throwable
	{
		waitForElementPresent(Locators.passengers_incheckin, "Passenger In Checkin");
		List<WebElement> passengers_incheckin = driver.findElements(Locators.passengers_incheckin);
		for(int  i=0;i<passengers_incheckin.size();i++)
		{
			passengers_incheckin.get(i).click();
		}
		click(Locators.passengers_checkterms, "Terms And Conditions");
		click(Locators.continuebtn, "Continue");
	}

	public void Baggage(String bookingtype,String totalpass) throws Throwable
	{
		waitforElement(Locators.baggageTittle);
		int j=0;
		if(isElementPresent(Locators.baggageTittle)==true){
			click(Locators.baggageAddPlusButton, "Baggage");
			List<WebElement> bag1  = driver.findElements(Locators.baggagePlusButton);
			bag1.get(j).click();
			j=j+3;
			List<WebElement> updownBtn = driver.findElements(Locators.baggageAdddownButton);
			if(updownBtn.size()>1){
				for(int i=1;i<updownBtn.size()-1;i++)
				{
					updownBtn.get(i).click();
					bag1  = driver.findElements(Locators.baggagePlusButton);
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
		waitForElementPresent(Locators.checkinConformation, "Check-in Conformation");
		if(isElementPresent(Locators.checkinConformation,"Check-in Conformation"))
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
		//System.out.println(getText(Locators.summaryStatus,"Status"));
		if(Iosdriver.findElementByAccessibilityId(Locators.summaryStatus).getText().equalsIgnoreCase("Confirmed"))
		{
			Reporter.SuccessReport("Ticket Confirmation", "Ticket has booked with PNR" + pnr);
		}
		else
		{
			Reporter.failureReport("Ticket Conformation", "Ticket has not booked");
		}
		
	}
	
	public void validate_ticketStatus() throws Throwable
	{
		waitforElement(Locators.summaryRefNumber);
		System.out.println(driver.findElement(Locators.pnrStatus).getText());
		if(Iosdriver.findElementByAccessibilityId(Locators.summaryStatus).getText().equalsIgnoreCase("Confirmed"))
			{		
			System.out.println("Ticket has been booked");
			writingPNR("iOS",getText(Locators.summaryRefNumber, "PNR"));
			Reporter.SuccessReport("Ticket Confirmation", "Ticket has been booked with PNR:" + getText(Locators.summaryRefNumber, "PNR"));
		}
		else if(driver.findElement(Locators.pnrStatus).getText().equalsIgnoreCase("Hold"))
			{
				writingPNR("iOS","Hold");
				Reporter.SuccessReport("Ticket Confirmation", "Ticket is in hold status with PNR:" + getText(Locators.summaryRefNumber, "PNR"));
				
			}
		else if(driver.findElement(Locators.pnrStatus).getText().equalsIgnoreCase("Pending"))
		{
			writingPNR("iOS","Pending");	
			Reporter.SuccessReport("Ticket Confirmation", "Ticket is in Pending status with PNR:" + getText(Locators.summaryRefNumber, "PNR"));
				
		}
		else{
				writingPNR("iOS","Fail");
				Reporter.failureReport("Ticket Conformation", "Ticket could not be Booked");
				
			}
	}
	
	public void verifyPNRforSadad(String pnr) throws Throwable{
		
		if(Iosdriver.findElementByAccessibilityId(Locators.SadadStatus).getText().equalsIgnoreCase("Pending"))
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
		c.add(Calendar.DATE, Integer.parseInt(depdate[1])); // Adding no days as given to the calender 
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		return newDate;
	}
	
	public static String nextDateof(String date) throws ParseException{
		  String dt = date;  // Start date
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM yyyy");
		  Calendar c = Calendar.getInstance();
		  c.setTime(sdf.parse(dt));
		  c.add(Calendar.DATE,1);  // Adding 1 day to given date
		  dt = sdf.format(c.getTime());  // dt is now the new date
		  return dt;
		 }
	
	
	
	public void Select_Meal() throws Throwable
	{
		      //waitForElementPresent(Locators.mealTitle, "Meal");
				if(isElementDisplayedTemp(Locators.mealTitle)){
				swipeVertical(0.50f);
				List<WebElement>  MealExpButtons = driver.findElements(Locators.mealExpansionButton);
				//List<WebElement> MealsNames = driver.findElements(Locators.mealNames);
		
				for(int i=0;i<MealExpButtons.size();i++)
				{
					MealExpButtons.get(i).click();
					swipeVertical(0.50f);
					List<WebElement> icndelt = driver.findElements(Locators.mealcloseButton);
					for(int j=0;j<icndelt.size();i++){
						icndelt.get(j).click();
						List<WebElement> mealadd = driver.findElements(Locators.mealAddBtn);
						mealadd.get(j).click();
						List<WebElement> avaiMeal = driver.findElements(Locators.availableMeal);
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
				click(Locators.selectSeat_btn, "Select Seat");
			}else{
				System.out.println("Meal Not Available");
			}
	}
	
	public void Select_lounge() throws Throwable
	{
		if(isElementPresent(Locators.Loung)==true){
		List<WebElement> Loung = driver.findElements(Locators.Loung);
		
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
		//click(Locators.continueBtn, "Continue");
	}
	public  void cancelFlight(String referenceNum,String email,String mobile,String lastname) throws Throwable
	{
		
		waitForElementPresent(Locators.cancelflightBtn, "Cancel Flight");
		click(Locators.cancelflightBtn, "Cancel Flight");
		List<WebElement> flighttocancel = driver.findElements(Locators.flightToChange);
		for(int i=0;i<flighttocancel.size();i++)
		{
			flighttocancel.get(i).click();
		}
		//click(Locators.flightToChange, "Select Flight");
		click(Locators.continuebtn, "Continue");
		waitforElement(Locators.cnfmChanges);
		click(Locators.cnfmChanges, "Conform Changes");
		if(isElementDisplayedTemp(Locators.ok)==true)
		{
			click(Locators.ok, "Ok To Cancel Flight");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		
		
	}
	public void verifyConformcharges() throws Throwable
	{
		if(isElementPresent(Locators.confirmedAftercharges)==true)
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
//		List<WebElement>  Adults = driver.findElements(Locators.Adult_baggagae);
//		for(int i=0;i<Adults.size();i++)
//		{
//			String value=Adults.get(i).getText();
//			if(value.equalsIgnoreCase("Adult 1"))
//			{
//				Adults.get(i).click();
//				ImplicitWait();
//				List<WebElement>  Baggage_weight = driver.findElements(Locators.Baggage_weight);
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
//					List<WebElement>  Baggage_weight = driver.findElements(Locators.Baggage_weight);
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
		if(isElementPresent(Locators.Deny)==true)
		{
			click(Locators.Deny, "DENY");
		}
	}
	public void login(String email,String pwd) throws Throwable
	{ 	if(isElementPresent(Locators.Login_lnk)==false){
		click_mobile("btn menu","Menu icon");
		scrollJS(Locators.logout_lnk);
		click_mobile("Logout","Logout button");
		waitforElement(Locators.logo);
		}
		click_mobile("Login","Login link");
		type(Locators.email, email, "EmailAddress");
		type(Locators.pasword, pwd, "Password");
		click_mobile("Login","Login btn");
	}
	
	public void verifyCancel() throws Throwable
	{
		waitforElement(Locators.confirmCancel);
		if(getAttribute(Locators.confirmCancel, "value", "Conform Cancel").equalsIgnoreCase("Confirmed")){
			Reporter.SuccessReport("Verifing Flight Cancel", "Canceled");
		}else{
			Reporter.SuccessReport("Verifing Flight Cancel", "Not canceled");
		}
	}
	
	
	public  void cancelFlights(String Flightways) throws Throwable
	{ try{
		waitForElementPresent(Locators.cancelflightBtn, "Cancel Flight");		
		click(Locators.cancelflightBtn, "Cancel Flight");
		waitForElementPresent(Locators.flightToChange, "Select Flight");
		List<WebElement> Flightstocancel = driver.findElements(Locators.flightToChange);
		if (Flightways.equalsIgnoreCase("All"))
			for(int i=0;i<Flightstocancel.size();i++){
				Flightstocancel.get(i).click();
			}
		else if (Flightways.equalsIgnoreCase("Departing"))
			Flightstocancel.get(0).click();
		else if (Flightways.equalsIgnoreCase("Returning"))
			Flightstocancel.get(1).click();
		//click(Locators.flightToChange, "Select Flight");
		
		click(Locators.continuebtn, "Continue");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		click(Locators.ok, "ok");	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		Reporter.SuccessReport("Cancelling flight", "Flight cancelled");
		}catch (Exception e){
		Reporter.failureReport("Cancelling Flight", "Flight cancellation failed");
		}
	}
	
	public  void confirmChanges() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		scrollToElement(Locators.cnfmChanges);
		click(Locators.cnfmChanges, "Confirm");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		if(isElementPresent(Locators.ok)==true)
			{
			click(Locators.ok, "Creditsheel popup");
			Reporter.SuccessReport("Credit shell pop-up handled", "Crdit shell repayment popup ok button");
			}		
	}
	
	public void verifyConfirmchanges() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		if(isElementPresent(Locators.summaryRefNumber)==true)
		{
			Reporter.SuccessReport("Verifing status after clicking confirm changes", "Status: Confirmed");
		}
		else
		{
			Reporter.failureReport("Verifing staus after clicking confirm changes", "Staus : not confirmed");
		}
	}
	
	public void verifyConfirmcharges() throws Throwable
	{
		if(isElementPresent(Locators.confirmedAftercharges)==true)
		{
			Reporter.SuccessReport("Verifing Confirmed after clicking conform charges", "Successfully Verified");
		}
		else
		{
			Reporter.failureReport("Verifing Confirmed after clicking conform charges", "fail to verify");
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
	
//***********Common UI Actions	*********************
	
	public void navigatetoHmPg() throws Throwable{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		click(Locators.homebtn, "Home Img");
		}
	
	
	public void continueOnPsngrDtls() throws Throwable{
		waitforElement(Locators.passengertitle);
		scrollJS(Locators.selectExtras_btn);
		//click(Locators.selectExtras_btn, "Select Extras");
		click_mobile("Continue to Select Extras","Continue on Passengerdetails");
	}
	
	public void continueOnExtras() throws Throwable{
		Thread.sleep(10000);
		waitforElement(Locators.baggageTittle);
		if(isElementDisplayedTemp(Locators.baggageTittle)==true){
			scrollJS(Locators.selectSeat_btn);
			click_mobile("Continue to Select Seat","Continue on Extra");
		}
	}
	
	public void continueOnSeatSelection() throws Throwable{
		waitforElement(Locators.seatSelectionTittle);
		if(isElementDisplayedTemp(Locators.seatSelectionTittle)==true){
			//click(Locators.payment_btn, "Payment");
			click_mobile("Continue to Payment","Continue on Seat selection");
		}else{
			System.out.println("No Seat Available");
		}
	}
	
	public void cntinueOnTravelDocument() throws Throwable
	{
	waitForElementPresent(Locators.travelDocuments, "Travel Documents");
	click(Locators.continuebtn, "Continue");
	}

	public void cntinueRandomSeatSelection() throws Throwable
	{
	if(isElementDisplayedTemp(Locators.seatSelectionTittle)){
		waitForElementPresent(Locators.seatSelectionTittle, "Seat Selection");
		click(Locators.continuebtn, "Continue");
	}
	}

	public void confirmRandomSeatSelection() throws Throwable
	{
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	if(isElementDisplayedTemp(Locators.ok)){
		click(Locators.ok, "OK");}
	}
	
	public void verifyPNRinMMBList(String PNRnumber, boolean expected) throws Throwable{
		if(isElementPresent(Locators.MMB(PNRnumber))==expected){
			Reporter.SuccessReport("Verifying PNR in chekin List", "Pnr");
		}else{
			Reporter.failureReport("Verifying PNR in chekin List", "Pnr");
		}
	}
	
	public  void registeredUsrManageFlight(String PNRnumber) throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		scrollToText(PNRnumber);
		click(Locators.MMB(PNRnumber), "Manage");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public void verifyPNRinCheckinList(String PNRnumber, boolean expected) throws Throwable{
		if(isElementPresent(Locators.checkin(PNRnumber))==expected){
			Reporter.SuccessReport("Verifying PNR in chekin List", "Pnr");
		}else{
			Reporter.failureReport("Verifying PNR in chekin List", "Pnr");
		}
	}
	
	public  void registeredUsrCheckin(String PNRnumber) throws Throwable
	{
		
		waitForElementPresent(Locators.checkin_title, "Check-in title");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		if(isElementPresent(Locators.checkin(PNRnumber))==true){
			click(Locators.checkin(PNRnumber), "Checkin");
		}else{
			Reporter.failureReport("Click Check in", "PNR visibility");
		}
		
	}
	
	
	public void clickExtrasbtn(){
		
	}
	
	public void seatslctnBtn(){
		
	}
	
	
	
	public void writingPNR(String sheetname,String value)
	{
		ExcelReader xls = new ExcelReader(configProps.getProperty("OutputPnrs"),sheetname);
		int rownum = xls.getRowCount(sheetname);
		if(xls.getCellData(sheetname, "PNR", rownum)==null){
			xls.setCellData(sheetname, "PNR", rownum, value);
			xls.setCellData(sheetname, "TestCaseNum", rownum,Integer.toString(rownum));
			
		}else{
			xls.setCellData(sheetname, "PNR", rownum+1, value);
			xls.setCellData(sheetname, "TestCaseNum", rownum+1,testName);
		}
	}
	
	public static void writecredentials(String userID,String password,String firstname,String lastname, String doctype, String docnumber )
	{
		ExcelReader xls = new ExcelReader(configProps.getProperty("Credentialsdata"),"UserCredentials");
		int rownum = xls.getRowCount("UserCredentials");
		if(xls.getCellData("UserCredentials", "userid", rownum)==null){
			xls.setCellData("UserCredentials", "key", rownum, "credentials"+(rownum-1));
			xls.setCellData("UserCredentials", "userid", rownum, userID);
			xls.setCellData("UserCredentials", "password", rownum, password);
			xls.setCellData("UserCredentials", "firstname", rownum, firstname);
			xls.setCellData("UserCredentials", "lastname", rownum, lastname);
			xls.setCellData("UserCredentials", "Document Type", rownum, doctype);
			xls.setCellData("UserCredentials", "Document Number", rownum, docnumber);
		}else{
			xls.setCellData("UserCredentials", "key", rownum+1, "credentials"+(rownum));
			xls.setCellData("UserCredentials", "userid", rownum+1, userID);
			xls.setCellData("UserCredentials", "password", rownum+1, password);
			xls.setCellData("UserCredentials", "firstname", rownum+1, firstname);
			xls.setCellData("UserCredentials", "lastname", rownum+1, lastname);
			xls.setCellData("UserCredentials", "Document Type", rownum+1, doctype);
			xls.setCellData("UserCredentials", "Document Number", rownum+1, docnumber);
		}
	}
	
	public void verifyAnonymousCheckinFail() throws Throwable{
		if(isElementPresent(Locators.checkInFlight)==false){
			Reporter.SuccessReport("Verifing anonymous checkin failure", "Failure message");
		}else{
			Reporter.failureReport("Verifing anonymous checkin failure", "Failure message");
		}
	}
	
	public void verifingEcofarePrice(String bookingClass) throws Throwable{
		Thread.sleep(3000);
		@SuppressWarnings("unchecked")
		List<WebElement> ClassArrow = Iosdriver.findElementsByAccessibilityId(Locators.selectFlightUpDownArrow);
		
		for(int k=0;k<ClassArrow.size();k++){
			
			if(bookingClass.contains("Business")){
				if(isElementDisplayedTemp(Locators.busOW)==true){
					String fare= getText(Locators.bussPrice, "Business Price");
					click(Locators.busOW, "Business");
					waitforElement(Locators.cartSummaryBalance);
					String summaryfare= getText(Locators.cartSummaryBalance, "Cart Summary Balance");
					String totalfare = summaryfare.split("\\s+")[1];
					if(fare.equals(totalfare)){
						Reporter.SuccessReport("Verifing Business Fare", "Successfully Verified");
					}else{
						Reporter.failureReport("Verifing Business Fare", "Fares Are Not same");
					}
					click(Locators.tittleBack, "Tittle Back Button");
					
					break;
				}else{
					ClassArrow.get(k+1).click();
				}
			}
			if(bookingClass.contains("Simple")){
				if(isElementDisplayedTemp(Locators.simpleOW)==true){
					String fare= getText(Locators.econnmyPrice, "Economy Price");
					click(Locators.simpleOW, "Economy");
					waitforElement(Locators.cartSummaryBalance);
					String summaryfare= getText(Locators.cartSummaryBalance, "Cart Summary Balance");
					String totalfare = summaryfare.split("\\s+")[1];
					if(fare.equals(totalfare)){
						Reporter.SuccessReport("Verifing Economy Fare", "Successfully Verified");
					}else{
						Reporter.failureReport("Verifing Economy Fare", "Fares Are Not same");
					}
					click(Locators.tittleBack, "Tittle Back Button");
					break;
				}else{
					ClassArrow.get(k+1).click();
				}
			}
			if(bookingClass.contains("Extra")){
				if(isElementDisplayedTemp(Locators.extraOW)==true){
					String fare= getText(Locators.flexPrice, "Flex Price");
					click(Locators.extraOW, "Extra");
					waitforElement(Locators.cartSummaryBalance);
					String summaryfare= getText(Locators.cartSummaryBalance, "Cart Summary Balance");
					String totalfare = summaryfare.split("\\s+")[1];
					if(fare.equals(totalfare)){
						Reporter.SuccessReport("Verifing Flex Fare", "Successfully Verified");
					}else{
						Reporter.failureReport("Verifing Flex Fare", "Fares Are Not same");
					}
					click(Locators.tittleBack, "Tittle Back Button");
					break;
				}else{
					ClassArrow.get(k+1).click();
				}
			}
			}
	}
	
	
	
}

