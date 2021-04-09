package com.xyz.hrms.Base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.xyz.hrms.utils.CommonMethods;


public  class Listener implements ITestListener {
@Override
	public void onTestStart(ITestResult result) {
		//this listener executes when @Test method starts
		System.out.println("Test Started " + result.getName());
		BaseClass.test=BaseClass.report.createTest(result.getName());
	}
@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed " + result.getName());
		BaseClass.test.pass("Test Case pass "+result.getName());
		
		try {
			BaseClass.test.addScreenCaptureFromPath(CommonMethods.
					takeScreenshot("Passed//"+result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed " + result.getName());
		BaseClass.test.fail("Test Case Failed "+result.getName());
		try {
			BaseClass.test.addScreenCaptureFromPath(CommonMethods.
					takeScreenshot("Failed//"+result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}
@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}
@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}
@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
}
