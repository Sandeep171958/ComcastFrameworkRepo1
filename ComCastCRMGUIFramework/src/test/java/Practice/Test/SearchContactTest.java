package Practice.Test;
/**
 * test class for Contact Module
 * @author LENOVO
 * 
 */

import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass {
	
	/**
	 * Scenario : login()===> navigateContact==>createContact()====verify
	 */

	@Test
	public void searchcontactTest() {
		/*step 1 : login to app*/
	  LoginPage lp=new LoginPage(driver);
	  lp.loginToApp("url", "username", "pas");
	}
	
	
}
