package utils;

import org.openqa.selenium.WebElement;

import genericScripts.BasePage;

public class MouseActions extends BasePage
{
	public static void RightClick(WebElement element)
	{
		Objects.MouseActions(driver).contextClick(element).perform();
	}
	public static void DoubleClick(WebElement element)
	{
		Objects.MouseActions(driver).doubleClick(element).perform();
	}
	public static void MouseHover(WebElement element)
	{
		Objects.MouseActions(driver).moveToElement(element).perform();
	}
	public static void DragAndDrop(WebElement Srcelement,WebElement Dstelement)
	{
		Objects.MouseActions(driver).dragAndDrop(Srcelement, Dstelement).perform();
	}
	public static void ClickAndHold(WebElement element)
	{
		Objects.MouseActions(driver).clickAndHold(element).perform();
	}

}
