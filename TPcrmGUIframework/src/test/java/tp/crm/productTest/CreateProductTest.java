package tp.crm.productTest;

import org.testng.Assert;

import org.testng.annotations.Test;

import tp.crm.genericUtility.baseclass.BaseClass;
import tp.crm.genericUtility.objectrepository.HomePage;
import tp.crm.genericUtility.objectrepository.ProductPage;
import tp.crm.genericUtility.objectrepository.VendorsPage;
import tp.crm.genericUtility.objectrepository.createProductPage;

/**
 * @author LENOVO
 */

public class CreateProductTest extends BaseClass {

	@Test
	public void createProduct() throws Throwable {
		String productName = excel.getdataFromExcel("product", 1, 2) + java.randomNumber();

		HomePage home = new HomePage(driver);
		home.getProductlink().click();

		ProductPage product = new ProductPage(driver);
		product.getCreateProductbtn().click();

		product.createProduct(productName);

		// verify header
		String headerText = product.getHeadertext().getText();
		boolean status = headerText.contains(productName);
		Assert.assertTrue(status, headerText);

	}

	@Test
	public void createProductwithPartNumberAndDates() throws Throwable {
		String productName = excel.getdataFromExcel("product", 4, 2) + java.randomNumber();
		String partName = excel.getdataFromExcel("product", 4, 3);

		HomePage h = new HomePage(driver);
		h.getProductlink().click();

		ProductPage p = new ProductPage(driver);
		p.getCreateProductbtn().click();

		createProductPage cp = new createProductPage(driver);
		String startDate = java.getSupportStartDate();
		String expiryDate = java.getSupportExpiryDate(30);
		cp.createProductWithDate(productName, partName, startDate, expiryDate);


		// verify header
		String headertxt = cp.getHeaderTxtInfo().getText();
		boolean status = headertxt.contains(productName);
		Assert.assertEquals(status, true);

	}
	@Test
	
	public void createProductWithVendors() throws Throwable {
		String vendorName = excel.getdataFromExcel("vendors", 1, 2);
		String productName = excel.getdataFromExcel("product", 6, 2);
		
		HomePage home=new HomePage(driver);
		home.navigatetoVendors();
		
		VendorsPage vp=new VendorsPage(driver);
		vp.createVendorPage.click();
		vp.createVendors(vendorName);
		
		Thread.sleep(20);
		home.getProductlink().click();
		ProductPage pp=new ProductPage(driver);
		pp.getCreateProductbtn().click();
		
		createProductPage cpp=new createProductPage(driver);
		cpp.createProductWithVendors(productName, vendorName);
		
		 
		
	}

}
