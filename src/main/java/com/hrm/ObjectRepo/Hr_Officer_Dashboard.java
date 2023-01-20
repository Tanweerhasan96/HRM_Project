package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hr_Officer_Dashboard 
{
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement searchBtn;
 
	@FindBy(xpath="//div[@class='card']/descendant::button[@class='btn btn-primary' and @type='button']")
	private WebElement addEmpBtn;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	private WebElement plusBtn;
	
	
	public Hr_Officer_Dashboard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getAddEmpBtn() {
		return addEmpBtn;
	}
	public void addEmp()
	{
		addEmpBtn.click();
	}
	public void search(String name)
	{
		searchBtn.sendKeys(name);
	}
}
