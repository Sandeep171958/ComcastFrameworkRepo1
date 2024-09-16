package tp.crm.genericUtility.fileUtility;

import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;


public class UtilityclassObject {
	
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
		
	}
	
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}
	
	public static WebDriver getdriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}


}
