package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hr_HeadCorporateDashboard 
{
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement addCorpoBtn;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchCorpo;
	
	@FindBy(xpath="(//input[@name='corporate_name'])[1]")
	private WebElement corpoName;
	
	@FindBy(xpath="//button[@name='corp']")
	private WebElement saveBtn;

	public WebElement getAddCorpoBtn() {
		return addCorpoBtn;
	}

	public WebElement getSearchCorpo() {
		return searchCorpo;
	}
	public WebElement getCorpoName() {
		return corpoName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public Hr_HeadCorporateDashboard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addCorpo(String corporate)
	{
		addCorpoBtn.click();
		corpoName.sendKeys(corporate);
		saveBtn.click();
		
		
	}
	public void searchCorporate(String corporate )
	{
		searchCorpo.sendKeys(corporate);
	}


	
}
