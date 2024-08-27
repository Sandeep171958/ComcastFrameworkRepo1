package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(linkText ="Organizations")
	private WebElement Orglink;;
	
	@FindBy(linkText ="Contacts")
	private WebElement contactlnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	@FindBy(linkText = "Products")
	private WebElement productlink;
	
	public WebElement getProductlink() {
		return productlink;
	}

	
	public WebElement getProductLink() {
		return productlink;
	}

	public WebElement getOrglink() {
		return Orglink;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}


	public WebElement getCampaignlink() {
		return campaignlink;
	}
	
	public WebElement getMorelink() {
		return morelink;
	}
	
	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	public void navigateTocampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(morelink).perform();
		campaignlink.click();
	}
	public void logout() {
		Actions action=new Actions(driver);
		action.moveToElement(adminImg).perform();
		signoutlink.click();
	}


}

