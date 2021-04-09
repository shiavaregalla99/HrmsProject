package com.xyz.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xyz.hrms.Base.BaseClass;
import com.xyz.hrms.Base.PageIntializer;

public class CommonMethods extends PageIntializer {

	
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
    
    public static String takeScreenshot(String filename) {
      TakesScreenshot ts=(TakesScreenshot)BaseClass.driver;
      File file=ts.getScreenshotAs(OutputType.FILE);
        String destinationPath=Constants.ScreenShot_Path+filename
        		+getTimeStamp()	+ ".png";
        
        try {
			FileUtils.copyFile(file, new File(destinationPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        return destinationPath;

}
    
    public static String getTimeStamp() {
    	Date date= new Date();
    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
      return sdf.format(date.getTime());
    }
}