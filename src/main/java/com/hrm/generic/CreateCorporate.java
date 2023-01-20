package com.hrm.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.genericUtility.DatabaseUtility;
import com.hrm.genericUtility.ExcelUtility;
import com.hrm.genericUtility.FileUtilty;
import com.hrm.genericUtility.JavaUtility;
import com.hrm.genericUtility.WebDriverUtility;

public class CreateCorporate {

	public static void main(String[] args) throws Throwable 
	{
		String expected_res="Insert Successfully!!!";
		
		//step 1:Generic classes
        JavaUtility jv = new JavaUtility();
		WebDriverUtility wd=new WebDriverUtility();
		FileUtilty fu = new FileUtilty();
		ExcelUtility excel = new ExcelUtility();
		DatabaseUtility db = new DatabaseUtility();
		
	    //step 2: Get common data
		String URL = fu.readDataFromPropertyFile("url");
		String Username = fu.readDataFromPropertyFile("hrheademail");
		String password = fu.readDataFromPropertyFile("hrheadpwd");
		
		//step 3:Launching the browser
		
		WebDriver driver=new ChromeDriver();
		wd.maximizeWindow(driver);
		driver.get(URL);
		wd.waitForPageToLoad(driver);
	    
	    //step 3: Login to app
		driver.findElement(By.name("hr_email")).sendKeys(Username);
	    driver.findElement(By.name("hr_password")).sendKeys(password);
	    WebElement hrtype = driver.findElement(By.id("hr_type"));
	    wd.select(hrtype,"→ HR Head");
	    driver.findElement(By.name("login_hr")).click();
	    
	    //step 4:Handle popup
	    //driver.switchTo().alert().accept();
	    wd.switchToAlertWindowAndAccept(driver);
	    
	    driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
	    driver.findElement(By.xpath("(//i[@class='far fa-circle nav-icon'])[1]")).click();
	    driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
	    
	    //step 5:get data from excel
	   String corporate = excel.getDataFromExcel("corporate", 1, 0);
	   driver.findElement(By.xpath("(//input[@name='corporate_name'])[1]")).sendKeys(corporate);
	   driver.findElement(By.xpath("//button[@name='corp']")).click();
	   
	  String actualRes = wd.getTextAlert(driver);
	  if(expected_res.equalsIgnoreCase(actualRes))
	  {
		  System.out.println("Add Corporate successfull!!!");
	  }
	  else
	  {
		  System.out.println("Fail");
	  }
	  wd.switchToAlertWindowAndAccept(driver);
	  driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(corporate);

	 List<WebElement> corporatelist = driver.findElements(By.xpath("//td[.='"+corporate+"']"));
	 int count=0;
	 for(int i=0;i<corporatelist.size();i++)
	 {
		 String actualName = corporatelist.get(i).getText();
		 count++;
	 }
	 if(count>0) {
		 System.out.println(corporate+" is Present");
	     System.out.println("Number of "+corporate+" is "+count);
	 }
	  else
	     System.out.println(corporate+" is not Presesnt");
	  driver.close();   
	}
}
