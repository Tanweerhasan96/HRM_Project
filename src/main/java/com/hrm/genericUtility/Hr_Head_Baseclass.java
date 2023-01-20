package com.hrm.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.hrm.ObjectRepo.LoginPage;
import com.hrm.ObjectRepo.SignOutPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.hrm.genericUtility.ListenerImp_Hr_Head.class)
public class Hr_Head_Baseclass
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtilty fLib=new FileUtilty();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	@BeforeSuite
	public void connectToDB() throws Throwable
	{
		//dLib.connectToDb();
		System.out.println("--Connect to Db--");
	}
	//@org.testng.annotations.Parameters("BROWSER")
	@BeforeClass
	public void openBrowser() throws Throwable
	{	
		String URL = fLib.readDataFromPropertyFile("url");
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		driver=	new ChromeDriver();
		System.out.println("--Launch the chrome browser--");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("--Launch the firefox browser--");
		}
		else
		{
			System.out.println("Invalid Browser");
		}
	    sdriver=driver;
		
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitForPageToLoad(driver);
		
	}
	@BeforeMethod
	public void loginTOApp() throws Throwable 
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.HrHeadLogin(wLib, driver);
		System.out.println("--Login to the App--");
	}
	@AfterMethod
	public void logoutApp()
	{
		
		SignOutPage signout=new SignOutPage(driver);
		signout.logout(wLib, driver);
		
		System.out.println("--logout from the App--");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		System.out.println("--Disconnect to Database");
	}
	@AfterSuite
	public void disconnetToDb() {
		System.out.println("--Disconnect to Database--");
	}

}
