package testProject.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.WorkbookParser;

import org.junit.Test;

public class ReadExcel {

	@Test
	public void dataFromExcel() {

		// file=Name variable

		String fileName = "C:\\Users\\IBM_ADMIN\\git\\PracticeProjects\\Test\\src\\main\\resources\\TestData\\DataExcel.xls";

		// creating file object for excel

		File file = new File(fileName);

		try {
			// using jxl to read excel, below we are sending file object to
			// workbook class

			Workbook wb = Workbook.getWorkbook(file);

			String[] sheetNames = wb.getSheetNames();

			HashMap<String, HashMap<String, ArrayList<String>>> excelData = new HashMap<String, HashMap<String, ArrayList<String>>>();
			
			for (String sheetName : sheetNames) {

				Sheet sheet = wb.getSheet(sheetName);

				int rows = sheet.getRows();
				int cols = sheet.getColumns();
				// Store data of sheet in this hashMap
				HashMap<String, ArrayList<String>> sheetData = new HashMap<String, ArrayList<String>>();

				ArrayList<String> colNames = new ArrayList<String>();
				// store column Names in a list
				for (int i = 0; i < cols; i++) {
					Cell cell = sheet.getCell(i, 0);
					colNames.add(cell.getContents());
				}

				//For loop to read data of sheets
				for(int i=0;i<cols;i++){
					ArrayList<String> rowsData = new ArrayList<String>();
					for(int j=1; j<rows;j++){
						
						Cell cell = sheet.getCell(i, j);
						rowsData.add(cell.getContents());
						
					}
					sheetData.put(colNames.get(i), rowsData);
					
				}
				
				excelData.put(sheetName, sheetData);
				

			}
			System.out.println(excelData);

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
