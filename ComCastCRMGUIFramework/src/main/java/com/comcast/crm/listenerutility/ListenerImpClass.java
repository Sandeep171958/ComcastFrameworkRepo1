package com.comcast.crm.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
 
public class ListenerImpClass  implements ITestListener, ISuiteListener {
	
	public ExtentSparkReporter spark;
	public  ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		
		String time = new Date().toString().replace(" ", "_").replace(":", " ");

		// spark report config
		spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+" .html");
		spark.config().setDocumentTitle("CRM Test Suit results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information and createTest
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "Windows-10");
		report.setSystemInfo("Browser", "Chrome-100");
	
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backUP");
		report.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=======" + result.getMethod().getMethodName() + "========START========");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===>STARTED<=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=======" + result.getMethod().getMethodName() + "=======ENDED=========");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====>PASSED<======");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", " ");

		test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		test.log(Status.FAIL,  result.getMethod().getMethodName()+"====>FAILED<======");
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
	

}
