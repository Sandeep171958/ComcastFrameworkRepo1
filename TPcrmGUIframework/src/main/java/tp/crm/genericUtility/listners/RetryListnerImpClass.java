package tp.crm.genericUtility.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListnerImpClass implements IRetryAnalyzer {
	
		int count=0;
		int limitCount=5;
		public boolean retry(ITestResult result) {
			if (count<limitCount) {
				count++;
				return true;
			}
			return false;
		}

	}



