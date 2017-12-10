package flynas.web.workflows;

import java.util.Arrays;

import com.ctaf.utilities.Reporter;

import flynas.web.testObjects.BookingPageLocators;

public class projectUtilities<RenderedWebElement> extends BookingPageLocators {
	
	public void waitforpageload() throws InterruptedException{
		waitUtilElementhasAttribute(BookingPageLocators.body);	
	}
	
	public void clickLogin() throws Throwable{
		waitforpageload();
		click(BookingPageLocators.login_lnk, "Login");
	}
	
	public void logout() throws Throwable{
		waitforpageload();
		click(BookingPageLocators.logout_lnk, "Logout");
	}
	
	public void clickok() throws Throwable{
		waitforpageload();
		click(BookingPageLocators.ok, "ok");
	}
	
	public boolean compareArrays(String[] Arr1, String[] Arr2) throws Throwable{
		boolean flag = false;
		try{
			 if (Arrays.equals(Arr1, Arr2)){
		            System.out.println("Same");
		            flag = true;
		            System.out.println(Arr1+"and"+Arr2+" are equal");
			 	}else{
			 		System.out.println(Arr1+"and"+Arr2+" are not equal");
			 	}
			 return flag;
		}catch (Exception e){
			Reporter.failureReport("Comparing"+"Arr1"+"Arr2", "Exception while comparing"+"Arr1"+"Arr2");
			return flag;				
		}
		
	}
	
	public void verifyDateupdate(String lable, String[] firstDate, String[] updatedDate) throws Throwable{
		waitforpageload();
		if(compareArrays(firstDate,updatedDate)==false){
			Reporter.SuccessReport("Verifing if Date is Updated :", lable+" Updated Successfully ");
		}else{
			Reporter.failureReport("Verifing if Date is Updated :", lable+" Updated UnSuccessfull ");
		}
	}
	
	public boolean compareStrings(String String1, String String2) throws Throwable{
		boolean flag = false;
		try{
			 if (String1.equalsIgnoreCase(String2)){
		            flag = true;
		            System.out.println(String1+"and"+String2+" are equal");
			 	}else{
			 		System.out.println(String1+"and"+String1+" are not equal");
			 	}
			 return flag;
		}catch (Exception e){
			Reporter.failureReport("Comparing"+"Arr1"+"Arr2", "Exception while comparing"+"Arr1"+"Arr2");
			return flag;				
		}
		
	}
	
	public void verifytextupdate(String lable, String text1, String text2) throws Throwable{
		waitforpageload();
		System.out.println("comparing string :" +text1+","+text2);
		if(compareStrings(text1,text2)==false){
			Reporter.SuccessReport("Verifing if text is Updated :", lable+" Updated Successfully ");
		}else{
			Reporter.failureReport("Verifing if text is Updated :", lable+" Update UnSuccessfull ");
		}
	}
	
	public void verifyAlertPopup() throws Throwable
	{
		waitUtilElementhasAttribute(BookingPageLocators.body);
		if(isElementDisplayedTemp(BookingPageLocators.Error)==true){
			click(BookingPageLocators.ok, "OK");
			Reporter.SuccessReport("Validating if failure message", "Failure message displayed");		
		}
		else{
			Reporter.failureReport("Validating if failure message", "Failure message is not displayed");					
		}
	}
	
	public void VerifyAlertmessage(String Text) throws Throwable
	{
		waitUtilElementhasAttribute(BookingPageLocators.body);
		if(isElementDisplayedTemp(BookingPageLocators.Error)==true){
			if(getText(BookingPageLocators.alertText, "Alert message").contains(Text));
			
			Reporter.SuccessReport("Validating if failure message", Text+" message displayed");		
		}
		else{
			Reporter.failureReport("Validating if failure message", Text+ "message is not displayed");					
		}
	}


}
