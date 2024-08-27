package Practice.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoWithMultipleDataTest {
	
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
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 13 (128GB) - Midnight";
		
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 15 (128 GB) - Black";
		
		objArr[2][0]="iphone";
		objArr[2][1]="Apple iPhone 14 (128 GB) - Purple";
		return objArr;
		
		
		
	}

}
