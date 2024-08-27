package com.comcast.crm.contacttest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;

public class CreateContactWithOrg {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password =flib.getDataFromPropertiesFile("password");
		 
		 
		 //read test script data from excel file
		  String orgname = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		 String ContactLastName = elib.getDataFromExcel("contact", 7, 3) ;
			
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
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
		
		//enter all the details & create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify Header message Expected result
				String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if (headerinfo.contains(orgname)) {
					System.out.println(orgname + " is created====PASS");
				}else {
					System.out.println(orgname + " is not created====FAIL");
				}
		
		
		
		
		// navigate to contact module
         driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//enter all the details & create new contact
		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
				wlib.switchToTabOnURL(driver, "module=Accounts");
				
				driver.findElement(By.name("search_text")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
				
				//Switch to parent window
				wlib.switchToTabTitle(driver, "Contacts&action");
				
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify Header message Expected result
		 headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (headerinfo.contains(ContactLastName)) {
			System.out.println(ContactLastName + " is created====PASS");
		}else {
			System.out.println(ContactLastName + " is not created====FAIL");
		}
		
		//verify Header orgname expected result
        String actualorgname = driver.findElement(By.linkText(orgname)).getText();
		System.out.println(actualorgname);
        
		if (actualorgname.equals(orgname)) {
			System.out.println(orgname + " is created====pass");
		}
		else {
			System.out.println(orgname + " is not created====fail");
		}
		
		
		
		//logout application
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		

	}

}
