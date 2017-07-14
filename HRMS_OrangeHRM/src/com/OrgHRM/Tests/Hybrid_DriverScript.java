package com.OrgHRM.Tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.OrgHRM.Utilities.Constants;

public class Hybrid_DriverScript extends Constants
{
	public static void main(String[] args) throws IOException
	{
		String res=null;
		FileInputStream Hybrid_fi=new FileInputStream(Hybrid_xlpath);
		
		XSSFWorkbook Hybrid_WB=new XSSFWorkbook(Hybrid_fi);
		
		XSSFSheet TC_Sht=Hybrid_WB.getSheet("TestCase");
		XSSFSheet TS_Sht=Hybrid_WB.getSheet("Teststeps");
		XSSFSheet T_Data=Hybrid_WB.getSheet("Key_Data");
		XSSFSheet Emp_Data=Hybrid_WB.getSheet("EmpReg");
		
		int Tc_Rows_Cnt=TC_Sht.getLastRowNum();
		int Ts_Rows_Cnt=TS_Sht.getLastRowNum();
		int Emp_Rows_Cnt=Emp_Data.getLastRowNum();
		
		for (int i = 1; i <= Tc_Rows_Cnt; i++) 
		{
			TC_Sht.getRow(i).createCell(3);
			String Tc_Exe=TC_Sht.getRow(i).getCell(2).getStringCellValue();
			if (Tc_Exe.equalsIgnoreCase("Y"))
			{
				String TC_TcId=TC_Sht.getRow(i).getCell(0).getStringCellValue();
				
				for (int j = 1; j <= Ts_Rows_Cnt; j++) 
				{
					String TS_TcId=TS_Sht.getRow(j).getCell(0).getStringCellValue();
					
					if (TC_TcId.equalsIgnoreCase(TS_TcId))
					{
						String TS_Key=TS_Sht.getRow(j).getCell(3).getStringCellValue();
//						System.out.println(TS_Key);
						
						switch (TS_Key) 
						{
						case "Launch":
							String br=T_Data.getRow(1).getCell(0).getStringCellValue();
							String url=T_Data.getRow(1).getCell(1).getStringCellValue();
							res=om.org_Launch(br, url);
							break;
						case "login":
							String u=T_Data.getRow(1).getCell(2).getStringCellValue();
							String p=T_Data.getRow(1).getCell(3).getStringCellValue();
							res=om.org_Login(u, p);
							break;
						case "logout":
							res=om.org_Logout();
							om.org_close();
							break;
						case "Empreg":
							for (int k = 1; k <= Emp_Rows_Cnt; k++)
							{
								String f=Emp_Data.getRow(k).getCell(0).getStringCellValue();
								String l=Emp_Data.getRow(k).getCell(1).getStringCellValue();
								String eId=Emp_Data.getRow(k).getCell(2).getStringCellValue();
								res=om.org_Empreg(f, l, eId);
								Emp_Data.getRow(k).createCell(3).setCellValue(res);
							}
							
							break;
						case "Usereg":
							String ename=T_Data.getRow(1).getCell(7).getStringCellValue();
							String uname=T_Data.getRow(1).getCell(8).getStringCellValue();
							String pswd=T_Data.getRow(1).getCell(9).getStringCellValue();
							String cpswd=T_Data.getRow(1).getCell(10).getStringCellValue();
							res=om.org_UserReg(ename, uname, pswd, cpswd);
							break;
						case "Ulogin":	
							String un=T_Data.getRow(1).getCell(8).getStringCellValue();
							String ps=T_Data.getRow(1).getCell(9).getStringCellValue();
							res=om.org_Login(un, ps);
							break;
						default:
							System.out.println("Please select a proper keyword");
							break;
						}
						//Updating the result in test steps sheet
						TS_Sht.getRow(j).createCell(4).setCellValue(res);
						//Updating the results in test case sheet
						if (!TC_Sht.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Fail"))
						{
							TC_Sht.getRow(i).getCell(3).setCellValue(res);
						}
						
					}
				}
			}
			else
			{
				TC_Sht.getRow(i).getCell(3).setCellValue("BLOCKED");
			}
		}
		
		FileOutputStream fo=new FileOutputStream(Hybrid_xlout);
		Hybrid_WB.write(fo);
		Hybrid_WB.close();

	}

}
