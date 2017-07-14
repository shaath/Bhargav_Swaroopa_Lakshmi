package com.OrgHRM.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.OrgHRM.LibraryFiles.OrgHrm_Master;

public class Constants 
{
	public static DateFormat d=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static Date date=new Date();
	public static String x=d.format(date);
	public static String date_time=((x.replace("/", "")).replace(" ", "")).replace(":", "");
	public static OrgHrm_Master om=new OrgHrm_Master();
	public static String xlpath="F:\\LiveProject\\HRMS_OrangeHRM\\src\\com\\OrgHRM\\TestData\\Keyword.xlsx";
	public static String xlout="F:\\LiveProject\\HRMS_OrangeHRM\\src\\com\\OrgHRM\\Results\\keyRes1.xlsx";
	public static String Hybrid_xlpath="F:\\LiveProject\\HRMS_OrangeHRM\\src\\com\\OrgHRM\\TestData\\Hybrid.xlsx";
	public static String Hybrid_xlout="F:\\LiveProject\\HRMS_OrangeHRM\\src\\com\\OrgHRM\\Results\\HybridRes"+date_time+".xlsx";
}
