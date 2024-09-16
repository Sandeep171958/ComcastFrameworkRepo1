package tp.crm.genericUtility.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement createProductbtn;

	@FindBy(name = "productname")
	private WebElement productNameTxtField;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	@FindBy(xpath= "//span[@class=\"lvtHeaderText\"]")
	private WebElement headertext;

	public WebElement getHeadertext() {
		return headertext;
	}

	public WebElement getCreateProductbtn() {
		return createProductbtn;
	}

	public WebElement getProductNameTxtField() {
		return productNameTxtField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createProduct(String ProductName) {
		productNameTxtField.sendKeys(ProductName);
		saveBtn.click();

	}

}
