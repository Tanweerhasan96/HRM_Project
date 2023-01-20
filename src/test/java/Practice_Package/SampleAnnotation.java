package Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleAnnotation 
{
	@BeforeClass
	public void openBrowswer()
	{
		System.out.println("---Launching the browser---");
	}
	@BeforeMethod
	public void loginApp() {
		System.out.println("---login to App---");
	}
	@Test(priority=1)
	public void addEmployee() {
		System.out.println("---Add Employee details---");
	}
	@Test
	public void editEmployee() {
		System.out.println("---Edit Employee---");
		
	}
	@AfterMethod
	public void logout()
	{
		System.out.println("---Logout from App---");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("---Close the Browser---");
	}

}
