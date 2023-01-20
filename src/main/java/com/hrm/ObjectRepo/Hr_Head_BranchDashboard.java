package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtility.WebDriverUtility;

public class Hr_Head_BranchDashboard
{
	@FindBy(xpath="//h3[@class='card-title' ]/button[@class='btn btn-primary']")
	private WebElement addBranchBtn;
	
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement searchTbx;
	
	@FindBy(xpath="(//input[@name='branches_name'])[1]")
	private WebElement branchTbx;
	
	@FindBy(xpath="//button[@name='bran']")
	private WebElement saveBtn;
	
	public WebElement getAddBranchBtn() {
		return addBranchBtn;
	}

	public WebElement getSearchTbx() {
		return searchTbx;
	}
	public WebElement getBranchTbx() {
		return branchTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public Hr_Head_BranchDashboard(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void addBranch(String branch,WebDriverUtility wLib,WebDriver driver)
	{
		addBranchBtn.click();
		branchTbx.sendKeys(branch);
		saveBtn.click();
		wLib.switchToAlertWindowAndAccept(driver);
		
	}
	public void searchBranch(String branch)
	{
		searchTbx.sendKeys(branch);
		
	}

	

}
