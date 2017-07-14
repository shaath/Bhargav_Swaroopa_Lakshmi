package com.OrgHRM.LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Methods_EG 
{
	public static String sc_Path="F:\\LiveProject\\HRMS_OrangeHRM\\src\\com\\OrgHRM\\Screenshots";
	public static WebDriver driver;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow r;
	public static XSSFCell c;
	
	public int sum(int a, int b)
	{
		int c=a+b;
		return c;
	}
	
	public void Screenshot(String name) throws IOException
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(sc_Path+"\\"+name+".png"));
	}
	
	public void launch_Br(String br)
	{
		if (br.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if (br.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "F:\\LiveProject\\HRMS_OrangeHRM\\Jars\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\LiveProject\\HRMS_OrangeHRM\\Jars\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
	}
	
	public void send_Text(String Loc, String value,String text)
	{
		if (Loc.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(value)).sendKeys(text);
		}
		else if (Loc.equalsIgnoreCase("name")) 
		{
			driver.findElement(By.name(value)).sendKeys(text);
		}
		else if (Loc.equalsIgnoreCase("classname"))
		{
			driver.findElement(By.className(value)).sendKeys(text);
		}
		else if (Loc.equalsIgnoreCase("tagname"))
		{
			driver.findElement(By.tagName(value)).sendKeys(text);
		}
		else if (Loc.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(value)).sendKeys(text);
		}
		else if (Loc.equalsIgnoreCase("cssselector"))
		{
			driver.findElement(By.cssSelector(value)).sendKeys(text);
		}
		
	}	
		
	public void click(String Loc, String value)
	{
		if (Loc.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(value)).click();
		}
		else if (Loc.equalsIgnoreCase("name")) 
		{
			driver.findElement(By.name(value)).click();
		}
		else if (Loc.equalsIgnoreCase("classname"))
		{
			driver.findElement(By.className(value)).click();
		}
		else if (Loc.equalsIgnoreCase("tagname"))
		{
			driver.findElement(By.tagName(value)).click();
		}
		else if (Loc.equalsIgnoreCase("linktext")) 
		{
			driver.findElement(By.linkText(value)).click();
		}
		else if (Loc.equalsIgnoreCase("Partiallinktext"))
		{
			driver.findElement(By.linkText(value)).click();
		}
		else if (Loc.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(value)).click();
		}
		else if (Loc.equalsIgnoreCase("cssselector"))
		{
			driver.findElement(By.cssSelector(value)).click();
		}
	}
	
	public int excel_RowCnt(String xl_path,String sht_Name) throws IOException
	{
		fi=new FileInputStream(xl_path);
		
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sht_Name);
		int rc=ws.getLastRowNum();
		return rc;
	}
	
	
	

}
