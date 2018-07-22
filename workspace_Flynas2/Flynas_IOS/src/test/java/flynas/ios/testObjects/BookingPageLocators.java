package flynas.ios.testObjects;

import org.openqa.selenium.By;

import com.ctaf.accelerators.ActionEngine;

public class BookingPageLocators extends ActionEngine{
	
	//Common
	public static By loadingBar = By.xpath("//div[@class='loading sk-wave']");
	public static By continuebtn = By.xpath("//*[@label='Continue']");
	public static By Deny = By.xpath("");
	public static By tittleBack = By.xpath("//XCUIElementTypeButton[@name='btn back']");
	
	public static By  elmWithText(String lable){
		return By.xpath("//*[@text='"+lable+"']");
	}
	
	//home page
	public static By logo = By.xpath("//XCUIElementTypeImage[@name='logo-flynas']");
	public static By menu = By.xpath("//XCUIElementTypeOther/*[@label='btn menu']");
	public static By login_lnk = By.xpath("//XCUIElementTypeButton[@name='Login']");
	public static By logout_lnk = By.xpath("//XCUIElementTypeButton[@name='Logout']");
	public static By email  = By.xpath("//*[@value='Email']");
	public static By password  = By.xpath("//*[@value='Password']");
	public static By login_btn = By.xpath("//*[@label='Login']");
	public static By tittleHome = By.xpath("//*[@label='icn home']");

	
	//booking page
	public static String bookflights = "Book";
	public static String Check ="Check-in";
	public static String MMB = "Manage";
	public static String homeicn = "Offers";
	public static String brdngPsIcn	 = "Boarding Passes";
	public static By homebtn = By.xpath("//XCUIElementTypeStaticText[@name='Offers']/../XCUIElementTypeButton");
	public static By bookbtn = By.xpath("//XCUIElementTypeStaticText[@name='Book']/../XCUIElementTypeButton");
	public static By managebtn = By.xpath("//XCUIElementTypeStaticText[@name='Manage']/../XCUIElementTypeButton");
	public static By checkinbtn = By.xpath("//XCUIElementTypeStaticText[@name='Check-in']/../XCUIElementTypeButton");
	public static By brdngPsbtn = By.xpath("//XCUIElementTypeStaticText[@name='Boarding Passes']/../XCUIElementTypeButton");
	
	public static String roundTrip = "Return";
	public static String oneWay = "One-way";
	public static By OWbtn = By.xpath("//*[@label='One-way']");
	public static By multiCity = By.xpath("//*[@label='Multi-City']");
	
	public static By bookingpageorigin = By.xpath("//div[@name='origin']/div[@placeholder='Origin']/span[@tabindex='-1']");
	public static By bookingpagetxtorigin = By.xpath("//div[@name='origin']/input[@placeholder='Origin']");
	public static By bookingpageDestination = By.xpath("//div[@name='destination']/div[@placeholder='Destination']/span[@tabindex='-1']");
	public static By bookingpagetxtDestination = By.xpath("//div[@name='destination']/input[@placeholder='Destination']");

	public static By origin = By.xpath("/XCUIElementTypeStaticText[@name='Origin']");
	

	public static String search = "Search";
	public static By searchEdit = By.xpath("//*[@label='Search']");
	public static String searched_city = "#";

	public static By Departuredate = By.xpath("//XCUIElementTypeStaticText[@name='Departure Date']/../XCUIElementTypeButton");
	
	public static String Departuredate_rtp = "Departure Date";
	public static By Select_date = By.xpath("//*[@label='Select']");
	
	public static By origin_multicity = By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther[4]/XCUIElementTypeButton");
	
	public static String passengerCount = "Passengers";
	
	public static By Audaltplusbutton = By.xpath("//*[@label='Adult']/following::XCUIElementTypeButton[2]");
	public static By childplusbutton = By.xpath("//*[@label='Child']/following::XCUIElementTypeButton[2]");
	public static By infantplusbutton = By.xpath("//*[@label='Infant']/following::XCUIElementTypeButton[2]");
	
