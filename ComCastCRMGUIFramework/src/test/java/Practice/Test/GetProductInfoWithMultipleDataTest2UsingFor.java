package Practice.Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileUtility.ExcelUtility;

public class GetProductInfoWithMultipleDataTest2UsingFor {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String BrandName, String productName) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName ,Keys.ENTER);
		
		
		//capture product info
		String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String Price=driver.findElement(By.xpath(x)).getText();
		System.out.println(Price);
		
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility elib=new ExcelUtility();
		int rowCount = elib.getRowCount("product");
		
		
		Object[][] objArr=new Object[rowCount][2];
		
		for(int i=0;i<rowCount-1;i++) {
			objArr[i][0]=elib.getDataFromExcel("product", i+1, 0);
			objArr[i][1]=elib.getDataFromExcel("product", i+1, 1); 
		}
		return objArr;
		
		
		
	}

}
