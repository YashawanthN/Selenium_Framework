package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLdata {

	/*public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ReadXLdata xl = new ReadXLdata();
		xl.gettestdata("login");

	}*/
	@DataProvider(name="LoginsData")
	public String[][] gettestdata(Method m) throws EncryptedDocumentException, IOException
	{
		String excelsheetName = m.getName();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		Workbook wbook = WorkbookFactory.create(inputstream);
		Sheet sheetName = wbook.getSheet(excelsheetName);
		
		
		int totalrows = sheetName.getLastRowNum();
		System.out.println(totalrows);
		Row rowcells = sheetName.getRow(0);
		int totalcolumns = rowcells.getLastCellNum();
		System.out.println(totalcolumns);
		
		DataFormatter format = new DataFormatter();
		String testdata[][] = new String[totalrows][totalcolumns];
		
		for(int i=1; i<=totalrows; i++)
		{
			for(int j=0; j < totalcolumns; j++)
			{
				testdata[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
			}
		}
		return testdata;
	}

}
