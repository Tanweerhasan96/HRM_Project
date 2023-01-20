package com.hrm.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.genericUtility.ExcelUtility;
import com.hrm.genericUtility.FileUtilty;
import com.hrm.genericUtility.JavaUtility;
import com.hrm.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateBranch {

	public static void main(String[] args) throws Throwable 
	{
		String expected_Res = "Insert Successfully!!!";
		ExcelUtility excel = new ExcelUtility();
		FileUtilty fu=new FileUtilty();
		JavaUtility jv=new JavaUtility();
		WebDriverUtility wb = new WebDriverUtility();
		//Read common data
		String URL = fu.readDataFromPropertyFile("url");
		String email = fu.readDataFromPropertyFile("hrheademail");
		String pwd = fu.readDataFromPropertyFile("hrheadpwd");
		
		// Get data from excel
		String value = excel.getDataFromExcel("EmployeeDetails", 1, 7);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wb.maximizeWindow(driver);
		driver.get(URL);
		wb.waitForPageToLoad(driver);
		
		driver.findElement(By.xpath("//input[@name='hr_email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='hr_password']")).sendKeys(pwd);
		WebElement element = driver.findElement(By.xpath("//select[@id='hr_type']"));
		wb.select(element,"→ HR Head");
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		wb.switchToAlertWindowAndAccept(driver);
		
		driver.findElement(By.xpath("(//a[@class='nav-link'])[5]")).click();
		driver.findElement(By.xpath("//p[.='Add Braches']")).click();
		driver.findElement(By.xpath("//h3[@class='card-title']")).click();
		driver.findElement(By.xpath("(//input[@name='branches_name'])[1]")).sendKeys(value);
		driver.findElement(By.xpath("//button[@name='bran']")).click();
		String actual_Res = wb.getTextAlert(driver);
		if(expected_Res.equalsIgnoreCase(actual_Res))
			System.out.println("Branch Created Successfully!!!");
		else
			System.out.println("Branch not created!!!");
		
		wb.switchToAlertWindowAndAccept(driver);
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(value);
		List<WebElement> branchlist = driver.findElements(By.xpath("//td[.='"+value+"']"));
		int branchcount = branchlist.size();
		if(branchcount>0) {
		System.out.println(value+" is "+branchcount);
		}
		else
			System.out.println("zero");
		
		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();
		wb.switchToAlertWindowAndAccept(driver);
		
	}

}
