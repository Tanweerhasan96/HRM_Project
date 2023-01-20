package com.hrm.generic;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.genericUtility.ExcelUtility;
import com.hrm.genericUtility.FileUtilty;
import com.hrm.genericUtility.JavaUtility;
import com.hrm.genericUtility.WebDriverUtility;

public class EditEmployee {

	public static void main(String[] args) throws Throwable
	{
		String expectedText="update Successfully!!!";
		ExcelUtility excel = new ExcelUtility();
		FileUtilty fu=new FileUtilty();
		JavaUtility jv=new JavaUtility();
		WebDriverUtility wb = new WebDriverUtility();

		//step1: Get common data
		String URL = fu.readDataFromPropertyFile("url");
		String email = fu.readDataFromPropertyFile("hrheademail");
		String pwd = fu.readDataFromPropertyFile("hrheadpwd");
		 
		//Step2: launch the browser
		
		WebDriver driver=new ChromeDriver();
		wb.maximizeWindow(driver);
		driver.get(URL);
	    wb.waitForPageToLoad(driver);
	    
	    //Login to app
	    driver.findElement(By.name("hr_email")).sendKeys(email);
	    driver.findElement(By.name("hr_password")).sendKeys(pwd);
	    WebElement hrtype = driver.findElement(By.id("hr_type"));
	    wb.select(hrtype,"→ HR Head");
	    driver.findElement(By.name("login_hr")).click();
	    wb.switchToAlertWindowAndAccept(driver);
	    driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();
	    driver.findElement(By.xpath("(//i[@class='far fa-circle nav-icon'])[3]")).click();
	    Thread.sleep(5000);
	    String firstname = excel.getDataFromExcel("EmployeeDetails",1,1);
	    driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(firstname);
	    driver.findElement(By.xpath("//td[@class='sorting_1']")).click();
	    JavascriptExecutor j=(JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0,300)");
	    driver.findElement(By.xpath("(//i[@class='fa fa-edit'])[2]")).click();
	    WebElement middleName = driver.findElement(By.xpath("(//input[@name='employee_middlename'])[5]"));
	    middleName.click();
	    String middle = excel.getDataFromExcel("EmployeeDetails",1,2);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_A);
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    middleName.sendKeys(middle);
	    
	   String abs = fu.fileUploadAbsolute();
	   driver.findElement(By.xpath("(//input[@name='employee_file201'])[5]")).sendKeys(abs);
	   String ab = fu.fileUploadAbsolute();
	   driver.findElement(By.xpath("(//input[@name='employee_image'])[5]")).sendKeys(ab);
	   
	   WebElement element = driver.findElement(By.xpath("(//select[@name='employee_department'])[5]"));
	 // WebElement value = driver.findElement(By.xpath("(//option[.='Credit Department'])[5]"));
	   wb.select(element,3);
	   
	   driver.findElement(By.xpath("(//button[@name='edit_emplo'])[4]")).click();
	   String actualText = wb.getTextAlert(driver);
	   if(expectedText.equalsIgnoreCase(actualText))
		   System.out.println("Edit Successfully!!!");
	   else
		   System.out.println("Not Edited!!!");
	   wb.switchToAlertWindowAndAccept(driver);
	   
	   driver.close();
	   
	   
	   
	   
	   
	   
	    
