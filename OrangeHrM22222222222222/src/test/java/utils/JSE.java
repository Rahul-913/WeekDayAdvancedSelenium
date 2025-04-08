package utils;

import org.openqa.selenium.WebElement;

import genericScripts.BasePage;

public class JSE extends BasePage 
{
	public static void PassValue(String value,WebElement element)
	{
		Objects.JSE(driver).executeScript("arguments[0].value='"+value+"'",element);
	}
	public static void ClearValue(WebElement element)
	{
		Objects.JSE(driver).executeScript("arguments[0].clear()",element);
	}
	public static void ScrollTillElement(WebElement element)
	{
		Objects.JSE(driver).executeScript("arguments[0].scrollIntoView()",element);
	}
}