	public static By smilePointsbtn = By.xpath("");
	
	public static String findFlights = "Find Flights";
	
	public static By Currency = By.xpath("//*[@resource-id='com.flynas.android.app:id/searchFlightCurrency']");
	public static By currencytype(String Currency) {
		return By.xpath("//*[@text='"+Currency+"']");
	}

	//Passenger details
	
	public static By title = By.xpath("//*[@label='Title*']/following-sibling::XCUIElementTypeButton[1]");
	public static By passengertitle = By.xpath("//XCUIElementTypeStaticText[@label='Passenger details']");
	public static By fName = By.xpath("//*[@label='First Name*']/following-sibling:: XCUIElementTypeTextField[1]");
	public static By lName = By.xpath("//*[@label='Last Name*']/following-sibling:: XCUIElementTypeTextField[4]");	
	public static By dateofbirth = By.xpath("//*[@label='Date of birth*']/following-sibling:: XCUIElementTypeButton[2]");	
	public static By selectdate = By.xpath("");

	
	public static By documenttype = By.xpath("//*[@label='Document Type*']/following-sibling::XCUIElementTypeButton[3]");
	public static By idnumber = By.xpath("//*[@label='ID Number*']/following-sibling::XCUIElementTypeTextField[3]");
	public static By idexpdate = By.xpath("//*[@label='ID Expiry Date*']/following-sibling::XCUIElementTypeButton[4]");
	public static By smily = By.xpath("//*[@label='Please enter your naSmiles number below']/following-sibling::XCUIElementTypeTextField[2]");
	public static By mobilenum = By.xpath("//*[@label='Mobile Number*']/following-sibling::XCUIElementTypeTextField[1]");
	public static By emailAddress = By.xpath("//*[@label='Email Address*']/following-sibling::XCUIElementTypeTextField");
	public static By cnfmemail = By.xpath("//*[@resource-id='com.flynas.android.app:id/contactDetailsEmailConfirm']");
	public static By baggageTittle = By.xpath("//XCUIElementTypeStaticText[@label='Select your extras']");
	public static By selectExtras_btn = By.xpath("//*[@label='Continue to Select Extras']");
	
	public static By selectSeat_btn= By.xpath("//*[@label='Continue to Select Seat']");
	public static By payment_btn =By.xpath("//*[@label='Continue to Payment']");
	public static String Purchase = "Purchase";
	public static By seatSelectionTittle = By.xpath("//XCUIElementTypeStaticText[@label='Select your seat']");

	public static By seatplusbutton = By.xpath("//*[@label='icn add']");

	public static By  ExtraLegSeats =By.xpath("//XCUIElementTypeCell[1]/ XCUIElementTypeButton");
	public static By ExtraSeats = By.xpath("//*[@resource-id='com.flynas.android.app:id/select_seat_column6_image']");
	public static By businessSeats = By.xpath("//XCUIElementTypeCell/ XCUIElementTypeButton");
	public static By seatSelectLeftButton =By.xpath("//*[@resource-id='com.flynas.android.app:id/titleBack']");
	public static By Seating = By.xpath("//*[@resource-id='com.flynas.android.app:id/title']");

	public static String Submit = "Submit";
	public static By confirmation_Status = By.xpath("//*[@resource-id='com.flynas.android.app:id/confirmationStatus']");
	public static By confirmation_PNR  = By.xpath("//*[@resource-id='com.flynas.android.app:id/confirmationPNR']");

	
	//Baggage
	
