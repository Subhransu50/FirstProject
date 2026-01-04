package com.org.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static String readFile()
	{
		String value=null;
		
		try
		{
			File f=new File("Give file path");
			FileInputStream fis=new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			for(int i=0;i<wb.getNumberOfSheets();i++)
			{
				XSSFSheet sheet=wb.getSheetAt(i);
				for(int j=0;j<sheet.getPhysicalNumberOfRows();j++)
				{
					XSSFRow row=sheet.getRow(j);
					for(int k=0;k<row.getPhysicalNumberOfCells();k++)
					{
						value=row.getCell(k).getStringCellValue();
					}
				}
				
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return value;
	}
}
