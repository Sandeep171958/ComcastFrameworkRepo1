package Practice.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class InvoiceTest2 extends BaseClass {
	
	
	@Test (retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImpClass.class)
	public void createInvoiceTest2() {
		
		System.out.println("execute createInvoiceTest2");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	@Test
	public void createInvoicewithConatctTest() {
		System.out.println("execute createInvoicewithConatctTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

}
