package flynas.ios.uat.reg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;



import flynas.ios.workflows.*;

public class TC01_f_UpdatePasswordInProfile extends BookingPageFlow{
	ExcelReader xls = new ExcelReader(configProps.getProperty("Credentialsdata"),"ChangepswdUser");
	
	@Test(dataProvider = "testData",groups={"ios"})
	public  void TC_01_f_UpdatePasswordInProfile(String username,String crntPswd,String Description) throws Throwable {
		try {
			
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, Description);
			//instantiating page objects
			System.out.println(username);
			System.out.println(crntPswd);
			String newPswd = randomString(10);
			
			Homepage homepage = new Homepage();
			MyProfilePage profilePage = new MyProfilePage();
			
		
			homepage.Login(username, crntPswd);		
			homepage.Click_myProfile();
			profilePage.updatePswd(crntPswd,newPswd);
			homepage.select_TittleMenu();
			homepage.Click_logout();
			homepage.select_TittleMenu();
			homepage.Click_login();
			homepage.Login(username, newPswd);
			
						
			Reporter.SuccessReport("TC01_a_memberRegistration", "Pass");
			
			}
		
	catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("TC01_a_memberRegistration", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{	
	    			xls.getCellValue("credentials1", "userid"),
	    			xls.getCellValue("credentials1", "password"),
	    			"Validate Member Login"}};
	}

}
