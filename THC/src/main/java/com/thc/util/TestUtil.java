package com.thc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

	public static long pageLoadTimeOut = 50;
	public static long impliciteWait = 10;
	

	public static Object[][] getTestData(String sheetName, String dataFilePath ) {
    
		Object[][] data = null;

		File file = new File(dataFilePath);
		FileInputStream fis;
		XSSFWorkbook workbook;
		XSSFSheet sheet = null;

		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     //  System.out.println("Total Rows = "+sheet.getLastRowNum() );
      // System.out.println("Total Coloumns = "+sheet.getRow(0).getLastCellNum()+","+sheet.getSheetName());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				//System.out.println(sheet.getRow(i + 1).getCell(j).toString());
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}	
}
