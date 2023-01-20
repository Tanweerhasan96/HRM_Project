package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtility.WebDriverUtility;

public class HrAssistant_Dashboard 
{
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement searchTbxAss;
	
	@FindBy(xpath="//h3[@class='card-title']/button[@class='btn btn-primary']")
	private WebElement addEmpBtnAss;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	private WebElement plusBtn;
	
	@FindBy(xpath="//span[@class='dtr-data']/i[@title='Edit Employee']")
	private WebElement editSymbl;
	
	@FindBy(xpath="//span[@class='dtr-data']/i[@title='Delete Employee']")
	private WebElement deleteSymbl;
	
	@FindBy(xpath="//input[@value='Tanweer Buddy']/parent::div/following-sibling::div/child::button[.='Delete']")
	private WebElement deleteBtn;

	public HrAssistant_Dashboard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTbxAss() {
		return searchTbxAss;
	}

	public WebElement getAddEmpBtnAss() {
		return addEmpBtnAss;
	}
	public WebElement getPlusBtn() {
		return plusBtn;
	}

	public WebElement getEditSymbl() {
		return editSymbl;
	}

	public WebElement getDeleteSymbl() {
		return deleteSymbl;
	}
	public void searchEmpAss(String name)
	{
		searchTbxAss.sendKeys(name);
	}
	public void addEmpBtnAss(WebDriver driver)
	{
		addEmpBtnAss.click();
		
	}
	public void deleteEmpAss(WebDriverUtility wLib,WebDriver driver)
	{
		plusBtn.click();
		deleteSymbl.click();
		deleteBtn.click();
		wLib.switchToAlertWindowAndAccept(driver);
	
		
	}
	public void editEmpDetailsAss()
	{
		editSymbl.click();
	}

	
}
