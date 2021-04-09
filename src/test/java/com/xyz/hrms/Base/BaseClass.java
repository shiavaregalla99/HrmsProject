package com.xyz.hrms.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.xyz.hrms.utils.ConfigReader;
import com.xyz.hrms.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class BaseClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeTest(alwaysRun = true)
	public void generateReport() { 
		ConfigReader.readProperties(Constants.Configs_File_Path);

		htmlReport = new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
		htmlReport.config().setDocumentTitle(ConfigReader.getproperty("reportTitle"));
		htmlReport.config().setReportName(ConfigReader.getproperty("reportName"));
		htmlReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReport);
	}
@AfterTest(alwaysRun = true)
	public void writeReport() {
		report.flush();
	}

@BeforeMethod(alwaysRun = true) 
	public static WebDriver setUp() {
		
		String browsername=ConfigReader.getproperty("browserName");
	 switch(browsername) {
	 case "chrome":
		// System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
		 WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 break;
	 case "firefox":
		// System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_PATH);
        WebDriverManager.firefoxdriver().setup();
		 driver= new InternetExplorerDriver();
         break;
         
	 case "ie":
		// System.setProperty("webdriver.ie.driver", Constants.IE_PATH);
        WebDriverManager.iedriver().setup();
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
@AfterMethod(alwaysRun = true)
public static void tearDown() {
	if(driver!=null) {
	driver.quit();
	}
}


}
