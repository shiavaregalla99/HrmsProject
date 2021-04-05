package com.xyz.hrms.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xyz.hrms.Base.BaseClass;

public class CommonMethods {

	
	public static void sendText(WebElement ele,String text) {
		ele.clear();
		ele.sendKeys(text);
	}
	public static void click(WebElement ele) {
		waitforClickability(ele);
		ele.click();
	}
	
    public static WebDriverWait getWaitObject() {
    	WebDriverWait wait= new WebDriverWait(BaseClass.driver,Constants.Explicit_Time);
      return wait;
    
    }
    
    public static WebElement waitforClickability(WebElement ele) {
    	return getWaitObject().until((ExpectedConditions.elementToBeClickable(ele)));
    }
    public static WebElement waitforVisibilty(WebElement ele) {
    	return getWaitObject().until((ExpectedConditions.visibilityOf(ele)));
    }
}
