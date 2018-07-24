package DataUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.LogStatus;

import globals.Constants;
import globals.Globals;

public class Excelutility {
          
	
	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	// Create a new Excel file
		public static void CreateExcelFile(String filePath, String fileName, String sheetName) throws IOException {
			File excelFile = new File(filePath + "\\" + fileName);
			// Assuming XLSX here. If XLS use HSSFWorkbook
			//Workbook excelWorkbook = new XSSFWorkbook();
			Workbook excelWorkbook = new HSSFWorkbook();
			
			// Create the sheet in the workbook
			Sheet sheet1 = excelWorkbook.createSheet(sheetName);
			
			//Create the row in the sheet
			Row row = sheet1.createRow(0);
			
			// Create cells in the row
			Cell cell = row.createCell(0);
			
			// Add cell value
			cell.setCellValue("Test123");
					
			// Now actually create the entire file
			FileOutputStream excelOutputStream = new FileOutputStream(excelFile);
			excelWorkbook.write(excelOutputStream);
			
			// Close our open objects
			excelOutputStream.close();
			//excelWorkbook.close();
			
		}
		
		
		
		public static void log(String msg) {
			System.out.println(msg);
		}
		
		
		
		// Load Excel data from file
		/*public static void loadExcelData(String filePath, String fileName, String sheetName) throws IOException {
			File excelFile = new File(filePath + "\\" + fileName);
			FileInputStream excelInputStream = new FileInputStream(excelFile);
			Workbook excelWorkbook = null;

			// Assuming XLSX here. If XLS use HSSFWorkbook
			excelWorkbook = new XSSFWorkbook(excelInputStream);

			// Read the sheet inside the excel workbook
			Sheet excelSheet = excelWorkbook.getSheet(sheetName);

			// Get the number of rows
			int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum();

			// Read all the rows
			for (int i = 0; i <= rowCount; i++) {
				Row excelRow = excelSheet.getRow(i);

				/ Now we need to read all the cell (column) values in each row
				for (int j = 0; j < excelRow.getLastCellNum(); j++) {
					// Output value to the console for now
					log(excelRow.getCell(j).getStringCellValue());
					excelData.add(excelRow.getCell(j).getStringCellValue());
				}

			}*/

			/*// Close the file stream
			excelWorkbook.close();
			excelInputStream.close();

		}
    */
		
		//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
		 
		public static String getExcelData(int SheetNo, int RowNum, int ColNum) throws Exception {
			
			File src = new File(Constants.Excel_Data_Path);	
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sh = wb.getSheetAt(SheetNo);
			
			String cellData = sh.getRow(RowNum).getCell(ColNum).getStringCellValue();
		
		//	wb.close();
		
			return cellData;
		
		}
		
		public String[][]   getUserNamePassword(String sheetName) throws IOException {
			int lastRowNo;
			Sheet sheet;
			String[][] arrayExcelData = null;

			arrayExcelData = new String[4][2];
			
//	File src = new File(Constants.Excel_Data_Path);	
			
			FileInputStream fis = new FileInputStream(Constants.Excel_Data_Path);
			
			Workbook wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
	//		lastRowNo = sheet.getLastRowNum();
			for(int i=0; i<=3; i++){
				Row  row = sheet.getRow(i);
				for (int j=1; j <=1; j++) {
					
					arrayExcelData[i][j-1] =row.getCell(0).getStringCellValue().trim();
					arrayExcelData[i][j]=row.getCell(1).getStringCellValue().trim();
				}

			}


			return arrayExcelData;




		}
		
		public String[][]   getCheckoutFieldDetails(String sheetName) throws IOException {
			String[][] arrayExcelData = null;
			try{
			int lastRowNo;
			Sheet sheet;
			

			arrayExcelData = new String[3][6];
			
//	File src = new File(Constants.Excel_Data_Path);	
			
			FileInputStream fis = new FileInputStream(Constants.Excel_Data_Path);
			
			Workbook wb = new HSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
	//		lastRowNo = sheet.getLastRowNum();
			for(int i=0; i<=2; i++){
				Row  row = sheet.getRow(i);
				for (int j=0; j <=5; j++) {
					
					//arrayExcelData[i][j-1] =row.getCell(0).getStringCellValue().trim();
					arrayExcelData[i][j]=row.getCell(j).getStringCellValue().trim();
					log(arrayExcelData[i][j]);
				}

			}


			


			}catch(Exception e){
				 	log(e.getMessage());
			}
			return arrayExcelData;

		}
		
		public String[][] getSignUptFieldDetails(String sheetName) throws IOException {
			String[][] arrayExcelData = null;
			try{
			int lastRowNo;
			Sheet sheet;
			

			arrayExcelData = new String[3][6];
			
//	File src = new File(Constants.Excel_Data_Path);	
			
			FileInputStream fis = new FileInputStream(Constants.Excel_Data_Path);
			
			Workbook wb = new HSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
	//		lastRowNo = sheet.getLastRowNum();
			for(int i=0; i<=2; i++){
				Row  row = sheet.getRow(i);
				for (int j=0; j <=5; j++) {
					
					//arrayExcelData[i][j-1] =row.getCell(0).getStringCellValue().trim();
					arrayExcelData[i][j]=row.getCell(j).getStringCellValue().trim();
					log(arrayExcelData[i][j]);
				}

			}


			


			}catch(Exception e){
				 	log(e.getMessage());
			}
			return arrayExcelData;

		}
		
	
		
	   
	  //This method is to write in the Excel cell, Row num and Col num are the parameters
	    
		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

   			try{

      			Row  = ExcelWSheet.getRow(RowNum);

				Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

				if (Cell == null) {

					Cell = Row.createCell(ColNum);

					Cell.setCellValue(Result);

					} else {

						Cell.setCellValue(Result);

					}

      // Constant variables Test Data path and Test Data file name

      				FileOutputStream fileOut = new FileOutputStream("Constant.Path_TestData + Constant.File_TestData");

      				ExcelWBook.write(fileOut);

      				fileOut.flush();

						fileOut.close();

					}catch(Exception e){

						throw (e);

				}

			}



		public Object[][] getLoginFieldDetails(String sheetName) {
			// TODO Auto-generated method stub
			String[][] arrayExcelData = null;
			try{
			int lastRowNo;
			Sheet sheet;
			

			arrayExcelData = new String[3][2];
			
//	File src = new File(Constants.Excel_Data_Path);	
			
			FileInputStream fis = new FileInputStream(Constants.Excel_Data_Path);
			
			Workbook wb = new HSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
	//		lastRowNo = sheet.getLastRowNum();
			for(int i=0; i<=2; i++){
				Row  row = sheet.getRow(i);
				for (int j=0; j <=1; j++) {
					
					//arrayExcelData[i][j-1] =row.getCell(0).getStringCellValue().trim();
					arrayExcelData[i][j]=row.getCell(j).getStringCellValue().trim();
					log(arrayExcelData[i][j]);
				}

			}


			


			}catch(Exception e){
				 	log(e.getMessage());
			}
			return arrayExcelData;
		}

}

