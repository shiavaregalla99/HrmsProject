package com.xyz.hrms.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xyz.hrms.Base.BaseClass;
import com.xyz.hrms.Base.PageIntializer;
import com.xyz.hrms.utils.CommonMethods;
import com.xyz.hrms.utils.Constants;
import com.xyz.hrms.utils.ExcelUtility;

public class DatadrivenTesting extends CommonMethods{

	
	@Test(dataProvider="TestData")
	public void invalidCerenditals(String Username,String Password,String ErrorMessage) {
		
		
		loginpage.username.sendKeys(Username);
		loginpage.password.sendKeys(Password);
		loginpage.loginbutton.click();
		String actualErrorMessage=loginpage.errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, ErrorMessage,"error message did not matched");
		BaseClass.tearDown();
	}
	
	@DataProvider(name="TestData")
	public Object[][] LoginData(){
		return ExcelUtility.excelData(Constants.Excel_Path, "LoginData");
	}
}
