package com.hrm.ObjectRepo;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtility.ExcelUtility;
import com.hrm.genericUtility.IPathConstants;

public class Hr_Head_EmpDetails 
{
	@FindBy(name="employee_companyid")
	private WebElement cmpyId;
	
	@FindBy(name="employee_firstname")
	private WebElement firstName;
	
	@FindBy(name="employee_lastname")
	private WebElement emplastName;
	
	@FindBy(name="employee_middlename")
	private WebElement empMiddleName;
	
	@FindBy(name="branches_datefrom")
	private WebElement branchDate;
	
	@FindBy(name="branches_recentdate")
	private WebElement branchRDate;
	
	@FindBy(name="employee_department")
	private WebElement empDeptDD;
	 
	@FindBy(name="employee_branches")
	private WebElement empBrDD;
	
	@FindBy(name="employee_position")
	private WebElement empPostbx;
	
	@FindBy(name="employee_contact")
	private WebElement empContacttbx;
	
	@FindBy(name="employee_sss")
	private WebElement empSSStbx;
	
	@FindBy(name="employee_tin")
	private WebElement tintbx;
	
	@FindBy(name="employee_hdmf_pagibig")
	private WebElement emphdmftbx;
	
	@FindBy(name="employee_gsis")
	private WebElement empGsistbx;
	
	@FindBy(name="emplo")
	private WebElement saveBtn;
	
	public Hr_Head_EmpDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCmpyId() {
		return cmpyId;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getEmplastName() {
		return emplastName;
	}

	public WebElement getEmpMiddleName() {
		return empMiddleName;
	}

	public WebElement getBranchDate() {
		return branchDate;
	}

	public WebElement getBranchRDate() {
		return branchRDate;
	}

	public WebElement getEmpDeptDD() {
		return empDeptDD;
	}

	public WebElement getEmpBrDD() {
		return empBrDD;
	}

	public WebElement getEmpPostbx() {
		return empPostbx;
	}

	public WebElement getEmpContacttbx() {
		return empContacttbx;
	}

	public WebElement getEmpSSStbx() {
		return empSSStbx;
	}

	public WebElement getTintbx() {
		return tintbx;
	}

	public WebElement getEmphdmftbx() {
		return emphdmftbx;
	}

	public WebElement getEmpGsistbx() {
		return empGsistbx;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	ExcelUtility eu=new ExcelUtility();
	//creating business logic
		public void addEmp(WebDriver driver) throws Throwable
		{
		
                  eu.getList(driver,"EmployeeDetails",0);		
		}
		
        public void uploadFile(WebDriver driver) {
		File f = new File(IPathConstants.Resume);
		  String absolute = f.getAbsolutePath();
		  driver.findElement(By.xpath("(//input[@name='employee_file201'])[1]")).sendKeys(absolute);
		  
		  File f1 = new File(IPathConstants.profilePic);
		  String abs = f1.getAbsolutePath();
		  driver.findElement(By.xpath("(//input[@name='employee_image'])[1]")).sendKeys(abs);
		  
		  saveBtn.click();
		 }

		

		

}
