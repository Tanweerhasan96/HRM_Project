package com.hrm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hr_Officer_HomePage {
	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	private WebElement empBtn;
	
	@FindBy(xpath="(//a[@class='nav-link'])[4]")
	private WebElement addEmpBtn;
	
	public Hr_Officer_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmpBtn() {
		return empBtn;
	}

	public WebElement getAddEmpBtn() {
		return addEmpBtn;
	}
	
	//Business login
	public void clickEmpAsOfficer()
	{
		empBtn.click();
		addEmpBtn.click();
	}

}
