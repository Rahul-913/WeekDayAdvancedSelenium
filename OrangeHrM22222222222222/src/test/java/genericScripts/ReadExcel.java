package genericScripts;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel extends BasePage
{
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	static XSSFRow row;//
	static XSSFCell cel;
	public static XSSFSheet AccessSheet(String SheetName,String ExcelPath) throws Exception
	{
		fis = new FileInputStream(ExcelPath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(SheetName);
		return sheet;
	}
	public static XSSFRow AccessRow(int Row)
	{
		row = sheet.getRow(Row);
		return row;
	}
	public static XSSFCell AccessCell(int Cell)
	{
		cel = row.getCell(Cell);
		return cel;
	}
	public static int GetLastRow()
	{
		int lastRow = sheet.getLastRowNum();
		return lastRow;
	}
	public static int GetLastCell()
	{
		XSSFRow rw = AccessRow(0);
		int lastCel = rw.getLastCellNum();
		return lastCel;
	}

}
