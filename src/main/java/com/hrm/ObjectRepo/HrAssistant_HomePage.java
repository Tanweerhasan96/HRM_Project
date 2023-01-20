package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrAssistant_HomePage 
{
	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	private WebElement empBtn;
	
	@FindBy(xpath="(//a[@class='nav-link'])[4]")
	private WebElement addEmpbtn;
	
	public HrAssistant_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmpBtn() {
		return empBtn;
	}

	public WebElement getAddEmpbtn() {
		return addEmpbtn;
	}
	
	
	public void clickEmpBtn()
	{
		empBtn.click();
		addEmpbtn.click();
	}
}
