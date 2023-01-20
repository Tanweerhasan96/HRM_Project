package com.hrm.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp_Hr_Head extends  Hr_Head_Baseclass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result)
	{
		//Execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"---------->Testscript execution started");
		
	}

	public void onTestFailure(ITestResult result)
	{
		String Failedscript = result.getMethod().getMethodName();
		String FS =Failedscript +new JavaUtility().getSystemDate();
		EventFiringWebDriver edriver=new EventFiringWebDriver(Hr_Head_Baseclass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+FS+".png");
		String filepath = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("--TestScript Execution failed--");
		
	}

	public void onTestSkipped(ITestResult result) 
    {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"--skipped--" );
		Reporter.log("--TestScript Execution Skipped--");
	
	}

	public void onTestSuccess(ITestResult result)
	{
		//Execution start from here
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"----->Passed");
		Reporter.log(MethodName+"---->Testscript execution successful");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context)
	{
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("HRM Report ");
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser","chrome");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Base-Url","https://localhost:8888");
		report.setSystemInfo("Reporter Name","Tanweer");
		

		
	}

	public void onFinish(ITestContext context) {
		//consolidated the report 
		report.flush();
		
	}
	
}
