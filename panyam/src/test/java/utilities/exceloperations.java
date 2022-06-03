package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceloperations {
	XSSFWorkbook wb;
	public exceloperations(String path) throws IOException {
	FileInputStream f=new FileInputStream(path);
	wb=new XSSFWorkbook(f);
	
}
	public String getdata(int row,int column,String sheetName) {
		DataFormatter df=new DataFormatter();
		return df.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(column));
	}
	public int getrowcount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}
	public int getcolumncount(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getLastCellNum();
	}
	
	}
		
	
	