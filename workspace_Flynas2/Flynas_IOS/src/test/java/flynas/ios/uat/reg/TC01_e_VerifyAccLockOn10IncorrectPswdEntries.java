package flynas.ios.uat.reg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;


import flynas.ios.workflows.*;

public class TC01_e_VerifyAccLockOn10IncorrectPswdEntries extends BookingPageFlow{
	
	@Test(dataProvider = "testData",groups={"ios"})
	public  void TC_01_e_VerifyAccLockOn10IncorrectPswdEntries(String Description) throws Throwable {
		try {
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			
			Homepage homepage = new Homepage();
			
			homepage.select_TittleMenu();
			homepage.Click_Register();
			RegistrationPage RegisterPg = new RegistrationPage();
			String username = RegisterPg.register("","Adult"); // Registering a new Adult member
			
			//Loging out
			homepage.select_TittleMenu();
  			homepage.Click_logout();
  			homepage.select_TittleMenu();
			homepage.Click_login();
  			homepage.lockAccount(username);
  			
  			homepage.Login(username, "Test@123");
  			homepage.verifyLoginSuccess(false);
						
			Reporter.SuccessReport("TC01_e_VerifyAccLockOn10IncorrectPswdEntries", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.SuccessReport("TC01_e_VerifyAccLockOn10IncorrectPswdEntries", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{"Verifying Account lock after ten incorrect password entries"}};
	}

}
