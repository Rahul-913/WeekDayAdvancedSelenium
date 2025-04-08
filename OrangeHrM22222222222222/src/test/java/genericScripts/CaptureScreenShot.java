package genericScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenShot extends BasePage implements ApplicationConstants
{
	public static void GetDefect(String filename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File(DefectsPath+filename);
		FileHandler.copy(temp, perm);
	}

}