	public static By baggageAddPlusButton = By.xpath("//*[@label='Add check-in baggage']/following-sibling::XCUIElementTypeButton");
	public static By baggagePlusButton = By.xpath("//*[@label='icn add']");
	public static By baggageAdddownButton = By.xpath("//XCUIElementTypeStaticText[@label='Add check-in baggage']/following::XCUIElementTypeCell/XCUIElementTypeButton[1]");
	
	
	public static By txtorigin = By.xpath("//input[@placeholde='Origin' and @aria-owns = 'ui-select-choices-0']");
	public static By selectOrigin = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div/div/div/ul/li//descendant::div[@class='ui-select-choices-row']");	
	public static By secOrigin = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div[4]/div/div/div/div/div");
	public static By selectSecOrigin = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div[4]/div/div/div/div/ul/li//descendant::div[@class='ui-select-choices-row']");
	public static By secDest = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div[4]/div/div[2]/div/div/div");
	public static By selectSecDest = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div[4]/div/div[2]/div/div/ul/li//descendant::div[@class='ui-select-choices-row']");
	public static By dest = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div[2]/div");
	public static By selectDest = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div[2]/div/div/ul/li//descendant::div[@class='ui-select-choices-row']");
	public static By dpDate = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div[3]/div");
	public static String selectDate = "//div[@class='input-group datepicker']/ul/li/div/table";
	public static By rtDate = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[2]/div[5]/div");
	public static By selectRTDate = By.xpath("");
	public static By adult = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[3]/div/div");
	public static By selectAdult = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[3]/div/div/div/ul/li//descendant::div[@class='ui-select-choices-row']");
	public static By child = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[3]/div/div[2]");
	public static By selectChild = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[3]/div/div[2]/div/ul/li//descendant::div[@class='ui-select-choices-row']");
	public static By infant = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[3]/div/div[3]");
	public static By selectInfant = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[3]/div/div[3]/div/ul/li//descendant::div[@class='ui-select-choices-row']");
	public static By promo = By.xpath("//div[@class='main_con']/div[2]//descendant::form/div[3]/div[2]/div[2]/input");
	
	
	
	
	//Class selection page
	public static By Slectflighttitle = By.xpath("//XCUIElementTypeStaticText[@label='Select your flight']");
	public static By FlightAcrdions = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell");
	public static By FlightAcrdion (int value) {
		return By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+value+"]/XCUIElementTypeButton[2]");
	}
	
	public static By bookingclass(String bookingclass) {
		return By.xpath("");}
	
	
	public static By simpleOW = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeButton[2]");
	public static By extraOW = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeButton[4]");
	public static By busOW = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeButton[6]");
	
	public static By simpleOW(int value) {
		return By.xpath("//XCUIElementTypeCell["+value+"]/XCUIElementTypeButton[2]");
	}
	public static By extraOW(int value){
		return By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+value+"]/XCUIElementTypeButton[4]");
	}
	public static By busOW(int value){
		return By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+value+"]/XCUIElementTypeButton[6]");
	}
	public static By busOW(int value,String rtclas){
		return By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+value+"]/XCUIElementTypeButton[21]");
	}
		
	public static String classbtnsofcell(int value) {
			return ("//XCUIElementTypeTable/XCUIElementTypeCell["+value+"]/XCUIElementTypeButton");		
		}	
	
	public static String rtClassStr= "//div[@class='main_con']/div/div/div[2]/div/flight-select/div/form/div[2]//descendant::table/tbody/tr";
	public static By rtClass = By.xpath("//div[@class='main_con']/div/div/div[2]/div/flight-select/div/form/div[2]//descendant::table/tbody/tr");
	public static By okBtn = By.xpath("//div[@class='modal-dialog']/div/div[3]/button[@class='btn btn-primary']");
	public static By cancelBtn = By.xpath("//div[@class='modal-dialog']/div/div[3]/button[@class='btn btn-warning']");
	public static String selectFlightUpDownArrow = "icn arrow down red";
	public static By flightNumber = By.xpath("//*[@resource-id='com.flynas.android.app:id/select_flight_extra_ticket_number']");
	public static By upArrow = By.xpath("//*[@label='icn arrow up red']");
	public static By rightarrow = By.xpath("//*[@label='icn arrow right red']");
	public static By econnmyPrice = By.xpath("");
	public static By flexPrice = By.xpath("");
	public static By bussPrice = By.xpath("");
	public static By cartSummaryBalance = By.xpath("");
	
	
	
	//Input Passenger Details
	public static String passType = "//div[@class='pass_tab']/div[#]/h3";
	public static String titleSelect = "//div[@class='pass_tab']/div[#]/div/ng-form//descendant::div[@class='dropdowntitlecon']/div/ul/li//descendant::div[@class='ui-select-choices-row']";
	
	public static String dd = "//div[@class='pass_tab']/div[#]//descendant::div[@class='dob_con dob_conday']";
	public static String selectDD = "//div[@class='pass_tab']/div[#]//descendant::div[@class='dob_con dob_conday']/div/ul/li//descendant::div[@class='ui-select-choices-row'][";
	public static String mm = "//div[@class='pass_tab']/div[#]//descendant::div[@class='dob_con dob_conmonth']";
	public static String selectMM = "//div[@class='pass_tab']/div[#]//descendant::div[@class='dob_con dob_conmonth']/div/ul/li//descendant::div[@class='ui-select-choices-row'][";
	public static String yyyy = "//div[@class='pass_tab']/div[#]//descendant::div[@class='dob_conyear']";
	public static String selectYYYY = "//div[@class='pass_tab']/div[#]//descendant::div[@class='dob_conyear']/div/ul/li//descendant::div[@class='ui-select-choices-row'][";
	public static String selectyyinfant = "//div[@class='pass_tab']/div[#]//descendant::div[@class='dob_conyear']/div/ul/li/div[contains(@class,'ui-select-choices-row')]";
	public static String nation = "//div[@class='pass_tab']/div[#]//descendant::div[@class='nationdropdown']";
	public static String selectNation = "//div[@class='pass_tab']/div[#]//descendant::div[@class='nationdropdown']/div/ul/li//descendant::div[@class='ui-select-choices-row']";
	
	//public static By travelDoc = By.xpath("//div[@class='traveldocdropdown']/div/div/span/span[2]/span");
	public static String travelDoc = "//booking-passengers/div/ng-form/div/div[#]/div/ng-form/div/div[2]/div[1]/div/div/div/span/span[2]/span";
	//public static By selecttravelDoc = By.xpath("//div[@class='traveldocdropdown']/div/ul/li//descendant::div[@class='ui-select-choices-row']");
	//public static String selecttravelDoc = "//booking-passengers/div/ng-form/div/div[#]/div/ng-form/div/div[2]/div[2]/input";
	public static String inputDoc = "//booking-passengers/div/ng-form/div/div[#]/div/ng-form/div/div[2]/div[2]/input";
	//public static By naSmiles = By.xpath("//input[@name='asiamiles']");
	public static String naSmiles = "//booking-passengers/div/ng-form/div/div[#]/div/ng-form/div/div[2]/div[*]/div/input";
	
	public static String ppNumber= "/html/body/div[1]/div/div/div[2]/div/passengers-contacts/div/form/booking-passengers/div/ng-form/div/div[#]/div/ng-form/div/div[2]/div[3]/input";
	public static String ppExpDD= "/html/body/div[1]/div/div/div[2]/div/passengers-contacts/div/form/booking-passengers/div/ng-form/div/div[#]/div/ng-form/div/div[2]/div[4]/div[1]/div/div/span/span[1]";	
	public static String ppExpMM = "/html/body/div[1]/div/div/div[2]/div/passengers-contacts/div/form/booking-passengers/div/ng-form/div/div[#]/div/ng-form/div/div[2]/div[4]/div[2]/div/div/span/span[1]";
	public static String ppExpYY = "/html/body/div[1]/div/div/div[2]/div/passengers-contacts/div/form/booking-passengers/div/ng-form/div/div[#]/div/ng-form/div/div[2]/div[4]/div[3]/div/div/span/span[1]";
	public static String ppSelectDD = "//ul/li/descendant::div[@class='ui-select-choices-row'][";
	
	
	public static By countryCode = By.xpath("//div[@placeholder='Country code*']");
	public static By selectCountCode = By.xpath("//div[@name='countrycode']/ul/li//descendant::div[@class='ui-select-choices-row']"); 
	public static By mobileNum = By.xpath("//input[@name='mobilenum']");
	public static By emailAdd = By.xpath("//input[@name='emailaddress']");
	
	//Extras
	//public static By selectCharity = By.xpath("//span[@tabindex='-1']");
	public static By selectCharity = By.xpath("//i[@class='caret pull-right']");
	public static By charitydisable = By.xpath("//label[contains(text(),'Amount options')]/following::div[2]");
	
	
	
	//Seat Selection
	public static By seatSelecttionTittle = By.xpath("");
	public static By selbusSeat = By.xpath("//div[@class='seatmap']/div/div//descendant::div[@class='seatimg type1']");
	public static By selExLegSeat = By.xpath("//div[@class='seatmap']/div/div//descendant::div[@class='seatimg type2']");
	public static By selPremSeat = By.xpath("//div[@class='seatmap']/div[2]/div//descendant::div[@class='seatimg type3']");
	public static By selUpfrontSeat = By.xpath("//div[@class='seatmap']/div[3]/div//descendant::div[@class='seatimg type4']");
	public static By selExLeg2Seat = By.xpath("//div[@class='seatmap']/div[4]/div//descendant::div[@class='seatimg type2']");
	public static By selStdSeat = By.xpath("//div[@class='seatmap']/div[5]/div//descendant::div[@class='seatimg type5']");
	public static By seatSelTabs = By.xpath("//div[@class='tabwrap']/ul/li");
	public static By  seatsofType(String seattype)
	{
		return By.xpath("");
	}
	
	
	//Payment Page
	public static By applepay = By.xpath("//*[@label='']");
	public static By otherpaymentoptions = By.xpath("//*[@label='Other payment options']/preceding-sibling::XCUIElementTypeButton");
	public static By Payment_title = By.xpath("//*[@label='Payment']");
	public static By paymentOptions = By.xpath("//div[@class='pass_tab']/div/div/ul/li");
	public static By paymentName = By.xpath("/a/div");
	public static By cardNumber = By.xpath("//*[@label='Card number']/following-sibling::XCUIElementTypeTextField");
	public static By cardName = By.xpath("//*[@label='Card holder name']/following-sibling::XCUIElementTypeTextField");
	public static By expdate = By.xpath("//*[@label='Expiry Date']/following-sibling::XCUIElementTypeTextField");
	public static By selectExpMonth = By.xpath("//div[@class='pass_tab']//descendant::div[@name='expMonth']/ul/li//descendant::div[@class='ui-select-choices-row']");
	public static By expYear = By.xpath("//div[@class='pass_tab']//descendant::div[@name='expYear']");
	public static By selectExpYear = By.xpath("//div[@class='pass_tab']//descendant::div[@name='expYear']/ul/li//descendant::div[@class='ui-select-choices-row']");
	public static By cvvNum = By.xpath("//*[@label='CW2/CVV Number']/following-sibling::XCUIElementTypeTextField");
	public static By ccCheckbox = By.xpath("//input[@type='checkbox']");
	public static By voucherNum = By.xpath("//voucher[@form='paymentForm']/div/div/input");
	public static By retrieveVoucher = By.xpath("//voucher[@form='paymentForm']//descendant::button[@class='btn btn-primary']");
	public static By tabCreditCard = By.xpath("//a/div[text()='Credit Card']");
	public static By tabNasCredit = By.xpath("");
	public static By tabSadad = By.xpath("//*[@label='SADAD']");
	public static By creditShellAmount = By.xpath("//*[@resource-id='com.flynas.android.app:id/creditShellAmount']");
	public static By tabNaSmiles = By.xpath("");
	public static By naSmileId = By.xpath("");
	public static By naSmilepwd = By.xpath("");
	public static By naSmileslogin = By.xpath("");
	public static By redeem = By.xpath("");
	
	public static By terms = By.xpath("//*[@label='I agree to the']/preceding-sibling::XCUIElementTypeButton[2]");
	public static By paswd_protect = By.xpath("//*[@label='Password:']/following::XCUIElementTypeOther[1]");
	public static By pnrstatus = By.xpath("");
