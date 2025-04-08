package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPageObjects 
{
	//Declaration
		@FindBy(xpath = "//button[@type='button' and @size='large']")
		private WebElement Upgrade_Btn;
		@FindBy(xpath = "(//img[@alt='profile picture'])[1]")
		private WebElement Profile_Option;
		@FindBy(xpath = "//a[.='Logout']")
		private WebElement Logout_Option;
		@FindBy(xpath = "//span[.='PIM']")
		private WebElement PIM_Btn;
		//Initialization
		public DashBoardPageObjects(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//Utilization
		public WebElement Upgrade_Btn()
		{
			return Upgrade_Btn;
		}
		public WebElement Profile_Option()
		{
			return Profile_Option;
		}
		public WebElement Logout_Option()
		{
			return Logout_Option;
		}
		public WebElement PIM_Btn()
		{
			return PIM_Btn;
		}
//		
//		
		

}
