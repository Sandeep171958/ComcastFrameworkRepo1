package com.comcast.crm.orgtest;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;

import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class CreateOrganizationTest2usingBaseClass extends BaseClass {

	@Test(groups= "smokeTest")

	public void CreateOrganizationTestBaseClass() throws Throwable, IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		// read test script data from excel file
		String orgname = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();

		// navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization");
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// click on create organization button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create organization button");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create a new org");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createorg(orgname);

		
		UtilityClassObject.getTest().log(Status.INFO, orgname + "======>create a new org");
		
		// verify Header message Expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgname)) {
			System.out.println(orgname + " name is verified==PASS");
		} else {
			System.out.println(orgname + " name is not verified==fail");
		}

	}

	@Test(groups="RegressionTest")

	public void createOrganizationWithIndustryTest() throws Throwable, IOException {

		// read test script data from excel file
		String orgname = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);

		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// click on create organization button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter all the details & create new organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgname, industry, type);

		// verify orgname info Expected result
		String actualindustries = driver.findElement(By.id("dtlview_Industry")).getText();

		if (actualindustries.equals(industry)) {
			System.out.println(industry + " is verified====pass");
		} else {
			System.out.println(industry + " is not verified====fail");
		}

		// typeeeeeeeeeeee
		String actualtype = driver.findElement(By.id("dtlview_Type")).getText();

		if (actualtype.equals(type)) {
			System.out.println(type + " is verified====pass");
		} else {
			System.out.println(type + " is not verified====fail");
		}

	}

	@Test(groups="RegressionTest")

	public void createOrganizationWithPhoneNumber() throws Throwable, IOException {

		// read test script data from excel file
		String orgname = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String phoneNumber = elib.getDataFromExcel("org", 7, 3);

		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// click on create organization button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter all the details & create new organization
		CreateNewOrganizationPage ccp = new CreateNewOrganizationPage(driver);
		ccp.createOrg(orgname, phoneNumber);

		// verify Header phone number into Expected result

		String pNumber = driver.findElement(By.id("dtlview_Phone")).getText();

		if (pNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber + " is created====PASS");
		} else {
			System.out.println(phoneNumber + " is not created====FAIL");
		}

	}

}
