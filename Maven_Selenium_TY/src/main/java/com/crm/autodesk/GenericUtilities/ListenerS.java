package com.crm.autodesk.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.autodesk.GenericUtilities.BaseClass;

public class ListenerS implements ITestListener {
	
	ExtentReports reports;
	ExtentTest test;

	public void onFinish(ITestContext arg0) {
		reports.flush();
		
	}

	public void onStart(ITestContext context) {
		
		JavaUtility jLib=new JavaUtility();
		
		ExtentHtmlReporter reporter;
		reporter=new ExtentHtmlReporter(IPathConstants.ExtentReporterPath+"Report"+jLib.getDateAndTime()+".html");
		reporter.config().setDocumentTitle("SDET21");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Regression");
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
		BaseClass baseclass=new BaseClass();
		try {
			String path=baseclass.getsscreenShot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+"is Passed");
		
	}

}
