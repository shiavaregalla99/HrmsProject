package com.xyz.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.hrms.Base.BaseClass;
import com.xyz.hrms.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {
	
	//page object model without page factory
// WebElement username= driver.findElement(By.id("txtUsername"));
// WebElement password= driver.findElement(By.id("txtPassword"));
 
 //page object model with page factory
 
 @FindBy(id="txtUsername")
 public WebElement username;
 @FindBy(id="txtPassword")
 public WebElement password;
 @FindBy(xpath="//input[@type='submit']")
 public WebElement loginbutton;
 @FindBy(id="spanMessage")
 public WebElement errorMessage;
 
public LoginPageElements() {
	PageFactory.initElements(BaseClass.driver, this);
}

}
