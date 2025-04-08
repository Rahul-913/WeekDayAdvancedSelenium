package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects
{
	//Declaration
	@FindBy(name="username")
	private WebElement Usn_TF;
	@FindBy(name="password")
	private WebElement Psw_TF;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Login_BTB;
	//Initialization
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement Usn_TF()
	{
		return Usn_TF;
	}
	public WebElement Psw_TF()
	{
		return Psw_TF;
	}
	public WebElement Login_BTB()
	{
		return Login_BTB;
	}
	
	
	
}
