package com.OrgHRM.LibraryFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class OrgHrm_Master extends Methods_EG
{
	public static FileInputStream fi;
	public static Properties pr;
//	public static WebDriver driver;
	public static String expval, actval;
	public static String pr_Path="F:\\LiveProject\\HRMS_OrangeHRM\\src\\com\\OrgHRM\\Properties\\OrgHRM.properties";
	/* Projectname	:OrangeHRM
	 * Module		:Admin
	 * MethodName	:org_Launch
	 * Arguments	:url
	 * Return Type	:String
	 * Author		:XXXXXXX(TesterName)
	 * Date			:30/6/2017
	 * Description	:It Launches the orangehrm Application
	 */
	public String org_Launch(String br,String url) throws IOException
	{
		fi=new FileInputStream(pr_Path);
		pr=new Properties();
		pr.load(fi);
		expval="LOGIN";
//		driver=new FirefoxDriver();
		launch_Br(br);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		actval=driver.findElement(By.id(pr.getProperty("login"))).getAttribute("value");
		if (expval.equalsIgnoreCase(actval)) 
		{
			return "Pass";
		}
		else
		{
			Screenshot("org_Launch");
			return "Fail";
		}
	}
	/* Projectname	:OrangeHRM
	 * Module		:Admin
	 * MethodName	:org_Login
	 * Arguments	:lp_User, lp_pswd
	 * Return Type	:String
	 * Author		:XXXXXXX(TesterName)
	 * Date			:7/6/2017
	 * Description	:It will do login
	 */
	public String org_Login(String lp_User, String lp_pswd) throws IOException
	{
		expval="welcome";
//		driver.findElement(By.id(pr.getProperty("username"))).sendKeys(lp_User);
//		driver.findElement(By.id(pr.getProperty("password"))).sendKeys(lp_pswd);
//		driver.findElement(By.id(pr.getProperty("login"))).click();
		
		send_Text("id", pr.getProperty("username"), lp_User);
		send_Text("id", pr.getProperty("password"), lp_pswd);
		click("id", pr.getProperty("login"));
		
		actval=driver.findElement(By.id(pr.getProperty("welcome"))).getAttribute("id");
		if (expval.equalsIgnoreCase(actval)) 
		{
			return "Pass";
		}
		else
		{
			Screenshot("org_Login");
			return "Fail";
		}
		
	}
	/* Projectname	:OrangeHRM
	 * Module		:Admin
	 * MethodName	:org_Logout
	 * Arguments	:NA
	 * Return Type	:String
	 * Author		:XXXXXXX(TesterName)
	 * Date			:7/6/2017
	 * Description	:It will do logout
	 */
	public String org_Logout()
	{
		expval="LOGIN";
		Sleeper.sleepTightInSeconds(3);
		click("id", pr.getProperty("welcome"));
		click("linktext", "Logout");
		actval=driver.findElement(By.id(pr.getProperty("login"))).getAttribute("value");
		if (expval.equalsIgnoreCase(actval)) 
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	/* Projectname	:OrangeHRM
	 * Module		:Admin
	 * MethodName	:org_Close
	 * Arguments	:NA
	 * Return Type	:NA
	 * Author		:XXXXXXX(TesterName)
	 * Date			:7/6/2017
	 * Description	:It will close the browser
	 */
	public void org_close()
	{
		driver.close();
	}
	/* Projectname	:OrangeHRM
	 * Module		:Admin
	 * MethodName	:org_EmpReg
	 * Arguments	:emp_FN,emp_LN,emp_ID
	 * Return Type	:String
	 * Author		:XXXXXXX(TesterName)
	 * Date			:7/6/2017
	 * Description	:It will create an employee
	 */
	public String org_Empreg(String emp_FN,String emp_LN,String emp_ID)
	{
		expval=emp_FN+" "+emp_LN;
		
		click("linktext", "PIM");
		click("linktext", "Add Employee");
		
		send_Text("id", "firstName", emp_FN);
		send_Text("id", "lastName", emp_LN);
		driver.findElement(By.id("employeeId")).clear();
		send_Text("id", "employeeId", emp_ID);
		click("id", "btnSave");
		
		actval=driver.findElement(By.xpath(".//*[@id='profile-pic']/h1")).getText();
		if (expval.equalsIgnoreCase(actval)) 
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	/* Projectname	:OrangeHRM
	 * Module		:Admin
	 * MethodName	:org_Userreg
	 * Arguments	:User_Ename, User_UN, User_Pswd,User_CPswd
	 * Return Type	:String
	 * Author		:XXXXXXX(TesterName)
	 * Date			:5/7/2017
	 * Description	:It will create User credentials for an employee
	 */
	public String org_UserReg(String User_Ename, String User_UN, String User_Pswd,String User_CPswd)
	{
		boolean flag=false;
		expval=User_UN;
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(User_Ename);
		driver.findElement(By.id("systemUser_userName")).sendKeys(User_UN);
		driver.findElement(By.id("systemUser_password")).sendKeys(User_Pswd);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(User_CPswd);
		driver.findElement(By.id("btnSave")).click();
		
		Sleeper.sleepTightInSeconds(3);
		
		List<WebElement> rows=driver.findElements(By.xpath(".//*[@id='resultTable']/tbody/tr"));
		for (int i = 0; i < rows.size(); i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			actval=cols.get(1).getText();
			if (expval.equalsIgnoreCase(actval)) 
			{
				flag=true;
				break;
			}
		}
		if (flag)
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
}
