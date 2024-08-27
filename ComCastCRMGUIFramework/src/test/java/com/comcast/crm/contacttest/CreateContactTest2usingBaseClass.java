package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
/**
 * @author LENOVO
 * 
 * 
 */


public class CreateContactTest2usingBaseClass extends BaseClass {

	@Test(groups="smokeTest")
	public void CreateContactTestusingBaseClass() throws Throwable, IOException {

		/* read test script data from excel file*/
		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		/* navigate to contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		/* click on create contact button*/
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		// enter all the details & create contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(lastname);

		// verify Header message Expected result
		String headerinfo = cp.getHeaderMsg().getText();
		boolean status = headerinfo.contains(lastname);
		Assert.assertEquals(status, true);
		
		String actLastName = cp.getActualLastName().getText();
		SoftAssert assobj=new SoftAssert();
		assobj.assertEquals(actLastName, lastname);
	}

	@Test(groups="RegressionTest")

	public void createContactWithSupportDate() throws Throwable, IOException {
		// read test script data from excel file
		String lastname = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();

		// navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		// click on create contact button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		// enter all the details & create new contact
		String startdate = jlib.getSystemDateYYYYDDMM();
		String enddate = jlib.getRequiredDateYYYYDDMM(30);
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSystemDate(lastname, startdate, enddate);

		// verify StartDate&EndDate Expected result
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();

		if (actStartDate.contains(startdate)) {
			System.out.println(startdate + " is created====PASS");
		} else {
			System.out.println(startdate + " is not created====FAIL");
		}

		// verify EndDate
		String actEnddate = driver.findElement(By.id("dtlview_Support End Date")).getText();

		if (actEnddate.contains(enddate)) {
			System.out.println(enddate + " is created====PASS");
		} else {
			System.out.println(enddate + " is not created====FAIL");
		}

	}
	@Test(groups="RegressionTest")
	public void createContactWithOrgTest() throws Throwable, IOException {
		
		 
		 
		 //read test script data from excel file
		  String orgname = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		 String ContactLastName = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
			
		//navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		//click on create organization button
		OrganizationPage cnp=new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
		
		
		//enter all the details & create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createorg(orgname);
		
//		//verify Header message Expected result
//				String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//				
//				if (headerinfo.contains(orgname)) {
//					System.out.println(orgname + " is created====PASS");
//				}else {
//					System.out.println(orgname + " is not created====FAIL");
//				}
		
		
		Thread.sleep(3000);
		
		// navigate to contact module
        hp.getContactlnk().click();
		
		//click on create contact button
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();
		
		//enter all the details & create new contact
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		ccp.createContactWithOrg(ContactLastName, orgname);
//		//verify Header message Expected result
//		 headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		
//		if (headerinfo.contains(ContactLastName)) {
//			System.out.println(ContactLastName + " is created====PASS");
//		}else {
//			System.out.println(ContactLastName + " is not created====FAIL");
//		}
//		
//		//verify Header orgname expected result
//        String actualorgname = driver.findElement(By.linkText(orgname)).getText();
//		System.out.println(actualorgname);
//        
//		if (actualorgname.equals(orgname)) {
//			System.out.println(orgname + " is created====pass");
//		}
//		else {
//			System.out.println(orgname + " is not created====fail");
//		}
		
		
		
		

	}

	}


