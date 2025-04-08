package genericScripts;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashBoardPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.PIMPageObjects;

public class BasePage 
{
	public static FileInputStream fis;
	public static WebDriver driver;
	public ReadPropertyFiles rpf;
	public LoginPageObjects loginPage;
	public DashBoardPageObjects dashboardpage;
	public PIMPageObjects pimPage;
	ExtentSparkReporter reporter;
	ExtentReports reports;
	Logger log;
	@BeforeTest
	public void ConfigReports()
	{
		
	}
	@BeforeClass
	public void BrowserConfiguration() throws Exception
	{
		log = LogManager.getLogger("BrowserConfiguration");
		log.info("The browser has been configured");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		rpf = new ReadPropertyFiles();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		loginPage = new LoginPageObjects(driver);
		dashboardpage = new DashBoardPageObjects(driver);
		pimPage = new PIMPageObjects(driver);
	}
	@BeforeMethod
	public void LaunchApplication()//Login
	{
		Logger log = LogManager.getLogger("LaunchApplication");
		log.info("The LaunchApplication has been launched");
		driver.get(rpf.EntertestUrl());
		loginPage.Usn_TF().sendKeys(rpf.EntertestUsn());
		loginPage.Psw_TF().sendKeys(rpf.EntertestPsw());
		loginPage.Login_BTB().click();
		boolean Result = dashboardpage.Upgrade_Btn().isDisplayed();
		Assert.assertTrue(Result);
		System.out.println("DashBoard Page is Accessed");
		
	}
	@AfterMethod
	public void CloseApplication() throws Exception//logout
	{
		Logger log = LogManager.getLogger("CloseApplication");
		log.info("The CloseApplication has been executed");
		
		Thread.sleep(2000);
		dashboardpage.Profile_Option().click();
		dashboardpage.Logout_Option().click();
	}
	@AfterClass
	public void CloseBrowser()
	{
		Logger log = LogManager.getLogger("CloseBrowser");
		log.info("The CloseBrowser has been executed");
		driver.quit();
	}
	@AfterTest
	public void FlushReports()
	{
		
	}

}
