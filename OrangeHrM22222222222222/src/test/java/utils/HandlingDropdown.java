package utils;

import org.openqa.selenium.WebElement;

import genericScripts.BasePage;

public class HandlingDropdown extends BasePage
{
	public static void SelectOptions(WebElement element,Object value)
	{
		
		if (value instanceof Integer) 
		{
			Objects.Dropdown(element).selectByIndex((int) value);
		}
		else if(value instanceof String) 
		{
			try 
			{
				Objects.Dropdown(element).selectByValue((String) value);
			} 
			catch (Exception e) 
			{
				Objects.Dropdown(element).selectByVisibleText((String) value);
			}
		}
	}
	public static void DeSelectOptions(WebElement element,Object value)
	{
		
		if (value instanceof Integer) 
		{
			Objects.Dropdown(element).deselectByIndex((int) value);
		}
		else if(value instanceof String) 
		{
			try 
			{
				Objects.Dropdown(element).deselectByValue((String) value);
			} 
			catch (Exception e) 
			{
				Objects.Dropdown(element).deselectByVisibleText((String) value);
			}
		}
	}

}
