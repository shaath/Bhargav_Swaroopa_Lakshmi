package com.OrgHRM.Tests;

import java.io.IOException;

import com.OrgHRM.LibraryFiles.OrgHrm_Master;

public class TestSuiteEg {

	public static void main(String[] args) throws IOException 
	{
		OrgHrm_Master ohm=new OrgHrm_Master();
		//Login
		
		String res=ohm.org_Launch("firefox", "http://opensource.demo.orangehrmlive.com");
		System.out.println("Application Launch "+res);

		res=ohm.org_Login("Admin", "admin");
		System.out.println("Application Login "+res);
		
		res=ohm.org_Logout();
		System.out.println("Application logout "+res);
		
		ohm.org_close();
		System.out.println("Application Close Successfull");
		
		//Empreg
		
		res=ohm.org_Launch("firefox", "http://opensource.demo.orangehrmlive.com");
		System.out.println("Application Launch "+res);

		res=ohm.org_Login("Admin", "admin");
		System.out.println("Application Login "+res);
		
		res=ohm.org_Empreg("Sharath", "Chandra", "0101");
		System.out.println("Employee Registration "+res);
		
		res=ohm.org_Logout();
		System.out.println("Application logout "+res);
		
		ohm.org_close();
		System.out.println("Application Close Successfull");

		//Userreg
		
		res=ohm.org_Launch("firefox", "http://opensource.demo.orangehrmlive.com");
		System.out.println("Application Launch "+res);

		res=ohm.org_Login("Admin", "admin");
		System.out.println("Application Login "+res);
		
		res=ohm.org_UserReg("Sharath Chandra", "SharathChandara", "SharathChandara", "SharathChandara");
		System.out.println("User Registration "+res);
		
		res=ohm.org_Logout();
		System.out.println("Application logout "+res);
		
		ohm.org_close();
		System.out.println("Application Close Successfull");
		
		//UserLogin 
		res=ohm.org_Launch("firefox", "http://opensource.demo.orangehrmlive.com");
		System.out.println("Application Launch "+res);

		res=ohm.org_Login("SharathChandara", "SharathChandara");
		System.out.println("Application Login "+res);
		
		res=ohm.org_Logout();
		System.out.println("Application logout "+res);
		
		ohm.org_close();
		System.out.println("Application Close Successfull");

	}

}
