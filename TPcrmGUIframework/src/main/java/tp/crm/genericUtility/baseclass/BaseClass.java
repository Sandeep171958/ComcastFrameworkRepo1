package tp.crm.genericUtility.baseclass;

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

import tp.crm.genericUtility.fileUtility.ExcelUtility;
import tp.crm.genericUtility.fileUtility.FileUtility;
import tp.crm.genericUtility.objectrepository.HomePage;
import tp.crm.genericUtility.objectrepository.LoginPage;
import tp.crm.genericUtility.utility.JavaUtility;
import tp.crm.genericUtility.utility.WebDriverUtility;

public class BaseClass {

	public WebDriver driver;

	public FileUtility file = new FileUtility();
	public ExcelUtility excel = new ExcelUtility();
	public JavaUtility java = new JavaUtility();
	public WebDriverUtility web = new WebDriverUtility();
	
	public static WebDriver sdriver;

	@BeforeSuite
	public void configureBS() {

		System.out.println("connect to database");

	}

	@BeforeClass
	public void configureBeforeClass() throws Throwable {
		System.out.println("===launch the browser====");
		String BROWSER = file.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("fireFox")) {
			driver = new FirefoxDriver();
		} else if(BROWSER.equals("edge")){
			driver = new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
    sdriver=driver;
	}

	@BeforeMethod
	public void configureBeforeMethod() throws Throwable {

		System.out.println("login------");
		String URL = file.getDataFromPropertiesFile("url");
		String USERNAME = file.getDataFromPropertiesFile("username");
		String PASSWORD = file.getDataFromPropertiesFile("password");

		LoginPage login = new LoginPage(driver);
		login.logintoApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configureAF() {
		System.out.println("logout--------------");
		HomePage home = new HomePage(driver);
		home.logout();
	}

	@AfterClass
	public void configureAC() {
		System.out.println("close browser-------------");
		driver.close();
	}

	@AfterSuite
	public void configureAS() {
		System.out.println("close dataBase----------");
	}

}
