package com.hrm.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.genericUtility.DatabaseUtility;
import com.hrm.genericUtility.ExcelUtility;
import com.hrm.genericUtility.FileUtilty;
import com.hrm.genericUtility.JavaUtility;
import com.hrm.genericUtility.WebDriverUtility;

public class DeleteEmployee 
{

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
		
		 
		//step 2:Launching the browser
		
		driver=new ChromeDriver();
		wd.maximizeWindow(driver);
		driver.get(URL);
		wd.waitForPageToLoad(driver);
	    
	  //step 3: Login to app
		
	    driver.findElement(By.name("hr_email")).sendKeys(Username);
	    driver.findElement(By.name("hr_password")).sendKeys(password);
	    WebElement hrtype = driver.findElement(By.id("hr_type"));
	    wd.select(hrtype,"→ HR Head");
	    driver.findElement(By.name("login_hr")).click();
	    
	    wd.switchToAlertWindowAndAccept(driver);
	    driver.findElement(By.xpath("(//i[@class='fas fa-angle-left right'])[3]")).click();
	    driver.findElement(By.xpath("(//i[@class='far fa-circle nav-icon'])[3]")).click();
	    String name = excel.getDataFromExcel("EmployeeDetails",1,1);
	    driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(name);
	    driver.findElement(By.xpath("//td[@class='sorting_1']")).click();
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("window.scrollby(0,300)");
	    driver.findElement(By.xpath("(//i[@class='fa fa-trash'])[2]")).click();
	}

}
