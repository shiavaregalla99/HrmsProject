package com.xyz.hrms.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.xyz.hrms.utils.ConfigReader;
import com.xyz.hrms.utils.Constants;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriver setUp() {
		ConfigReader.readProperties(Constants.Configs_File_Path);
		String browsername=ConfigReader.getproperty("browserName");
	 switch(browsername) {
	 case "chrome":
		 System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
		 driver= new ChromeDriver();
		 break;
	 case "firefox":
		 System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_PATH);
         driver= new InternetExplorerDriver();
         break;
         
	 case "ie":
		 System.setProperty("webdriver.ie.driver", Constants.IE_PATH);
         driver= new InternetExplorerDriver();
         break;
         
         default:
        	 throw new RuntimeException("Browser is not supported");
	 
	}
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 driver.get(ConfigReader.getproperty("URL"));
	 PageIntializer.intialize();
	  return driver;
	
}

public static void tearDown() {
	if(driver!=null) {
	driver.quit();
	}
}


}
