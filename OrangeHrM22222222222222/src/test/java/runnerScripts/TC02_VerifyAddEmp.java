package runnerScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericScripts.BasePage;

public class TC02_VerifyAddEmp extends BasePage
{
	@Test
	public void Test2()
	{
		dashboardpage.PIM_Btn().click();
		boolean res = pimPage.AddEmp_Btn().isDisplayed();
		Assert.assertTrue(res);
		System.out.println("Verification is Completed");
		Assert.fail();
	}

}