//	public static By PNR = By.xpath("//*[@resource-id='com.flynas.android.app:id/confirmationStatus']");
	
	public static By loveFlynasApp = By.xpath("");
	public static By noThanks = By.xpath("");
	
	public static By txtPNR = By.xpath("//span[text()='PNR: ']");
	public static By sadadOP = By.xpath("//sadadop[@form='paymentForm']/div/div/div/input");
	public static By sadadEnter = By.xpath("//sadadop[@form='paymentForm']//descendant::button[@class='btn btn-primary']");
	public static By ccSubmit = By.xpath("//input[@name='UsernamePasswordEntry']");
	public static By paymentType = By.xpath("//div[@class='passblock']");
	public static By ipt_pnr  = By.xpath("//input[@name='pnr']");
	public static By Amount = By.xpath("//input[@name='creditFileAmount']");
	public static By Retrive = By.xpath("//button[contains(text(),'Continue')]");
	public static By creditbal = By.xpath("//div[@class='col-md-6'][1]/p");
	public static By pasword = By.xpath("//input[@type='password']");
	
	//Summary Page
	public static By summaryRefNumber = By.xpath("//XCUIElementTypeStaticText[@label='PNR:']/following-sibling::XCUIElementTypeStaticText[1]");
	public static String summaryStatus = "Confirmed";
	public static String SadadStatus = "PENDING";
	
	//Summary Page with Edit Flight
