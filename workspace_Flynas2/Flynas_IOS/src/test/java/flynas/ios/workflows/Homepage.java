package flynas.ios.workflows;

import org.apache.commons.lang3.RandomStringUtils;

import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.*;

public class Homepage extends Locators{
	
	public void select_Bookflights(String userType) throws Throwable
	{
		try{
			Iosdriver.findElement(Locators.bookbtn).click();
			Reporter.SuccessReport("Clicking on Book Icon", "Book icon clicked successfully");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on Book Icon", "Failed to click on Book Icon");	
			}
		
	}
	
	public void select_Managebooking(String userType) throws Throwable
	{
		try{
			Iosdriver.findElement(Locators.managebtn).click();
			Reporter.SuccessReport("Clicking on Manage Icon", "Manage icon clicked successfully");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on Manage Icon", "Failed to click on Manage Icon");	
			}
		
	}
	
	public void select_OnlineCheckIn(String userType) throws Throwable
	{
		try{
			Iosdriver.findElement(Locators.checkinbtn).click();
			Reporter.SuccessReport("Clicking on CheckIn Icon", "Chekin icon Cicked successfuly");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on CheckIn Icon", "Failed to click on Checkin Icon");	
			}
			
	}
	
	public void select_Boardingpasses(String userType) throws Throwable
	{
		try{
			Iosdriver.findElement(Locators.brdngPsbtn).click();
			Reporter.SuccessReport("Clicking on Boarding Passes Icon", "Boarding Passes icon Cicked successfuly");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on Boarding Passes Icon", "Failed to click on Boarding Passes Icon");	
			}
	}
	
	public void select_HomeOffers(String userType) throws Throwable
	{
		Iosdriver.findElement(Locators.homebtn).click();
		try{
			Iosdriver.findElement(Locators.homebtn).click();
			Reporter.SuccessReport("Clicking on home Icon", "home icon Cicked successfuly");
			}
			catch(Exception e){
			Reporter.failureReport("Clicking on home Icon", "Failed to click on home Icon");	
			}
	}
	
	
	public void select_TittleMenu() throws Throwable
	{
		click(Locators.menuIcn, "TittleMenu");
	}
	
	public void Click_login() throws Throwable
	{
		click_mobile("Login","Login link");
	}
	
	
	public void Login(String email,String pwd) throws Throwable
	{ 	Thread.sleep(8000);
		if(isElementPresent(Locators.Login_lnk)==false)
		{
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
	
	public void Click_myProfile() throws Throwable
	{
		waitforElement(Locators.myProfile_lnk);
		click(Locators.myProfile_lnk, "My Profile link");
	}
	
	public void Click_logout() throws Throwable
	{
		click_mobile("Logout","Logout button");
	}
	
	public void Click_Register() throws Throwable {
		waitForElementPresent(Locators.register, "Register");
		click(Locators.register, "Register");
	}
	
	public void  lockAccount(String username) throws Throwable
	{
		try{
		String password = RandomStringUtils.random(8, true, true);
	
		for(int i=0;i<=10;i++){
			type(Locators.email, username, "Email");
			type(Locators.pasword, password, "Password");
			click(Locators.Login_lnk, "Login");
			//if(i!=10)
			//verifyAlertPopup();
			}
			Reporter.SuccessReport("Lock account", "Lock account Successful");
		}catch(Exception e){
			Reporter.SuccessReport("Lock account", "Lock account Unsuccessful");
		}
					
	}
	
	public void verifyLoginSuccess(boolean expected) throws Throwable{
		if(isElementPresent(Locators.logo)==expected)
		Reporter.SuccessReport("verify Login", " login "+expected+" Successfull");
		else
			Reporter.failureReport("verify Login", " login "+expected+" failed");
	}
	
	public void click_Settings() throws Throwable {
		waitForElementPresent(Locators.settingsIcn, "Login");
		click(Locators.settingsIcn, "Settings Icon");
	}
	
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

}
