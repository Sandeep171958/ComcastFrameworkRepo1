package tp.crm.genericUtility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tp.crm.genericUtility.utility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "user_name")
	private WebElement usernametextfield;

	@FindBy(name = "user_password")
	private WebElement passwordtextfield;

	@FindBy(id = "submitButton")
	private WebElement submitbtn;

	public WebElement getUsernametextfield() {
		return usernametextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public void logintoApp(String url, String username, String password) {
		waitForPagetoLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		usernametextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);
		submitbtn.click();
	}

}
