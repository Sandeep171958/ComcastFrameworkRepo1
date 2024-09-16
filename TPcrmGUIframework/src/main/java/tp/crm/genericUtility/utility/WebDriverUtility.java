package tp.crm.genericUtility.utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void notificationHandle() {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("----disable notification----");
		WebDriver driver=new ChromeDriver(option);
	}
	
	public void waitForPagetoLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForelementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=	new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchTotaburl(WebDriver driver,String currentUrl) {
		Set<String> allids = driver.getWindowHandles();
		Iterator<String> it = allids.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actualurl = driver.getCurrentUrl();
			if (actualurl.contains(currentUrl)) {
				break;
			}
			
		}
		
	}
	public void switchToTabtitle(WebDriver driver,String partialTitle) {
		Set<String> allids = driver.getWindowHandles();
		Iterator<String> it = allids.iterator();
		while (it.hasNext()) {
			String windowid =it.next();
			driver.switchTo().window(windowid);
			String actualTitle = driver.getTitle();
			if (actualTitle.contains(partialTitle)) {
				break;
			}
			
		}
	}
	 
	public void switchtoalertandaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchtoalertanddismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
}