	   /** driver.findElement(By.xpath("(//i[@class='fas fa-angle-left right'])[3]")).click();
	    driver.findElement(By.xpath("(//i[@class='far fa-circle nav-icon'])[3]")).click();
	    Thread.sleep(5000);
	   // driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(orgName);
	    
	    List<WebElement> listdName = driver.findElements(By.xpath("//td[.='Tanweer']"));
	    int count = listdName.size();
	    //System.out.println(count);
	    for(int i=0;i<count;i++)
	    {
	    	String actualName = listdName.get(i).getText();
	  //  	if(actualName.equalsIgnoreCase(orgName))
	    	{
	    		System.out.println("Employee is present");
	    	}
	    	else {
	    		System.out.println("Employee name is invalid");
	    	}	
	    }
	    driver.findElement(By.xpath("(//td[@class='sorting_1'])[1]")).click();
	    JavascriptExecutor j=(JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0,300)");
	    driver.findElement(By.xpath("//span[@class='dtr-data']/child::i[@class='fa fa-edit']")).click();
	    WebDriverWait wait=new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='form-group']/child::input[@value='Tanweer'])[1]")));
	    WebElement tan = driver.findElement(By.xpath("(//div[@class='form-group']/child::input[@value='Tanweer'])[1]"));
	    tan.click();
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_A);
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    tan.sendKeys(orgName1);
	    
	    WebElement has = driver.findElement(By.xpath("(//div[@class='form-group']/child::input[@value='Hasan'])[1]"));
	    has.click();
	    
	    Robot r1 = new Robot();
	    r1.keyPress(KeyEvent.VK_CONTROL);
	    r1.keyPress(KeyEvent.VK_A);
	    r1.keyRelease(KeyEvent.VK_CONTROL);
	    has.sendKeys(orgName2);
	    
	   WebElement lastn = driver.findElement(By.xpath("(//div[@class='form-group']/child::input[@value='Buddy'])[1]"));
	   lastn.click();
	   Robot r2 = new Robot();
	   r2.keyPress(KeyEvent.VK_CONTROL);
	   r2.keyPress(KeyEvent.VK_A);
	   r2.keyRelease(KeyEvent.VK_CONTROL);
	   lastn.sendKeys(lastname);
	   
	  WebElement position = driver.findElement(By.xpath("(//div[@class='form-group']/child::input[@value='Hr Head'])[1]"));
	  position.click();
	 Robot r3 = new Robot();
	 r3.keyPress(KeyEvent.VK_CONTROL);
	 r3.keyPress(KeyEvent.VK_A);
	 r3.keyRelease(KeyEvent.VK_CONTROL);
	 position.sendKeys(pos);
	 
	 WebElement contact = driver.findElement(By.xpath("(//div[@class='form-group']/child::input[@value='84569039710'])[1]"));
	 contact.clear();
	 Robot r4 = new Robot();
	 r4.keyPress(KeyEvent.VK_CONTROL);
	 r4.keyPress(KeyEvent.VK_A);
	 r4.keyRelease(KeyEvent.VK_CONTROL);
	 contact.sendKeys("78456670981");
	 
	//JavascriptExecutor u=(JavascriptExecutor) driver;
    //u.executeScript("window.scrollBy(0,300)");
    //driver.findElement(By.xpath("(//input[@name='employee_file201'])[6] ")).click();defect occur
	 
	 File f = new File("./src/main/resources/Naukri SIngle page Resume.pdf.docx");
	 String absolute = f.getAbsolutePath();
	 driver.findElement(By.xpath("((//input[@name='employee_file201'])[9]")).sendKeys(absolute);
	 
	/** File f = new File("./src/main/resources/LRM_EXPORT_20180307_234047.jpg");
	 String absolute1 = f.getAbsolutePath();
	 driver.findElement(By.xpath("((//input[@name='employee_file201'])[23]")).sendKeys(absolute1);
	 
	 driver.findElement(By.xpath("//button[@name='edit_emplo']")).click();//defect occur
	 **/
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  /* ArrayList<String> list = new ArrayList<String>();
	   list.a
	   add("employee_companyid");
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
	   
	   for(int i=0;i<cell;i++)
	   {
		  
		   String value = sh.getRow(1).getCell(i).getStringCellValue();
		   driver.findElement(By.name(list.get(i))).sendKeys(value);
	   }
	   //upload file softcopy
	  File f = new File("./src/main/resources/Automation@tanweerfresher.docx");
	  String abs = f.getAbsolutePath();
	  driver.findElement(By.xpath("(//input[@name='employee_file201'])[1]")).sendKeys(abs);
	  
	  //upload image
	 File img = new File("./src/main/resources/LRM_EXPORT_20180307_234047.jpg");
	 String a = img.getAbsolutePath();
	 driver.findElement(By.xpath("(//input[@name='employee_image'])[1]")).sendKeys(a);
	 driver.findElement(By.xpath("//button[.='Save']")).click();
	 Alert al = driver.switchTo().alert();
	 String actual_Res = al.getText();
	 if(actual_Res.contains(expected_res))
	 {
		 System.out.println("Employee created successfully");
	 }
	 else
	 {
		 System.out.println("Employee not created successfully");
	 }
	 al.accept();
	 String orgName = sh.getRow(1).getCell(1).getStringCellValue();
	 driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(orgName);
	 String type="Tanweer";
	 List<WebElement> actualName = driver.findElements(By.xpath("(//td[.='Tanweer'])"));
	 int count=0;
	 for(int i=0;i< actualName.size();i++)
	 {
		 String employeename=actualName.get(i).getText();
		 if(employeename.equalsIgnoreCase(type))
		 {
			 count++;
			 System.out.println("employee created by hr head");
		 }
	 }
	 if(count==0)
	 {
		 System.out.println("employee is not  created by hr head");
		 System.out.println("Number of Employee :"+count);
	 }
	 */
	 

	}

}
