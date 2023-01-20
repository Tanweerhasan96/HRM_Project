package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrHead_HomePage 
{
	//declaration
	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	private WebElement corporate;
	
	@FindBy(xpath="(//a[@class='nav-link'])[4]")
	private WebElement add_corporate;
	 
	@FindBy(xpath="(//a[@class='nav-link'])[5]")
	private WebElement branches;
	
	@FindBy(xpath="(//a[@class='nav-link'])[6]")
	private WebElement add_branch;
	
	@FindBy(xpath="(//a[@class='nav-link'])[7]")
	private WebElement employee;
	
	@FindBy(xpath="(//a[@class='nav-link'])[8]")
	private WebElement add_employee;
	
	@FindBy(xpath="(//a[@class='nav-link'])[9]")
	private WebElement admin;
	
	@FindBy(xpath="(//a[@class='nav-link'])[10]")
	private WebElement add_admin;
	
	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	private WebElement EmployeeHrAss;
	
	@FindBy(xpath="(//a[@class='nav-link'])[4]")
	private WebElement addEmpHrAss;
	
	//initialization
	public HrHead_HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utilization

	public WebElement getCorporate() {
		return corporate;
	}

	public WebElement getAdd_corporate() {
		return add_corporate;
	}

	public WebElement getBranches() {
		return branches;
	}

	public WebElement getAdd_branch() {
		return add_branch;
	}

	public WebElement getEmployee() {
		return employee;
	}

	public WebElement getAdd_employee() {
		return add_employee;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getAdd_admin() {
		return add_admin;
	}
	

	public WebElement getEmployeeHrAss() {
		return EmployeeHrAss;
	}

	public WebElement getAddEmpHrAss() {
		return addEmpHrAss;
	}
	//business library
	public void clickCorporate()
	{
		corporate.click();
		add_corporate.click();
	}
	
	public void clickBranch()
	{
		branches.click();
		add_branch.click();
	}
	
	public void clickEmployee() throws Throwable 
	{
		employee.click();
		Thread.sleep(2000);
		add_employee.click();
	}
	public void clickAdmin()
	{
		admin.click();
		add_admin.click();
	}
	public void clickEmpHrAss() {
		EmployeeHrAss.click();
		addEmpHrAss.click();
	}
	

}
