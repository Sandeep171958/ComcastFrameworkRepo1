package Practice.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
	
	@Test
	
	public void amazonTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://amazon.com");
		
		//create an object to EvenFirirng WebDriver
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
		//use getScreenshotAs method to get file type of Screenshot
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		//store screenShot in local drive
		FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
		   
	}
	

}
