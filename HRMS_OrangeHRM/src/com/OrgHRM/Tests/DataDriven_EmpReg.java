package com.OrgHRM.Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.OrgHRM.LibraryFiles.OrgHrm_Master;

public class DataDriven_EmpReg {

	public static void main(String[] args) throws IOException 
	{
		String xlpath="F:\\LiveProject\\HRMS_OrangeHRM\\src\\com\\OrgHRM\\TestData\\EmpReg.xlsx";
		String xlout="F:\\LiveProject\\HRMS_OrangeHRM\\src\\com\\OrgHRM\\Results\\EmpBColr.xlsx";
		
		OrgHrm_Master ohm=new OrgHrm_Master();
		
		FileInputStream fi=new FileInputStream(xlpath);
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("EmpRegData");
		
//		XSSFRow r=ws.getRow(4);
//		XSSFCell c=r.getCell(2);
//		
//		System.out.println(c.getStringCellValue());

		int rc=ws.getLastRowNum();
//		System.out.println(rc);
		ohm.org_Launch("firefox", "http://opensource.demo.orangehrmlive.com");
		ohm.org_Login("Admin", "admin");
		
		CellStyle style=wb.createCellStyle();
		
		
		for (int i = 1; i <= rc; i++) 
		{
			XSSFRow r=ws.getRow(i);
			
//			System.out.println(r.getLastCellNum());
			
			XSSFCell c=r.getCell(0);
			XSSFCell c1=r.getCell(1);
			XSSFCell c2=r.getCell(2);
			XSSFCell c3=r.createCell(3);
			
//			System.out.println(r.getLastCellNum());
			
			String f=c.getStringCellValue();
			String l=c1.getStringCellValue();
			String eId=c2.getStringCellValue();
			
			System.out.println(f+"-----"+l+"-------"+eId);
			String res=ohm.org_Empreg(f, l, eId);
			
			c3.setCellValue(res);
			if (res.equalsIgnoreCase("Pass")) 
			{
				style.setFillBackgroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			}
			else 
			{
				style.setFillBackgroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			}
			c3.setCellStyle(style);
			
		}
		FileOutputStream fo=new FileOutputStream(xlout);
		wb.write(fo);
		wb.close();
		
		ohm.org_Logout();
		ohm.org_close();
	}

}
