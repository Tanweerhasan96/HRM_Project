package com.hrm.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.ObjectRepo.Hr_Head_EmpDashboard;
import com.hrm.ObjectRepo.Hr_Head_EmpDetails;
import com.hrm.ObjectRepo.HrHead_HomePage;
import com.hrm.ObjectRepo.LoginPage;
import com.hrm.genericUtility.FileUtilty;
import com.hrm.genericUtility.WebDriverUtility;

public class MainMethodHrHead {

	public static void main(String[] args) throws Throwable
	{
		FileUtilty fu=new FileUtilty();
		WebDriverUtility wd=new WebDriverUtility();
		String URL = fu.readDataFromPropertyFile("url");
		String expectedRes="Insert Successfully!!!";
		//Opening Browser
	    WebDriver driver = new ChromeDriver();
	    wd.maximizeWindow(driver);
		driver.get(URL);
		wd.waitForPageToLoad(driver);
		//login Page
		LoginPage lp=new LoginPage(driver);
		lp.HrHeadLogin(wd, driver);
		//HomePage
		HrHead_HomePage hp=new HrHead_HomePage(driver);
        hp.clickEmployee();
        //Dashboard Page
        Hr_Head_EmpDashboard clickAdd=new Hr_Head_EmpDashboard(driver);
        clickAdd.addEmployee();
        //Add Employee Details
        Hr_Head_EmpDetails addEmp=new Hr_Head_EmpDetails(driver);
    
        addEmp.addEmp(driver);
        addEmp.uploadFile(driver);
        String orgRes = wd.getTextAlert(driver);
        wd.switchToAlertWindowAndAccept(driver);
        if(expectedRes.equalsIgnoreCase(orgRes))
        {
        	System.out.println("Employee Created");
        }
        else
        {
        	System.out.println("Employee not Created");
        }
        driver.close();
		
	}

}
