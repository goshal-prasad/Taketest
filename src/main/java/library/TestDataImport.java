package library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import baseclassLibrary.BaseClass;

public class TestDataImport extends BaseClass {

	private static XSSFWorkbook workbook;  
	private static XSSFSheet sheet;
	private static  FileInputStream inputStream;
	private static FileOutputStream outputstream;
	private static Cell cell;
	private static Row row;
	private String cellData;

	String path = projectFolder + excelPath;

	public void readSheet(String sheetName) {
		try {
			inputStream = new FileInputStream(path);
			//workbook = new HSSFWorkbook(inputStream);
			workbook = new XSSFWorkbook(inputStream); 
			sheet = workbook.getSheet(sheetName);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeCell(int rowNum, int colNum, String text) {
		try {
			outputstream=new FileOutputStream(path);
			if(sheet.getRow(rowNum) == null)
				row = sheet.createRow(rowNum);
			if(sheet.getRow(rowNum).getCell(colNum)==null){
				row=sheet.getRow(rowNum);
				cell=row.createCell(colNum);
			}
			else {
				cell=sheet.getRow(rowNum).getCell(colNum);
			}
			cell.setCellValue(text);
			workbook.write(outputstream);
			outputstream.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed");
		}


	}
}
