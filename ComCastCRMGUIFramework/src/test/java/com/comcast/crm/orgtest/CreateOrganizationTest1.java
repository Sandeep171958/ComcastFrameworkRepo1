package com.comcast.crm.orgtest;


import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationTest1 {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
			//create object
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		
		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username =flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		 
		 
		 //read test script data from excel file
		String orgname=elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
			
		 WebDriver driver=null;
		 
		  //Scanner sc=new Scanner(System.in);
		//String browser = sc.next();
		  
		  if (Browser.equals("Chrome")) {
			driver=new ChromeDriver();
		  }else if (Browser.equals("edge")) {
			driver=new EdgeDriver();	
			}
		  else {
			driver=new ChromeDriver();
		}
		driver=new ChromeDriver();
		//login to app
		wlib.waitForPageToLoad(driver);
		driver.get(Url);
		
		LoginPage lp = new LoginPage(driver);
	
		lp.loginToApp(Url,Username,Password);
		
		//navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		
		//click on create organization button
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		
		//enter all the details & create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createorg(orgname);
		
		//verify Header message Expected result
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName= oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgname)) {
			System.out.println(orgname + " name is verified==PASS");
		}
		else {
			System.out.println(orgname + " name is not verified==fail");
		}
		
		//logout application
		
		hp.logout();
		
		driver.quit();
		
	}




	
	}


