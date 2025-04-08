package genericScripts;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFiles extends BasePage implements ApplicationConstants 
{
	static Properties pro;
	ReadPropertyFiles() throws Exception
	{
		fis = new FileInputStream(PropertyPath);
		pro = new Properties();
		pro.load(fis);
	}
	public static String EntertestUrl()
	{
		String testUrl = pro.getProperty("testUrl");
		return testUrl;
	}
	public static String EntertestUsn()
	{
		String testUsn = pro.getProperty("testUsn");
		return testUsn;
	}
	
	public static String EntertestPsw()
	{
		String testPsw = pro.getProperty("testPsw");
		return testPsw;
	}

}
