package tp.crm.genericUtility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(linkText = "Products")
	private WebElement productlink;

	@FindBy(linkText = "More")
	private WebElement morelink;

	@FindBy(linkText = "Vendors")
	private WebElement vendorslink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimage;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;

	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getVendorslink() {
		return vendorslink;
	}

	public WebElement getAdministratorimage() {
		return administratorimage;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public void navigatetoVendors() {
		Actions action = new Actions(driver);
		action.moveToElement(morelink).perform();
		vendorslink.click();
	}

	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(administratorimage).perform();
		signoutlink.click();
	}

}
