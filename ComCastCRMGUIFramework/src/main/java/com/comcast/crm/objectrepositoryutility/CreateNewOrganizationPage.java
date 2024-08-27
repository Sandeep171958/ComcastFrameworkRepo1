package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		this.driver=driver;	
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDB;
	
	@FindBy(name="accounttype")
	private WebElement typeDB;
	
	@FindBy(id="phone")
	private WebElement phoneNum;
	
	
	public WebElement getPhoneNumber() {
		return phoneNum;
	}

	public WebElement getTypeDB() {
		return typeDB;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryDB() {
		return industryDB;
	}
	
	public void createorg(String orgname) {
		orgNameEdt.sendKeys(orgname);
		saveBtn.click();
		
	}
	
	public void createOrg(String orgname,String phoneNumber) throws InterruptedException {
		orgNameEdt.sendKeys(orgname);
		phoneNum.sendKeys(phoneNumber);
		saveBtn.click();
	}
	
	public void createOrg(String orgname,String Industry,String type) {
		orgNameEdt.sendKeys(orgname);
		Select sel=new Select(industryDB);
		sel.selectByVisibleText(Industry);
		Select sel1=new Select(typeDB);
		sel1.selectByVisibleText(type);
		saveBtn.click();
	}
	

	
}
