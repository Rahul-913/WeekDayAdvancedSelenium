package runnerScripts;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericScripts.ApplicationConstants;
import genericScripts.BasePage;
import genericScripts.ReadExcel;

public class TC01_AddEmp extends BasePage implements ApplicationConstants
{
	@Test(dataProvider = "TestData")
	public void AddEmpFeature(String FN,String LN) throws Exception
	{
		
		dashboardpage.PIM_Btn().click();
		pimPage.AddEmp_Btn().click();
		pimPage.Fn_TF().sendKeys(FN);
		pimPage.Ln_TF().sendKeys(LN);
		pimPage.Save_Btn().click();
	}
	@DataProvider(name = "TestData")
	public String[][] TestDataSupplier() throws Exception
	{
		ReadExcel.AccessSheet("Sheet1",ExcelPath);
		int LastRow = ReadExcel.GetLastRow();
		int LastCell = ReadExcel.GetLastCell();
		String [][] values = new String[LastRow+1][LastCell];
		for(int r=0;r<=LastRow;r++)
		{
			XSSFRow currentRow = ReadExcel.AccessRow(r);
			for(int c=0;c<LastCell;c++)
			{
				XSSFCell currentCell = currentRow.getCell(c);
				values[r][c] = currentCell.getStringCellValue();	
			}
		}
		return values;
	}
	
	
	
	
	
	
	

}
