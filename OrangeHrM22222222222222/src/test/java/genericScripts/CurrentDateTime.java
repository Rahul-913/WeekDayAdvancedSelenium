package genericScripts;

import java.util.Date;

public class CurrentDateTime 
{
	public static String DateTime()
	{
		Date d = new Date();
		String currentDate = d.toString().replace(":","-");
		return currentDate;
	}

}
