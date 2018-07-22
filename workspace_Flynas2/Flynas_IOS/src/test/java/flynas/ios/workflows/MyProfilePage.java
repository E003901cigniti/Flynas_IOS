package flynas.ios.workflows;

import java.util.concurrent.TimeUnit;

import com.ctaf.support.ExcelReader;
import com.ctaf.utilities.Reporter;

import flynas.ios.testObjects.*;

public class MyProfilePage extends Locators{
	
	public void waitforpageload() throws InterruptedException{	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		}
	
	public void updatePswd(String crntPswd, String newPswd) throws Throwable {
		ExcelReader xls = new ExcelReader(configProps.getProperty("Credentialsdata"),"ChangepswdUser");

		waitforpageload();
		try{
			type(Locators.crntpswd, crntPswd, "Current Password");
			type(Locators.newpswd, newPswd," New Password");
			click(Locators.prflupdtbtn(1),"Profile Update Btn");
			xls.setCellData("ChangepswdUser", "password", 1, newPswd);
			Reporter.SuccessReport("Modifying mobile number :", "Mobile number updated Successfully");
		}catch(Exception e){
			Reporter.failureReport("Modifying mobile number :", "Mobile number update failed");
		}
		
	}
	
	public void updateMobilenum() throws Throwable {
		waitforpageload();
		try{
			type(Locators.prflmobile, randomNumericString(10), "MobileNumber");
			click(Locators.prflupdtbtn(2),"Mobile Update Btn");
			Reporter.SuccessReport("Modifying mobile number :", "Mobile number updated Successfully");
		}catch(Exception e){
			Reporter.failureReport("Modifying mobile number :", "Mobile number update failed");
		}
		
	}
	
	
}
