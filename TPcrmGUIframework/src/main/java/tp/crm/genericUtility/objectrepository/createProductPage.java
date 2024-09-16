package tp.crm.genericUtility.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tp.crm.genericUtility.utility.WebDriverUtility;

public class createProductPage {

	WebDriver driver;

	public createProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "productcode")
	private WebElement partNumtextfield;

	@FindBy(name = "start_date")
	private WebElement startDatetxtField;

	public WebElement getSearchTxtfield() {
		return searchTxtfield;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	@FindBy(name = "expiry_date")
	private WebElement expiryDatetxtField;

	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerTxtInfo;

	@FindBy(xpath = "//input[@class=\"txtBox\"]")
	private WebElement searchTxtfield;

	@FindBy(name = "search")
	private WebElement searchbtn;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getHeaderTxtInfo() {
		return headerTxtInfo;
	}

	public WebElement getStartDatetxtField() {
		return startDatetxtField;
	}

	public WebElement getExpiryDatetxtField() {
		return expiryDatetxtField;
	}

	public WebElement getPartNumtextfield() {
		return partNumtextfield;
	}

	public void createProductWithDate(String ProductName, String PartNumber, String startDate, String expiryDate) {
		ProductPage p = new ProductPage(driver);
		p.getProductNameTxtField().sendKeys(ProductName);
		partNumtextfield.sendKeys(PartNumber);
		startDatetxtField.clear();
		startDatetxtField.sendKeys(startDate);
		expiryDatetxtField.clear();
		expiryDatetxtField.sendKeys(expiryDate);

		p.getSaveBtn().click();
	}

	public void createProductWithVendors(String ProductName, String vendorName) {
		ProductPage pr = new ProductPage(driver);
		pr.getProductNameTxtField().sendKeys(ProductName);
		VendorsPage vpp = new VendorsPage(driver);
		vpp.getVendorLookup().click();
		WebDriverUtility web = new WebDriverUtility();
		web.switchTotaburl(driver, "module=Vendors");
		searchTxtfield.sendKeys(vendorName);
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='" +vendorName+ "']")).click();
		web.switchToTabtitle(driver, "Products&action");
		savebtn.click();

	}

}
