package tp.crm.genericUtility.fileUtility;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	
	public String getdataFromExcel(String sheetname,int rowNum,int celNum) throws Throwable  {
		FileInputStream fis=new FileInputStream("./testdata/test_script.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
		
	}

}
