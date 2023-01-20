package com.hrm.generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.hrm.genericUtility.DatabaseUtility;
import com.hrm.genericUtility.ExcelUtility;
import com.hrm.genericUtility.FileUtilty;
import com.hrm.genericUtility.IPathConstants;
import com.hrm.genericUtility.JavaUtility;
import com.hrm.genericUtility.WebDriverUtility;

public class CreateEmployeeHrHead {
 

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver;
		String expected_res="Insert Successfully!!!";

		JavaUtility jv = new JavaUtility();
		WebDriverUtility wd=new WebDriverUtility();
		FileUtilty fu = new FileUtilty();
		ExcelUtility excel = new ExcelUtility();
		DatabaseUtility db = new DatabaseUtility();
		
	     //step1: Get common data
		
		String URL = fu.readDataFromPropertyFile("url");
		String Username = fu.readDataFromPropertyFile("hrheademail");
		String password = fu.readDataFromPropertyFile("hrheadpwd");
		//String URL = p.getProperty("url");
		//String email = p.getProperty("hrheademail");
		//String pwd = p.getProperty("hrheadpwd");
		 
		//step 2:Launching the browser
		
		driver=new ChromeDriver();
		wd.maximizeWindow(driver);
		driver.get(URL);
		wd.waitForPageToLoad(driver);
	    
	  //step 3: Login to app
		
	    driver.findElement(By.name("hr_email")).sendKeys(Username);
	    driver.findElement(By.name("hr_password")).sendKeys(password);
	    
	    WebElement hrtype = driver.findElement(By.id("hr_type"));
	    //Select s=new Select(hrtype);
	    // s.selectByValue("HR Head");
	    wd.select(hrtype,"→ HR Head");
	    
	    driver.findElement(By.name("login_hr")).click();
	    
	    //driver.switchTo().alert().accept();
	    wd.switchToAlertWindowAndAccept(driver);
	    
	    driver.findElement(By.xpath("(//i[@class='fas fa-angle-left right'])[3]")).click();
	    driver.findElement(By.xpath("(//i[@class='far fa-circle nav-icon'])[3]")).click();
	    driver.findElement(By.xpath("//h3[@class='card-title']")).click();
	    
	   ArrayList<String> list = new ArrayList<String>();
	   list.add("employee_companyid");
	   list.add("employee_firstname");
	   list.add("employee_lastname");
	   list.add("employee_middlename");
	   list.add("branches_datefrom");
	   list.add("branches_recentdate");
	   list.add("employee_department");
	   list.add("employee_branches");
	   list.add("employee_position");
	   list.add("employee_contact");
	   list.add("employee_sss");
	   list.add("employee_tin");
	   list.add("employee_hdmf_pagibig");
	   list.add("employee_gsis");
	   
	   for(int i=0;i<list.size();i++)
	   {
		   excel.setDataExcel("EmployeeDetails",0, i,list.get(i));
	   }
	   excel.getList(driver, "EmployeeDetails", 1);
	   
	  File f = new File(IPathConstants.Resume);
	  String absolute = f.getAbsolutePath();
	  driver.findElement(By.xpath("(//input[@name='employee_file201'])[1]")).sendKeys(absolute);
	  
	  File f1 = new File(IPathConstants.profilePic);
	  String abs = f1.getAbsolutePath();
	  driver.findElement(By.xpath("(//input[@name='employee_image'])[1]")).sendKeys(abs);
	  
	  driver.findElement(By.xpath("//button[.='Save']")).click();
	  String actual_res = wd.getTextAlert(driver);
	  if(actual_res.equalsIgnoreCase(expected_res))
	  {
		  System.out.println("Add Employee Successfully!!!");
	  }
	  else
	  {
		  System.out.println("Add Employee fAIL!!!");
	  }
	  wd.switchToAlertWindowAndAccept(driver);
	  driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys("Tanweer");
	  
	  driver.close();
	  
	  
	   
	}
}
