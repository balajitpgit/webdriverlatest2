package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ModifiedTestNGListener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult arg0)
	{
		System.out.println("******************Test Case Started here**************************");
	}

}
