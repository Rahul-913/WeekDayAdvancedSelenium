package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPageObjects 
{
	//Declaration
		@FindBy(xpath = "//a[.='Add Employee']")
		private WebElement AddEmp_Btn;
		@FindBy(name="firstName")
		private WebElement Fn_TF;
		@FindBy(name = "lastName")
		private WebElement Ln_TF;
		@FindBy(xpath = "//button[.=' Save ']")
		private WebElement Save_Btn;
		
		//Initialization
		public PIMPageObjects(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//Utilization
		public WebElement AddEmp_Btn()
		{
			return AddEmp_Btn;
		}
		public WebElement Fn_TF()
		{
			return Fn_TF;
		}
		public WebElement Ln_TF()
		{
			return Ln_TF;
		}
		public WebElement Save_Btn()
		{
			return Save_Btn;
		}
		

}
