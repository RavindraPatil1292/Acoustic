package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Workbook oWb = null;
	private static Sheet sheet = null;
	private static Cell cell = null;

	public static void setExcelFile(String excelPath) throws IOException {
		try {
			FileInputStream fisExl = new FileInputStream(excelPath);
			if (excelPath.contains(".xlsx")) {
				oWb = new XSSFWorkbook(fisExl);
			} else if (excelPath.contains(".xls")) {
				oWb = new HSSFWorkbook(fisExl);
			}

		} catch (FileNotFoundException e) {
			throw (e);
		}

	}

	public static String getCellData(String sheetName, int row, int col) throws Exception {
		try {
			String cellValue = sheet.getRow(row).getCell(col).getStringCellValue();
			return cellValue;
		} catch (Exception e) {
		
			return "";
		}
	}

	public static void setCellData(int row, int col, String value, String filePath, String sheetName) {
		sheet = oWb.getSheet(sheetName);
		cell = sheet.getRow(row).getCell(col);
		cell.setCellValue(value);
		try {
			FileOutputStream fosExl = new FileOutputStream(filePath);
			oWb.write(fosExl);
			fosExl.flush();
			fosExl.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int getRowCount(String sheetName) {
		int rowCount = oWb.getSheet(sheetName).getLastRowNum();
		return rowCount + 1;
	}

	public static int getColumnCount(String sheetName) {
		return oWb.getSheet(sheetName).getRow(0).getLastCellNum();

	}

}
