package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_logic implements IRetryAnalyzer {
     
	int counter = 0;
	int maxRetry = 3;
	
	public boolean retry(ITestResult result) {
		
		if(counter < maxRetry )
		{
			counter++;
			return true;
		}
		
		return false;
	}

	
	
}
