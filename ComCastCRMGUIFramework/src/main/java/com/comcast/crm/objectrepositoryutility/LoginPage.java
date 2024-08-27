package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

/**
 * @author LENOVO
 * 
 * Contains Login Page elements & business lib like login()
 */


public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passWordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//object Encapsulation

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * Login To Appliation Based On Username,password, url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	
	//provide Action
	public void loginToApp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		usernameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		loginBtn.click();
	}

}
