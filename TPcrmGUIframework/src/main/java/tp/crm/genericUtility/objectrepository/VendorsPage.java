package tp.crm.genericUtility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	WebDriver driver;
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(xpath= "//img[@title=\"Create Vendor...\"]")
	public WebElement createVendorPage;
	
	@FindBy(name="vendorname")
	public WebElement vendorsNameTextField;
	
	@FindBy(xpath= "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	@FindBy(xpath= "//span[@class=\"lvtHeaderText\"]")
	private WebElement headertext;
	
	@FindBy(xpath= "//img[@alt=\"Select\"]")
	private WebElement vendorLookup;
	
	public WebElement getVendorLookup() {
		return vendorLookup;
	}

	public WebElement getHeadertext() {
		return headertext;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCreateVendorPage() {
		return createVendorPage;
	}

	public WebElement getVendorsNameTextField() {
		return vendorsNameTextField;
	}
	
	
	public void createVendors(String vendorName) {
		vendorsNameTextField.sendKeys(vendorName);
		saveBtn.click();
	}
	

}
