package tp.crm.vendorsTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import tp.crm.genericUtility.baseclass.BaseClass;

import tp.crm.genericUtility.objectrepository.HomePage;
import tp.crm.genericUtility.objectrepository.VendorsPage;

/**
 * @author LENOVO
 */
@Listeners(tp.crm.genericUtility.listners.ListnerImpClass.class)

public class CreateVendorsTest extends BaseClass {

	@Test
	public void createVendors() throws Throwable {
		String vendorsName = excel.getdataFromExcel("vendors", 1, 2) + java.randomNumber();
		HomePage hp = new HomePage(driver);
		hp.getMorelink().click();
		hp.getVendorslink();

		VendorsPage vp = new VendorsPage(driver);
		vp.getCreateVendorPage().click();
		vp.createVendors(vendorsName);

//		// verify vendors
//		String headerinfo = vp.getHeadertext().getText();
//		boolean status = headerinfo.contains(vendorsName);
//		Assert.assertEquals(status, true);

	}

}
