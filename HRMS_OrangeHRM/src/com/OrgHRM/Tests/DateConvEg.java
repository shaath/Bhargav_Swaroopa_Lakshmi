package com.OrgHRM.Tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvEg {

	public static void main(String[] args)
	{
		DateFormat d=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
//		System.out.println(date);
//		System.out.println(d.format(date));
		String x=d.format(date);
		String date_time=((x.replace("/", "")).replace(" ", "")).replace(":", "");
		System.out.println(date_time);
	}

}
