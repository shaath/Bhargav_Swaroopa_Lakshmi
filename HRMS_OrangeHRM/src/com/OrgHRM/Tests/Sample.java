package com.OrgHRM.Tests;

import java.io.IOException;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.OrgHRM.LibraryFiles.Methods_EG;

public class Sample {

	public static void main(String[] args) throws IOException
	{
		Methods_EG mg=new Methods_EG();
		
//		int res=mg.sum(40, 60);
//		System.out.println(res);
		
		mg.launch_Br("chrome");
		mg.driver.get("http://primusbank.qedgetech.com");

//		mg.Screenshot("google");
		
		mg.send_Text("id", "txtuId", "Admin");
		mg.send_Text("id", "txtPword", "Admin");
		mg.click("id", "login");
		
		mg.click("xpath", ".//*[@id='Table_02']/tbody/tr/td[3]/a/img");
		
		mg.driver.close();
	}

}
