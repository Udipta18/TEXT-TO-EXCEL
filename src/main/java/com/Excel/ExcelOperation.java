package com.Excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {

	public void print(List<Object> map) {

		String[] row_heading = { "Attribute", "entity", "datatype", "description" };

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet spreadsheet = workbook.createSheet("User Details ");
		spreadsheet.setColumnWidth(0, 6000);
		spreadsheet.setColumnWidth(1, 6000);
		spreadsheet.setColumnWidth(2, 6000);
		spreadsheet.setColumnWidth(3, 6000);
		Row headerRow = spreadsheet.createRow(0);
		
		
		//STYLE PURPOSE
		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		headerStyle.setFillPattern(FillPatternType.FINE_DOTS);

		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(true);
		headerStyle.setFont(font);

		// Creating header
		for (int i = 0; i < row_heading.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(row_heading[i]);
			cell.setCellStyle(headerStyle);
		}
		// Creating data rows for each user
		for (int i = 0; i < map.size(); i++) {
			Row dataRow = spreadsheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(map.get(i).getAttribute());
			dataRow.createCell(1).setCellValue(map.get(i).getEntity());
			dataRow.createCell(2).setCellValue(map.get(i).getDatatype());
			dataRow.createCell(3).setCellValue(map.get(i).getDescription());

		}

		// Write the workbook in file system
		FileOutputStream out;
		try {
			out = new FileOutputStream(new File("C:\\Users\\dasud\\Documents\\taFinal_2.xlsx"));

			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Write to excel sheet done  successfully...........");

	}

}
