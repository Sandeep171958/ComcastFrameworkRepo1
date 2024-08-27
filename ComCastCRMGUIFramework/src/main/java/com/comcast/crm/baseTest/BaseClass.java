 package com.comcast.crm.baseTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.dataBaseUtility.DataBaseUtility;
import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	public DataBaseUtility dlib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver= null;	
	
	
	@BeforeSuite(groups={"smokeTest","RegressionTest"})
	public void configBS() throws SQLException {
		
		System.out.println("====connect Dto DB , Report config====");
		dlib.getDbConnection();


	}
	//@Parameters("Browser")
	
	
	@BeforeClass(groups={"smokeTest","RegressionTest"})
	public void configBeforeClass() throws IOException {
		System.out.println("======launch the browser======");
		String BROWSER =flib.getDataFromPropertiesFile("browser");
		 
		    if (BROWSER.equals("Chrome")) {
			driver=new ChromeDriver();
			
		 } else if (BROWSER.equals("Firefox")) {
			driver=new FirefoxDriver();
		}else if (BROWSER.equals("Edge")) {
			driver=new EdgeDriver();	
			}
		  else {
			driver=new ChromeDriver();
		}
		    sdriver=driver; 
		    UtilityClassObject.setDriver(driver);
		
	}
	
	
	@BeforeMethod(groups={"smokeTest","RegressionTest"})
	public void configBM() throws IOException {
		System.out.println(" ======login====");
		String URL = flib.getDataFromPropertiesFile("url");
		String USENAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL, USENAME, PASSWORD);
	}
	
	@AfterMethod(groups={"smokeTest","RegressionTest"})
	public void configAM() {
		System.out.println("=======logout=======");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups={"smokeTest","RegressionTest"})
	public void configAC() {
		System.out.println("=====close the browser====");
		driver.quit();
	}
	
	@AfterSuite(groups={"smokeTest","RegressionTest"})
	public void configAS() throws SQLException {
		System.out.println("====close Db, Report backup=======");
		dlib.CloseDbConnection();	
	}
}
