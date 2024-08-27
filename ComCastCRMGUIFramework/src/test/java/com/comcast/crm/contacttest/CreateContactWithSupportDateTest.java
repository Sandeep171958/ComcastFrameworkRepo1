package com.comcast.crm.contacttest;


import java.io.IOException;

import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		
		String Browser =flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		 
		 
		
		 
		 //read test script data from excel file
		 String lastname = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
			
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);
		
		 driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//enter all the details & create new contact
        String startdate = jlib.getSystemDateYYYYDDMM();
        String enddate = jlib.getRequiredDateYYYYDDMM(30);
		
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		
		//Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify StartDate&EndDate Expected result
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		
		if (actStartDate.contains(startdate)) {
			System.out.println(startdate + " is created====PASS");
		}else {
			System.out.println(startdate + " is not created====FAIL");
		}
		
		//verify EndDate
        String actEnddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		
		if (actEnddate.contains(enddate)) {
			System.out.println(enddate + " is created====PASS");
		}else {
			System.out.println(enddate + " is not created====FAIL");
		}
		
		//logout application
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		


	}

}
