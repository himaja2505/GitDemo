package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.Resources.ExtentReporterNG;

public class Listeners  extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> tlocal=new ThreadLocal<ExtentTest>(); //thread safe
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		
		test=extent.createTest( result.getMethod().getMethodName());	
		tlocal.set(test); // unique thread id
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		tlocal.get().log(Status.PASS, "Test Passed");
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		tlocal.get().fail(result.getThrowable());
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//take screenshot,attch to report
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tlocal.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
		}
	
		
		@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	

}
