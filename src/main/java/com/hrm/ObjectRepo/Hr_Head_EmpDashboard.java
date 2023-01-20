package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtility.ExcelUtility;

public class Hr_Head_EmpDashboard
{
	@FindBy(xpath="//button[@class='btn btn-primary']/parent::h3[@class='card-title']")
	private WebElement addEmpHeadBtn;
	
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement searchEmpHeadTbx;
	
	public Hr_Head_EmpDashboard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddEmpBtn() {
		return addEmpHeadBtn;
	}

	public WebElement getSearchEmpTbx() {
		return searchEmpHeadTbx;
	}
	 
	public void addEmployee()
	{
		addEmpHeadBtn.click();
	}
	public void searchEmp(ExcelUtility eLib) throws Throwable
	{
		String text = eLib.getDataFromExcel("EmployeeDetails", 1, 1);
		searchEmpHeadTbx.sendKeys(text);
	}

	

	
	
	

}
