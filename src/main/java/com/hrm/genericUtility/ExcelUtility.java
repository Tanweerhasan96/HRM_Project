package com.hrm.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Its developed using Apache poi libraries,which is used to handle Microsoft Excel sheet
 * @author Tanweer
 *
 */

public class ExcelUtility {
	/**
	 * Its used to read data from excel based on below Arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		//Cell cel = row.getCell(cellNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * Its used to get the last used number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		wb.close();
		return rowcount;
	}
	/**
	 * Its used to set the data to particular cell
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
		
	public Map<String,String> getList(WebDriver driver,String sheetName,int keyCell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(keyCell);
		int count = row.getLastCellNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<count;i++)
		{
			String key = sheet.getRow(0).getCell(i).getStringCellValue();
			String value = sheet.getRow(1).getCell(i).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		return map;
	}
	public Object[] []readMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.dataProvider);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SheetName);
		int lastRow = sheet.getLastRowNum()+1
				;
		int lastCell=sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	

}
