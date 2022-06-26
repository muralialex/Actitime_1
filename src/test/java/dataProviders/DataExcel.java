package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.BaseClass1;

public class DataExcel extends BaseClass1{
	
	@DataProvider (name="createTask")
	public static Object[][] registerData() throws InvalidFormatException, IOException   {
		System.out.println("registerData method");
	    sheet = wb.getSheetAt(0);
	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int columnCount= sheet.getRow(0).getPhysicalNumberOfCells();
	    System.out.println(rowCount + "========="+ columnCount);
	    String input[][]=new String[rowCount-1][columnCount];
	    for(int i = 1; i < rowCount; i++) {
	        row = sheet.getRow(i);
	            for(int j = 0; j < columnCount; j++) {
	                cell = row.getCell(j);
	                if(cell != null) {
	                	input[i-1][j] = cell.getStringCellValue();
	                }
	            }
	    }
		System.out.println("getting out from Data Provider registerData");
		return input;
	}
}

