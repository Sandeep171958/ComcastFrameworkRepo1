package tp.crm.genericUtility.listners;

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

import tp.crm.genericUtility.baseclass.BaseClass;


public class ListnerImpClass implements ITestListener,ISuiteListener {
	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configure");
		String time = new Date().toString().replace(" ", "_").replace(":", " ");
		
		spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM documents");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("browser", "chrome");
		
		
	}
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("report backup");
		report.flush();
	}
	@Override
	public void onTestStart(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"=========START========");	
	test=report.createTest(result.getMethod().getMethodName());
	//UtilityclassObject.setTest(test);
	test.log(Status.INFO, result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=======" + result.getMethod().getMethodName() + "=======ENDED=========");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====>PASSED<======");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		 String time = new Date().toString().replace(" ", "_").replace(":", " ");
		 
		 test.addScreenCaptureFromBase64String(filepath , testName + "_" + time);
		 test.log(Status.FAIL ,result.getMethod().getMethodName() + "===FAILED======");
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	
	
	

}
