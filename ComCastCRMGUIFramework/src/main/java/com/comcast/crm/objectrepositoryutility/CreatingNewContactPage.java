package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility {
	 
	WebDriver driver;
	
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="lastname")
	private WebElement createContact;

	public WebElement getCreateContact() {
		return createContact;
	}
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement OrgBtn;
	
   public WebElement getOrgName() {
		return OrgBtn;
	}

@FindBy(name="support_start_date")
      private WebElement startdate;
   
   @FindBy(name="support_end_date")
     private WebElement endDate;
	
	
	public WebElement getStartdate() {
	return startdate;
}

public WebElement getEndDate() {
	return endDate;
}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(name="search_text")
	private WebElement orgsearch;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public WebElement getOrgBtn() {
		return OrgBtn;
	}

	public WebElement getOrgsearch() {
		return orgsearch;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void createContact(String lastname) {
		waitForPageToLoad(driver);
		createContact.sendKeys(lastname);
		saveBtn.click();
		
	}
	public void createContactWithSystemDate(String lastname,String startDate,String enddate) {
		createContact.sendKeys(lastname);
		startdate.clear();
		startdate.sendKeys(startDate);
		endDate.clear();
		endDate.sendKeys(enddate);
		saveBtn.click();
	}
	public void createContactWithOrg(String ContactLastName,String orgName) {
		createContact.sendKeys(ContactLastName);
		OrgBtn.click();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.switchToTabOnURL(driver, "module=Accounts");
		orgsearch.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wlib.switchToTabTitle(driver, "Contacts&action");
		saveBtn.click();
	}
}
