package com.OrgHRM.Tests;

import java.io.IOException;

import com.OrgHRM.LibraryFiles.OrgHrm_Master;

public class UserLoginTest {

	public static void main(String[] args) throws IOException 
	{
		OrgHrm_Master ohm=new OrgHrm_Master();
		
		String res=ohm.org_Launch("firefox", "http://opensource.demo.orangehrmlive.com");
		System.out.println("Application Launch "+res);

		res=ohm.org_Login("HarishP12345", "HarishP12345");
		System.out.println("Application Login "+res);
		
		res=ohm.org_Logout();
		System.out.println("Application logout "+res);
		
		ohm.org_close();
		System.out.println("Application Close Successfull");

	}

}
