package com.xyz.hrms.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.xyz.hrms.Base.BaseClass;
import com.xyz.hrms.Base.PageIntializer;
import com.xyz.hrms.pages.LoginPageElements;
import com.xyz.hrms.utils.CommonMethods;

public class Test_001 extends PageIntializer {
	
	@Test
	public void Validlogin() {
		BaseClass.setUp();
		CommonMethods.sendText(loginpage.username,"admin");
		CommonMethods.sendText(loginpage.password,"admin123");
		CommonMethods.sendText(loginpage.username,"admin");
		
		loginpage.loginbutton.click();
		String actualTitle=BaseClass.driver.getTitle();
		String expectedTitle="OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle,"title did not matched");
		
	}
	
	@Test
	public void inValidUsername() {
		BaseClass.setUp();
		
		loginpage.username.sendKeys("admin42433");
		loginpage.password.sendKeys("admin123");
		loginpage.loginbutton.click();
		String actualErrorMessage=loginpage.errorMessage.getText();
		String expectedErrorMessage="Invalid credentials";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"error message did not matched");
		
	}
	
	@Test
	public void inValidpassword() {
		BaseClass.setUp();
		
		loginpage.username.sendKeys("admin");
		loginpage.password.sendKeys("admin123fasd");
		loginpage.loginbutton.click();
		String actualErrorMessage=loginpage.errorMessage.getText();
		String expectedErrorMessage="Invalid credentials";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"error message did not matched");
		
	}
	
	@Test
	public void invalidCerenditals() {
		BaseClass.setUp();
		
		loginpage.username.sendKeys("admin42433");
		loginpage.password.sendKeys("admin12352345");
		loginpage.loginbutton.click();
		String actualErrorMessage=loginpage.errorMessage.getText();
		String expectedErrorMessage="Invalid credentials";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"error message did not matched");
		
	}

}
