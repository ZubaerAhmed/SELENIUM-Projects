package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
//************************************************	
//=================This code is working===============================	
	public static String[][] readExcel() throws IOException{
		DataFormatter formatter= new DataFormatter();		
		String path = "E:/Project LUNA eclipse/Project/mmp_02_17/src/main/java/util/MMP testplan.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		
		int rowCount = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		//System.out.println(rowCount);
		String[][] data = new String[rowCount][col];
			
		for (int i = 0; i <rowCount; i++) {
	        for (int j = 0; j < col; j++) {	
	        	Cell cell = sheet.getRow(i+1).getCell(j);
	        	String value=formatter.formatCellValue(cell);
                data[i][j]=value;
                //System.out.println('-'+value);               
	        }
	    }		
/*		for (String[] x : data){
		   for (String y : x){
		        System.out.print('-'+y + " ");
		   }
		   System.out.println();
		}*/
		return data;
	}
//****************************************************
//===================Read===========================================
public static String readCellOnly(int row, int col) throws IOException{
		
		String path = "E:/Project LUNA eclipse/Project/mmp_02_17/src/main/java/util/MMP testplan.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		
		String data = sheet.getRow(row).getCell(col).toString();
		return data; 
	}
//====================Read=================================================

	public static Object[][] readExcelWithSS() throws EncryptedDocumentException, IOException{
		String path = "E:/Project LUNA eclipse/Project/mmp_02_17/src/main/java/util/MMP testplan.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("login");
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[row][col];
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				data[i][j] = sheet.getRow(i).getCell(j).toString();		
			}
		}
		return data; 
	}  
	//===============================Write============================	
		public void writeExcelWithXSSF() throws EncryptedDocumentException, IOException{
			String path = "E:/Project LUNA eclipse/Project/MMP2/src/test/resources/ExcelFileForMMP2.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Java Books");
	         
	        Object[][] bookData = {
	                {"Head First Java", "Kathy Serria", 79},
	                {"Effective Java", "Joshua Bloch", 36},
	                {"Clean Code", "Robert martin", 42},
	                {"Thinking in Java", "Bruce Eckel", 35},
	        }; 
	        int rowCount = 0;        
	        for (Object[] aBook : bookData) {
	            Row row2 = sheet.createRow(++rowCount);
	             
	            int columnCount = 0;
	            for (Object field : aBook) {
	                Cell cell = row2.createCell(++columnCount);
	                if (field instanceof String) {
	                    cell.setCellValue((String) field);
	                } else if (field instanceof Integer) {
	                    cell.setCellValue((Integer) field);
	                }
	            }         
	        }    
	        FileOutputStream fos = new FileOutputStream(path); 
	        workbook.write(fos); 
	        
			fos.close();
		} 
		
		//=======================write with SS=================================	
		public void writeExcelWithSS(int row, int col,String text) throws EncryptedDocumentException, IOException{
			//Single cell Not good, every time do fresh page===========
			String path = "E:/Project LUNA eclipse/Project/MMP2/src/test/resources/ExcelFileForMMP3.xlsx";
			//File file = new File(path);
			FileInputStream fis = new FileInputStream(path);

			//import org.apache.poi.ss.usermodel.Workbook;
			Workbook workbook = WorkbookFactory.create(fis); 
			Sheet sheet = workbook.getSheet("input2"); 
			
			FileOutputStream fos = new FileOutputStream(path); 
			//workbook.createSheet("Input").createRow(row).createCell(col).setCellValue(text);//First row/col is "0"
			sheet.getRow(row).getCell(col).setCellValue(text); 

			//String cellValue1 = sheet.getRow(row).getCell(col).toString();
			//System.out.println("Cell value is--> "+cellValue1);	
			workbook.write(fos);
			fos.close();
		}
		
}
