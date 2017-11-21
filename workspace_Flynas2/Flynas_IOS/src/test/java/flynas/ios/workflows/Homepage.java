package flynas.ios.workflows;

import flynas.ios.testObjects.Locators;

public class Homepage extends Locators{
	
	public void select_Bookflights() throws Throwable
	{
		click(Locators.bookFlights, "Book flights");
	}
	public void select_Managebooking() throws Throwable
	{
		click(Locators.manageBookings, "Manage Bookings");
	}
	public void select_OnlineCheckIn() throws Throwable
	{
		click(Locators.onlineCheckin, "Online Check-in");
	}
	public void select_TittleMenu() throws Throwable
	{
		click(Locators.tittleMenu, "TittleMenu");
	}
	public void Click_login() throws Throwable
	{
		click(Locators.login, "Login");
	}
	public void Login(String username,String pwd) throws Throwable
	{
		type(Locators.email, username, "Email");
		type(Locators.pasword, pwd, "Password");
		click(Locators.Login_btn, "Login");
		
	}
	public void Click_logout() throws Throwable
	{
		click(Locators.logout_btn, "Logout");
	}

}
