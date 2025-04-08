package genericScripts;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass extends BasePage implements ITestListener 
{
	ExtentSparkReporter reporter;
	ExtentReports reports;
	public void onStart(ITestContext context)
	{
		reporter = new ExtentSparkReporter("./src/test/resources/ExtentReports/"+context.getName()+" "+CurrentDateTime.DateTime()+".html");
		reporter.config().setDocumentTitle("AutomationTestReport");
		reporter.config().setReportName("E2EFramework");
		reporter.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Browser1", "Chrome");
		reports.setSystemInfo("Browser2", "Firefox");
		reports.setSystemInfo("Tester_Id", "00215");
		System.out.println("The Execution process has been started");
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("The "+result.getName()+" Testcase Execution process has been started");
	}
	public void onTestSuccess(ITestResult result)
	{
		ExtentTest test = reports.createTest(result.getName());
		test.log(Status.PASS,result.getName()+" this testcase is Success");
		System.out.println("The "+result.getName()+"  Testcase Execution has been success");
	}
	public void onTestFailure(ITestResult result)
	{
		ExtentTest test = reports.createTest(result.getName());
		test.log(Status.FAIL,result.getName()+" this testcase is Failed");
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath("./src/test/resources/Screenshots/"+result.getName()+" "+CurrentDateTime.DateTime()+".png");
		System.out.println("The "+result.getName()+"  Testcase Execution has been failed");
		try {
			CaptureScreenShot.GetDefect(result.getName()+" "+CurrentDateTime.DateTime()+".png");
		} catch (IOException e) 
		{
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		ExtentTest test = reports.createTest(result.getName());
		test.log(Status.SKIP,result.getName()+" this testcase is Skipped");
		System.out.println("The  "+result.getName()+" Testcase Execution has been skipped");
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("The Execution process has been finished");
		reports.flush();
	}
	
	
	
	
	
	
}