//	public static By summaryChangeFlight = By.xpath("//*[@resource-id='com.flynas.android.app:id/mmbChangeFlightBtn']");
	
	public static By summaryCancelFlight = By.xpath("//a[@class='btn btn-primary'][2]");
	public static By selectFlightstoCancel = By.xpath("//input[@name='cfcheckbox']");
	public static By cancelflightBtn = By.xpath("//*[@label='Cancel flight']");
	public static By conformCharges = By.xpath("//a[contains(text(),'Click here to confirm changes')]");
	public static By confirmedAftercharges = By.xpath("//b[contains(text(),'Confirmed')]");
	public static By confirmCancel = By.xpath("//*[@label='Departing Flight']/preceding::XCUIElementTypeOther[3]/following::XCUIElementTypeStaticText[20]");
	/*
	 * change flight elements 
	 */
	//Change Date
	public static By calender = By.xpath("//div[@class='padcon']");
	public static By btnchngFlight = By.xpath("//*[@label='Change flight']");
	public static By flightToChange = By.xpath("//*[@label='Select Flights']/following::XCUIElementTypeTable/XCUIElementTypeCell");
	public static By cnfmChanges = By.xpath("//*[@label='Confirm Changes']");
	
	
	public static By btnpopupchngFlight = By.xpath("//button[text()='Change flight']");
	public static By selflnextbutton = By.xpath("//a[@class='btn_next last']");
	public static By selfltxtNoFlight = By.xpath("//ng-form/div[3]/div[1]/div/div");
	public static By selflCurrentDate = By.xpath("//*[@id='select_departure']/div/ul/li[4]/a/span");
	public static By selflEcoFlight = By.xpath("//div[@class='btn_td col-xs-4']/"
			+ "button[@class = 'btn selectflightbtn col1']");			
	public static By selflightContinue = By.xpath("//button[text()='Continue']");
	public static By popupButtonOk = By.xpath("//button[@class='btn btn-primary']");
	public static By confirmmsg = By.xpath("//a[text()='Click here to confirm changes']");
	
	//Search Flight Page
	public static By sfpbookingReference = By.xpath("//input[@name='inputpnr']");
	public static By sfpEmail = By.xpath("//input[@name='inputemail']");
	public static By sfpMoblie = By.xpath("//input[@name='inputmobile']");
	public static By sfpLastName = By.xpath("//input[@name='inputlastname']");
	public static By sfpFindBooking = By.xpath("//span[text()='Find booking']");
	
	//Add extra
	
	public static By mealExpansionButton = By.xpath("//*[@label='Select your in-flight meals']/following-sibling::XCUIElementTypeButton");
	public static By mealcloseButton= By.xpath("//*[@label='icn delete']");
	public static By mealNames= By.xpath("//*[@label='Select your in-flight meals']/following::XCUIElementTypeOther[2]/following::XCUIElementTypeCell/XCUIElementTypeStaticText[2]");
	public static By availableMeal = By.xpath("//*[@label='Select your in-flight meals']/following::XCUIElementTypeCell[2]/XCUIElementTypeStaticText");
	public static By mealTitle = By.xpath("//*[@label='In-flight meals']");
	public static By mealAddBtn = By.xpath("//*[@label='Select your in-flight meals']/following::XCUIElementTypeButton[@label='icn add']");
	
	public static By Adult_baggagae = By.xpath("//h1[contains(text(),' Baggage')]/following-sibling::p/following::div[3]/ul/li/a");
	public static By inflightmeal = By.xpath("//h1[contains(text(),'In-flight meals')]/following-sibling::p/following::div[3]/ul/li/a");
	public static By selectedflightes = By.xpath("//h1[contains(text(),'In-flight meals')]/following::ul[2]/li/a");
	public static By meal = By.xpath("//th[contains(text(),'Meal')]");
	public static By select = By.xpath("//a[contains(text(),'Select')]");
	public static By Loung = By.xpath("//table[@class='table bloungetable']/tbody/tr[1]/td");
	public static By Selected_Flights = By.xpath("//div[@class='row baggage_row']");
	
	public static By Baggage_weight = By.xpath("//label[@name='baggage']");
	public static By important = By.xpath("//h3[contains(text(),'Important')]");
	
	
	//checkins
	public static By checkin_title = By.xpath("//*[@text='Check-in']");
	public static By bookingReference = By.xpath("//*[@value='Booking reference (PNR)']/following-sibling::XCUIElementTypeTextField");
	public static By lastName_CI = By.xpath("");
	
	public static By checkInFlight = By.xpath("");
	public static By passengers_incheckin = By.xpath("//XCUIElementTypeTable[2]//XCUIElementTypeButton");
	public static By checkinConformation = By.xpath("//*[@label='Check-in successful']");
	public static By passengers_checkterms = By.xpath("//*[@label='I agree to the Terms and Conditions.']/preceding-sibling::XCUIElementTypeButton");
	public static By travelDocuments = By.xpath("//*[@label='Travel documents']");
	public static By  checkin(String PNR){
		return By.xpath("//*[@label='"+value+"']/following-sibling::XCUIElementTypeButton");
		}
	
	/*public static By passengers_checkterms = By.xpath("//a[text()='Terms and conditions']/preceding-sibling::i/preceding-sibling::input");
	public static By checkinConformation = By.xpath("//p[(text()='Click below to view your boarding pass(es). You`ll also receive it in an email.')]");
	public static By sfpChekin = By.xpath("//button[text()='Check-in now']");
	*/
	
	
	//Manage my bookings
	public static By lastName_mb = By.xpath("");
	public static By email_mb = By.xpath("//*[@value='Email']/following-sibling::XCUIElementTypeTextField[1]");
	public static By selectDateButton_mb = By.xpath("");
	public static By pnr(String value){
		return By.xpath("//*[@label='"+value+"']");
	}
	public static By MMB(String value) {
		return By.xpath("//*[@label='"+value+"']/following-sibling::XCUIElementTypeButton");
	}
	public static By ok=By.xpath("//*[@label='OK']");
	
	public static By findBookings = By.xpath("//*[@label='Find booking' or @label='Check-in']");
	
}
